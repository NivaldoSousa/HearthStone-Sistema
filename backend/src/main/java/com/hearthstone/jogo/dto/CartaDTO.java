package com.hearthstone.jogo.dto;

import com.hearthstone.jogo.model.Carta;
import com.hearthstone.jogo.model.Classe;
import com.hearthstone.jogo.model.Tipo;

import java.io.Serializable;
import java.util.Objects;

public class CartaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;
    private Long ataque;
    private Long defesa;
    private Classe classe;
    private Tipo tipo;

    public CartaDTO() {
    }

    public CartaDTO(Long id, String nome, String descricao, Long ataque, Long defesa, Classe classe, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
        this.defesa = defesa;
        this.classe = classe;
        this.tipo = tipo;
    }

    public CartaDTO(Carta entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        ataque = entity.getAtaque();
        defesa = entity.getDefesa();
        classe = entity.getClasse();
        tipo = entity.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getAtaque() {
        return ataque;
    }

    public void setAtaque(Long ataque) {
        this.ataque = ataque;
    }

    public Long getDefesa() {
        return defesa;
    }

    public void setDefesa(Long defesa) {
        this.defesa = defesa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaDTO cartaDTO = (CartaDTO) o;
        return id.equals(cartaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


