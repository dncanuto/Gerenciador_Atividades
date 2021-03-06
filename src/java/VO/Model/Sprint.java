package VO.Model;
// Generated 20/11/2015 17:23:36 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sprint generated by hbm2java
 */
public class Sprint  implements java.io.Serializable {


     private int id;
     private Projeto projeto;
     private Sitsprint sitsprint;
     private String nome;
     private String descricao;
     private Date dtcriacao;
     private Date dtalteracao;
     private Set atividades = new HashSet(0);

    public Sprint() {
    }

	
    public Sprint(int id, Projeto projeto) {
        this.id = id;
        this.projeto = projeto;
    }
    public Sprint(int id, Projeto projeto, Sitsprint sitsprint, String nome, String descricao, Date dtcriacao, Date dtalteracao, Set atividades) {
       this.id = id;
       this.projeto = projeto;
       this.sitsprint = sitsprint;
       this.nome = nome;
       this.descricao = descricao;
       this.dtcriacao = dtcriacao;
       this.dtalteracao = dtalteracao;
       this.atividades = atividades;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Projeto getProjeto() {
        return this.projeto;
    }
    
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public Sitsprint getSitsprint() {
        return this.sitsprint;
    }
    
    public void setSitsprint(Sitsprint sitsprint) {
        this.sitsprint = sitsprint;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDtcriacao() {
        return this.dtcriacao;
    }
    
    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }
    public Date getDtalteracao() {
        return this.dtalteracao;
    }
    
    public void setDtalteracao(Date dtalteracao) {
        this.dtalteracao = dtalteracao;
    }
    public Set getAtividades() {
        return this.atividades;
    }
    
    public void setAtividades(Set atividades) {
        this.atividades = atividades;
    }




}


