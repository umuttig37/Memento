package com.example.demo;

import javafx.fxml.FXML;

import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RPGController {
    @FXML
    private Rectangle rectangle;

    @FXML
    private CheckBox checkBox;

    private final UndoRedoManager undoRedoManager = new UndoRedoManager();

    @FXML
    public void initialize() {
        saveCurrentState();
    }

    public void onColorChange() {
        rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        saveCurrentState();
    }

    public void onCheckboxToggle() {
        saveCurrentState();
    }

    public void onUndo() {
        Memento prevState = undoRedoManager.undo();
        if (prevState != null) restoreState(prevState);
    }

    public void onRedo() {
        Memento nextState = undoRedoManager.redo();
        if (nextState != null) restoreState(nextState);
    }

    public void showHistory() {
        new HistoryWindow(undoRedoManager).show();
    }

    private void saveCurrentState() {
        Memento memento = new Memento(rectangle.getFill().toString(), checkBox.isSelected());
        undoRedoManager.saveState(memento);
    }

    private void restoreState(Memento memento) {
        rectangle.setFill(Color.web(memento.getColor()));
        checkBox.setSelected(memento.isCheckboxState());
    }
}
