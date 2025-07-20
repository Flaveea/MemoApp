package com.memo.headerpostit;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.memo.utility.Constants;

import java.awt.event.*;
import java.awt.*;

public abstract class ButtonFactory{

    public JButton create(String textButton, int sizeButton){

        JButton closeButton = new JButton(textButton);
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