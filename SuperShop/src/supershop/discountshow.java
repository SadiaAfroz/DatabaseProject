/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;


public class discountshow {
    
int disid;
int proid;
String proname;
int per;
int price;
String type;
String start;
String end;

    public discountshow(int disid, int proid, String proname, int per, int price, String type, String start, String end) {
        this.disid = disid;
        this.proid = proid;
        this.proname = proname;
        this.per = per;
        this.price = price;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public void setDisid(int disid) {
        this.disid = disid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDisid() {
        return disid;
    }

    public int getProid() {
        return proid;
    }

    public String getProname() {
        return proname;
    }

    public int getPer() {
        return per;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
    
    
    
}
