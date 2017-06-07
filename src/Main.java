import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.*;


/**
 * Created by mrsfy on 27-Mar-17.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Logger LOG = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(Main.class.getResource("./session.fxml")));

        primaryStage.setScene(scene);
        primaryStage.setHeight(675);
        primaryStage.setWidth(753);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

}