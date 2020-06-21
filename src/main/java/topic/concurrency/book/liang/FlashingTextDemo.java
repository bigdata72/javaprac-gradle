package topic.concurrency.book.liang;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashingTextDemo extends Application {
	private String text = "";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		Label label = new Label("Program in java");
		pane.getChildren().add(label);
		new Thread(() -> { // lambda expression
			try{
				while(true) {
					if (label.getText().trim().length() == 0)
						text = "welcome";
					else
						text = "";
					
					Platform.runLater(() -> label.setText(text)); // run from JavaFX GUI
					
					Thread.sleep(200); // to allow the text to get updated
				}
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		
		}).start();
		
		// create a scene and add to stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Flashing text demo with threads");
		primaryStage.setScene(scene); // place scene in the stage
		primaryStage.show();
	
	}
}
