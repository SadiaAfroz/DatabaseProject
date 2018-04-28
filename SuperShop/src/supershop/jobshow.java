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
public class jobshow {

  int jobid;
  String  jobtitle;
  int empcount;

    public jobshow(int jobid, String jobtitle, int empcount) {
        this.jobid = jobid;
        this.jobtitle = jobtitle;
        this.empcount = empcount;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public void setEmpcount(int empcount) {
        this.empcount = empcount;
    }

    public int getJobid() {
        return jobid;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public int getEmpcount() {
        return empcount;
    }
    
    
    
    
}
