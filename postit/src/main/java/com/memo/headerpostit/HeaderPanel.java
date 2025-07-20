package com.memo.headerpostit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import com.memo.utility.Colors;
import com.memo.utility.Constants;

public class HeaderPanel extends JPanel {

    public HeaderPanel(JFrame frame, String title, Component textArea) {
        super(new BorderLayout());
        setBackground(Colors.YELLOW);
        setPreferredSize(new Dimension(0, 20));

        var titleLabel = getTitleLabel(title);
        add(titleLabel, BorderLayout.WEST);

        var buttonPanel = getButtonPanel(frame, textArea);
        add(buttonPanel, BorderLayout.EAST);
    }

    private JPanel getButtonPanel(JFrame frame, Component textArea) {
        var closeButton = new CloseButtonFactory().create(); // fixme
        var colorButton = new ColorButtonFactory(this, textArea).create();

        var buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(colorButton);
        buttonPanel.add(closeButton);
        return buttonPanel;
    }

    private JLabel getTitleLabel(String title) {
        var titleLabel = new JLabel(title);
        titleLabel.setFont(new Font(Constants.GEORGIA_FONT, Font.BOLD, 11));
        titleLabel.setForeground(new Color(80, 80, 80));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        return titleLabel;
    }
}