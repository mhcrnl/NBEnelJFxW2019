/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbeneljfxw2019;

//import com.sun.istack.internal.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Irina
 */
public class NBEnelJFxW2019 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root;
        
        
        VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(3));
        
        Label cost = new Label("Costul energiei electrice: ");
        
        TextField tfcost = new TextField();
        
        Label kwati = new Label("Kilowati consumati: ");
        
        TextField tfkwati = new TextField();
        
        Button bcalc = new Button("Calculate");
        
        Button bsave = new Button("Save");
//        bcalc.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                //throw new UnsupportedOperationException("Not supported yet."); 
//                //To change body of generated methods, choose Tools | Templates.
//            }
//            
//        });
        
        Label lpretkw = new Label("Cost per kilovat: ");
        
        TextArea ta = new TextArea();
        
        Button btn = new Button();
        btn.setText("Close ");
        //ACTIONS ...............................................................................
        bcalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                double pret = Double.parseDouble(tfcost.getText());
                double kwcons = Double.parseDouble(tfkwati.getText());
                double pretkw = pret / kwcons;
                ta.setText(String.valueOf(pretkw));
            }
        });
                     
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                System.exit(0);
            }
        });
        
        bsave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files(*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
                if(file != null){
                    SaveFile(ta.getText(), file);
                }
            }
            
        });
        
        vbox.getChildren().addAll(cost,tfcost,kwati, tfkwati,bcalc,lpretkw,ta,bsave, btn);
        
        root = new StackPane();
        root.getChildren().add(vbox);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Calculator ENEL !");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void SaveFile(String content, File file){
        try{
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex ){
            //Logger.getLogger(NBEnelJFxW2019.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex");
        }
    }    
}
