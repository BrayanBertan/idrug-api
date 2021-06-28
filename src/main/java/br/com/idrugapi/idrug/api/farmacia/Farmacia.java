/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idrugapi.idrug.api.farmacia;


import br.com.idrugapi.idrug.api.usuarios.PermissaoAceita;
import br.com.idrugapi.idrug.api.usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author brayanbertan
 */
@Entity
@Table(name = "Farmacias", schema="public")
public class Farmacia {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String sobre;
  @Column(nullable = false)
  private String endereco;
  @Column(nullable = false)
  private String telefone;
  @Column(nullable = false)
  private String celular;
  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String logo;
  @Column(nullable = false)
  private String cnpj;
  @Column(nullable = false)
  private boolean credito;
  @Column(nullable = false)
  private boolean debito;
  @Column(nullable = false)
  private boolean boleto;
  @Column(nullable = false)
  private boolean pix;

    public Farmacia() {
    }

    public Farmacia(int id, String nome, String sobre, String endereco, String telefone, String celular, String email, String logo, String cnpj, boolean credito, boolean debito, boolean boleto, boolean pix) {
        this.id = id;
        this.nome = nome;
        this.sobre = sobre;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.logo = logo;
        this.cnpj = cnpj;
        this.credito = credito;
        this.debito = debito;
        this.boleto = boleto;
        this.pix = pix;
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

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public boolean isBoleto() {
        return boleto;
    }

    public void setBoleto(boolean boleto) {
        this.boleto = boleto;
    }

    public boolean isPix() {
        return pix;
    }

    public void setPix(boolean pix) {
        this.pix = pix;
    }
    
 
    
}
