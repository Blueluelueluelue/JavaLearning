import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    Button button;
    Stage window;
    Button confirmButton;
    Button closebutton;
    Label label;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Title of window 1");
        button = new Button();
        button.setText("Create Alert Box");
        button.setOnAction(e -> AlertBox.display("AlertBox", "This is an Alert"));

        window.setOnCloseRequest(e -> {
            e.consume();                    // When user clicks on the cross the system's default behaviour is to close the window
            closeProgram();                 // without regard to what the user clicks afterwards, but e.consume() changes that and
        });                                 // tells the system that we are going to handle the close request you don't have to do it

        closebutton = new Button();
        closebutton.setText("Close Stage");
        closebutton.setOnAction(e-> closeProgram());

        label = new Label();
        confirmButton = new Button();
        confirmButton.setText("Create Confirmation Box");
        confirmButton.setOnAction(e -> {
            boolean result = ConfirmBox.display("Confirmation Box", "Yes or No?");
//            (result) ? label.setText("You clicked yes"); : label.setText("You clicked no");
            if(result)
                label.setText("You clicked yes");
            else
                label.setText("You clicked no");
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(button, closebutton, confirmButton, label);
        layout.setAlignment(Pos.BASELINE_LEFT);
        Scene scene = new Scene(layout, 300, 400);
        window.setScene(scene);
        window.show();

    }

    public void closeProgram() {
        Boolean answer = ConfirmBox.display("Confirm", "Do you really want to close?");

        if(answer){
            System.out.println("File saved");
            window.close();
        }
    }
}
