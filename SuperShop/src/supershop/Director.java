/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Director extends Application {

    String directorid;
    Stage stage;

    int max_pro_id;

    public Director(String directorid) {
        this.directorid = directorid;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        GridPane grid5 = new GridPane();
        grid5.setStyle("-fx-background-color: silver;");
        grid5.setHgap(30);
        grid5.setVgap(20);

        grid5.setAlignment(Pos.CENTER);

        Scene openwindow = new Scene(grid5, 600, 500);
        stage.setScene(openwindow);
        stage.show();

        Text guestwintext = new Text("    Director Account");
        guestwintext.setFill(Color.STEELBLUE);
        guestwintext.setFont(Font.font("Constantia", FontWeight.BOLD, 30));
        grid5.add(guestwintext, 0, 0, 1, 1);

        Button re = new Button("Recruit Employee");

        re.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        VBox guest1 = new VBox(50);
        re.setPrefSize(150, 35);
        guest1.setAlignment(Pos.CENTER);
        guest1.getChildren().add(re);
        grid5.add(guest1, 0, 2);

        re.setOnMouseEntered(e -> {
            re.setCursor(Cursor.HAND);
        });

        Button bc = new Button("Log Out");

        bc.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        VBox guest2 = new VBox(50);
        bc.setPrefSize(150, 35);
        guest2.setAlignment(Pos.CENTER);
        guest2.getChildren().add(bc);
        grid5.add(guest2, 0, 3);

        bc.setOnMouseEntered(e -> {
            bc.setCursor(Cursor.HAND);
        });

        bc.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                login lgn = new login();
                lgn.start(stage);
            }
        });

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: black;");
        grid.setHgap(30);
        grid.setVgap(20);
        grid.setAlignment(Pos.TOP_CENTER);
        Scene signwindow = new Scene(grid, 1000, 750);
        re.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(signwindow);
            }
        });

        Text greetings = new Text("WELCOME TO OUR SuperShop");
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
        grid.add(greetings, 0, 0, 5, 1);

        Text phead1 = new Text("Employee Name");
        phead1.setFill(Color.DODGERBLUE);
        phead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(phead1, 0, 1);

        VBox pr[];
        pr = new VBox[1];
        TextField p[];
        p = new TextField[1];

        pr[0] = new VBox();
        pr[0].setAlignment(Pos.TOP_LEFT);

        p[0] = new TextField();
        p[0].setPrefSize(120, 30);

        p[0].setPromptText("");
        pr[0].getChildren().add(p[0]);

        String n[] = new String[1];
        n[0] = p[0].getText();
        System.out.println(n[0]);

        Text qhead1 = new Text("Address");
        qhead1.setFill(Color.DODGERBLUE);
        qhead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead1, 0, 2);

        VBox pr1[];
        pr1 = new VBox[1];
        TextField p1[];
        p1 = new TextField[1];

        pr1[0] = new VBox();
        pr1[0].setAlignment(Pos.TOP_LEFT);

        p1[0] = new TextField();
        p1[0].setPrefSize(120, 30);

        p1[0].setPromptText("");
        pr1[0].getChildren().add(p1[0]);

        Text qhead2 = new Text("Date of Birth");
        qhead2.setFill(Color.DODGERBLUE);
        qhead2.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead2, 0, 3);

        VBox pr2[];
        pr2 = new VBox[1];
        TextField p2[];
        p2 = new TextField[1];

        pr2[0] = new VBox();
        pr2[0].setAlignment(Pos.TOP_LEFT);

        p2[0] = new TextField();
        p2[0].setPrefSize(120, 30);

        p2[0].setPromptText("");
        pr2[0].getChildren().add(p2[0]);

        Text qhead4 = new Text("Salary");
        qhead4.setFill(Color.DODGERBLUE);
        qhead4.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead4, 0, 4);

        VBox pr4[];
        pr4 = new VBox[1];
        TextField p4[];
        p4 = new TextField[1];

        pr4[0] = new VBox();
        pr4[0].setAlignment(Pos.TOP_LEFT);

        p4[0] = new TextField();
        p4[0].setPrefSize(120, 30);

        p4[0].setPromptText("");
        pr4[0].getChildren().add(p4[0]);

        Text qhead5 = new Text("Hire date");
        qhead5.setFill(Color.DODGERBLUE);
        qhead5.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead5, 0, 5);

        VBox pr5[];
        pr5 = new VBox[1];
        TextField p5[];
        p5 = new TextField[1];

        pr5[0] = new VBox();
        pr5[0].setAlignment(Pos.TOP_LEFT);

        p5[0] = new TextField();
        p5[0].setPrefSize(120, 30);

        p5[0].setPromptText("");
        pr5[0].getChildren().add(p5[0]);

        Text qhead6 = new Text("Job_id");
        qhead6.setFill(Color.DODGERBLUE);
        qhead6.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead6, 0, 6);

        VBox pr6[];
        pr6 = new VBox[1];
        TextField p6[];
        p6 = new TextField[1];

        pr6[0] = new VBox();
        pr6[0].setAlignment(Pos.TOP_LEFT);

        p6[0] = new TextField();
        p6[0].setPrefSize(120, 30);

        p6[0].setPromptText("");
        pr6[0].getChildren().add(p6[0]);

        Text qhead7 = new Text("Manager_id");
        qhead7.setFill(Color.DODGERBLUE);
        qhead7.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead7, 0, 7);

        VBox pr7[];
        pr7 = new VBox[1];
        TextField p7[];
        p7 = new TextField[1];

        pr7[0] = new VBox();
        pr7[0].setAlignment(Pos.TOP_LEFT);

        p7[0] = new TextField();
        p7[0].setPrefSize(120, 30);

        p7[0].setPromptText("");
        pr7[0].getChildren().add(p7[0]);

        Text qhead8 = new Text("Password");
        qhead8.setFill(Color.DODGERBLUE);
        qhead8.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead8, 0, 8);

        VBox pr8[];
        pr8 = new VBox[1];
        PasswordField p8[];
        p8 = new PasswordField[1];

        pr8[0] = new VBox();
        pr8[0].setAlignment(Pos.TOP_LEFT);

        p8[0] = new PasswordField();
        p8[0].setPrefSize(120, 30);

        p8[0].setPromptText("");
        pr8[0].getChildren().add(p8[0]);

        String ID[] = new String[1];
        //  String pass[]=new String[1];
        String name[] = new String[1];
        String DB[] = new String[1];
        String wh[] = new String[1];
        String ot[] = new String[1];
        String sl[] = new String[1];
        String jd[] = new String[1];
        String ps[] = new String[1];

        System.out.println();
        /*     ID[0]=p[0].getText();
                      name[0]=p1[0].getText();
                       DB[0]=p2[0].getText();
                       wh[0]=p4[0].getText();
                      ot[0]=p5[0].getText();
                       sl[0]=p6[0].getText();
                    jd[0]=p7[0].getText();
                    System.out.println("ndjkwwfnsdkajshfnkjasdfcjsdfkjSDjkf");
                              System.out.println(p[0]);
                   System.out.println(p[0]);

                   
                   System.out.println(p[0]);
                                      System.out.println(p[0]);

                    System.out.println(p[0]);
         */

        Button a = new Button("Sign Up");
        a.setPrefSize(130, 40);

        a.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        VBox ab = new VBox(50);
        ab.getChildren().add(a);
        ab.setAlignment(Pos.CENTER);
        grid.add(ab, 1, 10);

        Button back = new Button("Back");
        back.setPrefSize(130, 40);

        back.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 12pt; "
                + "-fx-font-family: \"Arial Narrow\";"
                + "-fx-font-weight: bold;"
                + "-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
                + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );

        VBox abback = new VBox(50);
        abback.getChildren().add(back);
        abback.setAlignment(Pos.CENTER);
        grid.add(abback, 0, 10);

        grid.add(pr[0], 1, 1);
        grid.add(pr1[0], 1, 2);
        grid.add(pr2[0], 1, 3);
        grid.add(pr4[0], 1, 4);
        grid.add(pr5[0], 1, 5);
        grid.add(pr6[0], 1, 6);
        grid.add(pr7[0], 1, 7);
        grid.add(pr8[0], 1, 8);

        a.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                ID[0] = p[0].getText();
                System.out.println(ID[0]);
                name[0] = p1[0].getText();
                System.out.println(name[0]);
                DB[0] = p2[0].getText();
                System.out.println(DB[0]);
                wh[0] = p4[0].getText();
                ot[0] = p5[0].getText();
                sl[0] = p6[0].getText();
                jd[0] = p7[0].getText();
                ps[0] = p8[0].getText();
                System.out.println("hello pass: " + ps[0]);

                String sql = "INSERT INTO Employee (EMP_NAME,ADDRESS,BIRTH_DATE,SALARY,HIRE_DATE,JOB_ID,MANAGER_ID,GENDER)"
                        + " VALUES ('" + ID[0] + "','" + name[0] + "',\"TO_DATE\"('" + DB[0] + "','YYYY-MM-DD')," + wh[0] + ",\"TO_DATE\"('" + ot[0] + "','YYYY-MM-DD ')," + sl[0] + "," + jd[0] + ",'Male')";
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

                userinfoinsert(ps[0]);

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.setScene(openwindow);
                //  login lg=new login();
                // lg.start(stage);

            }
        });

    }

    void userinfoinsert(String password) {
        System.out.println(password);
        /*
                      String sql2="INSERT INTO USER_INFO (PASSWORD,EMPLOYEE_ID)"
                    + " VALUES ('"+password+"',55602)";
         */
        String sql2 = "DECLARE\n"
                + "BEGIN\n"
                + "USER_INFO_INSERT('" + password + "') ;\n"
                + "END ;";

        System.out.println(sql2);
        // eita diye kal insert hoiche kintu aj hocche nah

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql2);

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

}
