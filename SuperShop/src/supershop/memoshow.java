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
import javafx.stage.Stage;



public class memoshow extends Application{

    String id;
    TableView<memo> table;
    Stage stage;
    
    memoshow(String id){
        this.id=id;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
      
           stage=primaryStage;
 StackPane root = new StackPane();
  GridPane grid5 = new GridPane();
  
 TableColumn<memo,Integer> proidcol=new TableColumn<>("product_id");
          proidcol.setMinWidth(200);
          proidcol.setCellValueFactory(new PropertyValueFactory<>("po_id"));
          
          
          
        TableColumn<memo,Integer> qua=new TableColumn<>("quantity");
          qua.setMinWidth(200);
          qua.setCellValueFactory(new PropertyValueFactory<>("quan"));
          
          
        TableColumn<memo,Float> total=new TableColumn<>("Total");
          total.setMinWidth(200);
          total.setCellValueFactory(new PropertyValueFactory<>("to_bill"));
          
                  TableColumn<memo,Float> price=new TableColumn<>("price");
          price.setMinWidth(200);
          price.setCellValueFactory(new PropertyValueFactory<>("vat_bill"));
          
          table=new TableView<>();
          table.setItems(getmemo());
          table.getColumns().addAll(proidcol,qua,price,total);
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
          
          Button backfromcattoempwindow = new Button("Back");
        VBox backemp5 = new VBox(50);
        backfromcattoempwindow.setPrefSize(100, 30);
        backemp5.setAlignment(Pos.CENTER_LEFT);
        backemp5.getChildren().add(backfromcattoempwindow);
        grid5.add(backemp5, 0, 1);
          
                   Scene scene=new Scene(grid5);

          
          stage.setScene(scene);
          stage.show();
          
     }
    
    public ObservableList<memo> getmemo(){
        ObservableList<memo> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT PRODUCT_ID , QUANTITY ,TOTAL_BILL , BILL_WITHOUT_VAT\n" +
                "FROM CASHMEMO\n" +
                "WHERE MEMO_ID='"+id + "'";
       float total = 0;
                    float novat = 0;
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new memo(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4)));
                    System.out.println(rs.getInt(1)+" "+rs.getInt(2)+"  "+rs.getFloat(3)+" "+rs.getFloat(4));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
    }
    
    /*
      public static void main(String[] args) {
        launch(args);
    }
*/
     

    }
    

