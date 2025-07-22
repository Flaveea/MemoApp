package com.memo;

import java.awt.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.memo.utility.Constants;

public class NoteManager {

    private final Component textArea;
    private final Path filePath = Paths.get(Constants.NOTE_FILE_NAME);


    public NoteManager(Component textArea) {
        this.textArea = textArea;
    }

    public void setContent() {
        if (Files.exists(filePath)) {
            String content;
            try {
                content = Files.readString(filePath);
            } catch (IOException e) {
                content = Constants.ERROR_RECOVER_NOTE_STRING;
                e.printStackTrace();
                System.err.println("Errore nel leggere il file: " + e.getMessage());

            }
            ((PlaceholderTextArea) textArea).setText(content);
        }
    }

    public void save() {
        try {
            Files.writeString(filePath, ((PlaceholderTextArea) textArea).getText());
        } catch (Exception e) {
            System.err.println("Errore nel salvare il file: " + e.getMessage());
        }
    }
}