package com.project.demo;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class TextEditorService {
    private String currentText = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public String getText() {
        return currentText;
    }

    public void addText(String newText) {
        undoStack.push(currentText);
        currentText += newText;
        redoStack.clear();
    }

    public void deleteText(int count) {
        if (count > currentText.length()) count = currentText.length();
        undoStack.push(currentText);
        currentText = currentText.substring(0, currentText.length() - count);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
        }
    }

    public void findAndReplace(String target, String replacement) {
        undoStack.push(currentText);
        currentText = findAndReplaceRecursive(currentText, target, replacement);
        redoStack.clear();
    }

    private String findAndReplaceRecursive(String text, String target, String replacement) {
        if (text == null || text.length() < target.length()) {
            return text;
        }

        if (text.startsWith(target)) {
            return replacement + findAndReplaceRecursive(text.substring(target.length()), target, replacement);
        }

        return text.charAt(0) + findAndReplaceRecursive(text.substring(1), target, replacement);
    }
}
