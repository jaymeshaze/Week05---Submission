/**
 * (Plot the sine and cosine functions) Write a program
 * that plots the sine function in red and cosine in blue,
 * as shown in Figure 14.48c.
 * 
 * Hint: The Unicode for p is \u03c0.
 * To display -2p, use Text(x, y, "-2\u03c0").
 * For a trigonometric function like sin(x), x is in radians.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 *
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	public void start(Stage primaryStage) {
		//set width and height to be used for refernce of axis lines
		final int WIDTH = 400;
		final int HEIGHT = 200;
		
		Pane pane = new Pane();
		
		//create sine graphed line and add to pane
		Polyline sinLine = new Polyline();
		ObservableList<Double> sinList = sinLine.getPoints();
		for (int x = -170; x <= 170; x++) {
			sinList.add(x + 200.0);
			sinList.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));
		}
		sinLine.setStroke(Color.RED);
		pane.getChildren().add(sinLine);
		
		//create cosine graphed line and add to pane
		Polyline cosLine = new Polyline();
		ObservableList<Double> cosList = cosLine.getPoints();
		for (int x = -170; x <= 170; x++) {
			cosList.add(x + 200.0);
			cosList.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));
		}
		cosLine.setStroke(Color.BLUE);
		pane.getChildren().add(cosLine);
		
		//create axis with arrow (X and Y)
		Line axisY = new Line(WIDTH / 2, 0, WIDTH / 2, WIDTH / 2);
		axisY.setStrokeWidth(1);
		pane.getChildren().add(axisY);
		
		Line axisX = new Line(0, HEIGHT / 2, WIDTH, HEIGHT / 2);
		axisX.setStrokeWidth(1);
		pane.getChildren().add(axisX);
		
		Line arrowYLeft = new Line(axisY.getStartX(), axisY.getStartY(), axisY.getStartX() - 10, axisY.getStartY() + 20);
		arrowYLeft.setStrokeWidth(1);
		pane.getChildren().add(arrowYLeft);
		
		Line arrowYRight = new Line(axisY.getStartX(), axisY.getStartY(), axisY.getStartX() + 10, axisY.getStartY() + 20);
		arrowYRight.setStrokeWidth(1);
		pane.getChildren().add(arrowYRight);
		
		Line arrowXTop = new Line(axisX.getEndX(), axisX.getEndY(), axisX.getEndX() - 20, axisX.getEndY() - 10);
		arrowXTop.setStrokeWidth(1);
		pane.getChildren().add(arrowXTop);
		
		Line arrowXBottom = new Line(axisX.getEndX(), axisX.getEndY(), axisX.getEndX() - 20, axisX.getEndY() + 10);
		arrowXBottom.setStrokeWidth(1);
		pane.getChildren().add(arrowXBottom);
		
		
		//add label graph for reference
		Text negative2Pi = new Text(WIDTH * .22, (HEIGHT / 2) + 15, "-2\u03c0");
		pane.getChildren().add(negative2Pi);
		
		Text negativePi = new Text(WIDTH * .35, (HEIGHT / 2) + 15, "-\u03c0");
		pane.getChildren().add(negativePi);
		
		Text zero = new Text((WIDTH / 2) + 3, (HEIGHT / 2) + 15, "0");
		pane.getChildren().add(zero);
		
		Text positivePi = new Text(WIDTH * .625, (HEIGHT / 2) + 15, "\u03c0");
		pane.getChildren().add(positivePi);
		
		Text positive2Pi = new Text(WIDTH * .875, (HEIGHT / 2) + 15, "2\u03c0");
		pane.getChildren().add(positive2Pi);
		
		Text labelX = new Text(axisX.getEndX() - 15, axisX.getEndY() - 25, "X");
		pane.getChildren().add(labelX);
		
		Text labelY = new Text(axisY.getStartX() + 25, axisY.getStartY() + 15, "Y");
		pane.getChildren().add(labelY);
		
		//show scene
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setTitle("sin/cos function"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	//launch application
	public static void main(String[] args) {
		Application.launch(args);
	}

}
