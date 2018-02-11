import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;

        //Initializing the grid
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(10, 10, 10, 10));

        //Username label
        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 1,1);

        //Giving Inline Style to UserLabel to make it's text bold
        userLabel.setStyle("-fx-font-weight: bold");

        //Password label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 1, 2);

        //Username TextField
        TextField userText = new TextField("Blue");     //Can specify default text in the constructor call
        GridPane.setConstraints(userText, 2,1);

        //Password TextField
        TextField passText = new TextField();
        passText.setPromptText("enter your password");    //prompt text and default text are different
        GridPane.setConstraints(passText, 2,2);

        //Log In button
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 2,3);

        //Sign Up Button
        Button signUpButton = new Button("Sign Up");
        GridPane.setConstraints(signUpButton, 2,4);

        //Giving Sign Up button an ID for unique CSS assignment
        signUpButton.setId("button-blue");

        grid.getChildren().addAll(userLabel, userText, passLabel, passText, loginButton, signUpButton);
        Scene scene = new Scene(grid, 400, 400);

        //Adding a stylesheet to a scene
        scene.getStylesheets().add("Razor.css");

        window.setScene(scene);
        window.show();
    }
}
