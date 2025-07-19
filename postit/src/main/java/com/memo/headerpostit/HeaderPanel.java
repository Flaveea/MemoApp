package com.memo.headerpostit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import com.memo.utility.Constants;


public class HeaderPanel extends JPanel {

    public HeaderPanel(JFrame frame, String title) {
        super(new BorderLayout());
        setBackground(new Color(240, 235, 100));
        setPreferredSize(new Dimension(0, 20));

        var titleLabel = getTitleLabel(title);

        add(titleLabel, BorderLayout.WEST);

        var closeButton = CloseButtonFactory.create(frame);
        add(closeButton, BorderLayout.EAST);
        ;
    }

    private JLabel getTitleLabel(String title) {
        var titleLabel = new JLabel(title);
        titleLabel.setFont(new Font(Constants.GEORGIA_FONT, Font.BOLD, 11));
        titleLabel.setForeground(new Color(80, 80, 80));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        return titleLabel;
    }
}