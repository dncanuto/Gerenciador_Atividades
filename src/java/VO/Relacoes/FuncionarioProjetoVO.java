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
public class FuncionarioProjetoVO {
    private Integer id;
    private int funcionarioId;
    private int projetoId;
    private LocalDate dtCriacao;
    private LocalDate dtAlteracao;
    private boolean is_adm;
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

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
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

    public boolean isIs_adm() {
        return is_adm;
    }

    public void setIs_adm(boolean is_adm) {
        this.is_adm = is_adm;
    }

    public boolean isIs_ativo() {
        return is_ativo;
    }

    public void setIs_ativo(boolean is_ativo) {
        this.is_ativo = is_ativo;
    }
}
