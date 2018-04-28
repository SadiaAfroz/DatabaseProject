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
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

/**
 *
 * @author Faiza
 */
public class optionforcashier extends Application{
   int i = 0;
    boolean go_for_more = true;
    boolean new_head = true;
    String  cashierid;
        String id;

    Stage stage;

    public optionforcashier(String cashierid) {
        this.cashierid = cashierid;
    }

  
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        stage=primaryStage;
               stage.setTitle("Super Shob Database MAnagement System");
        stage.show();

                VBox vb[];
        vb = new VBox[10];
        
        
        
          GridPane grid = new GridPane();
       // grid.setStyle("-fx-background-color: lightblue;");
               grid.setStyle("-fx-background-color: CORNSILK;");
 
       grid.setHgap(30);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);
        Scene openwindow = new Scene(grid, 600, 500);
        
        
               
        stage.setScene(openwindow);
        
        
        
            grid.setLayoutX(10);
              grid.setLayoutY(10);
        Text greetings = new Text("Cashier");
      //  greetings.setFill(Color.DODGERBLUE);
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 70));
        grid.add(greetings, 0, 0);
                grid.setVisible(true);

        Button button[];
        button=new Button[10];
        
 
        Text createcash=new Text("Create CashMemo");
        
        createcash.setStyle(
    "-fx-font-size: 16px;"
    +"-fx-font-weight: bold;"
    +"-fx-text-fill: #333333;"
   +" -fx-effect: dropshadow( gaussian , DARKGRAY , 0,0,0,1 );");

    //    Color.DARKGRAY
        // createcash.setFill(Color.DODGERBLUE);
       // createcash.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(createcash, 0, 2);
        
        button[0]=new Button("Create");
        
        button[0].setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
         button[0].setMaxSize(200, 50);
                 vb[0]=new VBox(10);
        vb[0].getChildren().add(button[0]);
        vb[0].setAlignment(Pos.CENTER);
        grid.add(vb[0], 1, 2);
        
        
        
        
        TextField memoid=new TextField();
        memoid.setPrefSize(200, 30);
            memoid.setPromptText("Enter Memo ID");
         grid.add(memoid, 0, 3);
         
        
           button[1]=new Button("Show");
         button[1].setMaxSize(200, 50);
         
         
         button[1].setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
                 vb[1]=new VBox(10);
        vb[1].getChildren().add(button[1]);
        vb[1].setAlignment(Pos.CENTER);
        grid.add(vb[1], 1, 3);
        
        
           TextField memodate=new TextField();
        memodate.setPrefSize(200, 30);
            memodate.setPromptText("Enter Date For Memos");
         grid.add(memodate, 0, 4);
         
        
           button[2]=new Button("Show");
         button[2].setMaxSize(200, 50);
         
         
          button[2].setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
         
                 vb[2]=new VBox(10);
        vb[2].getChildren().add(button[2]);
        vb[2].setAlignment(Pos.CENTER);
        grid.add(vb[2], 1, 4);
        
        
        
             button[2].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
        
                        memotable_by_date midshow=new memotable_by_date(memodate.getText());
                        Stage secondstage=new Stage();
                        secondstage.setTitle("Memo Show Table ");
                try {
                    midshow.start(secondstage);
                    
                    //  stage.setScene(scenememotable);
                } catch (Exception ex) {
                    Logger.getLogger(optionforcashier.class.getName()).log(Level.SEVERE, null, ex);
                }
              
             }
        });
        
        
        
        
        
        
        
        Button backfromguesttoempwindow = new Button("Back");
        
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
        grid.add(backemp3, 1, 13);
        
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
    
        
        
  
        
        
        
        
        //cashmemo  
        
        
        GridPane gridcash = new GridPane();
       gridcash.setStyle("-fx-background-color: lightblue;");
              //  gridcash.setStyle("-fx-background-color: black;");

        gridcash.setHgap(30);
        gridcash.setVgap(20);
        gridcash.setAlignment(Pos.TOP_CENTER);
        Scene opencash = new Scene(gridcash, 1000, 650 + (i / 6) * 100);

        
        
        
            button[0].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
        
                       // Guifordbproject productgui=new Guifordbproject(cashierid);
                       
                       stage.setScene(opencash);
                try {
                   // productgui.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(optionforcashier.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        });
        
          
        Text greet = new Text("Welcome");
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 70));
        gridcash.add(greetings, 0, 0, 6, 1);

        Text phead1 = new Text("Product ID(1-30)");
        phead1.setFill(Color.BLACK);
        phead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridcash.add(phead1, 0, 1);

        Text qhead1 = new Text("Quantity");
        qhead1.setFill(Color.BLACK);
        qhead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        gridcash.add(qhead1, 1, 1);

        Text phead2 = new Text("Product ID(1-30)");
        phead2.setFill(Color.BLACK);
        phead2.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));

        Text qhead2 = new Text("Quantity");
        qhead2.setFill(Color.BLACK);
        qhead2.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));

        ///
          Text wv = new Text("Without VAT:");
        wv.setFill(Color.GREEN);
        wv.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        gridcash.add(wv, 4, 10);

        Text tt = new Text("Total:");
        tt.setFill(Color.GREEN);
        tt.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        gridcash.add(tt, 4, 11);

        Text wv_res = new Text();
        wv_res.setFill(Color.BLACK);
        wv_res.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        gridcash.add(wv_res, 5, 10);
        //wv_res.setText("Farhan");
        // ei farhan er jaigai ekta string hobe jekhane without vat calculated amount ta likhbo.

        Text tt_res = new Text();
        tt_res.setFill(Color.BLACK);
        tt_res.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        gridcash.add(tt_res, 5, 11);
        //tt_res.setText("Sadia");
        
        ///
        
        VBox pro[];
        pro = new VBox[20];

        VBox pro2[];
        pro2 = new VBox[20];

        //ekhane text fiels er jei array ta nicce okhan theke 
        //ee amader data collect korte hobe.
        //pname theke product name and pquan theke product quantity.
        // i namok variable theke amra total number of products pabo.
        // mane koi dhoroner product order kora hoise emn kichu.
        TextField pname[];
        pname = new TextField[20];

        TextField pquan[];
        pquan = new TextField[20];

        for (int j = 0; j < 20; j++) {
            pro[j] = new VBox();
            pro[j].setAlignment(Pos.CENTER_LEFT);
            pro2[j] = new VBox();
            pro2[j].setAlignment(Pos.CENTER_LEFT);
            pname[j] = new TextField();
            pname[j].setPrefSize(200, 40);
            pquan[j] = new TextField();
            pquan[j].setPrefSize(70, 40);
            pname[j].setPromptText("Press Enter after giving name");
            pro[j].getChildren().add(pname[j]);
            pro2[j].getChildren().add(pquan[j]);
        }

        gridcash.add(pro[0], 0, 2);

        gridcash.add(pro2[0], 1, 2);

        Button addb = new Button("Add");
        addb.setPrefSize(80, 40);
        addb.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox ab = new VBox(50);
        ab.getChildren().add(addb);
        ab.setAlignment(Pos.CENTER);
        gridcash.add(ab, 4, 2);

        Button doneb = new Button("Done");
        doneb.setPrefSize(80, 40);
        
         doneb.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        VBox bb = new VBox(50);
        bb.getChildren().add(doneb);
        bb.setAlignment(Pos.CENTER);
        gridcash.add(bb, 5, 2);

        Button back = new Button("Back");
        back.setPrefSize(80, 40);
        back.setStyle(
    "-fx-text-fill: white;"
            + "-fx-font-size: 12pt; "
    +"-fx-font-family: \"Arial Narrow\";"
    +"-fx-font-weight: bold;"
    +"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
     +"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
        );
        
        
        VBox bback = new VBox(50);
        bback.getChildren().add(back);
        bback.setAlignment(Pos.CENTER);
        gridcash.add(back, 0, 10);
        
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            //  optionforcashier cashier=new optionforcashier(cashierid);
            
            stage.setScene(openwindow);
                try {
                   // cashier.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Guifordbproject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        addb.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (go_for_more) {
                    i++;
                    if (i < 20) {
                        if (i < 10) {
                            gridcash.add(pro[i], 0, 2 + i);
                            gridcash.add(pro2[i], 1, 2 + i);
                        } else if (i >= 10) {
                            if (new_head) {
                                new_head = false;
                                gridcash.add(phead2, 2, 1);
                                gridcash.add(qhead2, 3, 1);
                            }
                            gridcash.add(pro[i], 2, 2 + i - 10);
                            gridcash.add(pro2[i], 3, 2 + i - 10);
                        }
                    }
                }
            }
        });

        doneb.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String product_info="";
             

                if(go_for_more) {
                    go_for_more = false;
                    i++;
                }
                   String products2[]=new String[i];
                String productsquan2[]=new String[i];
                
                System.out.println("the value of i is "+i);
                for(int l =0;l<i;l++)
                {
                   // System.out.println("The nubmer is  "+l +"   "+pname[l].getText());
                    products2[l]=pname[l].getText();
                   // System.out.println(products2[l]);
                    //System.out.println("Its L" +l);
                }
                
                System.out.println("now the quantities");
                for(int l =0;l<i;l++)
                {
                   // System.out.println(pquan[l].getText());
                    productsquan2[l]=pquan[l].getText();         
                   // System.out.println(productsquan2[l]);
                }
                 for(int l =0;l<i;l++)
                {
                   product_info=product_info.concat(pname[l].getText());
                   product_info=product_info.concat("-");
                   product_info=product_info.concat(pquan[l].getText());
                   product_info=product_info.concat(";");
                }
                 System.out.println(product_info);
                 /*
                 for(int m=0;m<i;m++){
                     System.out.println(products2[m]+"  hello  "+productsquan2[m]);
                     
                 }
                 */
                 
                 
                 
               //  priceCal(product_info);
                 MemoInfo memo=priceCal2(products2,productsquan2);
                 insertmemohistory(memo.memo_id,memo.total_bill,memo.bill_without_vat);
                 
                 int p=0;
                 String productsplited[];
                 productsplited=new String[i];
                
                     productsplited=product_info.split(";");
                 
                     for (int l = 0; l < productsplited.length; l++) {
                             System.out.println(productsplited[l]);
                      }
                     
                     
                     
                 
                wv_res.setText(Float.toString(memo.bill_without_vat));
               tt_res.setText(Float.toString(memo.total_bill));
                
            }
        });
        
        
        
        
        
  
              button[1].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
        
                        memoshow midshow=new memoshow(memoid.getText());
                        Stage secondstage=new Stage();
                        //secondstage.setTitle("Memo Show Table ");
                try {
                    midshow.start(secondstage);
                    
                    //  stage.setScene(scenememotable);
                } catch (Exception ex) {
                    Logger.getLogger(optionforcashier.class.getName()).log(Level.SEVERE, null, ex);
                }
              
             }
        });
        
        //memoshow tableview scene
          
        
        /*
        GridPane grid5 = new GridPane();
        
         id=memoid.getText();
                Scene scenememotable=new Scene(grid5);

  
              button[1].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
        
                        memoshow midshow=new memoshow(memoid.getText());
                        Stage secondstage=new Stage();
                        //secondstage.setTitle("Memo Show Table ");
                try {
                    midshow.start(secondstage);
                    
                    //  stage.setScene(scenememotable);
                } catch (Exception ex) {
                    Logger.getLogger(optionforcashier.class.getName()).log(Level.SEVERE, null, ex);
                }
              
             }
        });
        
        
        
        
        
  TableView<memo> tablememo;
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
          
          tablememo=new TableView<>();
        //  id="22";
        
          tablememo.setItems(getmemo());
          tablememo.getColumns().addAll(proidcol,qua,price,total);
          VBox vbox=new VBox();
          vbox.getChildren().addAll(tablememo);
        /*  
          Button back=new Button();
          back.setLayoutX(12);
        back.setLayoutY(400);
        back.setMinSize(80, 50);
          root.getChildren().addAll(vbox,back);
          Scene scene=new Scene(root,600,400);
          
          
          grid5.add(vbox, 0, 0);
          
          Button backfromcattoempwindow = new Button("Back");
        VBox backemp5 = new VBox(50);
        backfromcattoempwindow.setPrefSize(100, 30);
        backemp5.setAlignment(Pos.CENTER_LEFT);
        backemp5.getChildren().add(backfromcattoempwindow);
        grid5.add(backemp5, 0, 1);
          
                   
                   
                   
                   
                   
              
     
               backfromcattoempwindow.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
        
                       // memoshow midshow=new memoshow(memoid.getText());
                       
                       stage.setScene(openwindow);
                try {
                  //  midshow.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(optionforcashier.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        });
        
               
               */
        
        
        
 
   

    }
    
    
    
    
        public MemoInfo priceCal2(String products2[],String productsquan2[]){
     String price="";
      //  System.out.println(product_info);]
      int id=doMethod();
      System.out.println("id "+id);
      for(int i=0;i<products2.length;i++){
          System.out.println(products2[i]+" "+productsquan2[i]);
           int quantity=Integer.parseInt(productsquan2[i]);
            
          // String sql = "INSERT INTO CASHMEMO (MEMO_ID,CASH_DATE,PRODUCT_ID,QUANTITY,TOTAL_BILL,BILL_WITHOUT_VAT) VALUES ("+id+",SYSDATE,'"+Integer.parseInt(products2[i])+"'," +quantity+",(SELECT PRICE*"+quantity+"FROM PRODUCTS WHERE PRODUCT_ID="+Integer.parseInt(products2[i])+"),10.0)";
           
           String sql="INSERT INTO CASHMEMO (MEMO_ID,CASH_DATE,PRODUCT_ID,QUANTITY,TOTAL_BILL,BILL_WITHOUT_VAT) \n" +
"VALUES \n" +
"("+id+",SYSDATE,"+Integer.parseInt(products2[i])+","+quantity+",(\n" +
"SELECT (PRICE+PRICE*VAT/100)*"+quantity+"\n" +
"FROM PRODUCTS WHERE PRODUCT_ID="+Integer.parseInt(products2[i])+"),(\n" +
"SELECT PRICE*"+quantity+"\n" +
"FROM PRODUCTS WHERE PRODUCT_ID="+Integer.parseInt(products2[i])+"))";

          
         // System.out.println("hello it's me");
// String sql="SELECT * FROM  PRODUCTS ";
     //  String sql = "INSERT INTO CATEGORY VALUES(?)";
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
                     //  System.out.println("hello");
                     /*
                     pst.setInt(4, 6);
                     pst.setString(3, product_info);
                     pst.setFloat(5, (float) 10.0);
                   pst.setFloat(6, (float) 8.0);
                     
                    // pst.setInt(0,22);
                     pst.setString(2, "juice");
                     */

                     int rs = pst.executeUpdate();
            
                   //  ResultSet rs=pst.executeQuery();
              
                     if (rs!=0) {
                         System.out.println("Value Inserted");
                     } else {
                         System.out.println("Value  Not Inserted");
                     }
                     
                     /*
         while (rs.next())
            {
                System.out.println(rs.getString(2));
            }
            */
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     
      
      
      }
      
      
      
      String sqlprice="SELECT SUM(TOTAL_BILL) , SUM(BILL_WITHOUT_VAT)\n" +
"FROM CASHMEMO\n" +
"HAVING MEMO_ID="+id+"\n" +
"GROUP BY MEMO_ID";
       float total = 0;
                    float novat = 0;
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
                total=rs.getFloat(1);
                novat=rs.getFloat(2);
                System.out.println(total+"   hello      "+novat);
            }
                  
                  
       
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     MemoInfo memo=new MemoInfo(id, novat, total);
     
     
     
     
     
     
    return memo;
    }
        
    
    
        public void insertmemohistory(int id,float total, float novat){
               System.out.println("hello it's me memo_history"+id);
       
     //String sql="SELECT * FROM CASHMEMO WHERE MEMO_ID="+id;
     
     
     
              String sql="INSERT INTO MEMO_HISTORY (MEMOHIS_ID,MEMO_ID,CASH_DATE,TOTAL_BILL,BILL_WITHOUT_VAT,ISSUED_BY) VALUES ("+id+", "+id+",SYSDATE,"+total+","+novat+","+cashierid+")" ;

          
// String sql="SELECT * FROM  PRODUCTS ";
     //  String sql = "INSERT INTO CATEGORY VALUES(?)";
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
                     //  System.out.println("hello");
                     /*
                     pst.setInt(4, 6);
                     pst.setString(3, product_info);
                     pst.setFloat(5, (float) 10.0);
                   pst.setFloat(6, (float) 8.0);
                     
                    // pst.setInt(0,22);
                     pst.setString(2, "juice");
                     */

                     int rs = pst.executeUpdate();
            
                   //  ResultSet rs=pst.executeQuery();
              
                     if (rs!=0) {
                         System.out.println("Value Inserted");
                     } else {
                         System.out.println("Value  Not Inserted");
                     }
                     
                     /*
         while (rs.next())
            {
                System.out.println(rs.getInt(2));
                 System.out.println(rs.getDate(3));

                 System.out.println(rs.getInt(4));
                System.out.println(rs.getInt(5));

            }
            */
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     
            
        }
    public int getCount() {

        int count = 0;
        try {
            if ( !new File("C:\\Users\\Faiza\\Desktop\\count.txt").exists())
                return 1;
            else {
                BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Faiza\\Desktop\\count.txt")));
                String s = br.readLine();
                count = Integer.parseInt(s);
                br.close();
            }                
        } catch(Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void putCount(int count) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\Faiza\\Desktop\\count.txt")));
            bw.write(Integer.toString(count));
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int doMethod() { 
        int count = getCount();            
        System.out.println("You are running this program " + count + " number of times");
        count++;
        putCount(count);            
     return count-1;
    }
    
    
    
    
    public String priceCal(String product_info){
     String price="";
        System.out.println(product_info);
     String sql = "INSERT INTO CASHMEMO3 (CASH_DATE,PRODUCT_ID_INFO,QUANTITY,TOTAL_BILL,BILL_WITHOUT_VAT) VALUES (SYSDATE,'"+product_info+"',7,8.0,10.0)";
       // String sql="SELECT * FROM  PRODUCTS ";
     //  String sql = "INSERT INTO CATEGORY VALUES(?)";
        try{
            Connection con = new OracleDBMS().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
                     //  System.out.println("hello");
                     /*
                     pst.setInt(4, 6);
                     pst.setString(3, product_info);
                     pst.setFloat(5, (float) 10.0);
                   pst.setFloat(6, (float) 8.0);
                     
                    // pst.setInt(0,22);
                     pst.setString(2, "juice");
                     */
                    int rs = pst.executeUpdate();
            
                     if (rs!=0) {
                         System.out.println("Value Inserted");
                     } else {
                         System.out.println("Value  Not Inserted");
                     }
                     
                     /*
         while (rs.next())
            {
                System.out.println(rs.getString(2));
            }
            */
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     
     
     
    return price;
    }
    
    
    public ObservableList<memo> getmemo(){
        ObservableList<memo> mm=FXCollections.observableArrayList();
        
        System.out.println("its getmemo "+id +"plz showw the table ");
        
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
