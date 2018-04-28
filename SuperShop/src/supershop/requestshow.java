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

public class requestshow {

int reqid;
int proid;
int per;
String type;
String start;
String end;
int sent_by;
Button btn;

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public void setPer(int per) {
        this.per = per;
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

    public void setSent_by(int sent_by) {
        this.sent_by = sent_by;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public int getReqid() {
        return reqid;
    }

    public int getProid() {
        return proid;
    }

    public int getPer() {
        return per;
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

    public int getSent_by() {
        return sent_by;
    }

    public Button getBtn() {
        return btn;
    }

    public requestshow(int reqid, int proid, int per, String type, String start, String end, int sent_by, Button btn) {
        this.reqid = reqid;
        this.proid = proid;
        this.per = per;
        this.type = type;
        this.start = start;
        this.end = end;
        this.sent_by = sent_by;
        this.btn = btn;
    }
    
}

