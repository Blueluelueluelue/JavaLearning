import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Create File Menu
        Menu fileMenu = new Menu("_File");    //Now the user can expand the File menu by using Alt+F shortcut

        //Add Events on option clicks
        MenuItem newItem = new MenuItem("New...");
        newItem.setOnAction(e -> {
            String fileName = NewDialog.display("Create New File", "Do you want to create a new file?");
            if(!fileName.equals(""))
                System.out.println(fileName + " HAS BEEN CREATED");
        });

        //Add Items in File Menu
        fileMenu.getItems().addAll(
                newItem,
                new MenuItem("Open..."),
                new MenuItem("Save..."),
                new SeparatorMenuItem(),
                new MenuItem("Exit"));

        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(fileMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(bar);

        Scene scene = new Scene(layout, 200,300);
        window.setScene(scene);
        window.show();
    }
}
