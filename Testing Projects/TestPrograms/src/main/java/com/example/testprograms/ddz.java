package com.example.testprograms;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ddz {

    public void start(Stage primaryStage) {
        TableView<Item> tv = new TableView<>(FXCollections.observableArrayList(
                new Item(1, 10),
                new Item(0, 9),
                new Item(1, 8),
                new Item(0, 7),
                new Item(1, 42),
                new Item(0, 4),
                new Item(1, 2),
                new Item(0, 99),
                new Item(1, 77),
                new Item(0, 44),
                new Item(1, 11),
                new Item(0, 2),
                new Item(1, 2),
                new Item(0, 3),
                new Item(1, 5),
                new Item(0, 6)
        ));

        TableColumn<Item, Item> countColumn = new TableColumn<>("count");
        countColumn.setCellValueFactory(cd -> Bindings.createObjectBinding(cd::getValue));

        countColumn.setCellFactory(new Callback<TableColumn<Item, Item>, TableCell<Item, Item>>() {
            @Override
            public TableCell<Item, Item> call(TableColumn<Item, Item> param) {
                TableCell<Item, Item> cell = new TableCell<Item, Item>() {

                    private final Spinner<Integer> count;
                    private final SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory;
                    private final ChangeListener<Number> valueChangeListener;

                    {
                        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0);
                        count = new Spinner<>(valueFactory);
                        count.setVisible(false);
                        setGraphic(count);
                        valueChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                            valueFactory.setValue(newValue.intValue());
                        };
                        count.valueProperty().addListener((obs, oldValue, newValue) -> {
                            if (getItem() != null) {
                                // write new value to table item
                                getItem().setItemCount(newValue);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Item item, boolean empty) {
                        // unbind old values
                        valueFactory.maxProperty().unbind();
                        if (getItem() != null) {
                            getItem().itemCountProperty().removeListener(valueChangeListener);
                        }

                        super.updateItem(item, empty);

                        // update according to new item
                        if (empty || item == null) {
                            count.setVisible(false);
                        } else {
                            valueFactory.maxProperty().bind(item.itemMaxCountProperty());
                            valueFactory.setValue(item.getItemCount());
                            item.itemCountProperty().addListener(valueChangeListener);
                            count.setVisible(true);
                        }
                    }
                };

                return cell;
            }
        });

        tv.getColumns().add(countColumn);

        Button btn = new Button("Print");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println(tv.getItems());
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(new VBox(10, tv, btn));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
