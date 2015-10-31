/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Dicionarios;

/**
 *
 * @author Daniel
 */
public class TpCargoVO {
    private int id;
    private String label;
    private int order;
    private boolean is_ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isIs_ativo() {
        return is_ativo;
    }

    public void setIs_ativo(boolean is_ativo) {
        this.is_ativo = is_ativo;
    }
}
