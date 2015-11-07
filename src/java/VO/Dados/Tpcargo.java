package VO.Dados;
// Generated 07/11/2015 19:10:52 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tpcargo generated by hbm2java
 */
public class Tpcargo  implements java.io.Serializable {


     private int id;
     private String label;
     private Integer order;
     private Boolean isAtivo;
     private Set funcionariocargos = new HashSet(0);

    public Tpcargo() {
    }

	
    public Tpcargo(int id) {
        this.id = id;
    }
    public Tpcargo(int id, String label, Integer order, Boolean isAtivo, Set funcionariocargos) {
       this.id = id;
       this.label = label;
       this.order = order;
       this.isAtivo = isAtivo;
       this.funcionariocargos = funcionariocargos;
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
    public Set getFuncionariocargos() {
        return this.funcionariocargos;
    }
    
    public void setFuncionariocargos(Set funcionariocargos) {
        this.funcionariocargos = funcionariocargos;
    }




}


