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
public class SprintVO {
    private Integer id;
    private int projetoVO;
    private String nome;
    private String descricao;
    private int sitSprintId;
    private LocalDate dtCriacao;
    private LocalDate dtAlteracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProjetoVO() {
        return projetoVO;
    }

    public void setProjetoVO(int projetoVO) {
        this.projetoVO = projetoVO;
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

    public int getSitSprintId() {
        return sitSprintId;
    }

    public void setSitSprintId(int sitSprintId) {
        this.sitSprintId = sitSprintId;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(LocalDate dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
    
}
