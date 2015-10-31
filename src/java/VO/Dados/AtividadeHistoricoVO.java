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
public class AtividadeHistoricoVO extends AtividadeVO{
    Integer id;
    private String descricao;
    private int sitAtividadeId;
    private int userAlteracaoId;
    private LocalDate dtAlteracao;
    private boolean is_atual;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSitAtividadeId() {
        return sitAtividadeId;
    }

    public void setSitAtividadeId(int sitAtividadeId) {
        this.sitAtividadeId = sitAtividadeId;
    }

    public int getUserAlteracaoId() {
        return userAlteracaoId;
    }

    public void setUserAlteracaoId(int userAlteracaoId) {
        this.userAlteracaoId = userAlteracaoId;
    }

    public LocalDate getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(LocalDate dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public boolean isIs_atual() {
        return is_atual;
    }

    public void setIs_atual(boolean is_atual) {
        this.is_atual = is_atual;
    }
}
