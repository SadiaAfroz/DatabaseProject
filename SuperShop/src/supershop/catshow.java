/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

/**
 *
 * @author HP
 */
public class catshow {

    int catid;
    String catname;
    int catcount;

    public catshow(int catid, String catname, int catcount) {
        this.catid = catid;
        this.catname = catname;
        this.catcount = catcount;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public void setCatcount(int catcount) {
        this.catcount = catcount;
    }

    public int getCatid() {
        return catid;
    }

    public String getCatname() {
        return catname;
    }

    public int getCatcount() {
        return catcount;
    }
    
}
