//import java.util.Random;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class loginController {

    @FXML
    private TextField compoSend;

    @FXML
    private TextField compoUserio;

    @FXML
    private Button enterLogin;

    @FXML
    private Label Hlogin;

    @FXML
    void zeroLogin(ActionEvent event) throws IOException {
        String userio = compoUserio.getText();
        String send = compoSend.getText();
        //Button enterLogin = new Button ("Exit");

        if(userio.equals("Neeracha") && send.equals("64010444")){
            System.out.println("You have login.");
            //แสดงหน้าขึ้นมาเมื่อกดปุ่ม
            
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
            ((Node) event.getSource()).getScene().getWindow().hide(); //ปิดต่างหน้า
            
            //((System) scene).exit(0);
        }else if(userio.equals("1") && send.equals("1")){
            System.out.println("You have login.");
            //แสดงหน้าขึ้นมาเมื่อกดปุ่ม
            
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
            ((Node) event.getSource()).getScene().getWindow().hide(); //ปิดต่างหน้า

        }
        else {
            System.out.println("USERNAME OR PASSWORD ARE MISSED");
        }


    }
    /*@FXML
    private void somthing(MouseEvent event){
        if(event.getSource() == somerbuttton){
            system.exit(0);
        }
    }*/
    //pane.toFont();
}
