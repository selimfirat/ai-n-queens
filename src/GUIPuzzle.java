import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by mrsfy on 27-Mar-17.
 */
public class GUIPuzzle extends StackPane {

    private GraphicsContext gc;
    private GraphicsContext bgc;
    private double size = 500;
    private double singleSize;

    private int numQueens = 8;
    private Image queen = new Image("queen.png");


    public GUIPuzzle() {


        Canvas canvas = new Canvas(size, size);
        Canvas backCanvas = new Canvas(size, size);


        gc = canvas.getGraphicsContext2D();
        bgc = backCanvas.getGraphicsContext2D();

        clearFields();

        singleSize = size / numQueens;
        drawGrid();
        this.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));
        this.setPrefWidth(size);
        this.setPrefHeight(size);
        this.getChildren().addAll(canvas, backCanvas);
        for (int i = 0; i < numQueens; i++)
            for (int j = 0; j < numQueens; j++)
                if ((i + j) % 2 == 1)
                    drawDarkCell(i, j);

    }

    public void drawQueens(int[] r) {
        clearFields();

        bgc.clearRect(0, 0, size, size);
        numQueens = r != null ? r.length : numQueens;
        singleSize = size / numQueens;
        drawGrid();
        for (int i = 0; i < numQueens; i++)
            for (int j = 0; j < numQueens; j++)
                if ((i + j) % 2 == 1)
                    drawDarkCell(i, j);

        if (r != null)
            for (int i = 0; i < r.length; i++) {
                addQueen(i, r[i]);
            }
    }

    private void addQueen(int i, int j) {
        gc.drawImage(queen, singleSize*(i + 0.1), singleSize*(j + 0.1), singleSize*.8, singleSize*.8);
    }

    public void clearFields() {

        gc.clearRect(0, 0, size, size);

    }

    private void drawDarkCell(int i, int j) {
        gc.setFill(Color.BROWN);
        gc.fillRect(i*singleSize, j*singleSize, singleSize, singleSize);
    }


    private void drawGrid() {
        for (int i = 0; i <= numQueens; i++) {

            bgc.setLineWidth(i == 0 || i == numQueens ? 2.4 : 0.6);
            bgc.setStroke(Color.DIMGRAY);

            bgc.strokeLine(0, i * singleSize, size, i * singleSize);
            bgc.strokeLine(i * singleSize, 0, i * singleSize, size);
        }
    }

}