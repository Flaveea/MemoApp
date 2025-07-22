package com.memo;

import java.awt.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.memo.utility.Constants;

public class NoteManager {

    private final Component textArea;
    private final Path notePath;


    public NoteManager(Component textArea) {
        this.textArea = textArea;
        this.notePath = Paths.get(System.getProperty("user.home"), ".postit", "note.txt");
        try {
            Files.createDirectories(notePath.getParent());
        } catch (Exception e) {
            System.err.println("Errore nella creazione della cartella: " + e.getMessage());
        }
    }

    public void setContent() {
        if (Files.exists(notePath)) {
            String content;
            try {
                content = Files.readString(notePath);
            } catch (IOException e) {
                content = Constants.ERROR_RECOVER_NOTE_STRING;
                e.printStackTrace();
                System.err.println(Constants.ERROR_READ_FILE + e.getMessage());

            }
            ((PlaceholderTextArea) textArea).setText(content);
        }
        else {
            var welcomeText = Constants.WELCOME_TEX_STRING;
            ((PlaceholderTextArea) textArea).setText(welcomeText);
        }
    }

    public void save() {
        try {
            Files.writeString(notePath, ((PlaceholderTextArea) textArea).getText());
        } catch (Exception e) {
            System.err.println(Constants.ERROR_SAVE_FILE + e.getMessage());
        }
    }
}