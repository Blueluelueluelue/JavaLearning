import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class NewDialog
{
    static String fileName;
    static TextField fileInput;

    public static String display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setOnCloseRequest(e -> {
            fileName = "";
        });


        Label label = new Label();
        label.setText(message);

        fileInput = new TextField();
        fileInput.setPromptText("Name of new file");
        fileInput.setMaxWidth(150);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e -> {
            yesButtonClicked();
            window.close();
        });
        noButton.setOnAction(e -> {
            noButtonClicked();
            window.close();
        });

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(yesButton, noButton);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, fileInput, buttons);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return fileName;
    }

    private static void yesButtonClicked() {
        fileName = fileInput.getText();
    }

    private static void noButtonClicked() {
        fileName = "";
    }
}
