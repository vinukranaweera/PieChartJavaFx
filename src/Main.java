/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

/**
 *
 * @author vinuk
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    // Sets the boundaries of stage
    final int WIDTHS = 1700; //
    final int HEIGHTS = 900; //900

    //Overide method
    @Override
    public void start(Stage primaryStages) {
        try {
            // Sets up the primary stage, canvas, and the graphics context
            primaryStages.setTitle("Assignment 3");
            Canvas canvass = new Canvas(WIDTHS, HEIGHTS);
            GraphicsContext gcs = canvass.getGraphicsContext2D();

            // Obtain the HashMap of frequencies of letters and draws the circular pie chart displaying each frequency
            double centerXs = WIDTHS / 2, centerYs = HEIGHTS / 2;
            HistogramAlphaBet Alice = new HistogramAlphaBet("/Users/vinuk/Downloads/Alice in Wonderland.txt");
            MyPieChart Pie = new MyPieChart(centerXs, centerYs, HEIGHTS / 3, 12, Alice.frequencyOfLetters());
            Pie.draw(gcs);
            //System.out.println(slice + "\n\n");

            // Set the stack pane and scene for the image to appear on
            StackPane roots = new StackPane(canvass);
            Scene scenes = new Scene(roots, WIDTHS, HEIGHTS);
            primaryStages.setScene(scenes);
            primaryStages.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
