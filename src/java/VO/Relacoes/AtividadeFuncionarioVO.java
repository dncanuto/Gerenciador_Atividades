/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Relacoes;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class AtividadeFuncionarioVO {
    private Integer id;
    private int funcionarioId;
    private int atividadeId;
    private LocalDate dtCriacao;
    private boolean is_ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
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
