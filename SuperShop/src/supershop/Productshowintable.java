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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Productshowintable extends Application{

    String val;
    Productshowintable(String value) {
        val = value;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid5_2 = new GridPane();
        grid5_2.setStyle("-fx-background-color: lightblue;");
        grid5_2.setHgap(30);
        grid5_2.setVgap(20);

        grid5_2.setAlignment(Pos.CENTER);

        Scene comboprowindow = new Scene(grid5_2, 1200, 450);
        
        primaryStage.setScene(comboprowindow);
        primaryStage.show();
        final Label labelcomb = new Label("Products:   "+val);
        labelcomb.setFont(new Font("Arial", 20));
//
//        TableView tablecomb = new TableView();
//        tablecomb.setEditable(true);
//        tablecomb.setMinWidth(900);

//        TableColumn tproid = new TableColumn("Product Id");
//        TableColumn tpronam = new TableColumn("Product Name");
//        TableColumn tpropri = new TableColumn("Price");
//        TableColumn tprovat = new TableColumn("VAT");
//        TableColumn tproquan = new TableColumn("Quantity");
//        TableColumn tpromandate = new TableColumn("Manufacturing date");
//        TableColumn tproexpdate = new TableColumn("Expiry Date");
//
//        tproid.setMinWidth(100);
//        tpronam.setMinWidth(200);
//        tpropri.setMinWidth(100);
//        tprovat.setMinWidth(100);
//        tproquan.setMinWidth(100);
//        tpromandate.setMinWidth(250);
//        tproexpdate.setMinWidth(250);
//
//        tablecomb.getColumns().addAll(tproid, tpronam, tpropri, tprovat, tproquan, tpromandate, tproexpdate);
        TableView<productshow> tablecomb;

        TableColumn<productshow, Integer> tproid = new TableColumn<>("Product Id");
        tproid.setMinWidth(100);
        tproid.setCellValueFactory(new PropertyValueFactory<>("proid"));

        TableColumn<productshow, String> tpronam = new TableColumn<>("Product Name");
        tpronam.setMinWidth(200);
        tpronam.setCellValueFactory(new PropertyValueFactory<>("proname"));

        TableColumn<productshow, Integer> tpropri = new TableColumn<>("Price");
        tpropri.setMinWidth(100);
        tpropri.setCellValueFactory(new PropertyValueFactory<>("proprice"));

        TableColumn<productshow, Integer> tprovat = new TableColumn<>("VAT");
        tprovat.setMinWidth(100);
        tprovat.setCellValueFactory(new PropertyValueFactory<>("provat"));

        TableColumn<productshow, Integer> tproquan = new TableColumn<>("Quantity");
        tproquan.setMinWidth(100);
        tproquan.setCellValueFactory(new PropertyValueFactory<>("proquan"));

        TableColumn<productshow, String> tpromandate = new TableColumn<>("Manufacturing date");
        tpromandate.setMinWidth(250);
        tpromandate.setCellValueFactory(new PropertyValueFactory<>("promandate"));

        TableColumn<productshow, String> tproexpdate = new TableColumn<>("Expiry date");
        tproexpdate.setMinWidth(250);
        tproexpdate.setCellValueFactory(new PropertyValueFactory<>("proexpdate"));

        tablecomb = new TableView<>();
        tablecomb.setItems(getproductshow());
        tablecomb.getColumns().addAll(tproid, tpronam, tpropri, tprovat, tproquan, tpromandate, tproexpdate);

        VBox tblcol5 = new VBox();
        tblcol5.setMinWidth(1100);
        tblcol5.setSpacing(10);
        tblcol5.setPadding(new Insets(0, 0, 0, 0));
        tblcol5.getChildren().addAll(labelcomb, tablecomb);
        grid5_2.add(tblcol5, 0, 1);

        
/*
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
                Gui_for_sadia gfs = new Gui_for_sadia();
                gfs.start(primaryStage);
            }
        });
*/
    }

    private ObservableList<productshow> getproductshow() {
                ObservableList<productshow> mm = FXCollections.observableArrayList();
                System.out.println(val+"asjkdasdhaslsadiaasadiasadi");
                String sqlprice
                        = "SELECT P.PRODUCT_ID,P.PRODUCT_NAME,P.PRICE,P.VAT,P.QUANTITY,P.MANUFACTURE_DATE,P.EXPIRE_DATE FROM PRODUCTS P JOIN CATEGORY C ON (P.CATEGORY_ID = C.CATEGORY_ID) WHERE C.CATEGORY_NAME = '" +val+ "'";

                try {
                    Connection con = new OracleDBMS().getConnection();
                    PreparedStatement pst = con.prepareStatement(sqlprice);
                    System.out.println("Its getproductshow");
                    ResultSet rs = pst.executeQuery();

                    while (rs.next()) {
                        //   total=rs.getFloat(1);
                        //   novat=rs.getFloat(2);
                        mm.add(new productshow(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getString(6) + " " + rs.getString(7));

                    }

                } catch (SQLException e) {
                    System.out.println(e);
                }

                return mm;
            }
    
}