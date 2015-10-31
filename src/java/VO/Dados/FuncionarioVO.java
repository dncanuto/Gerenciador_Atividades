/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Dados;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class FuncionarioVO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String password;
    private LocalDate dtCriacao;
    private boolean is_ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public boolean isIs_ativo() {
        return is_ativo;
    }

    public void setIs_ativo(boolean is_ativo) {
        this.is_ativo = is_ativo;
    }
    
}
