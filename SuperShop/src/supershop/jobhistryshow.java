/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

/**
 *
 * @author Faiza
 */
public class jobhistryshow {
 
    int backprmid;
    int empid;
    int jbid;
    int sal;
    int manid;
    String uptime;

    public jobhistryshow(int backprmid, int empid, int jbid, int sal, int manid, String uptime) {
        this.backprmid = backprmid;
        this.empid = empid;
        this.jbid = jbid;
        this.sal = sal;
        this.manid = manid;
        this.uptime = uptime;
    }

    public void setBackprmid(int backprmid) {
        this.backprmid = backprmid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setJbid(int jbid) {
        this.jbid = jbid;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setManid(int manid) {
        this.manid = manid;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public int getBackprmid() {
        return backprmid;
    }

    public int getEmpid() {
        return empid;
    }

    public int getJbid() {
        return jbid;
    }

    public int getSal() {
        return sal;
    }

    public int getManid() {
        return manid;
    }

    public String getUptime() {
        return uptime;
    }
    
    
    
}
