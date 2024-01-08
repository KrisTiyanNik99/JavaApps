package com.example.testprograms;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    List<String> modelAnswers;
    ObservableList<Test> newItem;
    TableView<Test> testTableView;
    TextField answer;

    @Override
    public void start(Stage window) {

        answer = new TextField();
        testTableView = new TableView<>();
        modelAnswers = new ArrayList<>();
        modelAnswers = names(getDam());
        newItem = getDam();

        TableColumn<Test, Test> testTableCell = new TableColumn<>();
        testTableCell.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue()));
        testTableCell.setCellFactory(testTestTableColumn -> new TableCell<>() {
            private final Spinner<String> choice = new Spinner<>();

            {
                //List<String> choose = names(getDam());
                SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(FXCollections.observableList(modelAnswers));
                choice.setValueFactory(valueFactory);
                /*choice.valueProperty().addListener((observable, oldValue, newValue) -> {
                    if (getItem() != null) {
                        getItem().editName(newValue);
                    }
                 });*/

            }

            @Override
            protected void updateItem(Test ddz, boolean empty) {
                //super.updateItem(ddz, empty);
                if (empty || ddz == null) {
                    // Ако клетката е празна или няма обект, скрийте Spinner
                    setGraphic(null);
                } else {
                    // Покажи Spinner и настрои стойността му спрямо модела на колата
                    //choice.getValueFactory().setValue(ddz.getName());
                    setGraphic(choice);
                }
            }
        });

        TableColumn<Test, String> namesis = new TableColumn<>("New String name");
        namesis.setCellValueFactory(new PropertyValueFactory<>("name"));

        testTableView.setItems(newItem);
        testTableView.getColumns().addAll(namesis, testTableCell);

        Button adding = new Button("Add model of answer");
        adding.alignmentProperty().setValue(Pos.CENTER_LEFT);
        adding.setOnAction(e -> addSomething());
        Button neshto = new Button("neshto");
        neshto.setOnAction(e -> print());

        GridPane vBox = new GridPane();
        vBox.getChildren().addAll(answer, adding);
        StackPane root = new StackPane();
        root.getChildren().add(neshto);

        Scene scene = new Scene(new VBox(10, testTableView, vBox, root));

        window.setTitle("Test!");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void addSomething() {
        Test kurva = new Test(answer.getText());
        modelAnswers.add(kurva.getName());

        newItem.add(new Test(kurva.getName()));
        testTableView.setItems(newItem);
        answer.clear();
    }

    public void print(){
        ObservableList<Test> ddz = testTableView.getItems();
        ddz.forEach(e ->System.out.println(e.getName()));
    }

    public ObservableList<Test> getDam() {
        ObservableList<Test> dame = FXCollections.observableArrayList();
        dame.add(new Test("da"));
        dame.add(new Test("ne"));
        dame.add(new Test("moje"));
        dame.add(new Test("sigurno"));
        return dame;
    }

    public List<String> names(ObservableList<Test> get) {

        List<String> name = new ArrayList<>();

        for (Test test : get) {
            name.add(test.getName());
        }

        return name;
    }
}