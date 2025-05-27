package com.project.demo.Controller;
// TextEditorController.java
import com.project.demo.TextEditorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editor")
public class TextEditorController {

    @Autowired
    private TextEditorService service;

    @GetMapping("/text")
    public String getText() {
        return service.getText();
    }

    @PostMapping("/add")
    public void addText(@RequestParam String newText) {
        service.addText(newText);
    }

    @PostMapping("/delete")
    public void deleteText(@RequestParam int count) {
        service.deleteText(count);
    }

    @PostMapping("/undo")
    public void undo() {
        service.undo();
    }

    @PostMapping("/redo")
    public void redo() {
        service.redo();
    }

    @PostMapping("/findReplace")
    public void findReplace(@RequestParam String find, @RequestParam String replace) {
        service.findAndReplace(find, replace);
    }
}
