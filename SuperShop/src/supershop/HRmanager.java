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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;







public class HRmanager extends Application {
        String  hrmanid;
            Stage stage;
   
          
       public HRmanager(String hrmanid) {
                this.hrmanid = hrmanid;
        }

        @Override
    public void start(Stage primaryStage) throws Exception {
    stage=primaryStage;
        GridPane grid5 = new GridPane();
        grid5.setStyle("-fx-background-color: silver;");
        grid5.setHgap(30);
        grid5.setVgap(20);

        grid5.setAlignment(Pos.CENTER);

        Scene openwindow = new Scene(grid5, 600, 500);
        stage.setScene(openwindow);
        stage.show();
        
      //  Color.BLANCHEDALMOND
        Text guestwintext = new Text("      HR Manager Account");
        guestwintext.setFill(Color.STEELBLUE);
        guestwintext.setFont(Font.font("Constantia", FontWeight.BOLD, 30));
        grid5.add(guestwintext, 0, 0, 1, 1);
        
        Button upsal = new Button("Update Salary");
        upsal.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox guest1 = new VBox(50);
        upsal.setPrefSize(200, 35);
        guest1.setAlignment(Pos.CENTER);
        guest1.getChildren().add(upsal);
        grid5.add(guest1, 0, 2);
        
        upsal.setOnMouseEntered(e -> {
            upsal.setCursor(Cursor.HAND);
        });
        
      
        Button prom = new Button(" Promotion ");
          prom.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox guest3 = new VBox(50);
        prom.setPrefSize(200, 35);
        guest3.setAlignment(Pos.CENTER);
        guest3.getChildren().add(prom);
        grid5.add(guest3, 0, 4);
        
        prom.setOnMouseEntered(e -> {
            prom.setCursor(Cursor.HAND);
        });
        
        
        
        Button discbtn = new Button("Show Info of Employee");
        
        discbtn.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox guest4 = new VBox(50);
        discbtn.setPrefSize(200, 35);
        guest4.setAlignment(Pos.CENTER);
        guest4.getChildren().add(discbtn);
        grid5.add(guest4, 0, 6);
        
        discbtn.setOnMouseEntered(e -> {
            discbtn.setCursor(Cursor.HAND);
        });
        
        
        //-----------------
        
        GridPane grid3 = new GridPane();
        grid3.setStyle("-fx-background-color: BLANCHEDALMOND;");
        grid3.setHgap(30);
        grid3.setVgap(20);

        grid3.setAlignment(Pos.CENTER);

        Scene empmngrshipwindow = new Scene(grid3, 1100, 440);
        
        discbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(empmngrshipwindow);
            }
        });
        
        final Label labelmngrshp = new Label("Employees under Your Supervision:");
        labelmngrshp.setFont(new Font("Arial",20));
        
        TableView<mysupervision> table2;
        TableColumn<mysupervision,Integer> EMPID=new TableColumn<>("EMPLOYEE_ID");
        EMPID.setMinWidth(100);
        EMPID.setCellValueFactory(new PropertyValueFactory<>("empid"));
          
          
          
        TableColumn<mysupervision,String> EMPNAME=new TableColumn<>("Name");
          EMPNAME.setMinWidth(200);
          EMPNAME.setCellValueFactory(new PropertyValueFactory<>("empname"));
          
          
        TableColumn<mysupervision,String> EMPADD=new TableColumn<>("ADDRESS");
          EMPADD.setMinWidth(200);
          EMPADD.setCellValueFactory(new PropertyValueFactory<>("empadd"));
          
                  TableColumn<mysupervision,String> BD=new TableColumn<>("BIRTH_DATE");
          BD.setMinWidth(200);
          BD.setCellValueFactory(new PropertyValueFactory<>("bd"));
          
                  
 TableColumn<mysupervision,Integer> SAL=new TableColumn<>("SALARY");
          SAL.setMinWidth(100);
          SAL.setCellValueFactory(new PropertyValueFactory<>("sal"));
          
          
          TableColumn<mysupervision,String> HRD=new TableColumn<>("HIRE_DATE");
          HRD.setMinWidth(200);
          HRD.setCellValueFactory(new PropertyValueFactory<>("hrd"));

          
           TableColumn<mysupervision,Integer> JOBID=new TableColumn<>("JOB_ID");
          JOBID.setMinWidth(100);
          JOBID.setCellValueFactory(new PropertyValueFactory<>("jobid"));
          
            TableColumn<mysupervision,String> GENDER=new TableColumn<>("GENDER");
          GENDER.setMinWidth(100);
          GENDER.setCellValueFactory(new PropertyValueFactory<>("gender"));

          table2=new TableView<>();
          table2.setItems(getundermysupervision());
          table2.getColumns().addAll(EMPID,EMPNAME,EMPADD,BD,SAL,HRD,JOBID,GENDER);
         // VBox vbox=new VBox();
          //vbox.getChildren().addAll(table2);
        
        
        
        
        
        
        
        
        
        
        
        
        
      
        
        VBox tblcol = new VBox();
        tblcol.setMinWidth(1100);
        tblcol.setSpacing(5);
        tblcol.setPadding(new Insets(0,0,0,0));
        tblcol.getChildren().addAll(labelmngrshp,table2);
        grid3.add(tblcol, 0, 0);
        
        Button backfrommngrshptoempwindow = new Button("Back");
        
        backfrommngrshptoempwindow.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox backemp2 = new VBox(50);
        backfrommngrshptoempwindow.setPrefSize(100, 30);
        backemp2.setAlignment(Pos.CENTER_LEFT);
        backemp2.getChildren().add(backfrommngrshptoempwindow);
        grid3.add(backemp2, 0, 1);
        
        backfrommngrshptoempwindow.setOnMouseEntered(e -> {
            backfrommngrshptoempwindow.setCursor(Cursor.HAND);
        });
        
        backfrommngrshptoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });
        
        //----------------
       
        
        
        Button backfromguesttoempwindow = new Button("Log Out");
        
        
        backfromguesttoempwindow.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox backemp3 = new VBox(50);
        backfromguesttoempwindow.setPrefSize(150, 35);
        backemp3.setAlignment(Pos.CENTER);
        backemp3.getChildren().add(backfromguesttoempwindow);
        grid5.add(backemp3, 0, 10);
        
        backfromguesttoempwindow.setOnMouseEntered(e -> {
            backfromguesttoempwindow.setCursor(Cursor.HAND);
        });
        
        backfromguesttoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              //  primaryStage.setScene(openwindow);
                  login lgn=new login();
              lgn.start(stage);
            }
        });
        
        /*
        Text guestwinwarn = new Text("NOTE: Guest account do not allow any changes or updates.");
        guestwinwarn.setFill(Color.RED);
        guestwinwarn.setFont(Font.font("Constantia", FontWeight.BOLD, 16));
        grid5.add(guestwinwarn, 0, 12, 1, 1);
        */
        
        
        
      
        
        //update sal
        
        
        GridPane gridincreasesal = new GridPane();
        gridincreasesal.setStyle("-fx-background-color: silver;");
        gridincreasesal.setHgap(30);
        gridincreasesal.setVgap(20);

        gridincreasesal.setAlignment(Pos.CENTER);

        Scene addsupplywindow = new Scene(gridincreasesal, 600, 500);
        
      
        
        upsal.setOnAction((event) -> {
            stage.setScene(addsupplywindow);
        });
        
        
       Text icmotxt = new Text("Update Salary");
        icmotxt.setFill(Color.DODGERBLUE);
        icmotxt.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
        gridincreasesal.add(icmotxt, 0, 0, 5, 1);
        
        
       Text label1 = new Text("Employee Id ");
        label1.setFill(Color.DODGERBLUE);
        label1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridincreasesal.add(label1, 0, 1);
        
          Text label2 = new Text("Set Salary");
        label2.setFill(Color.DODGERBLUE);
        label2.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridincreasesal.add(label2, 0, 2);
        
        
        
        VBox pr1[];
        pr1 = new VBox[1];
        TextField p1[];
        p1 = new TextField[1];
        
        pr1[0] = new VBox();
            pr1[0].setAlignment(Pos.TOP_LEFT);
            
            p1[0] = new TextField();
            p1[0].setPrefSize(200, 30);
            
            p1[0].setPromptText("");
            pr1[0].getChildren().add(p1[0]);
            
            
            
            VBox pr2[];
        pr2 = new VBox[1];
        TextField p2[];
        p2 = new TextField[1];
        
        pr2[0] = new VBox();
            pr2[0].setAlignment(Pos.TOP_LEFT);
            
            p2[0] = new TextField();
            p2[0].setPrefSize(200, 30);
            
            p2[0].setPromptText("");
            pr2[0].getChildren().add(p2[0]);
           
            
                gridincreasesal.add(pr1[0], 1, 1);
        gridincreasesal.add(pr2[0], 1, 2);
        
        
            Button add=new Button("ADD");
            add.setPrefSize(150, 35);
            add.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
            
             gridincreasesal.add(add, 1, 4);
             
            add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
             //insertsupplier(p1[0].getText(),p2[0].getText());
             
            // String managerid="55561";
             
             boolean success = new permitioncheck().checkcredentials(p1[0].getText(), hrmanid);
        if (success)
        {

            updatesalary(p1[0].getText(),p2[0].getText());

        } else
        {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("THE EMPLOYEE_ID YOU INSERTED IS NOT UNDER YOUR SUPERVISION.");
            alert.showAndWait();
        }
                
             
             
             
             
             
             
             
             
             
           
            }
            });
            
              Button backfromsupplier=new Button("BACK");
              
              backfromsupplier.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
            backfromsupplier.setPrefSize(150, 35);
             gridincreasesal.add(backfromsupplier, 1, 6);
             
                 backfromsupplier.setOnAction((event) -> {
            stage.setScene(openwindow);
        });
            
        
        
        /// promotion
        
        
         
        GridPane gridpromotion = new GridPane();
        gridpromotion.setStyle("-fx-background-color: silver;");
        gridpromotion.setHgap(30);
        gridpromotion.setVgap(20);

        gridpromotion.setAlignment(Pos.CENTER);

        Scene addorderwindow = new Scene(gridpromotion, 600, 600);
        
      
        
        prom.setOnAction((event) -> {
            stage.setScene(addorderwindow);
        });
        
        
       Text ordertxt = new Text("Promotion");
        ordertxt.setFill(Color.DODGERBLUE);
        ordertxt.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
        gridpromotion.add(ordertxt, 0, 0, 5, 1);
        
        
       Text label12 = new Text("EMPLOYEE ID");
        label12.setFill(Color.DODGERBLUE);
        label12.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridpromotion.add(label12, 0, 1);
        
          Text label22 = new Text("JOB ID");
        label22.setFill(Color.DODGERBLUE);
        label22.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridpromotion.add(label22, 0, 2);
        
        Text label32 = new Text("SALARY");
        label32.setFill(Color.DODGERBLUE);
        label32.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridpromotion.add(label32, 0, 3);
        
        
        
        Text label42 = new Text("MANAGER ID");
        label42.setFill(Color.DODGERBLUE);
        label42.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridpromotion.add(label42, 0, 4);
        /*
        Text label52 = new Text("SUPPLY DATE");
        label52.setFill(Color.DODGERBLUE);
        label52.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridpromotion.add(label52, 0, 5);
        */
        
        VBox pr12[];
        pr12 = new VBox[1];
        TextField p12[];
        p12= new TextField[1];
        
        pr12[0] = new VBox();
            pr12[0].setAlignment(Pos.TOP_LEFT);
            
            p12[0] = new TextField();
            p12[0].setPrefSize(200, 30);
            
            p12[0].setPromptText("");
            pr12[0].getChildren().add(p12[0]);
            
            
            
            VBox pr22[];
        pr22= new VBox[1];
        TextField p22[];
        p22 = new TextField[1];
        
        pr22[0] = new VBox();
            pr22[0].setAlignment(Pos.TOP_LEFT);
            
            p22[0] = new TextField();
            p22[0].setPrefSize(200, 30);
            
            p22[0].setPromptText("");
            pr22[0].getChildren().add(p22[0]);
           
            
                  VBox pr32[];
        pr32= new VBox[1];
        TextField p32[];
        p32 = new TextField[1];
        
        pr32[0] = new VBox();
            pr32[0].setAlignment(Pos.TOP_LEFT);
            
            p32[0] = new TextField();
            p32[0].setPrefSize(200, 30);
            
            p32[0].setPromptText("");
            pr32[0].getChildren().add(p32[0]);
            
            
            
                  VBox pr42[];
        pr42= new VBox[1];
        TextField p42[];
        p42 = new TextField[1];
        
        pr42[0] = new VBox();
            pr42[0].setAlignment(Pos.TOP_LEFT);
            
            p42[0] = new TextField();
            p42[0].setPrefSize(200, 30);
            
            p42[0].setPromptText("");
            pr42[0].getChildren().add(p42[0]);
            
            /*
            
                       VBox pr52[];
        pr52= new VBox[1];
        TextField p52[];
        p52 = new TextField[1];
        
        pr52[0] = new VBox();
            pr52[0].setAlignment(Pos.TOP_LEFT);
            
            p52[0] = new TextField();
            p52[0].setPrefSize(200, 30);
            
            p52[0].setPromptText("");
            pr52[0].getChildren().add(p52[0]);
            */
            
            
                gridpromotion.add(pr12[0], 1, 1);
        gridpromotion.add(pr22[0], 1, 2);
                gridpromotion.add(pr32[0], 1, 3);
            
                
                gridpromotion.add(pr42[0], 1, 4);
                /*
     gridpromotion.add(pr52[0], 1, 5);
*/

        
        
            Button addorder=new Button("ADD");
            addorder.setPrefSize(150, 35);
            addorder.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
            
             gridpromotion.add(addorder, 1, 6);
             
            addorder.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              
           //  insertorder(p12[0].getText(),p22[0].getText(),p32[0].getText(),p42[0].getText(),p52[0].getText());
           
        //  String managerid2="55561";
             
             boolean success = new permitioncheck().checkcredentials(p12[0].getText(), hrmanid);
        if (success)
        {

              promotion(p12[0].getText(),p22[0].getText(),p32[0].getText(),p42[0].getText());

        } else
        {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("THE EMPLOYEE_ID YOU INSERTED IS NOT UNDER YOUR SUPERVISION.");
            alert.showAndWait();
        }
                
           
           
           
           
           
           
           
           
            }
            });
            
              Button backfromorder=new Button("BACK");
            backfromorder.setPrefSize(150, 35);
            backfromorder.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
            
             gridpromotion.add(backfromorder, 1, 7);
             
                 backfromorder.setOnAction((event) -> {
            stage.setScene(openwindow);
        });
            
        
                 
                 
                 // add discount
        
        /*
        GridPane gridadddiscount = new GridPane();
        gridadddiscount.setStyle("-fx-background-color: silver;");
        gridadddiscount.setHgap(30);
        gridadddiscount.setVgap(20);

        gridadddiscount.setAlignment(Pos.CENTER);

        Scene adddiscountwindow = new Scene(gridadddiscount, 600, 500);
        
      
        
        discbtn.setOnAction((event) -> {
            stage.setScene(adddiscountwindow);
        });
        
        
       Text discountxt = new Text("Add Order");
        discountxt.setFill(Color.DODGERBLUE);
        discountxt.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
        gridadddiscount.add(discountxt, 0, 0, 5, 1);
        
        
       Text label13 = new Text("PRODUCT ID");
        label13.setFill(Color.DODGERBLUE);
        label13.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridadddiscount.add(label13, 0, 1);
        
          Text label23 = new Text("PERCENT");
        label23.setFill(Color.DODGERBLUE);
        label23.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridadddiscount.add(label23, 0, 2);
        
        Text label33 = new Text("TYPE");
        label33.setFill(Color.DODGERBLUE);
        label33.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridadddiscount.add(label33, 0, 3);
        
        
        Text label43 = new Text("START DATE");
        label43.setFill(Color.DODGERBLUE);
        label43.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridadddiscount.add(label43, 0, 4);
        
        Text label53 = new Text("END DATE");
        label53.setFill(Color.DODGERBLUE);
        label53.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridadddiscount.add(label53, 0, 5);
        
        
        VBox pr13[];
        pr13 = new VBox[1];
        TextField p13[];
        p13= new TextField[1];
        
        pr13[0] = new VBox();
            pr13[0].setAlignment(Pos.TOP_LEFT);
            
            p13[0] = new TextField();
            p13[0].setPrefSize(200, 30);
            
            p13[0].setPromptText("");
            pr13[0].getChildren().add(p13[0]);
            
            
            
            VBox pr23[];
        pr23= new VBox[1];
        TextField p23[];
        p23 = new TextField[1];
        
        pr23[0] = new VBox();
            pr23[0].setAlignment(Pos.TOP_LEFT);
            
            p23[0] = new TextField();
            p23[0].setPrefSize(200, 30);
            
            p23[0].setPromptText("");
            pr23[0].getChildren().add(p23[0]);
           
            
                  VBox pr33[];
        pr33= new VBox[1];
        TextField p33[];
        p33 = new TextField[1];
        
        pr33[0] = new VBox();
            pr33[0].setAlignment(Pos.TOP_LEFT);
            
            p33[0] = new TextField();
            p33[0].setPrefSize(200, 30);
            
            p33[0].setPromptText("");
            pr33[0].getChildren().add(p33[0]);
            
            
                  VBox pr43[];
        pr43= new VBox[1];
        TextField p43[];
        p43 = new TextField[1];
        
        pr43[0] = new VBox();
            pr43[0].setAlignment(Pos.TOP_LEFT);
            
            p43[0] = new TextField();
            p43[0].setPrefSize(200, 30);
            
            p43[0].setPromptText("");
            pr43[0].getChildren().add(p43[0]);
            
            
            
                       VBox pr53[];
        pr53= new VBox[1];
        TextField p53[];
        p53 = new TextField[1];
        
        pr53[0] = new VBox();
            pr53[0].setAlignment(Pos.TOP_LEFT);
            
            p53[0] = new TextField();
            p53[0].setPrefSize(200, 30);
            
            p53[0].setPromptText("");
            pr53[0].getChildren().add(p53[0]);
            
            
            
                gridadddiscount.add(pr13[0], 1, 1);
        gridadddiscount.add(pr23[0], 1, 2);
                gridadddiscount.add(pr33[0], 1, 3);
                gridadddiscount.add(pr43[0], 1, 4);
     gridadddiscount.add(pr53[0], 1, 5);


        
        
            Button adddiscount=new Button("ADD");
            adddiscount.setPrefSize(150, 35);
             gridadddiscount.add(adddiscount, 1, 6);
             
            adddiscount.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
             insertdiscount(p13[0].getText(),p23[0].getText(),p33[0].getText(),p43[0].getText(),p53[0].getText());
            }
            });
            
              Button backfromdiscount=new Button("BACK");
            backfromdiscount.setPrefSize(150, 35);
             gridadddiscount.add(backfromdiscount, 1, 7);
             
                 backfromdiscount.setOnAction((event) -> {
            stage.setScene(openwindow);
        });
            
        
        */
        
        
        
        
        
        


    }
    
    
    public void updatesalary(String empid, String sal){
        //Md. Kamal Mia Md. Jamal Mia
        //01532144567
                               String sql="DECLARE\n" +
"BEGIN\n" +
"UPDATE_SALARY('"+empid+"','"+sal+"') ;\n" +
"END ;";
            System.out.println(sql);
            // eita diye kal insert hoiche kintu aj hocche nah

              try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
                    
                    int rs = pst.executeUpdate();
            
                     if (rs!=0) {
                         System.out.println("Value Inserted");
                     } else {
                         System.out.println("Value  Not Inserted");
                     }
                     
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
           
    }
    
    
    
    
    public void promotion(String empid, String jbid,String sal, String manid){
        //Md. Kamal Mia Md. Jamal Mia
        //01532144567
        
        

                    String sql="UPDATE EMPLOYEE\n" +
"SET SALARY = '"+sal+"', JOB_ID="+jbid+",MANAGER_ID="+manid+"\n" +
"WHERE EMPLOYEE_ID = '"+empid+"'";
            System.out.println(sql);
            // eita diye kal insert hoiche kintu aj hocche nah

              try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
                    
                    int rs = pst.executeUpdate();
            
                     if (rs!=0) {
                         System.out.println("Value Inserted");
                     } else {
                         System.out.println("Value  Not Inserted");
                     }
                     
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
           
    }
    
    
    
            
            
          
    
    public void insertdiscount(String proid, String per,String type, String startdate,String enddate){
        //Md. Kamal Mia Md. Jamal Mia
        //01532144567
        
        

                    String sql="INSERT INTO DISCOUNT(PRODUCT_ID,PERCENT,TYPE,START_DATE,END_DATE)"
                    + " VALUES ('"+proid+"','"+per+"','"+type+"',\"TO_DATE\"('"+startdate+"','YYYY-MM-DD'),\"TO_DATE\"('"+enddate+"','YYYY-MM-DD'))";
            System.out.println(sql);
            // eita diye kal insert hoiche kintu aj hocche nah

              try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
                    
                    int rs = pst.executeUpdate();
            
                     if (rs!=0) {
                         System.out.println("Value Inserted");
                     } else {
                         System.out.println("Value  Not Inserted");
                     }
                     
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
           
    }  
    
    /*
    
      public static void main(String[] args) {
        launch(args);
    }

*/

    private ObservableList<mysupervision> getundermysupervision() {
        ObservableList<mysupervision> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT EMPLOYEE_ID , EMP_NAME ,ADDRESS , BIRTH_DATE,SALARY,HIRE_DATE,JOB_ID,GENDER\n" +
                "FROM EMPLOYEE\n" +
                "WHERE MANAGER_ID='"+hrmanid+"'";
 
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new mysupervision(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getString(8));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
    }

}
