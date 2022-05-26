import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = fxmlLoader.load();
        Scene lay = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("MAIN");
        primaryStage.setScene(lay);
        primaryStage.show();
        
    }
    
}
