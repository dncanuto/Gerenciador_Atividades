/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Model;

/**
 *
 * @author Daniel
 */
public class Tag {

    private int id;
    private String tagName;

	//getter and setter methods
    public Tag(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
