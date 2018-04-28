
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

import javafx.scene.control.Button;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class requestsupshow {

int reqid;
int supid;
int proid;
int quan;
String ordate;
String sudate;
int pri;
int sent_by;
Button btn;

    public void setPri(int pri) {
        this.pri = pri;
    }

    public int getPri() {
        return pri;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    public void setSupid(int supid) {
        this.supid = supid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public requestsupshow(int reqid, int supid, int proid, int quan, String ordate, String sudate, int pri, int sent_by, Button btn) {
        this.reqid = reqid;
        this.supid = supid;
        this.proid = proid;
        this.quan = quan;
        this.ordate = ordate;
        this.sudate = sudate;
        this.pri = pri;
        this.sent_by = sent_by;
        this.btn = btn;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public void setOrdate(String ordate) {
        this.ordate = ordate;
    }

    public void setSudate(String sudate) {
        this.sudate = sudate;
    }

    public void setSent_by(int sent_by) {
        this.sent_by = sent_by;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public int getReqid() {
        return reqid;
    }

    public int getSupid() {
        return supid;
    }

    public int getProid() {
        return proid;
    }

    public int getQuan() {
        return quan;
    }

    public String getOrdate() {
        return ordate;
    }

    public String getSudate() {
        return sudate;
    }

    public int getSent_by() {
        return sent_by;
    }

    public Button getBtn() {
        return btn;
    }

    
}