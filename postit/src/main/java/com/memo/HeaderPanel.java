package com.memo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel(JFrame frame, String title) {
        super(new BorderLayout());
        setBackground(new Color(240, 235, 100));
        setPreferredSize(new Dimension(0, 20));

        var titleLabel = getTitleLabel(title);

        add(titleLabel, BorderLayout.WEST);

        setActionButton();
    }

    private void setActionButton() {
        var closeButton = getCloseButton();

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
        
        add(closeButton, BorderLayout.EAST);
    }

    private JButton getCloseButton() {
        var closeButton = new JButton("x");
        closeButton.setFont(new Font("Georgia", Font.BOLD, 12));
        closeButton.setForeground(Color.DARK_GRAY);
        closeButton.setBackground(new Color(240, 235, 100));
        closeButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
        closeButton.setPreferredSize(new Dimension(20, 20));
        closeButton.setFocusPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return closeButton;
    }

    private JLabel getTitleLabel(String title) {
        var titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 11));
        titleLabel.setForeground(new Color(80, 80, 80));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        return titleLabel;
    }
}