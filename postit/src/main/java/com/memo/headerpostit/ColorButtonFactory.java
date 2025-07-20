package com.memo.headerpostit;

import java.awt.Component;
import javax.swing.JButton;

import com.memo.utility.Constants;

public class ColorButtonFactory extends ButtonFactory {

    private final Component headerComponent;
    private final Component textAreaComponent;
    private final AlphaStatus transparencyState;


    protected ColorButtonFactory(Component headerComponent, Component textAreaComponent, AlphaStatus transparencyState) {
        this.headerComponent = headerComponent;
        this.textAreaComponent = textAreaComponent;
        this.transparencyState = transparencyState;

    }

    protected JButton create() {
        return super.create(Constants.COLOR_BUTTON_STRING, Constants.COLOR_BUTTON_SIZE);
    }

    @Override
    protected void setAction(JButton colorButton) {
        var colorMenu = ColorMenu.colorMenu(headerComponent, textAreaComponent, transparencyState);

        colorButton.addActionListener(e -> colorMenu.show(colorButton, 0, colorButton.getHeight()));
    }

}