

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.logging.*;

import static javafx.application.Application.launch;


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
        primaryStage.show();

        /*
        HillClimbing hillClimbing = new HillClimbing();
        System.out.println(Arrays.toString(hillClimbing.solve(8)));
        */

        /*
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        System.out.println(Arrays.toString(simulatedAnnealing.solve(8, 500000, 300000, 0.95)));
        */

        LocalBeamSearch localBeamSearch = new LocalBeamSearch();
        System.out.println(Arrays.toString(localBeamSearch.solve(8, 500000, 15)));


    }

}