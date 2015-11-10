package VO.Model;
// Generated 10/11/2015 14:22:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sitsprint generated by hbm2java
 */
public class Sitsprint  implements java.io.Serializable {


     private int id;
     private String label;
     private Integer order;
     private Boolean isAtivo;
     private Set sprints = new HashSet(0);

    public Sitsprint() {
    }

	
    public Sitsprint(int id) {
        this.id = id;
    }
    public Sitsprint(int id, String label, Integer order, Boolean isAtivo, Set sprints) {
       this.id = id;
       this.label = label;
       this.order = order;
       this.isAtivo = isAtivo;
       this.sprints = sprints;
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
    public Set getSprints() {
        return this.sprints;
    }
    
    public void setSprints(Set sprints) {
        this.sprints = sprints;
    }




}


