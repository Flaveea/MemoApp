package com.memo.headerpostit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

import com.memo.utility.Constants;

import java.awt.event.*;
import java.awt.*;

public abstract class ButtonFactory {

    protected JButton create(String textButton, int sizeButton) {

        JButton button = new JButton(textButton);
        button.setUI(new BasicButtonUI());
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.setFont(new Font(Constants.GEORGIA_FONT, Font.BOLD, sizeButton));
        button.setForeground(Color.DARK_GRAY);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
        button.setPreferredSize(new Dimension(20, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setAction(button);

        setMouseEffect(button);

        return button;

    }

    protected void setMouseEffect(JButton closeButton) {
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

    protected abstract void setAction(JButton closeButton);
}