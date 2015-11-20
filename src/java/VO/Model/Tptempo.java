package VO.Model;
// Generated 20/11/2015 17:23:36 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tptempo generated by hbm2java
 */
public class Tptempo  implements java.io.Serializable {


     private int id;
     private String label;
     private Integer order;
     private Boolean isAtivo;
     private Set atividadesForTptempoconclusaoid = new HashSet(0);
     private Set atividadesForTptempoestimadoid = new HashSet(0);

    public Tptempo() {
    }

	
    public Tptempo(int id) {
        this.id = id;
    }
    public Tptempo(int id, String label, Integer order, Boolean isAtivo, Set atividadesForTptempoconclusaoid, Set atividadesForTptempoestimadoid) {
       this.id = id;
       this.label = label;
       this.order = order;
       this.isAtivo = isAtivo;
       this.atividadesForTptempoconclusaoid = atividadesForTptempoconclusaoid;
       this.atividadesForTptempoestimadoid = atividadesForTptempoestimadoid;
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
    public Set getAtividadesForTptempoconclusaoid() {
        return this.atividadesForTptempoconclusaoid;
    }
    
    public void setAtividadesForTptempoconclusaoid(Set atividadesForTptempoconclusaoid) {
        this.atividadesForTptempoconclusaoid = atividadesForTptempoconclusaoid;
    }
    public Set getAtividadesForTptempoestimadoid() {
        return this.atividadesForTptempoestimadoid;
    }
    
    public void setAtividadesForTptempoestimadoid(Set atividadesForTptempoestimadoid) {
        this.atividadesForTptempoestimadoid = atividadesForTptempoestimadoid;
    }




}


