/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faiza
 */
    
public class OracleDBMS
{

    private String username;
    private String password;
    
private final String CONN_STRING = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
    public Connection connection = null;
    //private static OracleDBMS instance = null;

    public OracleDBMS()
    {
        this.username = "supershop";
        this.password = "123";
    }

    public OracleDBMS(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

//    public static OracleDBMS getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new OracleDBMS();
//        }
//        return instance;
//    }

    public Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                //Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(CONN_STRING, username, password);
            } catch (SQLException e)
            {
                System.out.println("Connection Failed! Check it from console");
                e.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(OracleDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return connection;
    }

    public void closeConnection()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
                connection = null;
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
