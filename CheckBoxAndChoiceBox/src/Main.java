import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(20);

        Label label = new Label("What do you like?");
        GridPane.setConstraints(label, 0,0);

        CheckBox footballBox = new CheckBox("Football");
        footballBox.setSelected(true);                          // checking this box on default but user can uncheck if he wants to
        GridPane.setConstraints(footballBox, 1,0);

        CheckBox basketballBox = new CheckBox("Basketball");
        GridPane.setConstraints(basketballBox, 1,1);

        CheckBox dodgeballBox = new CheckBox("Dodgeball");
        GridPane.setConstraints(dodgeballBox, 1,2);

        Label label2 = new Label("Where do you live?");
        GridPane.setConstraints(label2, 0,4);

        ChoiceBox<String> countryList = new ChoiceBox<>();
        countryList.getItems().add("India");        //getItems() returns the ObservableList object which you can add items to
        countryList.getItems().addAll("Germany", "USA", "China", "Brazil");
        // set a default value checked, won't check anything if the passed data is not inside the list already
        countryList.setValue("India");
        GridPane.setConstraints(countryList, 1, 4);

        Label label3 = new Label("Select desired version");
        GridPane.setConstraints(label3, 0, 6);

        ChoiceBox<Integer> versionList = new ChoiceBox<>();
        versionList.getItems().addAll(6, 7, 8, 9, 10);
        versionList.setValue(10);
        GridPane.setConstraints(versionList, 1, 6);

        // Adding a listener gives the functionality that there's some code run when the user clicks on the item in the
        // choicebox, this can't be achieved with standard JavaFX events so we use a workaround by adding listeners to
        // the individual options in the choicebox that will fire the specified code when evoked
        versionList.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            System.out.println("You went from " + oldValue + " to " + newValue);
        } );

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            handleOptions(footballBox, basketballBox, dodgeballBox);
            handleChoices(countryList);
        });
        GridPane.setConstraints(submitButton, 1,7);

        grid.getChildren().addAll(label, footballBox, basketballBox, dodgeballBox, label2, countryList, label3, versionList, submitButton);
        Scene scene = new Scene(grid, 600, 400);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox foot, CheckBox basket, CheckBox dodge) {
        String message = "You like:\n";
        if(foot.isSelected())
            message += "Football\n";
        if(basket.isSelected())
            message += "Basketball\n";
        if(dodge.isSelected())
            message += "Dodgeball\n";
        System.out.println(message);
    }

    private void handleChoices(ChoiceBox<String> list) {
        System.out.println("You live in:\n" + list.getValue() + "\n");     //getValue() returns which data was selected
    }
}
