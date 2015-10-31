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
public class AtividadeVO {
    private Integer id;
    private int sprintId;
    private String nome;
    private int tpPrioridadeId;
    private LocalDate dtCriacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTpPrioridadeId() {
        return tpPrioridadeId;
    }

    public void setTpPrioridadeId(int tpPrioridadeId) {
        this.tpPrioridadeId = tpPrioridadeId;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
}
