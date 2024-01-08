package com.example.testprograms;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Item {

    private final IntegerProperty itemCount = new SimpleIntegerProperty();
    private final IntegerProperty itemMaxCount = new SimpleIntegerProperty();

    @Override
    public String toString() {
        return Integer.toString(getItemCount());
    }

    public Item(int disp, int max) {
        this.itemCount.setValue(disp);
        this.itemMaxCount.setValue(max);
    }

    public final int getItemCount() {
        return this.itemCount.get();
    }

    public final void setItemCount(int value) {
        this.itemCount.set(value);
    }

    public final IntegerProperty itemCountProperty() {
        return this.itemCount;
    }

    public final IntegerProperty itemMaxCountProperty() {
        return this.itemMaxCount;
    }

}
