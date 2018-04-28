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
public class productshow {
    
    int proid;
    String proname;
    int proprice;
    int provat;
    int proquan;
    String promandate;
    String proexpdate;

    
    public productshow(int proid, String proname, int proprice, int provat, int proquan, String promandate, String proexpdate) {
        this.proid = proid;
        this.proname = proname;
        this.proprice = proprice;
        this.provat = provat;
        this.proquan = proquan;
        this.promandate = promandate;
        this.proexpdate = proexpdate;
    }
    
    public void setProid(int proid) {
        this.proid = proid;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public void setProprice(int proprice) {
        this.proprice = proprice;
    }

    public void setProvat(int provat) {
        this.provat = provat;
    }

    public void setProquan(int proquan) {
        this.proquan = proquan;
    }

    public void setPromandate(String promandate) {
        this.promandate = promandate;
    }

    public void setProexpdate(String proexpdate) {
        this.proexpdate = proexpdate;
    }

    public int getProid() {
        return proid;
    }

    public String getProname() {
        return proname;
    }

    public int getProprice() {
        return proprice;
    }

    public int getProvat() {
        return provat;
    }

    public int getProquan() {
        return proquan;
    }

    public String getPromandate() {
        return promandate;
    }

    public String getProexpdate() {
        return proexpdate;
    }

    
}
