package com.memo.headerpostit;

import java.awt.Color;
import java.awt.Component;

import com.memo.utility.Colors;

public class AlphaSettings {

    protected void setAlpha(Component headerComponent, Component textAreaComponent, boolean isTransparent) {

        var alpha = isTransparent ? Colors.MIN_ALPHA_VALUE : Colors.MAX_ALPHA_VALUE;
            headerComponent.setBackground(setAlpha(headerComponent.getBackground(), alpha));
            textAreaComponent.setBackground(setAlpha(textAreaComponent.getBackground(), alpha));
    }

    protected Color setAlpha(Color color, int alpha) {

        var red = color.getRed();
        var green = color.getGreen();
        var blue = color.getBlue();

        return new Color(red, green, blue, alpha);

    }
}