/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifordbproject;


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
 * @author HP
 */
public class Gui_for_sadia extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Supershop");
        primaryStage.setResizable(true);
        primaryStage.show();
        
        Button btn = new Button();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: lightblue;");
        grid.setHgap(30);
        grid.setVgap(20);

        Scene openwindow = new Scene(grid, 600, 500);
        
        primaryStage.setScene(openwindow);
        
        grid.setAlignment(Pos.CENTER);
        
        Text greetings = new Text("Super Shop");
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 50));
        grid.add(greetings, 0, 2, 3, 1);

        Button loginbutton = new Button("Log in");
        VBox lx = new VBox(50);
        loginbutton.setPrefSize(150, 30);
        lx.setAlignment(Pos.CENTER);
        lx.getChildren().add(loginbutton);
        grid.add(lx, 1, 4);
        
        loginbutton.setOnMouseEntered(e -> {
            loginbutton.setCursor(Cursor.HAND);
        });
        
        Button signupbutton = new Button("Sign up");
        VBox sx = new VBox(50);
        signupbutton.setPrefSize(150, 30);
        sx.setAlignment(Pos.CENTER);
        sx.getChildren().add(signupbutton);
        grid.add(sx, 1, 6);
        
        signupbutton.setOnMouseEntered(e -> {
            signupbutton.setCursor(Cursor.HAND);
        });
        
        Button loginasguestbutton = new Button("Log in as Guest");
        VBox gx = new VBox(50);
        loginasguestbutton.setPrefSize(150, 30);
        gx.setAlignment(Pos.CENTER);
        gx.getChildren().add(loginasguestbutton);
        grid.add(gx, 1, 8);
        
        loginasguestbutton.setOnMouseEntered(e -> {
            loginasguestbutton.setCursor(Cursor.HAND);
        });
        
        Button exitbutton = new Button("Exit");
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
                primaryStage.close();
            }
        });
        
/// first page ekdm...
/// er pore ami just alada alada wall er jnno alada alada window banacchi shate
/// query o ready kore dicci
        

////=----------------------------------------------------------------------------------------









        
        GridPane grid2 = new GridPane();
        grid2.setStyle("-fx-background-color: silver;");
        grid2.setHgap(30);
        grid2.setVgap(20);

        grid2.setAlignment(Pos.CENTER);

        Scene employeewindow = new Scene(grid2, 600, 500);
        
        loginbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(employeewindow);
            }
        });
        
        Text empwintext = new Text("Employee Account");
        empwintext.setFill(Color.STEELBLUE);
        empwintext.setFont(Font.font("Constantia", FontWeight.BOLD, 30));
        grid2.add(empwintext, 0, 0, 1, 1);
        
        Button viewprof = new Button("View Profile");
        VBox emp1 = new VBox(50);
        viewprof.setPrefSize(150, 30);
        emp1.setAlignment(Pos.CENTER);
        emp1.getChildren().add(viewprof);
        grid2.add(emp1, 0, 2);
        
        viewprof.setOnMouseEntered(e -> {
            viewprof.setCursor(Cursor.HAND);
        });
        
        Button mymangr = new Button("My Manager");
        VBox emp2 = new VBox(50);
        mymangr.setPrefSize(150, 30);
        emp2.setAlignment(Pos.CENTER);
        emp2.getChildren().add(mymangr);
        grid2.add(emp2, 0, 4);
        
        mymangr.setOnMouseEntered(e -> {
            mymangr.setCursor(Cursor.HAND);
        });
        
        Button mymangrshp = new Button("My Managership");
        VBox emp3 = new VBox(50);
        mymangrshp.setPrefSize(150, 30);
        emp3.setAlignment(Pos.CENTER);
        emp3.getChildren().add(mymangrshp);
        grid2.add(emp3, 0, 6);
        
        mymangrshp.setOnMouseEntered(e -> {
            mymangrshp.setCursor(Cursor.HAND);
        });
        
        Button empdepinf = new Button("Department Info");
        VBox emp4 = new VBox(50);
        empdepinf.setPrefSize(150, 30);
        emp4.setAlignment(Pos.CENTER);
        emp4.getChildren().add(empdepinf);
        grid2.add(emp4, 0, 8);
        
        empdepinf.setOnMouseEntered(e -> {
            empdepinf.setCursor(Cursor.HAND);
        });
        
        Button emplogout = new Button("Log out");
        VBox emp5 = new VBox(50);
        emplogout.setPrefSize(150, 30);
        emp5.setAlignment(Pos.CENTER);
        emp5.getChildren().add(emplogout);
        grid2.add(emp5, 0, 10);
        
        emplogout.setOnMouseEntered(e -> {
            emplogout.setCursor(Cursor.HAND);
        });
        
        emplogout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(openwindow);
            }
        });
/// employee er profile vagera check korar jnno ekhane dhuke then buttons click korbo
/// logout korle abar login er page e
/// my  manager er btn click korle tar manager er ekta halka porichoi show korbe
/// my managership e o jodi manager hoi or under e jara employee ase tader k show korbe
/// ekhane join er kaj kora jabe mane employee table er shate self join kora lagbe. 
/// dhuurrrr ekhane kintu join kora obligatory na
/// joining er jnno login as guest namok process khulsi
/// manager er inf ber korar jnno sub query lagbe
/// like select employee_id, emp_name,address,gender etc.... from employee
/// where employee_id = (select manager_id from employee where employee_id = jar ta amra khujtesi..); bujchos asha kori
/// ei query diye




////--------------------------------------------------------------------------------------




        GridPane grid4_1 = new GridPane();
        grid4_1.setStyle("-fx-background-color: springgreen;");
        grid4_1.setHgap(30);
        grid4_1.setVgap(20);

        grid4_1.setAlignment(Pos.CENTER);

        Scene empviewprowindow = new Scene(grid4_1, 600, 700);
        
        viewprof.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(empviewprowindow);
            }
        });
        Text empviewprogreet = new Text("   My Profile");
        empviewprogreet.setFill(Color.BLACK);
        empviewprogreet.setFont(Font.font("Constantia", FontWeight.LIGHT, 24));
        grid4_1.add(empviewprogreet, 2 , 2 , 3 ,1);
        
        Text empviewprotxt[];
        empviewprotxt = new Text[18];
        
        empviewprotxt[0] = new Text("Id         :");
        empviewprotxt[1] = new Text("Name       :");
        empviewprotxt[2] = new Text("Address    :");
        empviewprotxt[3] = new Text("Birth-date :");
        empviewprotxt[4] = new Text("Hire-date :");
        empviewprotxt[5] = new Text("Job Id     :");
        empviewprotxt[6] = new Text("Salary     :");
        empviewprotxt[7] = new Text("Gender     :");
        empviewprotxt[8] = new Text("Manager Id :");
        
        for (int z=0 ; z<9 ;z++)
        {
            empviewprotxt[z].setFill(Color.BLACK);
            empviewprotxt[z].setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
            grid4_1.add(empviewprotxt[z],2 , (z+1)*2 + 2);
        }
        
        for(int z=9 ;z<18;z++)
        {
            empviewprotxt[z] = new Text("Sadia");
            // ei jaigai toke table theke extract kore data show korte hobe
            empviewprotxt[z].setFill(Color.BLACK);
            empviewprotxt[z].setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
            grid4_1.add(empviewprotxt[z] , 4 , (z-8)*2 + 2);
        }
        
        Button backfromviewprotoempwindow = new Button("Back");
        VBox backemp4 = new VBox(50);
        backfromviewprotoempwindow.setPrefSize(70, 30);
        backemp4.setAlignment(Pos.CENTER);
        backemp4.getChildren().add(backfromviewprotoempwindow);
        grid4_1.add(backemp4, 0, 0);
        
        backfromviewprotoempwindow.setOnMouseEntered(e -> {
            backfromviewprotoempwindow.setCursor(Cursor.HAND);
        });
        
        backfromviewprotoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(employeewindow);
            }
        });
//// ekhane basically je login korse tar info ee show korte hobe
        
        
///---------------------------------------------------------------------------------------------------




        GridPane grid4 = new GridPane();
        grid4.setStyle("-fx-background-color: lightgreen;");
        grid4.setHgap(30);
        grid4.setVgap(20);

        grid4.setAlignment(Pos.CENTER);

        Scene empsmngrwindow = new Scene(grid4, 600, 500);
        
        mymangr.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(empsmngrwindow);
            }
        });
        Text empsmngrgreet = new Text("   My Manager");
        empsmngrgreet.setFill(Color.BLACK);
        empsmngrgreet.setFont(Font.font("Constantia", FontWeight.LIGHT, 24));
        grid4.add(empsmngrgreet, 2 , 2 , 3 ,1);
        
        Text empsmngrtxt[];
        empsmngrtxt = new Text[10];
        
        empsmngrtxt[0] = new Text("Id      :");
        
        empsmngrtxt[1] = new Text("Name    :");
        empsmngrtxt[2] = new Text("Address :");
        empsmngrtxt[3] = new Text("Job Id  :");
        empsmngrtxt[4] = new Text("Gender  :");
        
        for (int z=0 ; z<5 ;z++)
        {
            empsmngrtxt[z].setFill(Color.BLACK);
            empsmngrtxt[z].setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
            grid4.add(empsmngrtxt[z],2 , (z+1)*2 + 2);
        }
        
        for(int z=5 ;z<10;z++)
        {
            empsmngrtxt[z] = new Text();
            // ei jaigai toke table theke extract kore data show korte hobe
            empsmngrtxt[z].setFill(Color.BLACK);
            empsmngrtxt[z].setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
            grid4.add(empsmngrtxt[z] , 4 , (z-4)*2 + 2);
        }
        
        String s[]=new String[6];
                s=mymanagerinfo();
                
          for(int z=5,i=0 ;z<10;z++,i++)
        {
            empsmngrtxt[z].setText(s[i]);
            
        }
        Button backfrommymantoempwindow = new Button("Back");
        VBox backemp1 = new VBox(50);
        backfrommymantoempwindow.setPrefSize(70, 30);
        backemp1.setAlignment(Pos.CENTER);
        backemp1.getChildren().add(backfrommymantoempwindow);
        grid4.add(backemp1, 0, 0);
        
        backfrommymantoempwindow.setOnMouseEntered(e -> {
            backfrommymantoempwindow.setCursor(Cursor.HAND);
        });
        
        backfrommymantoempwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(employeewindow);
            }
        });
/// ei page e just jei employee login korbe tar manager er halka patla info pabo
/// etate query kore data gula insert kore dite hobe








/////-------------------------------------------------------------------------------------------------------------------------





        GridPane grid3 = new GridPane();
        grid3.setStyle("-fx-background-color: lightgreen;");
        grid3.setHgap(30);
        grid3.setVgap(20);

        grid3.setAlignment(Pos.CENTER);

        Scene empmngrshipwindow = new Scene(grid3, 1100, 440);
        
        mymangrshp.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(empmngrshipwindow);
            }
        });
        
        final Label labelmngrshp = new Label("Employees under Your Supervision:");
        labelmngrshp.setFont(new Font("Arial",20));
        
        
        
        
        
        /*
        
        TableView tablemngrship = new TableView();
        tablemngrship.setEditable(true);
        tablemngrship.setMinWidth(1000);
        
        TableColumn tempid = new TableColumn("Employee Id");
        TableColumn tempname = new TableColumn("Full Name");
        TableColumn tempadd = new TableColumn("Address");
        TableColumn temphdate = new TableColumn("Hire Date");
        TableColumn tempsal = new TableColumn("Salary");
        TableColumn tempjbid = new TableColumn("Job Id");
        TableColumn tempsex = new TableColumn("Gender");
        
        tempid.setMinWidth(100);
        tempname.setMinWidth(200);
        tempadd.setMinWidth(300);
        temphdate.setMinWidth(200);
        tempsal.setMinWidth(100);
        tempjbid.setMinWidth(100);
        tempsex.setMinWidth(100);
        
          tablemngrship.getColumns().addAll(tempid,tempname,tempadd,temphdate,tempsal,tempjbid,tempsex);
        
        */
          
          
        
        
         TableView<mysupervision> table2;
 TableColumn<mysupervision,Integer> EMPID=new TableColumn<>("EMPLOYEE_ID");
          EMPID.setMinWidth(200);
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
          SAL.setMinWidth(200);
          SAL.setCellValueFactory(new PropertyValueFactory<>("sal"));
          
          
          TableColumn<mysupervision,String> HRD=new TableColumn<>("HIRE_DATE");
          HRD.setMinWidth(200);
          HRD.setCellValueFactory(new PropertyValueFactory<>("hrd"));

          
           TableColumn<mysupervision,Integer> JOBID=new TableColumn<>("JOB_ID");
          JOBID.setMinWidth(200);
          JOBID.setCellValueFactory(new PropertyValueFactory<>("jobid"));
          
            TableColumn<mysupervision,String> GENDER=new TableColumn<>("GENDER");
          GENDER.setMinWidth(200);
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
                primaryStage.setScene(employeewindow);
            }
        });
/// ekhane table e tui data direct resultset theke dhukai dite parbi ami toke code pathai dibo
/// table e kore aramse reprent korte parbo



//////-------------------------------------------------------------------------------------------------------




        GridPane grid5 = new GridPane();
        grid5.setStyle("-fx-background-color: silver;");
        grid5.setHgap(30);
        grid5.setVgap(20);

        grid5.setAlignment(Pos.CENTER);

        Scene guestwindow = new Scene(grid5, 600, 500);
        
        loginasguestbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(guestwindow);
            }
        });
        
        Text guestwintext = new Text("                Guest Account");
        guestwintext.setFill(Color.STEELBLUE);
        guestwintext.setFont(Font.font("Constantia", FontWeight.BOLD, 30));
        grid5.add(guestwintext, 0, 0, 1, 1);
        
        Button catbtn = new Button("Category");
        VBox guest1 = new VBox(50);
        catbtn.setPrefSize(150, 35);
        guest1.setAlignment(Pos.CENTER);
        guest1.getChildren().add(catbtn);
        grid5.add(guest1, 0, 2);
        
        catbtn.setOnMouseEntered(e -> {
            catbtn.setCursor(Cursor.HAND);
        });
        
        Button jobbtn = new Button("Jobs");
        VBox guest2 = new VBox(50);
        jobbtn.setPrefSize(150, 35);
        guest2.setAlignment(Pos.CENTER);
        guest2.getChildren().add(jobbtn);
        grid5.add(guest2, 0, 4);
        
        jobbtn.setOnMouseEntered(e -> {
            jobbtn.setCursor(Cursor.HAND);
        });
        
        Button suppliersbtn = new Button("Suppliers");
        VBox guest3 = new VBox(50);
        suppliersbtn.setPrefSize(150, 35);
        guest3.setAlignment(Pos.CENTER);
        guest3.getChildren().add(suppliersbtn);
        grid5.add(guest3, 0, 6);
        
        suppliersbtn.setOnMouseEntered(e -> {
            suppliersbtn.setCursor(Cursor.HAND);
        });
        
        Button discbtn = new Button("Discounts");
        VBox guest4 = new VBox(50);
        discbtn.setPrefSize(150, 35);
        guest4.setAlignment(Pos.CENTER);
        guest4.getChildren().add(discbtn);
        grid5.add(guest4, 0, 8);
        
        discbtn.setOnMouseEntered(e -> {
            discbtn.setCursor(Cursor.HAND);
        });
        
        Button backfromguesttoempwindow = new Button("Back");
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
        
        
        
        
        
        
        
          GridPane grid5_1 = new GridPane();
        grid5_1.setStyle("-fx-background-color: silver;");
        grid5_1.setHgap(30);
        grid5_1.setVgap(20);

        grid5_1.setAlignment(Pos.CENTER);

        Scene catintmdwindow = new Scene(grid5_1, 600, 500);
        catbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(catintmdwindow);
            }
        });
        
        
        Button catintm1btn = new Button(" By Category");
        VBox catintmd1 = new VBox(50);
        catintm1btn.setPrefSize(150, 35);
        catintmd1.setAlignment(Pos.CENTER);
        catintmd1.getChildren().add(catintm1btn);
        grid5_1.add(catintmd1, 0, 2);
        
        catintm1btn.setOnMouseEntered(e -> {
            catbtn.setCursor(Cursor.HAND);
        });
        
        Button catintm2btn = new Button("By Product");
        VBox catintmd2 = new VBox(50);
        catintm2btn.setPrefSize(150, 35);
        catintmd2.setAlignment(Pos.CENTER);
        catintmd2.getChildren().add(catintm2btn);
        grid5_1.add(catintmd2, 0, 4);
        
        catintm2btn.setOnMouseEntered(e -> {
            jobbtn.setCursor(Cursor.HAND);
        });
    Button backfromcatintmtoguestwindow = new Button("Back");
        VBox backintm3 = new VBox(50);
        backfromcatintmtoguestwindow.setPrefSize(150, 35);
        backintm3.setAlignment(Pos.CENTER);
        backintm3.getChildren().add(backfromcatintmtoguestwindow);
        grid5_1.add(backintm3, 0, 6);
        
        backfromcatintmtoguestwindow.setOnMouseEntered(e -> {
            backfromcatintmtoguestwindow.setCursor(Cursor.HAND);
        });
        
        backfromcatintmtoguestwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(guestwindow);
            }
        });
//--------------------------------------------------------------------------------------------------------------

/// grid5_2 te combobox ase done btn e click korle amra info extract kore table show korbo
/// ami just emni tin ta naam disi ogula shamlano jabe.



/*
        GridPane grid5_2 = new GridPane();
        grid5_2.setStyle("-fx-background-color: lightblue;");
        grid5_2.setHgap(30);
        grid5_2.setVgap(20);
        
        grid5_2.setAlignment(Pos.CENTER);
        
        Scene comboprowindow = new Scene(grid5_2, 1200, 450);
        
        catintm2btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(comboprowindow);
            }
        });
        final Label labelcombcat = new Label("Category :");
        labelcombcat.setFont(new Font("Arial",20));
        
        final ComboBox combpro = new ComboBox();
        combpro.setMinWidth(200);
        combpro.setPromptText("Select Category");
        combpro.getItems().addAll(
        "Fruits", "Vegetables", "Cosmetics"
        );
        
        Button combodone = new Button("Done");
        combodone.setPrefSize(100, 35);
        
        HBox labcombbtn = new HBox();
        labcombbtn.setSpacing(20);
        labcombbtn.getChildren().addAll(labelcombcat,combpro,combodone);
        grid5_2.add(labcombbtn,0,0);
        
        
        final Label labelcomb = new Label("Products:");
        labelcomb.setFont(new Font("Arial",20));
        
        TableView tablecomb = new TableView();
        tablecomb.setEditable(true);
        tablecomb.setMinWidth(900);
        
        TableColumn tproid = new TableColumn("Product Id");
        TableColumn tpronam = new TableColumn("Product Name");
        TableColumn tpropri = new TableColumn("Price");
        TableColumn tprovat = new TableColumn("VAT");
        TableColumn tproquan = new TableColumn("Quantity");
        TableColumn tpromandate = new TableColumn("Manufacturing date");
        TableColumn tproexpdate = new TableColumn("Expiry Date");
        
        tproid.setMinWidth(100);
        tpronam.setMinWidth(200);
        tpropri.setMinWidth(100);
        tprovat.setMinWidth(100);
        tproquan.setMinWidth(100);
        tpromandate.setMinWidth(250);
        tproexpdate.setMinWidth(250);
        
        tablecomb.getColumns().addAll(tproid,tpronam,tpropri,tprovat,tproquan,tpromandate,tproexpdate);
        
        VBox tblcol5 = new VBox();
        tblcol5.setMinWidth(1100);
        tblcol5.setSpacing(10);
        tblcol5.setPadding(new Insets(0,0,0,0));
        tblcol5.getChildren().addAll(labelcomb,tablecomb);
        grid5_2.add(tblcol5, 0, 1);
        
        Button backfromcombtocatintwindow = new Button("Back");
        VBox backemp8 = new VBox(50);
        backfromcombtocatintwindow.setPrefSize(100, 30);
        backemp8.setAlignment(Pos.CENTER_LEFT);
        backemp8.getChildren().add(backfromcombtocatintwindow);
        grid5_2.add(backemp8, 0, 2);
        
        backfromcombtocatintwindow.setOnMouseEntered(e -> {
            backfromcombtocatintwindow.setCursor(Cursor.HAND);
        });
        
        backfromcombtocatintwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(catintmdwindow);
            }
        }

   
);

      */  
        





GridPane grid5_2 = new GridPane();
        grid5_2.setStyle("-fx-background-color: lightblue;");
        grid5_2.setHgap(30);
        grid5_2.setVgap(20);

        grid5_2.setAlignment(Pos.CENTER);

        Scene comboprowindow = new Scene(grid5_2, 600, 450);

        catintm2btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(comboprowindow);
            }
        });
        
       
        
        
        
        final Label labelcombcat = new Label("Category :");
        labelcombcat.setFont(new Font("Arial", 20));

        final ComboBox combpro = new ComboBox();
        combpro.setMinWidth(200);
        combpro.setPromptText("Select Category");
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
            System.out.println(catstring[asd]);
            combpro.getItems().add(catstring[asd]);
        }

        Button combodone = new Button("Done");
        combodone.setPrefSize(100, 35);

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
        backemp8.setAlignment(Pos.CENTER_LEFT);
        backemp8.getChildren().add(backfromcombtocatintwindow);
        grid5_2.add(backemp8, 0, 2);
/*
        backfromcombtocatintwindow.setOnMouseEntered(e -> {
            backfromcombtocatintwindow.setCursor(Cursor.HAND);
        });

        backfromcombtocatintwindow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(catintmdwindow);
            }
        });
*/
/*
  for (int asd = 0; asd < 25; asd++) {
            System.out.println( catstring[asd]);
           // combpro.getItems().add(catstring[asd]);
        }
  */      
        
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
                System.out.println(rs.getString(1));
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
    
    private ObservableList<catshow> getcatshow() {
        ObservableList<catshow> mm = FXCollections.observableArrayList();

        String sqlprice
                = "SELECT C.CATEGORY_ID ,C.CATEGORY_NAME ,COUNT(*)\n"
                + "FROM CATEGORY C JOIN PRODUCTS P\n"
                + "ON(C.CATEGORY_ID=P.CATEGORY_ID)\n"
                + "GROUP BY C.CATEGORY_ID ,C.CATEGORY_NAME\n"
                + "ORDER BY C.CATEGORY_ID ASC";

        try {
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sqlprice);
          //  System.out.println("Its getCATshow");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //   total=rs.getFloat(1);
                //   novat=rs.getFloat(2);
                mm.add(new catshow(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return mm;
    }
    
    
    
    
    
    public String[] mymanagerinfo(){
    
     //   select employee_id, emp_name,address,gender etc.... from employee
/// where employee_id = (select manager_id from employee where employee_id = jar ta amra khujtesi..)
    
        
        String sqlprice = 
                "SELECT EMPLOYEE_ID , EMP_NAME ,ADDRESS , JOB_ID, GENDER\n" +
                "FROM EMPLOYEE\n" +
                "WHERE EMPLOYEE_ID=(SELECT MANAGER_ID FROM EMPLOYEE WHERE EMPLOYEE_ID=55604)";
     
                String managername,manageraddress,mangender;
                int managerid,manjobid;
                String managerinfo[]=new String[6];
                    
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                   managerinfo[0]=Integer.toString(rs.getInt(1));
                     managerinfo[1]=rs.getString(2);
                      managerinfo[2]=rs.getString(3);
                       managerinfo[3]=Integer.toString(rs.getInt(4));
                        managerinfo[4]=rs.getString(5);
                       
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        return managerinfo;
    
}
    
    
    
    
    public ObservableList<mysupervision> getundermysupervision(){
        ObservableList<mysupervision> mm=FXCollections.observableArrayList();
        
        
        
        String sqlprice = 
                "SELECT EMPLOYEE_ID , EMP_NAME ,ADDRESS , BIRTH_DATE,SALARY,HIRE_DATE,JOB_ID,GENDER\n" +
                "FROM EMPLOYEE\n" +
                "WHERE MANAGER_ID=55555";
 
           try{
            Connection con = new OracleDBMS().getConnection(); 
            PreparedStatement pst = con.prepareStatement(sqlprice);
                
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new mysupervision(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
                 ///   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getString(8));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
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
                System.out.println("Its getjobshow");
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()){
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new jobshow(rs.getInt(1),rs.getString(2),rs.getInt(3)));
               ///     System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                  
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
                    //   total=rs.getFloat(1);
                    //   novat=rs.getFloat(2);
                    mm.add(new discountshow(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                   /// System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
                  
                }
                
                
                
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         
        
        
        
        
        return mm;
        
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}