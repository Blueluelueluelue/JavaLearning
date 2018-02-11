import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Create Name Column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Create Price Column
        TableColumn<Product, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(80);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Create Quantity Column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(80);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Create Name TextField
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMaxWidth(80);

        //Create Price TextField
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMaxWidth(80);

        //Create Quantity TextField
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMaxWidth(80);

        //Create Add Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addEvent());

        //Create Delete Button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteEvent());

        HBox editable = new HBox(10);
        editable.setPadding(new Insets(10,0,0,0));
        editable.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setItems(getData());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        layout.getChildren().addAll(table, editable);

        Scene scene = new Scene(layout, 420,500);
        window.setScene(scene);
        window.show();
    }


    //Add Event
    public void addEvent() {
        Product newProduct = new Product();
        String name, errormsg = "";
        Double price = 0.0;
        Integer quantity = 0;
        //setting name in the newProduct object
        name = nameInput.getText();
        if(!name.equals(""))
            newProduct.setName(name);
        else
            errormsg += "Name should not be blank. ";

        //setting price in the newProduct object
        try {
            //newProduct.setPrice(Double.parseDouble(priceInput.getText()));
            price = Double.parseDouble(priceInput.getText());
            newProduct.setPrice(price);
        } catch (NumberFormatException ne) {
            errormsg += "Price should be a double. ";
        }

        //setting quantity in the newProduct object
        try {
            //newProduct.setQuantity(Integer.parseInt(quantityInput.getText()));
            quantity = Integer.parseInt(quantityInput.getText());
            newProduct.setQuantity(quantity);
        } catch (NumberFormatException ne) {
            errormsg += "Quantity should be an integer. ";
        }

        //add newProduct to the table
        if(!name.equals("") && (price != 0.0) && (quantity != 0))
            table.getItems().add(newProduct);
        else
            AlertBox.display("Alert", errormsg);

        //clearing the TextFields
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    //Delete Event NOT WORKING AS IT'S SUPPOSED TO AND DON'T KNOW WHY
//    public void deleteEvent() {
//        ObservableList<Product> selected, all;
//        selected = table.getSelectionModel().getSelectedItems();
//        all = table.getItems();
////        for(Product p: selected){
////            all.remove(p);
////        }
//        selected.forEach(all::remove);
//    }

    //Delete Event
    public void deleteEvent() {
        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }

    //Fetching the data to fill up the table
    public ObservableList<Product> getData() {
        ObservableList<Product> list = FXCollections.observableArrayList();
        list.add(new Product("GPU", 350.49,20));
        list.add(new Product("CPU", 480.19,50));
        list.add(new Product("Football", 20.00,39));
        list.add(new Product("Speaker", 30.54,27));
        list.add(new Product("Headphone", 115.69,100));
        return list;
    }
}
