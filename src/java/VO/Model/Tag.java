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

    private int tagId;
    private String tagName;
    private boolean isExisteBD;

	//getter and setter methods
    public Tag(int tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;        
    }
    
    public Tag(){}

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public boolean isIsExisteBD() {
        return isExisteBD;
    }

    public void setIsExisteBD(boolean isExisteBD) {
        this.isExisteBD = isExisteBD;
    }
}
