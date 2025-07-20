package com.memo.headerpostit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.memo.utility.Colors;

public class ColorMenu {
    protected static JPopupMenu colorMenu(Component headerComponent, Component textAreaComponent) {
        var menu = new JPopupMenu();
        menu.setBorder(BorderFactory.createEmptyBorder());
        var colorList = Colors.getHeaderColor();

        for (Color[] colors : colorList) {
            var item = new JMenuItem();
            item.setBackground(colors[0]);
            item.setOpaque(true);
            item.setPreferredSize(new Dimension(20, 20));

            item.addActionListener(e -> {
                headerComponent.setBackground(colors[0]);
                textAreaComponent.setBackground(colors[1]);
            });

            menu.add(item);
        }

        return menu;
    }

}
