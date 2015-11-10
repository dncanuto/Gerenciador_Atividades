package VO.Model;
// Generated 10/11/2015 14:22:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Atividadefuncionario generated by hbm2java
 */
public class Atividadefuncionario  implements java.io.Serializable {


     private int id;
     private Atividade atividade;
     private Funcionario funcionario;
     private Date dtcriacao;
     private Boolean isAtivo;

    public Atividadefuncionario() {
    }

	
    public Atividadefuncionario(int id) {
        this.id = id;
    }
    public Atividadefuncionario(int id, Atividade atividade, Funcionario funcionario, Date dtcriacao, Boolean isAtivo) {
       this.id = id;
       this.atividade = atividade;
       this.funcionario = funcionario;
       this.dtcriacao = dtcriacao;
       this.isAtivo = isAtivo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Atividade getAtividade() {
        return this.atividade;
    }
    
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Date getDtcriacao() {
        return this.dtcriacao;
    }
    
    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }
    public Boolean getIsAtivo() {
        return this.isAtivo;
    }
    
    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }




}


