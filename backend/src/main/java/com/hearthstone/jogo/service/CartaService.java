package com.hearthstone.jogo.service;

import com.hearthstone.jogo.dto.CartaDTO;
import com.hearthstone.jogo.model.Carta;
import com.hearthstone.jogo.model.Classe;
import com.hearthstone.jogo.model.Tipo;
import com.hearthstone.jogo.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaService {

    @Autowired
    private CartaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<CartaDTO> consultar() {
        List<Carta> list = repository.findAll();
        return list.stream().map(x -> new CartaDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public CartaDTO cadastrar(CartaDTO dto) {
        Carta carta = new Carta(null, dto.getNome(), dto.getDescricao(), dto.getAtaque(),
                dto.getDefesa(), dto.getClasse(), dto.getTipo());
        carta = repository.save(carta);
        return new CartaDTO(carta);
    }

    @Transactional
    public CartaDTO delete(Long id) {
        Carta carta = repository.getOne(id);
        repository.delete(carta);
        return new CartaDTO(carta);
    }

    @Transactional
    public List<Carta> pesquisar(CartaDTO dto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carta> criteriaQuery = criteriaBuilder.createQuery(Carta.class);
        Root<Carta> root = criteriaQuery.from(Carta.class);

        Predicate[] predicates = restricoes(dto, criteriaBuilder, root);
        criteriaQuery.where(predicates);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));

        TypedQuery<Carta> query = entityManager.createQuery(criteriaQuery);
        try {
            List<Carta> lst = query.getResultList();
            return lst;

        } catch (Exception e) {
            return null;
        }
    }

    private Predicate[] restricoes(CartaDTO dto, CriteriaBuilder criteriaBuilder, Root<Carta> root) {
        List<Predicate> predicateList = new ArrayList<>();

        if (!StringUtils.isEmpty(dto.getNome())) {
            predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), dto.getNome().toLowerCase().trim() + "%"));
        }

        if (!StringUtils.isEmpty(dto.getId())) {
            predicateList.add(criteriaBuilder.equal(root.get("id"), dto.getId()));
        }

        if (!StringUtils.isEmpty(dto.getClasse())) {
            predicateList.add(criteriaBuilder.equal(root.get("classe"), dto.getClasse()));
        }

        if (!StringUtils.isEmpty(dto.getTipo())) {
            predicateList.add(criteriaBuilder.equal(root.get("tipo"), dto.getTipo()));
        }

        return predicateList.toArray(new Predicate[predicateList.size()]);

    }
}
