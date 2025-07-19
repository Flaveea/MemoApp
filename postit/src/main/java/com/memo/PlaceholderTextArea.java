package com.memo;

import javax.swing.*;
import java.awt.*;

class PlaceholderTextArea extends JTextArea {
    private String placeholder = "";

    public PlaceholderTextArea() {
        super();
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !placeholder.isEmpty() && !hasFocus()) {
            var g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            var fm = g2.getFontMetrics();
            var x = getInsets().left;
            var y = getInsets().top + fm.getAscent();
            g2.drawString(placeholder, x, y);
            g2.dispose();
        }
    }
}