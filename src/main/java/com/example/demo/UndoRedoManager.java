package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndoRedoManager {
    private final Stack<Memento> undoList = new Stack<>();
    private final Stack<Memento> redoList = new Stack<>();

    public void saveState(Memento memento) {
        undoList.push(memento);
        redoList.clear();
    }

    public Memento undo() {
        if (!undoList.isEmpty()) {
            Memento currentState = undoList.pop();
            redoList.push(currentState);
            return !undoList.isEmpty() ? undoList.peek() : null;
        }
        return null;
    }

    public Memento redo() {
        if (!redoList.isEmpty()) {
            Memento redoState = redoList.pop();
            undoList.push(redoState);
            return redoState;
        }
        return null;
    }

    public List<Memento> getHistory() {
        return new ArrayList<>(undoList);
    }
}

