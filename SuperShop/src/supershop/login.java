/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author JOHN
 */

public class login extends Application{
    
    //public class Guifordbproject extends Application {

    // COMMENT GULA PORE PORE JAIS SADIA...
    int i = 0;
    boolean go_for_more = true;
    boolean new_head = true;
    Stage stage;

    public login() {
    }

    
    
    @Override
    public void start(Stage primaryStage) {
// stage=primaryStage;
   Pane root=new Pane();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: CORNSILK;");
        
      //  Color.CORNSILK
        grid.setHgap(30);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);
        Scene openwindow = new Scene(grid, 900, 650 );
       // ImageView image1=new ImageView(new Image(getClass().getResourceAsStream("frontpage.PNG"), 600, 500, true, true));
        
       // image1.setFitHeight(500);
        //image1.setFitWidth(600);
        
      //  Image image = new Image("File:F:\\Faiza\frontpage.PNG");
//grid.getChildren().add(new ImageView(image));
       // grid.getChildren().add(new ImageView(new Image("frontpage.PNG")));
        
  primaryStage.setTitle("SUPERSHOP MANAGEMENT SYSTEM");
        primaryStage.setScene(openwindow);
        primaryStage.show();
        
        
        Text greetings = new Text("WELCOME TO OUR SuperShop");
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 40));
        grid.add(greetings, 0, 0, 5, 1);

        Text phead1 = new Text("USER_ID");
        phead1.setFill(Color.DODGERBLUE);
        phead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(phead1, 0, 2);
        
         VBox pr[];
        pr = new VBox[1];
        TextField p[];
        p = new TextField[1];
        
        pr[0] = new VBox();
            pr[0].setAlignment(Pos.CENTER_LEFT);
            
            p[0] = new TextField();
            p[0].setPrefSize(200, 40);
            
            p[0].setPromptText("");
            pr[0].getChildren().add(p[0]);
           


        Text qhead1 = new Text("PASSWORD");
        qhead1.setFill(Color.DODGERBLUE);
        qhead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead1, 0, 3);
        
         VBox pr1[];
        pr1 = new VBox[1];
        PasswordField p1[];
        p1 = new PasswordField[1];
        
        pr1[0] = new VBox();
            pr1[0].setAlignment(Pos.CENTER_LEFT);
            
            p1[0] = new PasswordField();
            p1[0].setPrefSize(200, 40);
            
            p1[0].setPromptText("");
            pr1[0].getChildren().add(p1[0]);
           

        grid.add(pr[0], 1, 2);
        grid.add(pr1[0], 1, 3);

      //  grid.add(pro2[0], 1, 2);

        Button logb = new Button("Login");
        logb.setPrefSize(100, 40);
        
        logb.setStyle(
    "-fx-text-fill: white;"
              + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
     //   
        
         // fi.setStyle("-fx-background-color:lightblue; -fx-text-fill: black;");
        
        
        
        
        
        /*
         Button signb = new Button("SignUp");
        signb.setPrefSize(100, 40);
        
        */
        HBox ab = new HBox(2);
        ab.setSpacing(20.0);
        
        
        ab.getChildren().add(logb);
       // ab.getChildren().add(signb);
        ab.setAlignment(Pos.CENTER);
        grid.add(ab, 1, 5);
        
        
         Button loginasguest=new Button("Login as guest");
        loginasguest.setPrefSize(200, 40);
            loginasguest.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
            grid.add(loginasguest, 1, 6);
        
        //login as guest r category te emn akta window create kor jeno 
          
        
        
        
        
        /*
        ComboBox<String> cmbox=new ComboBox<>();
            
            String[] items={" hello"," world ","what's going on"};
            
            
             ObservableList<String> cmbstr=FXCollections.observableArrayList();
             for(int i=0;i<3;i++){
                   cmbstr.add(items[i]);
             }
      
          //  cmbox.setModel( new DefaultComboBoxModel( items ) );
            cmbox.setItems(cmbstr);
            grid.add(cmbox, 1, 7);
        */
        
        
        
        
        
        
        //System.out.println(p[0].getText());
        //System.out.println(p1[0].getText());
    /*   Button doneb = new Button("Done");
        doneb.setPrefSize(80, 40);
        VBox bb = new VBox(50);
        bb.getChildren().add(doneb);
        bb.setAlignment(Pos.CENTER);
        grid.add(bb, 5, 2);
        
*/
    
    /*
    signb.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                    
                signup2 sn  =new signup2();
                sn.start(primaryStage);
            }
        });
    
    */
                
      String name[]=new String[1];
                String pass[]=new String[1];
              
        logb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             
                String employeeid = p[0].getText();
        String password = p1[0].getText();
        boolean success = new Users().validateLogin(employeeid, password);
        if (success)
        {
           // System.out.println("hello success");
            
            int check=checkingdesig(employeeid);
          //  System.out.println("after checking desig"+check);
            if(check==1) {
                  optionforcashier cashier=new optionforcashier(employeeid);
                    try {
                        cashier.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else if(check==2){
                
                
                  ICMO icmo=new ICMO(employeeid);
                    try {
                        icmo.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
              else if(check==3){
                
                
                  HRmanager hrman=new HRmanager(employeeid);
                    try {
                        hrman.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
              else if(check==4){
                
                
                  HRexecutive hrexe=new HRexecutive(employeeid);
                    try {
                        hrexe.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
               else if(check==5){
                
                
                  Director dir=new Director(employeeid);
                    try {
                        dir.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
            
            else if(check==6){
                
                
                  CEO c =new CEO();
                    try {
                        c.start(primaryStage);
                    } catch (Exception ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
          

        } else
        {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }
                
                
                
                
                
                
            }
        });
      
        /*
        
       stage.setTitle("SuperShop MANAGEMENT SYSTEM");
        stage.setScene(openwindow);
        stage.show();
        
        
        */
        
        
        
        
        //login as guest
        
        
        
        GridPane grid5 = new GridPane();
        grid5.setStyle("-fx-background-color: silver;");
        grid5.setHgap(30);
        grid5.setVgap(20);

        grid5.setAlignment(Pos.CENTER);

        Scene guestwindow = new Scene(grid5, 800, 600);
        
        loginasguest.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(guestwindow);
            }
        });
        
        Text guestwintext = new Text("                Guest Account");
        guestwintext.setFill(Color.STEELBLUE);
        guestwintext.setFont(Font.font("Constantia", FontWeight.BOLD, 30));
        grid5.add(guestwintext, 0, 0, 1, 1);
        
        Button catbtn = new Button("Products");
        VBox guest1 = new VBox(50);
        catbtn.setPrefSize(150, 35);
        
        
               catbtn.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        guest1.setAlignment(Pos.CENTER);
        guest1.getChildren().add(catbtn);
        grid5.add(guest1, 0, 2);
        
        
    

        
        
        
        
        
        
        
        catbtn.setOnMouseEntered(e -> {
            catbtn.setCursor(Cursor.HAND);
        });
        
        Button jobbtn = new Button("Jobs");
        VBox guest2 = new VBox(50);
        jobbtn.setPrefSize(150, 35);
        
        
                 jobbtn.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        guest2.setAlignment(Pos.CENTER);
        guest2.getChildren().add(jobbtn);
        grid5.add(guest2, 0, 4);
        
        jobbtn.setOnMouseEntered(e -> {
            jobbtn.setCursor(Cursor.HAND);
        });
        
        
        
        Button discbtn = new Button("Discounts");
        VBox guest4 = new VBox(50);
        discbtn.setPrefSize(150, 35);
        
        
          
                 discbtn.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
                 
        guest4.setAlignment(Pos.CENTER);
        guest4.getChildren().add(discbtn);
        grid5.add(guest4, 0, 6);
        
        discbtn.setOnMouseEntered(e -> {
            discbtn.setCursor(Cursor.HAND);
        });
        
        Button backfromguesttoempwindow = new Button("Home Page");
        VBox backemp3 = new VBox(50);
        backfromguesttoempwindow.setPrefSize(150, 35);
        backemp3.setAlignment(Pos.CENTER);
            
                 backfromguesttoempwindow.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        backemp3.getChildren().add(backfromguesttoempwindow);
        grid5.add(backemp3, 0, 8);
        
        backfromguesttoempwindow.setOnMouseEntered(e -> {
            backfromguesttoempwindow.setCursor(Cursor.HAND);
        });
        
        backfromguesttoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });
        
        Text guestwinwarn = new Text("NOTE: Guest account do not allow any changes or updates.");
        guestwinwarn.setFill(Color.RED);
        guestwinwarn.setFont(Font.font("Constantia", FontWeight.BOLD, 16));
        grid5.add(guestwinwarn, 0, 12, 1, 1);
/// ekhane guest hishebe login kore diff jinish check korte parbe.
/// moreover ekhane amra join ta use korbo categories er bhitore.
/// sub query o easily effient use kora jabe discount er moddhe.
/// ei part diye 2nd update er kaj complete hoi jabe.
/// 3rd update er kaj ta ami apatoto porio nai to bolte partesina kono kichu
/// categories er bhitore ami table create kortesi managership er moto kore
/// ekhaneo similarly table e data insert kore dite parbi ami jei code ta toke dibo oita diye
/// ami connect korte na parar karone check korte partesina amar ekhane tables create ee hoccena



//----------------------------------------------------------------------------------------------------------


// Products show by category



GridPane grid5_2 = new GridPane();
        grid5_2.setStyle("-fx-background-color: lightblue;");
        grid5_2.setHgap(30);
        grid5_2.setVgap(20);

        grid5_2.setAlignment(Pos.CENTER);

        Scene comboprowindow = new Scene(grid5_2, 800, 600);

        catbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(comboprowindow);
            }
        });
        
       
        
        
        
        final Label labelcombcat = new Label("Category :");
        labelcombcat.setFont(new Font("Arial", 20));

        final ComboBox combpro = new ComboBox();
        combpro.setMinWidth(200);
        combpro.setMinHeight(35);
        combpro.setPromptText("Select Category");
        //combpro.setFont(Font.font("Constantia", FontWeight.BOLD, 16));
        String catstring[] = new String[25];
  //String a[] = new String[25];
//        for(int asd=0;asd<30;asd++)
//        {
//            catstring[asd] = new String();
//        }
//        combpro.getItems().addAll(
//        "Fruits", "Vegetables", "Cosmetics"
//        );


        catstring = getcatnames();
    /// a=getcatnames();


        for (int asd = 0; asd < catstring.length; asd++) {
          //  System.out.println(catstring[asd]);
            combpro.getItems().add(catstring[asd]);
        }

        Button combodone = new Button("Done");
        combodone.setPrefSize(100, 35);
            combodone.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        // button er action
        HBox labcombbtn = new HBox();
        labcombbtn.setSpacing(20);
        labcombbtn.getChildren().addAll(labelcombcat, combpro, combodone);
        grid5_2.add(labcombbtn, 0, 0);
 
        combodone.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String value;
                value = combpro.getValue().toString();
                Productshowintable psit = new Productshowintable(value);
               Stage secondstage=new Stage();
                try {
                    psit.start(secondstage);
                } catch (Exception ex1) {
                    Logger.getLogger(Gui_for_sadia.class.getName()).log(Level.SEVERE, null, ex1);
                }

            }
        });

        Button backfromcombtocatintwindow = new Button("Back");
        VBox backemp8 = new VBox(50);
        backfromcombtocatintwindow.setPrefSize(100, 30);
        
               backfromcombtocatintwindow.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        backemp8.setAlignment(Pos.CENTER_LEFT);
        backemp8.getChildren().add(backfromcombtocatintwindow);
        grid5_2.add(backemp8, 0, 2);
        
        
        backfromcombtocatintwindow.setOnMouseEntered(e -> {
            backfromcombtocatintwindow.setCursor(Cursor.HAND);
        });

        backfromcombtocatintwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                  primaryStage.setScene(guestwindow);
            }
        });








    /*
        GridPane grid6 = new GridPane();
        grid6.setStyle("-fx-background-color: lightblue;");
        grid6.setHgap(30);
        grid6.setVgap(20);

        grid6.setAlignment(Pos.CENTER);

        Scene categorieswindow = new Scene(grid6, 500, 450);
        
        catbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(categorieswindow);
            }
        });
        
        final Label labelcats = new Label("Categories of Products:");
        labelcats.setFont(new Font("Arial",20));
        
        TableView tablecats = new TableView();
        tablecats.setEditable(true);
        tablecats.setMinWidth(400);
        
        TableColumn tcatid = new TableColumn("Category Id");
        TableColumn tcatname = new TableColumn("Category Name");
        TableColumn tcatnum = new TableColumn("Number of Products");
        
        tcatid.setMinWidth(100);
        tcatname.setMinWidth(200);
        tcatnum.setMinWidth(150);
        tablecats.getColumns().addAll(tcatid,tcatname,tcatnum);
        
        VBox tblcol2 = new VBox();
        tblcol2.setMinWidth(400);
        tblcol2.setSpacing(10);
        tblcol2.setPadding(new Insets(0,0,0,0));
        tblcol2.getChildren().addAll(labelcats,tablecats);
        grid6.add(tblcol2, 0, 0);
        
        Button backfromcattoempwindow = new Button("Back");
        VBox backemp5 = new VBox(50);
        backfromcattoempwindow.setPrefSize(100, 30);
        backemp5.setAlignment(Pos.CENTER_LEFT);
        backemp5.getChildren().add(backfromcattoempwindow);
        grid6.add(backemp5, 0, 1);
        
        backfromcattoempwindow.setOnMouseEntered(e -> {
            backfromcattoempwindow.setCursor(Cursor.HAND);
        });
        
        backfromcattoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(guestwindow);
            }
        });
/// ekhane halka patla calculations. Amader product count korar jnno join use korte hobe
/// Tui amake connection korai dewar por ami ee kore felbo eshob insha Allah.


////----------------------------------------------------------------------------------------

*/

        GridPane grid7 = new GridPane();
        grid7.setStyle("-fx-background-color: lightblue;");
        grid7.setHgap(30);
        grid7.setVgap(20);

        grid7.setAlignment(Pos.CENTER);

        Scene jobswindow = new Scene(grid7, 600, 450);
        
        jobbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(jobswindow);
            }
        });
        
        final Label labeljobs = new Label("Division of Labour:");
        labeljobs.setFont(new Font("Arial",20));
        
        
        
        
        
      /*  
        TableView tablejobs = new TableView();
        tablejobs.setEditable(true);
        tablejobs.setMinWidth(400);
        
        TableColumn tjobid = new TableColumn("Job Id");
        TableColumn tjobttl = new TableColumn("Job Title");
        TableColumn twrkrnum = new TableColumn("Number of Employees");
        
        tjobid.setMinWidth(100);
        tjobttl.setMinWidth(200);
        twrkrnum.setMinWidth(150);
        tablejobs.getColumns().addAll(tjobid,tjobttl,twrkrnum);
        
        
        */
        
        
        
        
         TableView<jobshow> tablejob;
 TableColumn<jobshow,Integer> JBID=new TableColumn<>("JOB_ID");
          JBID.setMinWidth(200);
          JBID.setCellValueFactory(new PropertyValueFactory<>("jobid"));
          
          
          
        TableColumn<jobshow,String> JBTITLE=new TableColumn<>("JOB_TITLE");
          JBTITLE.setMinWidth(200);
          JBTITLE.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
          
         
                  
 TableColumn<jobshow,Integer> EMPCOUNT=new TableColumn<>("NUMBER OF EMPLOYEES");
          EMPCOUNT.setMinWidth(300);
          EMPCOUNT.setCellValueFactory(new PropertyValueFactory<>("empcount"));
          
          

          tablejob=new TableView<>();
          tablejob.setItems(getjobshow());
          tablejob.getColumns().addAll(JBID,JBTITLE,EMPCOUNT);
        
        
        
        
        
        
        
        
        
        
        
        
        VBox tblcol3 = new VBox();
        tblcol3.setMinWidth(400);
        tblcol3.setSpacing(10);
        tblcol3.setPadding(new Insets(0,0,0,0));
        tblcol3.getChildren().addAll(labeljobs,tablejob);
        grid7.add(tblcol3, 0, 0);
        
        Button backfromjobtoempwindow = new Button("Back");
        VBox backemp6 = new VBox(50);
        backfromjobtoempwindow.setPrefSize(100, 30);
        
                  backfromjobtoempwindow.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        backemp6.setAlignment(Pos.CENTER_LEFT);
        backemp6.getChildren().add(backfromjobtoempwindow);
        grid7.add(backemp6, 0, 1);
        
        backfromjobtoempwindow.setOnMouseEntered(e -> {
            backfromjobtoempwindow.setCursor(Cursor.HAND);
        });
        
        backfromjobtoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(guestwindow);
            }
        });
/// ekhane job id and nam shate ekta join perform korar jnno number of employees add korsi

////------------------------------------------------------------------------------------------------------------





















        GridPane grid8 = new GridPane();
        grid8.setStyle("-fx-background-color: lightblue;");
        grid8.setHgap(30);
        grid8.setVgap(20);

        grid8.setAlignment(Pos.CENTER);

        Scene discwindow = new Scene(grid8, 1200, 450);
        
        discbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(discwindow);
            }
        });
        
        final Label labeldisc = new Label("Offers and Discounts:");
        labeldisc.setFont(new Font("Arial",20));
        
        
        
        
        /*
        
        TableView tabledisc = new TableView();
        tabledisc.setEditable(true);
        tabledisc.setMinWidth(1100);
        
        TableColumn tdiscid = new TableColumn("Discount Id");
        TableColumn tdiscpro = new TableColumn("Product Id");
        TableColumn tdiscpron = new TableColumn("Product Name");
        TableColumn tdiscperc = new TableColumn("Percentage");
        TableColumn tdiscpri = new TableColumn("Actual Price");
        TableColumn tdiscoff = new TableColumn("Off (in Taka)");
        TableColumn tdisctype = new TableColumn("Type");
        TableColumn tdiscstr = new TableColumn("Start Date");
        TableColumn tdiscend = new TableColumn("End Date");
        
        tdiscid.setMinWidth(100);
        tdiscpro.setMinWidth(100);
        tdiscpron.setMinWidth(200);
        tdiscperc.setMinWidth(100);
        tdiscpri.setMinWidth(100);
        tdiscoff.setMinWidth(100);
        tdisctype.setMinWidth(200);
        tdiscstr.setMinWidth(100);
        tdiscend.setMinWidth(100);
        
        tabledisc.getColumns().addAll(tdiscid,tdiscpro,tdiscpron,tdiscperc,tdiscpri,tdiscoff,tdisctype,tdiscstr,tdiscend);
        
        */
        
        
          
         TableView<discountshow> tablediscount;
 TableColumn<discountshow,Integer> DISID=new TableColumn<>("Discount Id");
          DISID.setMinWidth(200);
          DISID.setCellValueFactory(new PropertyValueFactory<>("disid"));
          
          
          
        TableColumn<discountshow,Integer> PROID=new TableColumn<>("Product Id");
          PROID.setMinWidth(200);
          PROID.setCellValueFactory(new PropertyValueFactory<>("proid"));
          
          
        TableColumn<discountshow,String> PRONAME=new TableColumn<>("Product Name");
          PRONAME.setMinWidth(200);
          PRONAME.setCellValueFactory(new PropertyValueFactory<>("proname"));
          
                  TableColumn<discountshow,Integer> PER=new TableColumn<>("Percentage");
          PER.setMinWidth(200);
          PER.setCellValueFactory(new PropertyValueFactory<>("per"));
          
                  
 TableColumn<discountshow,Integer> PRICE=new TableColumn<>("Actual Price");
          PRICE.setMinWidth(200);
          PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));
          
          
          TableColumn<discountshow,String> TYP=new TableColumn<>("Type");
          TYP.setMinWidth(200);
          TYP.setCellValueFactory(new PropertyValueFactory<>("type"));

          
           TableColumn<discountshow,String> START=new TableColumn<>("Start Date");
          START.setMinWidth(200);
          START.setCellValueFactory(new PropertyValueFactory<>("start"));
          
            TableColumn<discountshow,String> END=new TableColumn<>("End Date");
          END.setMinWidth(200);
          END.setCellValueFactory(new PropertyValueFactory<>("end"));

          tablediscount=new TableView<>();
          tablediscount.setItems(getdiscountshow());
          tablediscount.getColumns().addAll(DISID,PROID,PRONAME,PER,PRICE,TYP,START,END);
        
        
        
        
        
        
        
        
        
        
        
        VBox tblcol4 = new VBox();
        tblcol4.setMinWidth(1100);
        tblcol4.setSpacing(10);
        tblcol4.setPadding(new Insets(0,0,0,0));
        tblcol4.getChildren().addAll(labeldisc,tablediscount);
        grid8.add(tblcol4, 0, 0);
        
        Button backfromdisctoempwindow = new Button("Back");
        VBox backemp7 = new VBox(50);
        backfromdisctoempwindow.setPrefSize(100, 30);
        
        
         
                  backfromdisctoempwindow.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        backemp7.setAlignment(Pos.CENTER_LEFT);
        backemp7.getChildren().add(backfromdisctoempwindow);
        grid8.add(backemp7, 0, 1);
        
        backfromdisctoempwindow.setOnMouseEntered(e -> {
            backfromdisctoempwindow.setCursor(Cursor.HAND);
        });
        
        backfromdisctoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(guestwindow);
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
     private String[] getcatnames() {
        String names[] = new String[25];

        String sqlprice
                = "SELECT CATEGORY_NAME FROM CATEGORY\n";

        int i = 0;
        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sqlprice);
          //  System.out.println("Its gecat namesw");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //   total=rs.getFloat(1);
                //   novat=rs.getFloat(2);
                names[i] = rs.getString(1);
                i++;
               // System.out.println(rs.getString(1));
                //mm.add(new discountshow(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                //System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        /*
  for (int asd = 0; asd < 25; asd++) {
            System.out.println( names[asd]);
           // combpro.getItems().add(catstring[asd]);
        }
*/
        
        return names;
    }
    
    
    
    
    
    
    public ObservableList<jobshow> getjobshow(){
        ObservableList<jobshow> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT J.JOB_ID ,J.JOB_TITLE,COUNT(*)\n" +
"FROM JOBS J JOIN EMPLOYEE E\n" +
"ON(J.JOB_ID=E.JOB_ID)\n" +
"GROUP BY J.JOB_ID ,J.JOB_TITLE\n" +
"ORDER BY J.JOB_ID ASC";
 
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
             //   System.out.println("Its getjobshow");
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new jobshow(rs.getInt(1),rs.getString(2),rs.getInt(3)));
                   // System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
    }
    
    
    
 
    
            
              public ObservableList<discountshow> getdiscountshow(){
        ObservableList<discountshow> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT D.DISCOUNT_ID,D.PRODUCT_ID,P.PRODUCT_NAME,D.PERCENT,P.PRICE,D.TYPE,D.START_DATE,D.END_DATE\n" +
"FROM DISCOUNT D JOIN PRODUCTS P\n" +
"ON(D.PRODUCT_ID=P.PRODUCT_ID)\n" +
"ORDER BY D.DISCOUNT_ID ASC";
 
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                System.out.println("Its getdiscountshow");
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                  
                    mm.add(new discountshow(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                   // System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
    }
    
              public int checkingdesig(String EID){
                  
                  String jobtitle = null;
        String sqlprice = 
                "SELECT JOB_TITLE\n" +
"FROM JOBS \n" +
"WHERE JOB_ID=GET_JOBID('"+EID+"')";
     
             
                    
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
               
                      jobtitle=rs.getString(1);
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
                if(jobtitle.equals("CASHIER")){
                    return 1;
                }  
                  
                else if(jobtitle.equals("ICMO")){
                  return 2;  
                }
                else if(jobtitle.equals("HR MANAGER")){
                    return 3;  
                }
                 else if(jobtitle.equals("HR EXECUTIVE")){
                    return 4;  
                }
                 else if(jobtitle.equals("DIRECTOR")){
                    return 5;  
                }
                
                else if(jobtitle.equals("CEO")){
                    return 6;  
                }
                  return 0;
                  
              }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }

   
}

