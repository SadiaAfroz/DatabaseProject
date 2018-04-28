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
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Faiza
 */
public class requestdiscounttable extends Application {
      Stage stage; 
      int no_button=0;
       Button[] btnara = new Button[20];
    int[] flag = new int[20];
    Button[] btnaras = new Button[20];
    int[] flags = new int[20];
    
    @Override
    public void start(Stage primaryStage) throws Exception {
            
        Arrays.fill(flag, 0);
        Arrays.fill(flags, 0);
        
           stage=primaryStage;
  GridPane grid5 = new GridPane();
  Scene scene = new Scene(grid5, 1200, 450);
  final Label labelreq = new Label("Requests For Offers & Discounts:");
        labelreq.setFont(new Font("Arial", 20));

        TableView<requestshow> tablerequest;

        TableColumn<requestshow, Integer> REQID = new TableColumn<>("Request Id");
        REQID.setMinWidth(100);
        REQID.setCellValueFactory(new PropertyValueFactory<>("reqid"));

        TableColumn<requestshow, Integer> RPROID = new TableColumn<>("Product Id");
        RPROID.setMinWidth(100);
        RPROID.setCellValueFactory(new PropertyValueFactory<>("proid"));

        TableColumn<requestshow, Integer> RPER = new TableColumn<>("Percentage");
        RPER.setMinWidth(100);
        RPER.setCellValueFactory(new PropertyValueFactory<>("per"));

        TableColumn<requestshow, String> RTYP = new TableColumn<>("Type");
        RTYP.setMinWidth(200);
        RTYP.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<requestshow, String> RSTART = new TableColumn<>("Start Date");
        RSTART.setMinWidth(200);
        RSTART.setCellValueFactory(new PropertyValueFactory<>("start"));

        TableColumn<requestshow, String> REND = new TableColumn<>("End Date");
        REND.setMinWidth(200);
        REND.setCellValueFactory(new PropertyValueFactory<>("end"));

        TableColumn<requestshow, Integer> RSENTBY = new TableColumn<>("Sent By");
        RSENTBY.setMinWidth(100);
        RSENTBY.setCellValueFactory(new PropertyValueFactory<>("sent_by"));

        TableColumn<requestshow, Integer> RBTN = new TableColumn<>("Confirm Buttons");
        RBTN.setMinWidth(100);
        RBTN.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tablerequest = new TableView<>();
        tablerequest.setItems(getrequestshow());
        tablerequest.getColumns().addAll(REQID, RPROID, RPER, RTYP, RSTART, REND, RSENTBY, RBTN);

        VBox tblcol5 = new VBox();
        tblcol5.setMinWidth(1100);
        tblcol5.setSpacing(10);
        tblcol5.setPadding(new Insets(0, 0, 0, 0));
        tblcol5.getChildren().addAll(labelreq, tablerequest);
        grid5.add(tblcol5, 0, 0);

        Button backfromreqtoempwindow = new Button("Back");
        VBox backemp11 = new VBox(50);
        backfromreqtoempwindow.setPrefSize(100, 30);
        backemp11.setAlignment(Pos.CENTER_LEFT);
        backemp11.getChildren().add(backfromreqtoempwindow);
        grid5.add(backemp11, 0, 1);
            
        for(int i=1;i<=no_button;i++){
            eventlistenercall(i);
        }
        
        backfromreqtoempwindow.setOnMouseEntered(e -> {
            backfromreqtoempwindow.setCursor(Cursor.HAND);
        });

            
        
        
        
        backfromreqtoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              //  primaryStage.setScene(openwindow);
              
              for(int i=1;i<20;i++){
                  if(flag[i]==1){
                      
                      String sqlextract
                            = "SELECT PRODUCT_ID , PERCENT ,TYPE , START_DATE, END_DATE\n"
                            + "FROM REQUEST_DISCOUNT\n"
                            + "WHERE BUTTON_NO='"+i+"'";

                    String discreqinfo[] = new String[6];

                    try {
                        Connection con = new OracleDBMS().getConnection();
                        PreparedStatement pst = con.prepareStatement(sqlextract);

                        ResultSet rs = pst.executeQuery();

                        while (rs.next()) {
                            discreqinfo[0] = Integer.toString(rs.getInt(1));
                            discreqinfo[1] = Integer.toString(rs.getInt(2));
                            discreqinfo[2] = rs.getString(3);
                            discreqinfo[3] = rs.getString(4);
                            discreqinfo[4] = rs.getString(5);
                            System.out.println(discreqinfo[0] + discreqinfo[1] + discreqinfo[2] + discreqinfo[3] + discreqinfo[4]);
                        }

                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    System.out.println("paisi to eigula" + 1);
                    /* String sqlins = "INSERT INTO DISCOUNT(PRODUCT_ID,PERCENT,TYPE,START_DATE,END_DATE)"
                            + " VALUES ('" + discreqinfo[0] + "','" + discreqinfo[1] + "','" + discreqinfo[2] + "',\"TO_DATE\"('"
                            + discreqinfo[3] + "','YYYY-MM-DD HH24:MI:SS'),\"TO_DATE\"('" + discreqinfo[4] + "','YYYY-MM-DD HH24:MI:SS'))";
                    
                     */

                    String sqlins = "INSERT INTO DISCOUNT(PRODUCT_ID,PERCENT,TYPE,START_DATE,END_DATE)"
                            + " VALUES ('" + discreqinfo[0] + "','" + discreqinfo[1] + "','" + discreqinfo[2] + "',\"TO_DATE\"('"+discreqinfo[3]+"','YYYY-MM-DD'),\"TO_DATE\"('"+discreqinfo[4]+"','YYYY-MM-DD'))";

                    System.out.println(sqlins);
                    try {
                        Connection con2 = new OracleDBMS().getConnection();
                        PreparedStatement pst2 = con2.prepareStatement(sqlins);

                        int rs2 = pst2.executeUpdate();

                        if (rs2 != 0) {
                            System.out.println("Value Inserted");
                        } else {
                            System.out.println("Value  Not Inserted");
                        }

                        pst2.close();
                        con2.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    //btnara[1].setCursor(Cursor.CROSSHAIR);
                    btnara[i].setVisible(false);
                }
                            
                      
                      
                      
                      
                      
                      
                  }
              }
              
            
        });
          

          
          stage.setScene(scene);
          stage.show();
          
     }
    
    
    
      private void eventlistenercall(int i){
         btnara[i].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    flag[i]=1;
                    
            }
        });
        
        
        
    }
    
    
    
    private ObservableList<requestshow> getrequestshow() {
        ObservableList<requestshow> mm = FXCollections.observableArrayList();

        String sqlprice
                = "SELECT REQUEST_ID, PRODUCT_ID, PERCENT, TYPE, START_DATE, END_DATE, SENT_BY, BUTTON_NO\n"
                + "FROM REQUEST_DISCOUNT";

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sqlprice);
            System.out.println("Its getdiscountshow");
            ResultSet rs = pst.executeQuery();
            int btni = 0;
            while (rs.next()) {
                btni = rs.getInt(8);
                //   total=rs.getFloat(1);
                //   novat=rs.getFloat(2);
                mm.add(new requestshow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), btnara[btni]));
                System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));
                System.out.println("");
                no_button++;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return mm;

    }
 
    
    
    
      public static void main(String[] args) {
        launch(args);
    }

    }
    





    
    

