package com.hearthstone.jogo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "carta")
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Long ataque;
    private Long defesa;
    private Classe classe;
    private Tipo tipo;

    public Carta() {

    }

    public Carta(Long id, String nome, String descricao, Long ataque, Long defesa, Classe classe, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
        this.defesa = defesa;
        this.classe = classe;
        this.tipo = tipo;
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
        Carta carta = (Carta) o;
        return id.equals(carta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
