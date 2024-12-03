package com.example.demo;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryWindow {
    private final UndoRedoManager undoRedoManager;

    public HistoryWindow(UndoRedoManager undoRedoManager) {
        this.undoRedoManager = undoRedoManager;
    }

    public void show() {
        Stage historyStage = new Stage();
        ListView<String> historyListView = new ListView<>();


        for (Memento memento : undoRedoManager.getHistory()) {
            historyListView.getItems().add(memento.getTimestamp() + " - " + memento.getDescription());
        }

        VBox layout = new VBox(10, historyListView);
        Scene scene = new Scene(layout, 300, 400);
        historyStage.setScene(scene);
        historyStage.setTitle("History");
        historyStage.show();
    }
}

