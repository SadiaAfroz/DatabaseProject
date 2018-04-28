
package guifordbproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
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

/*
class MemoInfo{
    
      int memo_id;
     float total_bill;
      float bill_without_vat;

    public MemoInfo( int memo_id,float bill_without_vat,float total_bill) {
        this.memo_id=memo_id;
        this.bill_without_vat=bill_without_vat;
        this.total_bill=total_bill;
    
    }
     
}


*/
public class Guifordbproject extends Application {

    // COMMENT GULA PORE PORE JAIS SADIA...
    int i = 0;
    boolean go_for_more = true;
    boolean new_head = true;
    Stage stage;
   String cashierid;

    public Guifordbproject(String cashierid) {
        this.cashierid = cashierid;
    }
   
   
   
    @Override
    public void start(Stage primaryStage) {
                    stage=primaryStage;

        //linr number 77 porjnto tor dekhar dorkar nai.
        StackPane root = new StackPane();

        GridPane grid = new GridPane();
       grid.setStyle("-fx-background-color: lightblue;");
              //  grid.setStyle("-fx-background-color: black;");

        grid.setHgap(30);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);
        Scene openwindow = new Scene(grid, 1000, 650 + (i / 6) * 100);

        Text greetings = new Text("Welcome");
        greetings.setFill(Color.DODGERBLUE);
        greetings.setFont(Font.font("Monotype Corsiva", FontWeight.BOLD, 70));
        grid.add(greetings, 0, 0, 6, 1);

        Text phead1 = new Text("Product ID(1-30)");
        phead1.setFill(Color.BLACK);
        phead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(phead1, 0, 1);

        Text qhead1 = new Text("Quantity");
        qhead1.setFill(Color.BLACK);
        qhead1.setFont(Font.font("Constantia", FontWeight.LIGHT, 16));
        grid.add(qhead1, 1, 1);

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
        grid.add(wv, 4, 10);

        Text tt = new Text("Total:");
        tt.setFill(Color.GREEN);
        tt.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        grid.add(tt, 4, 11);

        Text wv_res = new Text();
        wv_res.setFill(Color.BLACK);
        wv_res.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        grid.add(wv_res, 5, 10);
        //wv_res.setText("Farhan");
        // ei farhan er jaigai ekta string hobe jekhane without vat calculated amount ta likhbo.

        Text tt_res = new Text();
        tt_res.setFill(Color.BLACK);
        tt_res.setFont(Font.font("Constantia", FontWeight.LIGHT, 20));
        grid.add(tt_res, 5, 11);
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

        grid.add(pro[0], 0, 2);

        grid.add(pro2[0], 1, 2);

        Button addb = new Button("Add");
        addb.setPrefSize(80, 40);
        VBox ab = new VBox(50);
        ab.getChildren().add(addb);
        ab.setAlignment(Pos.CENTER);
        grid.add(ab, 4, 2);

        Button doneb = new Button("Done");
        doneb.setPrefSize(80, 40);
        VBox bb = new VBox(50);
        bb.getChildren().add(doneb);
        bb.setAlignment(Pos.CENTER);
        grid.add(bb, 5, 2);

        Button back = new Button("Back");
        back.setPrefSize(80, 40);
        VBox bback = new VBox(50);
        bback.getChildren().add(back);
        bback.setAlignment(Pos.CENTER);
        grid.add(back, 0, 10);
        
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              optionforcashier cashier=new optionforcashier(cashierid);
                try {
                    cashier.start(stage);
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
                            grid.add(pro[i], 0, 2 + i);
                            grid.add(pro2[i], 1, 2 + i);
                        } else if (i >= 10) {
                            if (new_head) {
                                new_head = false;
                                grid.add(phead2, 2, 1);
                                grid.add(qhead2, 3, 1);
                            }
                            grid.add(pro[i], 2, 2 + i - 10);
                            grid.add(pro2[i], 3, 2 + i - 10);
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

      
        // ei sadia er jaigai ekta string hobe jekhane total calculated amount ta likhbo.
       stage.setTitle("Super Shob Database MAnagement System");
        stage.setScene(openwindow);
        stage.show();
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
           
           String sql="DECLARE \n"
                   + "BEGIN"
                   
                   + "INSERT INTO CASHMEMO (MEMO_ID,CASH_DATE,PRODUCT_ID,QUANTITY,TOTAL_BILL,BILL_WITHOUT_VAT) \n" +
"VALUES \n" +
"("+id+",SYSDATE,"+Integer.parseInt(products2[i])+","+quantity+",(\n" +
"SELECT (PRICE+PRICE*VAT/100)*"+quantity+"\n" +
"FROM PRODUCTS WHERE PRODUCT_ID="+Integer.parseInt(products2[i])+"),(\n" +
"SELECT PRICE*"+quantity+"\n" +
"FROM PRODUCTS WHERE PRODUCT_ID="+Integer.parseInt(products2[i])+"));\n"
                   +"UPDATE_PRODUCT_QUANTITY('"+quantity+"','"+products2[i]+"');"
                   + "END ;/";

          
        //  System.out.println("hello it's me");
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
                         System.out.println("Value update+  Inserted");
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

    /**
     * @param args the command line arguments
     */
    
    /*
    
    public static void main(String[] args) {
        launch(args);
    }

*/

}