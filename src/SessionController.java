import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class SessionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane mainWordPane;

    @FXML
    private Label noSolutionLabel;

    @FXML
    private TextField saTemperature;

    @FXML
    private TextField saCoolingFactor;

    @FXML
    private TextField lbIterations;

    @FXML
    private TextField hcIterations;

    @FXML
    private TextField queens;

    @FXML
    private SplitPane splitWordList;

    @FXML
    private TextField saIterations;

    @FXML
    private TextField lbStates;

    @FXML
    private TextField gaGenerations;

    @FXML
    private TextField gaInitialPopulationSize;

    @FXML
    private TextField gaMutationProbability;

    GUIPuzzle guiPuzzle = new GUIPuzzle();

    private int getNum(TextField tf) {
        return Integer.parseInt(tf.getText());
    }
    private double getDouble(TextField tf) {
        return Double.parseDouble(tf.getText());
    }

    @FXML
    void runHillClimbing(ActionEvent event) {
        HillClimbing hillClimbing = new HillClimbing();
        int[] res = hillClimbing.solve(getNum(queens), getNum(hcIterations));

        showResult(res);
    }

    @FXML
    void runSimulatedAnnealing(ActionEvent event) {
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();

        int[] res = simulatedAnnealing.solve(getNum(queens), getNum(saIterations), getDouble(saTemperature), getDouble(saCoolingFactor));

        showResult(res);
    }

    private void showResult(int[] res) {
        guiPuzzle.drawQueens(res);
        noSolutionLabel.setVisible(res == null);
    }

    @FXML
    void runLocalBeamSearch(ActionEvent event) {
        LocalBeamSearch localBeamSearch = new LocalBeamSearch();

        int[] res = localBeamSearch.solve(getNum(queens), getNum(lbIterations), getNum( lbStates));
        showResult(res);
    }

    @FXML
    void runGeneticAlgorithm(ActionEvent event) {

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        int[] res = geneticAlgorithm.solve(getNum(queens), getNum(gaInitialPopulationSize), getDouble(gaMutationProbability), getNum(gaGenerations));

        showResult(res);
    }

    @FXML
    void initialize() {
        assert mainWordPane != null : "fx:id=\"mainWordPane\" was not injected: check your FXML file 'session.fxml'.";
        assert saTemperature != null : "fx:id=\"saTemperature\" was not injected: check your FXML file 'session.fxml'.";
        assert saCoolingFactor != null : "fx:id=\"saCoolingFactor\" was not injected: check your FXML file 'session.fxml'.";
        assert lbIterations != null : "fx:id=\"lbIterations\" was not injected: check your FXML file 'session.fxml'.";
        assert hcIterations != null : "fx:id=\"hcIterations\" was not injected: check your FXML file 'session.fxml'.";
        assert queens != null : "fx:id=\"queens\" was not injected: check your FXML file 'session.fxml'.";
        assert splitWordList != null : "fx:id=\"splitWordList\" was not injected: check your FXML file 'session.fxml'.";
        assert saIterations != null : "fx:id=\"saIterations\" was not injected: check your FXML file 'session.fxml'.";
        assert lbStates != null : "fx:id=\"lbStates\" was not injected: check your FXML file 'session.fxml'.";
        assert gaGenerations != null : "fx:id=\"gaGenerations\" was not injected: check your FXML file 'session.fxml'.";
        assert gaMutationProbability != null : "fx:id=\"gaMutationProbability\" was not injected: check your FXML file 'session.fxml'.";


        mainWordPane.setCenter(guiPuzzle);
        mainWordPane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));

    }
}
