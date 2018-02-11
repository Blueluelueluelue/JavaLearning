import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sun.reflect.generics.tree.Tree;

public class Main extends Application
{
    Stage window;
    TreeView<String> tree;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //create
        TreeItem<String> root = new TreeItem<>();
        root.setExpanded(true);


        //create children of root
        TreeItem<String> food = makeBranch("Food", root);
        TreeItem<String> furniture = makeBranch("Furniture", root);

        //create children of food
        makeBranch("Ice Cream", food);          //no need to assign the object to a reference since we are making
        makeBranch("Pizza", food);              //leaf nodes. Leaf nodes are not going to be parents so no need of
        makeBranch("Burger", food);             //their objects

        //create children of furniture
        makeBranch("Bed", furniture);
        makeBranch("Table", furniture);
        makeBranch("Chair", furniture);

        //it only needs the root object to create the tree object since every other node will be a direct
        //or an indirect child of the root
        tree = new TreeView<>(root);
        tree.setShowRoot(false);                //hides the root

        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null)
                System.out.println(newValue.getValue());
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300,300);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);         //starts the branch as expanded on default
        parent.getChildren().add(item); //sets parent as parent node of item
        return item;
    }
}
