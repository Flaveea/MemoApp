package com.memo.headerpostit;

import javax.swing.*;

import com.memo.utility.Constants;

import java.awt.*;
import java.awt.event.*;

public class CloseButtonFactory {

    public static JButton create(JFrame frame) {
        JButton closeButton = new JButton("x");
        closeButton.setFont(new Font(Constants.GEORGIA_FONT, Font.BOLD, 12));
        closeButton.setForeground(Color.DARK_GRAY);
        closeButton.setBackground(new Color(240, 235, 100));
        closeButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
        closeButton.setPreferredSize(new Dimension(20, 20));
        closeButton.setFocusPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        closeButton.addActionListener(e -> System.exit(0));

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(255, 100, 100));
                closeButton.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(new Color(240, 235, 100));
                closeButton.setForeground(Color.DARK_GRAY);
            }
        });

        return closeButton;
    }
}
