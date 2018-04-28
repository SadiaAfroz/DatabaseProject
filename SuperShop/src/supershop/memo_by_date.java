/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

public class memo_by_date {
    int memoid;
  float totalbill;
    float  bilwithoutvat;
    String issuedby;
    
    public memo_by_date(int memoid, float totalbill, float bilwithoutvat, String issuedby) {
        this.memoid = memoid;
        this.totalbill = totalbill;
        this.bilwithoutvat = bilwithoutvat;
        this.issuedby = issuedby;
    }

    public void setMemoid(int memoid) {
        this.memoid = memoid;
    }

    public void setTotalbill(float totalbill) {
        this.totalbill = totalbill;
    }

    public void setBilwithoutvat(float bilwithoutvat) {
        this.bilwithoutvat = bilwithoutvat;
    }

    public void setIssuedby(String issuedby) {
        this.issuedby = issuedby;
    }

    public int getMemoid() {
        return memoid;
    }

    public float getTotalbill() {
        return totalbill;
    }

    public float getBilwithoutvat() {
        return bilwithoutvat;
    }

    public String getIssuedby() {
        return issuedby;
    }
  
    
    
}
