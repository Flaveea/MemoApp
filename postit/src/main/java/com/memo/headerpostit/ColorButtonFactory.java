package com.memo.headerpostit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.event.*;

import com.memo.utility.Constants;

public class ColorButtonFactory {

    public static JButton create(Component headerComponent, Component textAreaComponent) {

        var colorButton = new JButton("❑");
        colorButton.setFont(new Font(Constants.GEORGIA_FONT, Font.ITALIC, 12));
        colorButton.setForeground(Color.DARK_GRAY);
        colorButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));
        colorButton.setPreferredSize(new Dimension(20, 20));
        colorButton.setFocusPainted(false);
        colorButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        var colorMenu = ColorMenu.colorMenu(headerComponent, textAreaComponent);

        colorButton.addActionListener(e -> colorMenu.show(colorButton, 0, colorButton.getHeight()));
        
        colorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colorButton.setBackground(new Color(255, 100, 100));
                colorButton.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                colorButton.setBackground(new Color(240, 235, 100));
                colorButton.setForeground(Color.DARK_GRAY);
            }
        });

        return colorButton;
    }

}