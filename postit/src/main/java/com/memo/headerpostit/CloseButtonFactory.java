package com.memo.headerpostit;

import java.awt.Component;

import javax.swing.*;

import com.memo.NoteManager;
import com.memo.utility.Constants;

public class CloseButtonFactory extends ButtonFactory {

    private final Component textArea;

    protected CloseButtonFactory(Component textArea){
        this.textArea = textArea;
    }

    protected JButton create() {
        return super.create(Constants.CLOSE_BUTTON_STRING, Constants.CLOSE_BUTTON_SIZE);
    }

    @Override
    protected void setAction(JButton closeButton) {
        closeButton.addActionListener(e -> {
                var recoverNote = new NoteManager(textArea);
                recoverNote.save();
            System.exit(0);});
    }
}
