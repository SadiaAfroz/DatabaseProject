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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ICMO extends Application {

    String icmoid;
    Stage stage;
    int itt = 1;
    int max_pro_id;

    public ICMO(String icmoid) {
        this.icmoid = icmoid;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        GridPane grid5 = new GridPane();
        grid5.setStyle("-fx-background-color: ANTIQUEWHITE;");
        //  Color.ANTIQUEWHITE

        grid5.setHgap(30);
        grid5.setVgap(20);

        grid5.setAlignment(Pos.CENTER);

        Scene openwindow = new Scene(grid5, 600, 500);
        stage.setScene(openwindow);
        stage.show();

        Text guestwintext = new Text("                ICMO Account");
        guestwintext.setFill(Color.STEELBLUE);
        guestwintext.setFont(Font.font("Constantia", FontWeight.BOLD, 30));
        grid5.add(guestwintext, 0, 0, 1, 1);

        Button catbtn = new Button("Add Supplier");
        VBox guest1 = new VBox(50);
        catbtn.setPrefSize(150, 35);

        catbtn.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        guest1.setAlignment(Pos.CENTER);
        guest1.getChildren().add(catbtn);
        grid5.add(guest1, 0, 2);

        catbtn.setOnMouseEntered(e -> {
            catbtn.setCursor(Cursor.HAND);
        });

        //  maximum of product id
        getmax_proid();

        Button probtn = new Button("Add Products");
        VBox guest2 = new VBox(50);
        probtn.setPrefSize(150, 35);

        probtn.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        guest2.setAlignment(Pos.CENTER);
        guest2.getChildren().add(probtn);
        grid5.add(guest2, 0, 4);

        probtn.setOnMouseEntered(e -> {
            probtn.setCursor(Cursor.HAND);
        });

        Button suppliersbtn = new Button("New Order ");
        VBox guest3 = new VBox(50);
        suppliersbtn.setPrefSize(150, 35);

        suppliersbtn.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        guest3.setAlignment(Pos.CENTER);
        guest3.getChildren().add(suppliersbtn);
        grid5.add(guest3, 0, 6);

        suppliersbtn.setOnMouseEntered(e -> {
            suppliersbtn.setCursor(Cursor.HAND);
        });

        Button discbtn = new Button("Add Discount");
        VBox guest4 = new VBox(50);
        discbtn.setPrefSize(150, 35);

        discbtn.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        guest4.setAlignment(Pos.CENTER);
        guest4.getChildren().add(discbtn);
        grid5.add(guest4, 0, 8);

        discbtn.setOnMouseEntered(e -> {
            discbtn.setCursor(Cursor.HAND);
        });

        Button backfromguesttoempwindow = new Button("Log Out");
        VBox backemp3 = new VBox(50);
        backfromguesttoempwindow.setPrefSize(150, 35);

        backfromguesttoempwindow.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

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
                login lgn = new login();
                lgn.start(stage);
            }
        });

        /*
        Text guestwinwarn = new Text("NOTE: Guest account do not allow any changes or updates.");
        guestwinwarn.setFill(Color.RED);
        guestwinwarn.setFont(Font.font("Constantia", FontWeight.BOLD, 16));
        grid5.add(guestwinwarn, 0, 12, 1, 1);
         */
        // add supplier
        GridPane gridaddsupply = new GridPane();
        gridaddsupply.setStyle("-fx-background-color: silver;");
        gridaddsupply.setHgap(30);
        gridaddsupply.setVgap(20);

        gridaddsupply.setAlignment(Pos.CENTER);

        Scene addsupplywindow = new Scene(gridaddsupply, 600, 500);

        catbtn.setOnAction((event) -> {
            stage.setScene(addsupplywindow);
        });

        Text icmotxt = new Text("Add Supplier Info");
        icmotxt.setFill(Color.DODGERBLUE);
        icmotxt.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
        gridaddsupply.add(icmotxt, 0, 0, 5, 1);

        Text label1 = new Text("Supplier Name");
        label1.setFill(Color.DODGERBLUE);
        label1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridaddsupply.add(label1, 0, 1);

        Text label2 = new Text("Phone Number");
        label2.setFill(Color.DODGERBLUE);
        label2.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridaddsupply.add(label2, 0, 2);

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

        gridaddsupply.add(pr1[0], 1, 1);
        gridaddsupply.add(pr2[0], 1, 2);

        Button add = new Button("ADD");
        add.setPrefSize(150, 35);

        add.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        gridaddsupply.add(add, 1, 4);

        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                insertsupplier(p1[0].getText(), p2[0].getText());
            }
        });

        Button backfromsupplier = new Button("BACK");
        backfromsupplier.setPrefSize(150, 35);

        backfromsupplier.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        gridaddsupply.add(backfromsupplier, 1, 6);

        backfromsupplier.setOnAction((event) -> {
            stage.setScene(openwindow);
        });

        /// add order
        GridPane grid13 = new GridPane();
        grid13.setStyle("-fx-background-color: lightblue;");
        grid13.setHgap(20);
        grid13.setVgap(10);

        grid13.setAlignment(Pos.TOP_CENTER);

        Scene addorderwindow = new Scene(grid13, 1200, 450);
        //Button balsalbtn = new Button();//HUDAAAAI
        suppliersbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(addorderwindow);
            }
        });

        Text greetings2 = new Text("                                 Add Order");
        greetings2.setFill(Color.DODGERBLUE);
        greetings2.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 70));
        grid13.add(greetings2, 0, 0, 6, 1);

        Text shead1 = new Text("SUPPLIER ID: ");
        shead1.setFill(Color.BLACK);
        shead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid13.add(shead1, 0, 1);

        VBox shead1box = new VBox(50);
        shead1box.setAlignment(Pos.CENTER_LEFT);
        TextField shead1field = new TextField();
        shead1box.getChildren().add(shead1field);
        shead1field.setPrefSize(150, 30);
        grid13.add(shead1box, 1, 1);

        Text ohead1 = new Text("ORDER DATE: ");
        ohead1.setFill(Color.DODGERBLUE);
        ohead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid13.add(ohead1, 2, 1);

        VBox ohead1box = new VBox(50);
        ohead1box.setAlignment(Pos.CENTER_LEFT);
        TextField ohead1field = new TextField();
        ohead1box.getChildren().add(ohead1field);
        ohead1field.setPrefSize(150, 30);
        grid13.add(ohead1box, 3, 1);

        Text sdhead1 = new Text("SUPPLY DATE: ");
        sdhead1.setFill(Color.DODGERBLUE);
        sdhead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid13.add(sdhead1, 4, 1);

        VBox sdhead1box = new VBox(50);
        sdhead1box.setAlignment(Pos.CENTER_LEFT);
        TextField sdhead1field = new TextField();
        sdhead1box.getChildren().add(sdhead1field);
        sdhead1field.setPrefSize(150, 30);
        grid13.add(sdhead1box, 5, 1);

        Text phead1 = new Text("Product ID(1-30)");
        phead1.setFill(Color.BLACK);
        phead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid13.add(phead1, 0, 2);

        Text qhead1 = new Text("Quantity");
        qhead1.setFill(Color.BLACK);
        qhead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid13.add(qhead1, 2, 2);

        Text prihead1 = new Text("Price");
        prihead1.setFill(Color.BLACK);
        prihead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid13.add(prihead1, 4, 2);

        VBox proboxara[];
        proboxara = new VBox[10];

        VBox proboxara2[];
        proboxara2 = new VBox[10];

        VBox proboxara3[];
        proboxara3 = new VBox[10];

        //ekhane text fiels er jei array ta nicce okhan theke 
        //ee amader data collect korte hobe.
        //pname theke product name and pquan theke product quantity.
        // i namok variable theke amra total number of products pabo.
        // mane koi dhoroner product order kora hoise emn kichu.
        TextField pnameara[];
        pnameara = new TextField[10];

        TextField pquanara[];
        pquanara = new TextField[10];

        TextField ppriara[];
        ppriara = new TextField[10];

        for (int j = 0; j < 10; j++) {
            proboxara[j] = new VBox();
            proboxara[j].setAlignment(Pos.CENTER_LEFT);
            proboxara2[j] = new VBox();
            proboxara2[j].setAlignment(Pos.CENTER_LEFT);
            proboxara3[j] = new VBox();
            proboxara3[j].setAlignment(Pos.CENTER_LEFT);
            pnameara[j] = new TextField();
            pnameara[j].setPrefSize(150, 30);
            pquanara[j] = new TextField();
            pquanara[j].setPrefSize(70, 30);
            ppriara[j] = new TextField();
            ppriara[j].setPrefSize(70, 30);
            proboxara[j].getChildren().add(pnameara[j]);
            proboxara2[j].getChildren().add(pquanara[j]);
            proboxara3[j].getChildren().add(ppriara[j]);
        }

        grid13.add(proboxara[0], 0, 3);

        grid13.add(proboxara2[0], 2, 3);

        grid13.add(proboxara3[0], 4, 3);

        Button addnessupp = new Button("Add");
        
         addnessupp.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
         
        addnessupp.setPrefSize(80, 40);
        VBox addnessuppbx = new VBox(50);
        addnessuppbx.getChildren().add(addnessupp);
        addnessuppbx.setAlignment(Pos.CENTER);
        grid13.add(addnessuppbx, 6, 2);

        addnessupp.setOnMouseEntered(e -> {
            addnessupp.setCursor(Cursor.HAND);
        });

        addnessupp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // itt ekta global var
                if (itt < 10) {
                    grid13.add(proboxara[itt], 0, 3 + itt);
                    grid13.add(proboxara2[itt], 2, 3 + itt);
                    grid13.add(proboxara3[itt], 4, 3 + itt);
                    itt++;
                }

            }
        });

        Button doneaddsupp = new Button("Done");
        doneaddsupp.setPrefSize(80, 40);
        
            doneaddsupp.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox doneaddsuppbx = new VBox(50);
        doneaddsuppbx.getChildren().add(doneaddsupp);
        doneaddsuppbx.setAlignment(Pos.CENTER);
        grid13.add(doneaddsuppbx, 8, 2);

        doneaddsupp.setOnMouseEntered(e -> {
            doneaddsupp.setCursor(Cursor.HAND);
        });

        Button backfromaddsupp = new Button("Back");
        backfromaddsupp.setPrefSize(80, 40);
        
        backfromaddsupp.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox backfromaddsuppbx = new VBox(50);
        backfromaddsuppbx.getChildren().add(backfromaddsupp);
        backfromaddsuppbx.setAlignment(Pos.CENTER);
        grid13.add(backfromaddsuppbx, 10, 2);

        backfromaddsupp.setOnMouseEntered(e -> {
            backfromaddsupp.setCursor(Cursor.HAND);
        });

        backfromaddsupp.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });

        doneaddsupp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int it = itt;
                int sum = 0;
                for (int i = 0; i < it; i++) {
                    sum = sum + Integer.parseInt(ppriara[i].getText());
                }
                System.out.println(sum);

                if (sum < 50000) {
                    for (int i = 0; i < it; i++) {
                        System.out.println(shead1field.getText() + " " + pnameara[i].getText() + " " + pquanara[i].getText() + " " + ohead1field.getText() + " " + sdhead1field.getText() + " " + ppriara[i].getText());
                        insertorder(shead1field.getText(), pnameara[i].getText(), pquanara[i].getText(), ohead1field.getText(), sdhead1field.getText(), ppriara[i].getText());
                    }
                } else {
                    String sqlextract
                            = "SELECT MAX(BUTTON_NO) FROM REQUEST_SUPPLY";

                    String max_btn_num = new String();

                    try {
                        Connection con = new OracleDBMS().getConnection();
                        PreparedStatement pst = con.prepareStatement(sqlextract);

                        ResultSet rs = pst.executeQuery();

                        while (rs.next()) {
                            max_btn_num = Integer.toString(rs.getInt(1));
                            System.out.println(max_btn_num);
                        }

                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    int k = Integer.parseInt(max_btn_num);
                    k++;
                    for (int i = 0; i < it; i++) {
                        // ekhaner part ta j login korbe tar id hobe.. ami just emni integer diye disi
                        insertorderinreqsup(shead1field.getText(), pnameara[i].getText(), pquanara[i].getText(), ohead1field.getText(), sdhead1field.getText(), ppriara[i].getText(), 55574, k);
                        k++;
                    }

                }
            }

            private void insertorderinreqsup(String text, String text0, String text1, String text2, String text3, String text4, int i, int s) {
                String sql = "INSERT INTO REQUEST_SUPPLY(SUPPLIER_ID,PRODUCT_ID,QUANTITY,ORDER_DATE,SUPPLY_DATE,PRICE,SENT_BY,BUTTON_NO)"
                        + " VALUES ('" + text + "','" + text0 + "','" + text1 + "',\"TO_DATE\"('"
                        + text2 + "','YYYY-MM-DD'),\"TO_DATE\"('" + text3 + "','YYYY-MM-DD'),'" + text4 + "','" + i + "','" + s + "')";
                System.out.println(sql);
                // eita diye kal insert hoiche kintu aj hocche nah

                try {
                    Connection con = new OracleDBMS().getConnection();
                    PreparedStatement pst = con.prepareStatement(sql);

                    int rs = pst.executeUpdate();

                    if (rs != 0) {
                        System.out.println("Value Inserted");
                    } else {
                        System.out.println("Value  Not Inserted");
                    }

                    pst.close();
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });

//        GridPane gridaddorder = new GridPane();
//        gridaddorder.setStyle("-fx-background-color: silver;");
//        gridaddorder.setHgap(30);
//        gridaddorder.setVgap(20);
//
//        gridaddorder.setAlignment(Pos.CENTER);
//
//        Scene addorderwindow = new Scene(gridaddorder, 600, 600);
//        
//      
//        
//        suppliersbtn.setOnAction((event) -> {
//            stage.setScene(addorderwindow);
//        });
//        
//        
//       Text ordertxt = new Text("Add Order");
//        ordertxt.setFill(Color.DODGERBLUE);
//        ordertxt.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
//        gridaddorder.add(ordertxt, 0, 0, 5, 1);
//        
//        
//       Text label12 = new Text("SUPPLIER ID");
//        label12.setFill(Color.DODGERBLUE);
//        label12.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
//        gridaddorder.add(label12, 0, 1);
//        
//          Text label22 = new Text("PRODUCT ID");
//        label22.setFill(Color.DODGERBLUE);
//        label22.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
//        gridaddorder.add(label22, 0, 2);
//        
//        Text label32 = new Text("QUANTITY");
//        label32.setFill(Color.DODGERBLUE);
//        label32.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
//        gridaddorder.add(label32, 0, 3);
//        
//        
//        Text label42 = new Text("ORDER DATE");
//        label42.setFill(Color.DODGERBLUE);
//        label42.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
//        gridaddorder.add(label42, 0, 4);
//        
//        Text label52 = new Text("SUPPLY DATE");
//        label52.setFill(Color.DODGERBLUE);
//        label52.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
//        gridaddorder.add(label52, 0, 5);
//        
//        
//        VBox pr12[];
//        pr12 = new VBox[1];
//        TextField p12[];
//        p12= new TextField[1];
//        
//        pr12[0] = new VBox();
//            pr12[0].setAlignment(Pos.TOP_LEFT);
//            
//            p12[0] = new TextField();
//            p12[0].setPrefSize(200, 30);
//            
//            p12[0].setPromptText("");
//            pr12[0].getChildren().add(p12[0]);
//            
//            
//            
//            VBox pr22[];
//        pr22= new VBox[1];
//        TextField p22[];
//        p22 = new TextField[1];
//        
//        pr22[0] = new VBox();
//            pr22[0].setAlignment(Pos.TOP_LEFT);
//            
//            p22[0] = new TextField();
//            p22[0].setPrefSize(200, 30);
//            
//            p22[0].setPromptText("");
//            pr22[0].getChildren().add(p22[0]);
//           
//            
//                  VBox pr32[];
//        pr32= new VBox[1];
//        TextField p32[];
//        p32 = new TextField[1];
//        
//        pr32[0] = new VBox();
//            pr32[0].setAlignment(Pos.TOP_LEFT);
//            
//            p32[0] = new TextField();
//            p32[0].setPrefSize(200, 30);
//            
//            p32[0].setPromptText("");
//            pr32[0].getChildren().add(p32[0]);
//            
//            
//                  VBox pr42[];
//        pr42= new VBox[1];
//        TextField p42[];
//        p42 = new TextField[1];
//        
//        pr42[0] = new VBox();
//            pr42[0].setAlignment(Pos.TOP_LEFT);
//            
//            p42[0] = new TextField();
//            p42[0].setPrefSize(200, 30);
//            
//            p42[0].setPromptText("");
//            pr42[0].getChildren().add(p42[0]);
//            
//            
//            
//                       VBox pr52[];
//        pr52= new VBox[1];
//        TextField p52[];
//        p52 = new TextField[1];
//        
//        pr52[0] = new VBox();
//            pr52[0].setAlignment(Pos.TOP_LEFT);
//            
//            p52[0] = new TextField();
//            p52[0].setPrefSize(200, 30);
//            
//            p52[0].setPromptText("");
//            pr52[0].getChildren().add(p52[0]);
//            
//            
//            
//                gridaddorder.add(pr12[0], 1, 1);
//        gridaddorder.add(pr22[0], 1, 2);
//                gridaddorder.add(pr32[0], 1, 3);
//                gridaddorder.add(pr42[0], 1, 4);
//     gridaddorder.add(pr52[0], 1, 5);
//
//
//        
//        
//            Button addorder=new Button("ADD");
//            addorder.setPrefSize(150, 35);
//            
//                                   addorder.setStyle(
//    "-fx-text-fill: white;"
//            + "-fx-font-size: 12pt; "
//    +"-fx-font-family: \"Arial Narrow\";"
//    +"-fx-font-weight: bold;"
//    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
//     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
//        );
//             gridaddorder.add(addorder, 1, 6);
//             
//            addorder.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                
//             insertorder(p12[0].getText(),p22[0].getText(),p32[0].getText(),p42[0].getText(),p52[0].getText());
//            }
//            });
//            
//              Button backfromorder=new Button("BACK");
//            backfromorder.setPrefSize(150, 35);
//            
//                                 backfromorder.setStyle(
//    "-fx-text-fill: white;"
//            + "-fx-font-size: 12pt; "
//    +"-fx-font-family: \"Arial Narrow\";"
//    +"-fx-font-weight: bold;"
//    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
//     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
//        );
//            
//            
//             gridaddorder.add(backfromorder, 1, 7);
//             
//                 backfromorder.setOnAction((event) -> {
//            stage.setScene(openwindow);
//        });



        // add discount
        GridPane gridadddiscount = new GridPane();
        gridadddiscount.setStyle("-fx-background-color: silver;");
        gridadddiscount.setHgap(30);
        gridadddiscount.setVgap(20);

        gridadddiscount.setAlignment(Pos.CENTER);

        Scene adddiscountwindow = new Scene(gridadddiscount, 600, 500);

        discbtn.setOnAction((event) -> {
            stage.setScene(adddiscountwindow);
        });

        Text discountxt = new Text("Add Discount");
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
        p13 = new TextField[1];

        pr13[0] = new VBox();
        pr13[0].setAlignment(Pos.TOP_LEFT);

        p13[0] = new TextField();
        p13[0].setPrefSize(200, 30);

        p13[0].setPromptText("");
        pr13[0].getChildren().add(p13[0]);

        VBox pr23[];
        pr23 = new VBox[1];
        TextField p23[];
        p23 = new TextField[1];

        pr23[0] = new VBox();
        pr23[0].setAlignment(Pos.TOP_LEFT);

        p23[0] = new TextField();
        p23[0].setPrefSize(200, 30);

        p23[0].setPromptText("");
        pr23[0].getChildren().add(p23[0]);

        VBox pr33[];
        pr33 = new VBox[1];
        TextField p33[];
        p33 = new TextField[1];

        pr33[0] = new VBox();
        pr33[0].setAlignment(Pos.TOP_LEFT);

        p33[0] = new TextField();
        p33[0].setPrefSize(200, 30);

        p33[0].setPromptText("");
        pr33[0].getChildren().add(p33[0]);

        VBox pr43[];
        pr43 = new VBox[1];
        TextField p43[];
        p43 = new TextField[1];

        pr43[0] = new VBox();
        pr43[0].setAlignment(Pos.TOP_LEFT);

        p43[0] = new TextField();
        p43[0].setPrefSize(200, 30);

        p43[0].setPromptText("");
        pr43[0].getChildren().add(p43[0]);

        VBox pr53[];
        pr53 = new VBox[1];
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

        Button adddiscount = new Button("ADD");
        adddiscount.setPrefSize(150, 35);

        adddiscount.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        gridadddiscount.add(adddiscount, 1, 6);

        adddiscount.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                insertdiscount(p13[0].getText(), p23[0].getText(), p33[0].getText(), p43[0].getText(), p53[0].getText());
            }
        });

        Button backfromdiscount = new Button("BACK");
        backfromdiscount.setPrefSize(150, 35);
        backfromdiscount.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        gridadddiscount.add(backfromdiscount, 1, 7);

        backfromdiscount.setOnAction((event) -> {
            stage.setScene(openwindow);
        });

        // add products 
        GridPane grid9 = new GridPane();
        grid9.setStyle("-fx-background-color: silver;");
        grid9.setHgap(30);
        grid9.setVgap(20);

        grid9.setAlignment(Pos.CENTER);

        Scene addprowindow = new Scene(grid9, 600, 700);

        probtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(addprowindow);
            }
        });

        Text pro_idtxt = new Text("Product Id: ");
        pro_idtxt.setFill(Color.STEELBLUE);
        pro_idtxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_idtxt, 0, 1);

        Text pro_idtxt2 = new Text("" + max_pro_id);
        pro_idtxt2.setFill(Color.STEELBLUE);
        pro_idtxt2.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_idtxt2, 1, 1);

        Text pro_nametxt = new Text("Product Name: ");
        pro_nametxt.setFill(Color.STEELBLUE);
        pro_nametxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_nametxt, 0, 2);

        VBox p1box = new VBox(50);
        p1box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_namef = new TextField();
        p1box.getChildren().add(pro_namef);
        pro_namef.setPrefSize(150, 40);
        grid9.add(p1box, 1, 2);

        Text pro_pritxt = new Text("Price:   ");
        pro_pritxt.setFill(Color.STEELBLUE);
        pro_pritxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_pritxt, 0, 3);

        VBox p2box = new VBox(50);
        p2box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_prif = new TextField();
        p2box.getChildren().add(pro_prif);
        pro_prif.setPrefSize(150, 40);
        grid9.add(p2box, 1, 3);

        Text pro_vattxt = new Text("VAT(Percentage): ");
        pro_vattxt.setFill(Color.STEELBLUE);
        pro_vattxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_vattxt, 0, 4);

        VBox p3box = new VBox(50);
        p3box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_vatf = new TextField();
        p3box.getChildren().add(pro_vatf);
        pro_vatf.setPrefSize(150, 40);
        grid9.add(p3box, 1, 4);

        Text pro_quantxt = new Text("Quantity: ");
        pro_quantxt.setFill(Color.STEELBLUE);
        pro_quantxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_quantxt, 0, 5);

        VBox p4box = new VBox(50);
        p4box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_quanf = new TextField();
        p4box.getChildren().add(pro_quanf);
        pro_quanf.setPrefSize(150, 40);
        grid9.add(p4box, 1, 5);

        Text pro_mdtxt = new Text("Manufacturing Date: ");
        pro_mdtxt.setFill(Color.STEELBLUE);
        pro_mdtxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_mdtxt, 0, 6);

        VBox p5box = new VBox(50);
        p5box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_mdf = new TextField();
        p5box.getChildren().add(pro_mdf);
        pro_mdf.setPrefSize(150, 40);
        grid9.add(p5box, 1, 6);

        Text pro_xdtxt = new Text("Expiry Date: ");
        pro_xdtxt.setFill(Color.STEELBLUE);
        pro_xdtxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_xdtxt, 0, 7);

        VBox p6box = new VBox(50);
        p6box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_xdf = new TextField();
        p6box.getChildren().add(pro_xdf);
        pro_xdf.setPrefSize(150, 40);
        grid9.add(p6box, 1, 7);

        Text pro_cattxt = new Text("Category Id: ");
        pro_cattxt.setFill(Color.STEELBLUE);
        pro_cattxt.setFont(Font.font("Constantia", FontWeight.BOLD, 20));
        grid9.add(pro_cattxt, 0, 8);

        VBox p7box = new VBox(50);
        p7box.setAlignment(Pos.CENTER_LEFT);
        TextField pro_catf = new TextField();
        p7box.getChildren().add(pro_catf);
        pro_catf.setPrefSize(150, 40);
        grid9.add(p7box, 1, 8);

        Button backfromadnewptoempwindow = new Button("Cancel");

        backfromadnewptoempwindow.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox backemp9 = new VBox(50);
        backfromadnewptoempwindow.setPrefSize(100, 35);
        backemp9.setAlignment(Pos.CENTER_LEFT);
        backemp9.getChildren().add(backfromadnewptoempwindow);
        grid9.add(backemp9, 0, 10);

        backfromadnewptoempwindow.setOnMouseEntered(e -> {
            backfromadnewptoempwindow.setCursor(Cursor.HAND);
        });

        backfromadnewptoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });

        Button donenewproorder = new Button("Done");

        donenewproorder.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        VBox donenewproorderbox = new VBox(50);
        donenewproorder.setPrefSize(100, 35);
        donenewproorderbox.setAlignment(Pos.CENTER_RIGHT);
        donenewproorderbox.getChildren().add(donenewproorder);
        grid9.add(donenewproorderbox, 1, 10);

        donenewproorder.setOnMouseEntered(e -> {
            donenewproorder.setCursor(Cursor.HAND);
        });

        donenewproorder.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addnewproorder(max_pro_id, pro_namef.getText(), pro_prif.getText(), pro_vatf.getText(), pro_quanf.getText(), pro_mdf.getText(), pro_xdf.getText(), pro_catf.getText());
                max_pro_id++;
            }
        });

    }

    public void getmax_proid() {

        String sql = "SELECT MAX(PRODUCT_ID)\n"
                + "FROM PRODUCTS";
        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                max_pro_id = rs.getInt(1) + 1;

            }

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void addnewproorder(int max_pr_id, String text, String text0, String text1, String text2, String text3, String text4, String text5) {
        String sql = "INSERT INTO PRODUCTS VALUES ('" + max_pr_id + "', '" + text + "', '" + text0 + "', '" + text1 + "', '" + text2
                + "', TO_DATE('" + text3 + "','YYYY-MM-DD HH24:MI:SS'), TO_DATE('" + text4
                + "','YYYY-MM-DD HH24:MI:SS'), '" + text5 + "')";
        System.out.println(sql + "Ami eta korisiiiiiyeahah");
        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            int rs = pst.executeUpdate();

            if (rs != 0) {
                System.out.println("Value Inserted");

            } else {
                System.out.println("Value  Not Inserted");
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertsupplier(String name, String phnno) {
        //Md. Kamal Mia Md. Jamal Mia
        //01532144567
        String sql = "INSERT INTO SUPPLIER_INFO(NAME,PHONE_NO)"
                + " VALUES ('" + name + "','" + phnno + "')";
        System.out.println(sql);
        // eita diye kal insert hoiche kintu aj hocche nah

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            int rs = pst.executeUpdate();

            if (rs != 0) {
                System.out.println("Value Inserted");
            } else {
                System.out.println("Value  Not Inserted");
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void insertorder(String supid, String proid, String quan, String orderdate, String supdate, String price) {
        //Md. Kamal Mia Md. Jamal Mia
        //01532144567

        String sql = "DECLARE "
                + "BEGIN "
                + "INSERT INTO SUPPLIER(SUPPLIER_ID,PRODUCT_ID,QUANTITY,PRICE,ORDER_DATE,SUPPLY_DATE)"
                + " VALUES ('" + supid + "','" + proid + "','" + quan +"','"+ price+"',\"TO_DATE\"('" + orderdate + "','YYYY-MM-DD'),\"TO_DATE\"('" + supdate + "','YYYY-MM-DD'));"
                + "UPDATE PRODUCTS SET  QUANTITY = QUANTITY+" + quan + " WHERE PRODUCT_ID='" + proid + "';"
                + "END ;";

        /*
                      String sql="INSERT INTO SUPPLIER(SUPPLIER_ID,PRODUCT_ID,QUANTITY,ORDER_DATE,SUPPLY_DATE)"
                    + " VALUES ('"+supid+"','"+proid+"','"+quan+"',\"TO_DATE\"('"+orderdate+"','YYYY-MM-DD'),\"TO_DATE\"('"+supdate+"','YYYY-MM-DD'))";
         */
        System.out.println(sql);
        // eita diye kal insert hoiche kintu aj hocche nah

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            int rs = pst.executeUpdate();

            if (rs != 0) {
                System.out.println("Value update+  Inserted");
            } else {
                System.out.println("Value  Not Inserted");
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

//    public void insertdiscount(String proid, String per,String type, String startdate,String enddate){
//        //Md. Kamal Mia Md. Jamal Mia
//        //01532144567
//        
//        
//
//                    String sql="INSERT INTO DISCOUNT(PRODUCT_ID,PERCENT,TYPE,START_DATE,END_DATE)"
//                    + " VALUES ('"+proid+"','"+per+"','"+type+"',\"TO_DATE\"('"+startdate+"','YYYY-MM-DD'),\"TO_DATE\"('"+enddate+"','YYYY-MM-DD'))";
//            System.out.println(sql);
//            // eita diye kal insert hoiche kintu aj hocche nah
//
//              try{
//            Connection con = new OracleDBMS().getConnection();
//            PreparedStatement pst = con.prepareStatement(sql);
//                    
//                    int rs = pst.executeUpdate();
//            
//                     if (rs!=0) {
//                         System.out.println("Value Inserted");
//                     } else {
//                         System.out.println("Value  Not Inserted");
//                     }
//                     
//            pst.close();
//            con.close();
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//           
//    }  
    public void insertdiscount(String proid, String per, String type, String startdate, String enddate) {
        //Md. Kamal Mia Md. Jamal Mia
        //01532144567
        String sqlextract
                = "SELECT MAX(BUTTON_NO) FROM REQUEST_DISCOUNT";

        String max_btn_no = new String();

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sqlextract);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                max_btn_no = Integer.toString(rs.getInt(1));
                System.out.println(max_btn_no);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        int k = Integer.parseInt(max_btn_no);
        k++;

        String sql = "INSERT INTO REQUEST_DISCOUNT(PRODUCT_ID,PERCENT,TYPE,START_DATE,END_DATE,SENT_BY,BUTTON_NO)"
                + " VALUES ('" + proid + "','" + per + "','" + type + "',\"TO_DATE\"('"
                + startdate + "','YYYY-MM-DD'),\"TO_DATE\"('" + enddate + "','YYYY-MM-DD'),'" + icmoid + "','" + k + "')";
        System.out.println(sql);
        // eita diye kal insert hoiche kintu aj hocche nah

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            int rs = pst.executeUpdate();

            if (rs != 0) {
                System.out.println("Value Inserted");
            } else {
                System.out.println("Value  Not Inserted");
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*
      public static void main(String[] args) {
        launch(args);
    }

     */
}
