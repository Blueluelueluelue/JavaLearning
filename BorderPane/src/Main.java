import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        Button file = new Button("File");
        Button edit = new Button("Edit");
        Button view = new Button("View");
        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 2");
        Button b3 = new Button("Button 3");

        HBox topMenu = new HBox(10);            //DO NOT USE HBOX FOR TOP MENUS JAVAFX HAS MUCH MUCH BETTER OPTIONS
        topMenu.getChildren().addAll(file, edit, view);

        VBox leftMenu = new VBox(10);
        leftMenu.getChildren().addAll(b1, b2, b3);

        BorderPane layout = new BorderPane();
        layout.setTop(topMenu);
        layout.setLeft(leftMenu);

        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }
}
