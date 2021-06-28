/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idrugapi.idrug.api.usuarios;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author brayanbertan
 */
@Entity
@Table(name = "Usuarios", schema="public")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String foto;
   @ManyToMany(fetch = FetchType.EAGER) 
   @JoinTable(
    name = "permissao_usuario",
    joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "id_permissao"),
    foreignKey = @ForeignKey(name = "fk_usuario"),
    inverseForeignKey = @ForeignKey(name = "fk_permissao")
    )
    private List<PermissaoAceita> permissoes = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int id, String nome, String usuario, String senha, String foto) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<PermissaoAceita> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<PermissaoAceita> permissoes) {
        this.permissoes = permissoes;
    }





    
    
    
    
}
