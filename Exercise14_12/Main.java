/**
 * 
 */

/**
 * (Display a bar chart) Write a program that uses a bar chart
 * to display the percentages of the overall grade represented
 * by projects, quizzes, midterm exams, and the final exam,
 * as shown in Figure 14.46b. Suppose that projects take 20 percent
 * and are displayed in red, quizzes take 10 percent and are
 * displayed in blue, midterm exams take 30 percent and are
 * displayed in green, and the final exam takes 40 percent and is
 * displayed in orange. Use the Rectangle class to display the bars.
 * Interested readers may explore the JavaFX BarChart class for further study.
 * 
 * @author Kris
 * @version 1.0
 * @since 06-28-2016
 *
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		// Create project bar and add to pane
		Rectangle r1 = new Rectangle(10, 120, 100, 80);
		r1.setStroke(Color.BLACK);
		r1.setFill(Color.RED);
		pane.getChildren().add(new Text(20, 100, "Projects -- 20%"));
		pane.getChildren().add(r1);
		
		// Create quiz bar and add to pane
		Rectangle r2 = new Rectangle(120, 160, 100, 40);
		r2.setStroke(Color.BLACK);
		r2.setFill(Color.BLUE);
		pane.getChildren().add(new Text(130, 140, "Quiz -- 10%"));
		pane.getChildren().add(r2);
		
		// Create midterm bar and add to pane
		Rectangle r3 = new Rectangle(230, 80, 100, 120);
		r3.setStroke(Color.BLACK);
		r3.setFill(Color.GREEN);
		pane.getChildren().add(new Text(240, 60, "Midterm -- 30%"));
		pane.getChildren().add(r3);
		
		// Create final bar and add to pane
		Rectangle r4 = new Rectangle(340, 40, 100, 160);
		r4.setStroke(Color.BLACK);
		r4.setFill(Color.ORANGE);
		pane.getChildren().add(new Text(350, 20, "Final -- 40%"));
		pane.getChildren().add(r4);
		
		//show scene
		Scene scene = new Scene(pane, 450, 250);
		primaryStage.setTitle("GradeBarGraph"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	//launch program
	public static void main(String[] args) {
		Application.launch(args);
	}

}
