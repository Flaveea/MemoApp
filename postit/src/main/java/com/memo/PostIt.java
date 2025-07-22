package com.memo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.memo.headerpostit.HeaderPanel;
import com.memo.utility.Constants;

import java.awt.*;

public class PostIt extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
                new PostIt().setVisible(true);
        });
    }

    private PostIt() {
        setFrameProperties();
        var textArea = getTextArea();

        add(new HeaderPanel(this, Constants.TITLE, textArea), BorderLayout.NORTH);

        var scrollPane = getScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        new DraggableFrameHelper(this);
        new ResizableFrameHelper(this);
    }

    private void setFrameProperties() {
        setTitle(Constants.TITLE);
        setSize(300, 200);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private JScrollPane getScrollPane(PlaceholderTextArea textArea) {
        var scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private PlaceholderTextArea getTextArea() {
        var textArea = new PlaceholderTextArea();
        var noteManager = new NoteManager(textArea);
        noteManager.setContent();
        textArea.setFont(new Font(Constants.GEORGIA_FONT, Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        textArea.setBackground(new Color(255, 251, 155));
        textArea.setPlaceholder(Constants.PLACEHOLDER_POSTIT);
        return textArea;
    }
}