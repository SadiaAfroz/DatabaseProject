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
public class MemoInfo{
    
      int memo_id;
     float total_bill;
      float bill_without_vat;

    public MemoInfo( int memo_id,float bill_without_vat,float total_bill) {
        this.memo_id=memo_id;
        this.bill_without_vat=bill_without_vat;
        this.total_bill=total_bill;
    
    }
     
}
