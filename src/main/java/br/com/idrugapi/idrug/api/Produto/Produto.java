/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idrugapi.idrug.api.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author brayanbertan
 */
@Entity
@Table(name = "Produtos", schema="public")
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String descricao;
  @Column(nullable = false)
  private String categoria;
  @Column(nullable = false)
  private Double preco;
  @Column(nullable = false)
  private String volume;
  @Column(nullable = false)
  private String unidade;
  @Column(nullable = false)
  private int estoque;
  @Column(nullable = false)
  private String foto;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, String categoria, Double preco, String volume, String unidade, int estoque, String foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.volume = volume;
        this.unidade = unidade;
        this.estoque = estoque;
        this.foto = foto;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
  
  
}
