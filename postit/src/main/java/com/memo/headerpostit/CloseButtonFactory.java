package com.memo.headerpostit;

import javax.swing.*;

import com.memo.utility.Constants;

import java.awt.*;
import java.awt.event.*;

public class CloseButtonFactory {

    private static final int sizeButton = 15;

    public static JButton create() {
        JButton closeButton = new JButton(Constants.CLOSE_BUTTON_STRING);
        closeButton.setFont(new Font(Constants.GEORGIA_FONT, Font.BOLD, sizeButton));
        closeButton.setForeground(Color.DARK_GRAY);
        closeButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
        closeButton.setPreferredSize(new Dimension(20, 20));
        closeButton.setFocusPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setAction(closeButton);

        setMouseEffect(closeButton);

        return closeButton;
    }

    private static void setAction(JButton closeButton) {
        closeButton.addActionListener(e -> System.exit(0));
    }

    private static void setMouseEffect(JButton closeButton) {
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setForeground(Color.DARK_GRAY);
            }
        });
    }
}
