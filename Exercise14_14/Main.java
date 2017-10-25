/**
 * 
 */

/**
 * (Display a rectanguloid) Write a program that displays
 * a rectanguloid, as shown in Figure 14.47a. The cube
 * should grow and shrink as the window grows or shrinks.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 *
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Main extends Application {


	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		//create rectangle 1 and bind to pane dimensions to scale
		Rectangle r1 = new Rectangle(10, 10, 0, 0);
		r1.widthProperty().bind(pane.widthProperty().subtract(50));
		r1.heightProperty().bind(pane.heightProperty().subtract(50));
		r1.setStroke(Color.BLACK);
		r1.setFill(null);
		pane.getChildren().add(r1);
		
		//create rectangle 2  and bind to pane dimensions to scale
		Rectangle r2 = new Rectangle(40, 40, 0, 0);
		r2.widthProperty().bind(pane.widthProperty().subtract(50));
		r2.heightProperty().bind(pane.heightProperty().subtract(50));
		r2.setStroke(Color.BLACK);
		r2.setFill(null);
		pane.getChildren().add(r2);
		
		//create lines to connect corners of rectangles
		Line l1 = new Line(10, 10, 40, 40);
		l1.setStrokeWidth(1);
		pane.getChildren().add(l1);
		
		
		Line l2 = new Line(10, 10, 40, 40);
		l2.startXProperty().bind(r1.widthProperty().add(10));
		l2.endXProperty().bind(r2.widthProperty().add(40));
		l2.setStrokeWidth(1);
		pane.getChildren().add(l2);
		
		Line l3 = new Line(10, 160, 40, 190);
		l3.startYProperty().bind(r1.heightProperty().add(10));
		l3.endYProperty().bind(r2.heightProperty().add(40));
		l3.setStrokeWidth(1);
		pane.getChildren().add(l3);
		
		Line l4 = new Line(10, 160, 40, 190);
		l4.startXProperty().bind(r1.widthProperty().add(10));
		l4.endXProperty().bind(r2.widthProperty().add(40));
		l4.startYProperty().bind(r1.heightProperty().add(10));
		l4.endYProperty().bind(r2.heightProperty().add(40));
		l4.setStrokeWidth(1);
		pane.getChildren().add(l4);
		
		
		//show scene
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("Rectanguloid"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	//launch application
	public static void main(String[] args) {
		Application.launch(args);
	}

}
