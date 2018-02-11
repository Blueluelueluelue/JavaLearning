import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        //Add Event on item click
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
                new MenuItem("Exit")
        );

        //Create Edit Menu
        Menu editMenu = new Menu("Edit");

        MenuItem cut = new MenuItem("Cut");
        cut.setDisable(true);                   //makes this menu item greyed out so user can't click on it

        //Add Items in Edit Menu
        editMenu.getItems().addAll(
                cut,
                new MenuItem("Copy"),
                new MenuItem("Paste")
        );

        //Create Options Menu
        Menu optionsMenu = new Menu("Options");

        //Create CheckMenuItem for Options Menu
        CheckMenuItem showLineNo = new CheckMenuItem("Show Line Numbers");

        //Create on-click event for showLineNo Item
        showLineNo.setOnAction(e -> {
            if(showLineNo.isSelected())
                System.out.println("Showing Line Numbers");
            else
                System.out.println("Hiding Line Numbers");
        });

        //Add Items to Options Menu
        optionsMenu.getItems().addAll(showLineNo);


        //Create Difficulty Menu
        Menu difficultyMenu = new Menu("Difficulty");

        //Create RadioMenuItems for Difficulty Menu
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        //The RadioMenuItems which I want to have in the same group so that user can only select
        //one amongst those at a time have to added to ONE ToggleGroup

        //Create ToggleGroup
        ToggleGroup difficultyGroup = new ToggleGroup();

        //Adding the appropriate RadioMenuItems to a ToggleGroup
        easy.setToggleGroup(difficultyGroup);
        medium.setToggleGroup(difficultyGroup);
        hard.setToggleGroup(difficultyGroup);

        //Adding RadioMenuItems to the Difficulty Menu
        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Create Menu Bar
        MenuBar bar = new MenuBar();

        //Add Menus to Menu Bar
        bar.getMenus().addAll(fileMenu, editMenu, optionsMenu, difficultyMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(bar);

        Scene scene = new Scene(layout, 300,300);
        window.setScene(scene);
        window.show();
    }
}
