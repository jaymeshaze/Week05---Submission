import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * (Game: hangman) Write a program that displays a
 * drawing for the popular hangman game, as shown
 * in Figure 14.48a.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 */
public class HangmanDrawing extends Application {

	public static void main(String[] args) {
		Application.launch(args);
}

	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Arc base = new Arc(40, 140, 30, 10, 0, 180); // Create an arc
		base.setStroke(Color.BLACK);
		base.setFill(null); // Set fill color
		base.setType(ArcType.OPEN); // Set arc type
		pane.getChildren().add(base); // Add arc to pane
		
		Line pole = new Line(base.centerXProperty().get(), base.centerYProperty().get() - 10, base.centerXProperty().get(), base.centerYProperty().get() - 100);
		pole.setStrokeWidth(1);
		pane.getChildren().add(pole);
		
		Line highBar = new Line(pole.getEndX(),pole.getEndY(),pole.getEndX() + 40, pole.getEndY());
		highBar.setStrokeWidth(1);
		pane.getChildren().add(highBar);
		
		Line rope = new Line(highBar.getEndX(),highBar.getEndY(),highBar.getEndX(),highBar.getEndY() + 10);
		rope.setStrokeWidth(1);
		pane.getChildren().add(rope);
		
		Circle head = new Circle(rope.getEndX(), rope.getEndY() + 15, 15);
		head.setStroke(Color.BLACK);
		head.setFill(null);
		pane.getChildren().add(head);
		
		Line body = new Line(rope.getEndX(), rope.getEndY() + 30, rope.getEndX(), rope.getEndY() + 60);
		body.setStrokeWidth(1);
		pane.getChildren().add(body);
		
		Line leftArm = new Line(body.getStartX(), body.getStartY(), body.getStartX() - 10, body.getStartY() + 20);
		leftArm.setStrokeWidth(1);
		pane.getChildren().add(leftArm);
		
		Line rightArm = new Line(body.getStartX(), body.getStartY(), body.getStartX() + 10, body.getStartY() + 20);
		rightArm.setStrokeWidth(1);
		pane.getChildren().add(rightArm);
		
		Line leftLeg = new Line(body.getEndX(), body.getEndY(), body.getEndX() - 10, body.getEndY() + 20);
		leftLeg.setStrokeWidth(1);
		pane.getChildren().add(leftLeg);
		
		Line rightLeg = new Line(body.getEndX(), body.getEndY(), body.getEndX() + 10, body.getEndY() + 20);
		rightLeg.setStrokeWidth(1);
		pane.getChildren().add(rightLeg);

		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("hangman"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
	}
}
