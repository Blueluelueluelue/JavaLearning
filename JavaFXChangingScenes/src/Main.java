import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    //    Button button;
//    Button button2;
//    Button button3;
//    Button button4;
//    Scene scene2;
    Button button1, button2;
    Scene scene1, scene2;
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Label label1 = new Label("Welcome to Scene 1");
        Label label2 = new Label("Welcome to Scene 2");

        button1 = new Button("Go to Scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        button2 = new Button("Go to Scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 400);

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 300, 400);

        window.setScene(scene1);
        window.setTitle("This is title");
        window.show();

//        primaryStage.setTitle("This is the title");
//        button = new Button();
//        button.setText("Click here");
//        button.setOnAction(this);
//
//        button2 = new Button();
//        button2.setText("Don't Click here");
////        button2.setOnAction(new EventHandler<ActionEvent>() {
////            @Override
////            public void handle(ActionEvent event) {
////                System.out.println("No hi");
////            }
////        });
//        button2.setOnAction(e -> {              //lambda expression
//            System.out.print("No ");
//            System.out.println("hi");
//        });
//        Label label1 = new Label("Welcome to Scene 1");
//
//        VBox layout = new VBox(20);
//        layout.getChildren().addAll(button, button2, label1, button3);
////        layout.getChildren().add(button2);
//
//        Scene scene = new Scene(layout, 200, 400);
//        VBox layout2 = new VBox(20);
//
//        button3 = new Button();
//        button3.setText("Go to scene 2");
//        button3.setOnAction(e -> primaryStage.setScene(scene2));
//
//        Label label2 = new Label("Welcome to Scene 2");
//        button4 = new Button("Go to scene 1");
//        button4.setOnAction(e -> primaryStage.setScene(scene));
//        layout2.getChildren().addAll(label2, button4);
//        scene2 = new Scene(layout2, 300, 400);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    @Override
//    public void handle(ActionEvent event) {
//        if(event.getSource() == button) {
//            System.out.println("Hi");
//        }
//      }

    }
}
