/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class memotable_by_date extends Application {
    
    float sell1 = 0;
        float sell2= 0;
        
    String date;
    TableView<memo_by_date> table;
    Stage stage;
    
    memotable_by_date(String date){
        this.date=date;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
      
           stage=primaryStage;
           stage.setTitle(date);
 StackPane root = new StackPane();
  GridPane grid5 = new GridPane();
  
 TableColumn<memo_by_date,Integer> memid=new TableColumn<>("MEMO ID");
          memid.setMinWidth(200);
          memid.setCellValueFactory(new PropertyValueFactory<>("memoid"));
          
          
          
       
          
          
        TableColumn<memo_by_date,Float> total=new TableColumn<>("Total");
          total.setMinWidth(200);
          total.setCellValueFactory(new PropertyValueFactory<>("totalbill"));
          
                  TableColumn<memo_by_date,Float> price=new TableColumn<>("WITHOUT VAT");
          price.setMinWidth(200);
          price.setCellValueFactory(new PropertyValueFactory<>("bilwithoutvat"));
          
           TableColumn<memo_by_date,String> issue=new TableColumn<>("ISSUED BY");
          issue.setMinWidth(200);
          issue.setCellValueFactory(new PropertyValueFactory<>("issuedby"));
          
          
          table=new TableView<>();
          table.setItems(getmemo());
          table.getColumns().addAll(memid,price,total,issue);
          VBox vbox=new VBox();
          vbox.getChildren().addAll(table);
        /*  
          Button back=new Button();
          back.setLayoutX(12);
        back.setLayoutY(400);
        back.setMinSize(80, 50);
          root.getChildren().addAll(vbox,back);
          Scene scene=new Scene(root,600,400);
          
          */
          grid5.add(vbox, 0, 0);
          /*
          Button backfromcattoempwindow = new Button("Back");
        VBox backemp5 = new VBox(50);
        backfromcattoempwindow.setPrefSize(100, 30);
        backemp5.setAlignment(Pos.CENTER_LEFT);
        backemp5.getChildren().add(backfromcattoempwindow);
        grid5.add(backemp5, 0, 1);
          */
          
           totalsell();
        Text wv = new Text("Total bill (Without VAT) :       "+Float.toString(sell1));
        wv.setFill(Color.GREEN);
        wv.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        grid5.add(wv, 0, 3);

        Text tt = new Text("Total bill                            :       "+Float.toString(sell2));
        tt.setFill(Color.GREEN);
        tt.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        grid5.add(tt, 0, 6);
/*
        Text wv_res = new Text();
        wv_res.setFill(Color.BLACK);
        wv_res.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
         grid5.add(wv_res, 1, 1);
        //wv_res.setText("Farhan");
        // ei farhan er jaigai ekta string hobe jekhane without vat calculated amount ta likhbo.

        Text tt_res = new Text();
        tt_res.setFill(Color.BLACK);
        tt_res.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
         grid5.add(tt_res, 1, 2);
          
         
          
          wv_res.setText(Float.toString(sell1));
          
          tt_res.setText(Float.toString(sell2));
          
          */
          
          
                   Scene scene=new Scene(grid5);

          
          stage.setScene(scene);
          stage.show();
          
     }
    
    public ObservableList<memo_by_date> getmemo(){
        ObservableList<memo_by_date> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT MEMO_ID,TOTAL_BILL, BILL_WITHOUT_VAT,ISSUED_BY\n" +
"FROM MEMO_HISTORY\n" +
"WHERE TRUNC(CASH_DATE) = TO_DATE('"+ date+"', 'YYYY-MM-DD')\n" +
"ORDER BY MEMO_ID ASC";
       float total = 0;
                    float novat = 0;
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new memo_by_date(rs.getInt(1),rs.getFloat(2),rs.getFloat(3),rs.getString(4)));
                    //System.out.println(rs.getInt(1)+" "+rs.getInt(2)+"  "+rs.getFloat(3)+" "+rs.getFloat(4));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
    }
    
    
    public void totalsell(){
        
        
        
        
        
      String sqlprice="SELECT SUM(BILL_WITHOUT_VAT),SUM(TOTAL_BILL)\n" +
"FROM MEMO_HISTORY\n" +
"WHERE TRUNC(CASH_DATE) = TO_DATE('"+date+"', 'YYYY-MM-DD')";
    
           try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sqlprice);
                     //  System.out.println("hello");
                     /*
                     pst.setInt(4, 6);
                     pst.setString(3, product_info);
                     pst.setFloat(5, (float) 10.0);
                   pst.setFloat(6, (float) 8.0);
                     
                    // pst.setInt(0,22);
                     pst.setString(2, "juice");
                     */
                    ResultSet rs = pst.executeQuery();
                   
            while (rs.next()){
                
               sell1=rs.getFloat(1);
               sell2=rs.getFloat(2);
            }
                  
                  
       
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
        
        
        
        
       
    } 
    
    
    
    
    
}
