
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



public class jobhistorytable extends Application{

    String id;
    TableView<jobhistryshow> table;
    Stage stage;

    public jobhistorytable() {
        
    }
    
  
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
      
           stage=primaryStage;
 StackPane root = new StackPane();
  GridPane grid5 = new GridPane();
  
 TableColumn<jobhistryshow,Integer> proidcol=new TableColumn<>("PROMOTION_ID");
          proidcol.setMinWidth(200);
          proidcol.setCellValueFactory(new PropertyValueFactory<>("backprmid"));
          
          
          
        TableColumn<jobhistryshow,Integer> qua=new TableColumn<>("EPLOYEE_ID");
          qua.setMinWidth(200);
          qua.setCellValueFactory(new PropertyValueFactory<>("empid"));
          
          
        TableColumn<jobhistryshow,Integer> total=new TableColumn<>("JOB_ID");
          total.setMinWidth(200);
          total.setCellValueFactory(new PropertyValueFactory<>("jbid"));
          
                  TableColumn<jobhistryshow,Integer> price=new TableColumn<>("SALARY");
          price.setMinWidth(200);
          price.setCellValueFactory(new PropertyValueFactory<>("sal"));
          
          
               TableColumn<jobhistryshow,Integer> manager=new TableColumn<>("MANAGER_ID");
          manager.setMinWidth(200);
          manager.setCellValueFactory(new PropertyValueFactory<>("manid"));
          
             TableColumn<jobhistryshow,String> update=new TableColumn<>("UPDATE_TIME");
          update.setMinWidth(200);
          update.setCellValueFactory(new PropertyValueFactory<>("uptime"));
          
          
          table=new TableView<>();
          table.setItems(getjobhistryshow());
          table.getColumns().addAll(proidcol,qua,price,total,manager,update);
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
    
    public ObservableList<jobhistryshow> getjobhistryshow(){
        ObservableList<jobhistryshow> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT BACKPROM_ID , EMPLOYEE_ID ,JOB_ID ,SALARY,MANAGER_ID, UPDATE_TIME\n" +
                "FROM BACKUP_PROMOTION\n";
       float total = 0;
                    float novat = 0;
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new jobhistryshow(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
                  //  System.out.println(rs.getInt(1)+" "+rs.getInt(2)+"  "+rs.getFloat(3)+" "+rs.getFloat(4));
                  
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
    

