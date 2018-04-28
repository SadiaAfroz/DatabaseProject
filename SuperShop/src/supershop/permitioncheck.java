/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Faiza
 */
public class permitioncheck {
    
        private static permitioncheck instance; 

    public boolean checkcredentials(String empid, String manid)
    {
        boolean success = false;
        String sql = "SELECT JOB_TITLE\n" +
"FROM JOBS\n" +
"WHERE JOB_ID=CHECK_MANAGER('"+empid+"','"+manid+"')";
        
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        
            ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                success = true;
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
        }
        return success;
    }
    
    
}
