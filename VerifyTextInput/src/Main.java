import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;


public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;

        TextField input = new TextField();
        input.setPromptText("enter an integer");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            if(isInt(input, input.getText()))
                System.out.println("Nice");
        });

        HBox layout = new HBox(10);
        layout.getChildren().addAll(input, submitButton);

        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }

    public boolean isInt(TextField input , String message) {
        try {
            int result = Integer.parseInt(message);
            return true;
        }catch (NumberFormatException e) {
            System.out.println(input.getText() + " is not an int");
            return false;
        }
    }
}
