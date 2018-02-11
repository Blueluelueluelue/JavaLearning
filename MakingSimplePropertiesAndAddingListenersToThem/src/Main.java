import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class Main extends Application
{
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Creating an object of Person
        Person blue = new Person();


        //Adding a listener to its firstName property (recall we made firstName as a SimpleStringProperty object
        //so that we can listener to it, which is not possible to do for a String object)
        blue.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("First Name: " + blue.getFirstName());
            System.out.println("First Name Property: " + blue.firstNameProperty() + "\n");
        });

        //Creating an IntegerProperty object x and giving it an initial value 5
        IntegerProperty x = new SimpleIntegerProperty(5);

        //Creating an IntegerProperty object y and not giving it any initial value
        IntegerProperty y = new SimpleIntegerProperty();

        //Binding y to x so that y always has 10 times the value of x
        y.bind(x.multiply(10));

        //Creating UserInput TextField
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);

        //Creating Labels
        Label firstLabel = new Label("Welcome to the Project ");
        Label secondLabel = new Label();

        //Binding secondLabel to UserInput
        secondLabel.textProperty().bind(userInput.textProperty());          //Now just as the user starts typing anything in the
                                                                            //TextField, the secondLabel will dynamically update to
                                                                            //reflect that

        //Adding the labels to an HBox
        HBox bottomText = new HBox();
        bottomText.setAlignment(Pos.CENTER);
        bottomText.getChildren().addAll(firstLabel, secondLabel);

        //Create submitButton
        Button submitButton = new Button("Submit");

        //Clicking of submitButton will change the value of firstName triggering the listener and executing the above mentioned code
        submitButton.setOnAction( e -> {
            blue.setFirstName("Red");
            System.out.println("x: " + x.getValue());
            System.out.println("y: " + y.getValue());
            x.set(x.getValue() + 5);                    //Now x will be incremented by 5 on every button click so that we can
        });                                             //see that the value of y is always 10 times that of x without ever directly
                                                        //changing the value of y


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(userInput, bottomText, submitButton);

        Scene scene = new Scene(layout, 300, 400);
        window.setScene(scene);
        window.show();
    }
}
