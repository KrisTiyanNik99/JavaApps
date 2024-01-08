package com.example.testprograms;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Test {
    private final StringProperty name = new SimpleStringProperty();

    public Test(String name) {
        this.name.setValue(name);
    }

    public final String getName() {
        return this.name.get();
    }

    public final void editName(String name) {
        this.name.setValue(name);
    }
}
