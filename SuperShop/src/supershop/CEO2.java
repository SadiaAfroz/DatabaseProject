/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

import com.sun.deploy.util.StringUtils;
import com.sun.javafx.scene.control.skin.TableColumnHeader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Faiza
 */
public class CEO2 extends Application {

    int btnnn;

    Button[] btnara = new Button[20];
    int[] flag = new int[20];
    Button[] btnaras = new Button[20];
    int[] flags = new int[20];

    @Override
    public void start(Stage primaryStage) throws Exception {

        for (int i = 0; i < 20; i++) {
            btnara[i] = new Button("Confirm");
            flag[i] = 0;
            btnaras[i] = new Button("Confirm");
            flags[i] = 0;
        }

        Button btn = new Button();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: lightblue;");
        grid.setHgap(30);
        grid.setVgap(20);

        Scene openwindow = new Scene(grid, 600, 500);

        primaryStage.setScene(openwindow);

        grid.setAlignment(Pos.CENTER);

        Text greetings = new Text("     CEO");
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 50));
        grid.add(greetings, 0, 2, 3, 1);

        Button loginbutton = new Button("Discount Requests");
        
              loginbutton.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        
        VBox lx = new VBox(50);
        loginbutton.setPrefSize(150, 30);
        lx.setAlignment(Pos.CENTER);
        lx.getChildren().add(loginbutton);
        grid.add(lx, 1, 4); 

        loginbutton.setOnMouseEntered(e -> {
            loginbutton.setCursor(Cursor.HAND);
        });

        Button signupbutton = new Button("Supply requests");
        
            signupbutton.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox sx = new VBox(50);
        signupbutton.setPrefSize(150, 30);
        sx.setAlignment(Pos.CENTER);
        sx.getChildren().add(signupbutton);
        grid.add(sx, 1, 6);

        signupbutton.setOnMouseEntered(e -> {
            signupbutton.setCursor(Cursor.HAND);
        });

        Button showjobhistry = new Button("Show Job History");
        
          showjobhistry.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox gx = new VBox(50);
        showjobhistry.setPrefSize(150, 30);
        gx.setAlignment(Pos.CENTER);
        gx.getChildren().add(showjobhistry);
        grid.add(gx, 1, 8);

        showjobhistry.setOnMouseEntered(e -> {
            showjobhistry.setCursor(Cursor.HAND);
        });

        
          showjobhistry.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

        Stage Secondstage=new Stage();
        jobhistorytable jb=new jobhistorytable();
                try {
                    jb.start(Secondstage);
                } catch (Exception ex) {
                    Logger.getLogger(CEO.class.getName()).log(Level.SEVERE, null, ex);
                }
        

            }
        });

        
        
        
        Button exitbutton = new Button("Log Out");
        
         exitbutton.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox ex = new VBox(50);
        exitbutton.setPrefSize(150, 30);
        ex.setAlignment(Pos.CENTER);
        ex.getChildren().add(exitbutton);
        grid.add(ex, 1, 10);

        exitbutton.setOnMouseEntered(e -> {
            exitbutton.setCursor(Cursor.HAND);
        });

        exitbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                login lgn = new login();
                lgn.start(primaryStage);
            }
        });

        //---------------------------------------------------------
        GridPane grid12 = new GridPane();
        grid12.setStyle("-fx-background-color: lightblue;");
        grid12.setHgap(30);
        grid12.setVgap(20);

        grid12.setAlignment(Pos.CENTER);

        Scene requestwindow = new Scene(grid12, 1200, 450);

        //primaryStage.setScene(requestwindow);
        loginbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(requestwindow);
            }
        });

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
        grid12.add(tblcol5, 0, 0);

        Button backfromreqtoempwindow = new Button("Back");
        VBox backemp11 = new VBox(50);
        backfromreqtoempwindow.setPrefSize(100, 30);
        backemp11.setAlignment(Pos.CENTER_LEFT);
        backemp11.getChildren().add(backfromreqtoempwindow);
        grid12.add(backemp11, 0, 1);

        backfromreqtoempwindow.setOnMouseEntered(e -> {
            backfromreqtoempwindow.setCursor(Cursor.HAND);
        });

        backfromreqtoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });
        
        

        ///--------------------------------------------
        GridPane grid14 = new GridPane();
        grid14.setStyle("-fx-background-color: lightblue;");
        grid14.setHgap(30);
        grid14.setVgap(20);

        grid14.setAlignment(Pos.CENTER);

        Scene requestsupwindow = new Scene(grid14, 1200, 450);
        //Button ceobtn = new Button();//HUDAAAAI
        signupbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(requestsupwindow);
            }
        });

     int maxbutton=0;

 String sqlextract
                            = "SELECT MAX(BUTTON_NO)\n" +
"From REQUEST_DISCOUNT";

                    String discreqinfo[] = new String[6];

                   
                        Connection con = new OracleDBMS().getConnection();
                        PreparedStatement pst = con.prepareStatement(sqlextract);

                        ResultSet rs = pst.executeQuery();

                        while (rs.next()) {
                                maxbutton=rs.getInt(1);
                        }

        
        
        
        
        for(int i=1;i<maxbutton;i++){
            eventlistenercall(i);
        }
        
        
        
        
        final Label labelreqsup = new Label("Requests For Supplies:");
        labelreqsup.setFont(new Font("Arial", 20));

        TableView<requestsupshow> tablerequestsup;

        TableColumn<requestsupshow, Integer> REQSID = new TableColumn<>("Request Id");
        REQSID.setMinWidth(100);
        REQSID.setCellValueFactory(new PropertyValueFactory<>("reqid"));

        TableColumn<requestsupshow, Integer> RSSUPID = new TableColumn<>("Supplier Id");
        RSSUPID.setMinWidth(100);
        RSSUPID.setCellValueFactory(new PropertyValueFactory<>("supid"));

        TableColumn<requestsupshow, Integer> RSPROID = new TableColumn<>("Product Id");
        RSPROID.setMinWidth(100);
        RSPROID.setCellValueFactory(new PropertyValueFactory<>("proid"));

        TableColumn<requestsupshow, Integer> RSQUAN = new TableColumn<>("Quantity");
        RSQUAN.setMinWidth(100);
        RSQUAN.setCellValueFactory(new PropertyValueFactory<>("quan"));

        TableColumn<requestsupshow, String> RSSTART = new TableColumn<>("Order Date");
        RSSTART.setMinWidth(200);
        RSSTART.setCellValueFactory(new PropertyValueFactory<>("ordate"));

        TableColumn<requestsupshow, String> RSEND = new TableColumn<>("Supply Date");
        RSEND.setMinWidth(200);
        RSEND.setCellValueFactory(new PropertyValueFactory<>("sudate"));

        TableColumn<requestsupshow, Integer> RSPRI = new TableColumn<>("Price");
        RSPRI.setMinWidth(100);
        RSPRI.setCellValueFactory(new PropertyValueFactory<>("pri"));

        TableColumn<requestsupshow, Integer> RSSENTBY = new TableColumn<>("Sent By");
        RSSENTBY.setMinWidth(100);
        RSSENTBY.setCellValueFactory(new PropertyValueFactory<>("sent_by"));

        TableColumn<requestsupshow, Integer> RSBTN = new TableColumn<>("Confirm Buttons");
        RSBTN.setMinWidth(100);
        RSBTN.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tablerequestsup = new TableView<>();
        tablerequestsup.setItems(getrequestsupshow());
        tablerequestsup.getColumns().addAll(REQSID, RSSUPID, RSPROID, RSQUAN, RSSTART, RSEND, RSPRI, RSSENTBY, RSBTN);

        VBox tblcol5s = new VBox();
        tblcol5s.setMinWidth(1100);
        tblcol5s.setSpacing(10);
        tblcol5s.setPadding(new Insets(0, 0, 0, 0));
        tblcol5s.getChildren().addAll(labelreqsup, tablerequestsup);
        grid14.add(tblcol5s, 0, 0);

        Button backfromreqsuptoempwindow = new Button("Back");
        VBox backemp11s = new VBox(50);
        backfromreqsuptoempwindow.setPrefSize(100, 30);
        backemp11s.setAlignment(Pos.CENTER_LEFT);
        backemp11s.getChildren().add(backfromreqsuptoempwindow);
        grid14.add(backemp11s, 0, 1);

        backfromreqsuptoempwindow.setOnMouseEntered(e -> {
            backfromreqsuptoempwindow.setCursor(Cursor.HAND);
        });

        backfromreqsuptoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });

   

    
    }
    
    
    
    private void eventlistenercall(int i){
         btnara[i].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                    
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

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return mm;

    }

    private ObservableList<requestsupshow> getrequestsupshow() {
        ObservableList<requestsupshow> mm = FXCollections.observableArrayList();

        String sqlprice
                = "SELECT REQUEST_ID, SUPPLIER_ID, PRODUCT_ID, QUANTITY, ORDER_DATE, SUPPLY_DATE, PRICE, SENT_BY, BUTTON_NO\n"
                + "FROM REQUEST_SUPPLY";

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sqlprice);
            System.out.println("Its getdiscountshow");
            ResultSet rs = pst.executeQuery();
            int btni = 0;
            while (rs.next()) {
                btni = rs.getInt(9);
                //   total=rs.getFloat(1);
                //   novat=rs.getFloat(2);
                mm.add(new requestsupshow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), btnaras[btni]));
                System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));
                System.out.println("sdshlkgafepogtsr");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return mm;

    }

}
