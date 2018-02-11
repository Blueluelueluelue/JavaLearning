import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;

public class Main extends Application
{
    ComboBox<String> movieList;
    ListView<String> tvList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;

        movieList = new ComboBox<>();
        movieList.getItems().addAll("Inception", "The Survivalist", "Anchorman");

        movieList.setPromptText("Was ist deine Lieblingsfilm?");
        movieList.setEditable(true);

        tvList = new ListView<>();
        tvList.getItems().addAll("Vikings", "The Office", "HIMYM", "Friends");

        tvList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        movieList.setOnAction(e -> {
            System.out.println(movieList.getValue());
        });

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            printChoice();
            printSelection();
        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(movieList, tvList, submitButton);

        Scene scene = new Scene(layout, 200, 300);
        window.setScene(scene);
        window.show();

    }

    private void printChoice() {
        System.out.println(movieList.getValue());
    }

    private void printSelection() {
        String message = "";
        ObservableList<String> tvShows = tvList.getSelectionModel().getSelectedItems();

        for(String s: tvShows)
            message += s + "\n";

        System.out.println(message);
    }
}
