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
        //Creating Labels
        Label lengthLabel = new Label("Length :");
        GridPane.setConstraints(lengthLabel, 0,0);

        Label widthLabel = new Label("Width :");
        GridPane.setConstraints(widthLabel, 0, 1);

        Label areaLabel = new Label("Area :");
        GridPane.setConstraints(areaLabel, 0, 3);

        Label perimeterLabel = new Label("Perimeter :");
        GridPane.setConstraints(perimeterLabel, 0, 4);

        //Creating TextFields
        TextField lengthText = new TextField();
        lengthText.setPromptText("Length of rectangle");
        GridPane.setConstraints(lengthText, 1, 0);

        TextField widthText = new TextField();
        widthText.setPromptText("Width of rectangle");
        GridPane.setConstraints(widthText, 1, 1);

        //Creating Answer Labels
        Label areaAnswer = new Label();
        GridPane.setConstraints(areaAnswer, 1, 3);

        Label perimeterAnswer = new Label();
        GridPane.setConstraints(perimeterAnswer, 1, 4);

        //Creating Buttons
        Button calculteButton = new Button("Calculate");
        calculteButton.setMinWidth(100);
        GridPane.setConstraints(calculteButton, 0, 2);

        //Calculates Area and Perimeter using text from the 2 TextFields of length and width and
        //sets text of Area and Perimeter labels with the results
        calculteButton.setOnAction(e -> {
            double length = Double.parseDouble(lengthText.getText());
            double width = Double.parseDouble(widthText.getText());
            areaAnswer.setText(String.format("%.2f", length * width));
            perimeterAnswer.setText(String.format("%.2f", 2 * (length + width)));
        });

        Button resetButton = new Button("Reset");
        resetButton.setMinWidth(100);
        GridPane.setConstraints(resetButton, 1, 2);

        //Clears the TextFields and the Answer labels
        resetButton.setOnAction( e -> {
            areaAnswer.setText("");
            perimeterAnswer.setText("");
            lengthText.setText("");
            widthText.setText("");
        });

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(10);
        layout.setVgap(10);

        //Adding all the items to the GridPane layout
        layout.getChildren().addAll(lengthLabel,
                widthLabel,
                areaLabel,
                perimeterLabel,
                lengthText,
                widthText,
                calculteButton,
                resetButton,
                areaAnswer,
                perimeterAnswer);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
