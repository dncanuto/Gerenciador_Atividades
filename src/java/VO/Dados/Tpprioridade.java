package VO.Dados;
// Generated 07/11/2015 19:10:52 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tpprioridade generated by hbm2java
 */
public class Tpprioridade  implements java.io.Serializable {


     private int id;
     private String label;
     private Integer order;
     private Boolean isAtivo;
     private Set atividades = new HashSet(0);

    public Tpprioridade() {
    }

	
    public Tpprioridade(int id) {
        this.id = id;
    }
    public Tpprioridade(int id, String label, Integer order, Boolean isAtivo, Set atividades) {
       this.id = id;
       this.label = label;
       this.order = order;
       this.isAtivo = isAtivo;
       this.atividades = atividades;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    public Integer getOrder() {
        return this.order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    public Boolean getIsAtivo() {
        return this.isAtivo;
    }
    
    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }
    public Set getAtividades() {
        return this.atividades;
    }
    
    public void setAtividades(Set atividades) {
        this.atividades = atividades;
    }




}


