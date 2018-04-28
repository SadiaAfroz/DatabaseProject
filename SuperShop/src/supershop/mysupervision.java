/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

public class mysupervision {
    
    
     int empid;
     String empname;
     String  empadd;
     String bd;
     int sal;
     String hrd;
     int jobid;
     String gender;

    public mysupervision(int empid, String empname, String empadd, String bd, int sal, String hrd, int jobid, String gender) {
        this.empid = empid;
        this.empname = empname;
        this.empadd = empadd;
        this.bd = bd;
        this.sal = sal;
        this.hrd = hrd;
        this.jobid = jobid;
        this.gender = gender;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEmpname() {
        return empname;
    }

    public String getEmpadd() {
        return empadd;
    }

    public String getBd() {
        return bd;
    }

    public int getSal() {
        return sal;
    }

    public String getHrd() {
        return hrd;
    }

    public int getJobid() {
        return jobid;
    }

    public String getGender() {
        return gender;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setEmpadd(String empadd) {
        this.empadd = empadd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setHrd(String hrd) {
        this.hrd = hrd;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
     
  
    
    
    
    
    
    
}
