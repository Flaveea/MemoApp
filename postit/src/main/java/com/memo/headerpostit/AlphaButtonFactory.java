package com.memo.headerpostit;

import java.awt.Component;

import javax.swing.JButton;

import com.memo.utility.Constants;

public class AlphaButtonFactory extends ButtonFactory {

    private final Component headerComponent;
    private final Component textAreaComponent;
    private final AlphaStatus transparencyState;

    protected AlphaButtonFactory(Component headerComponent, Component textAreaComponent, AlphaStatus transparencyState) {
        this.headerComponent = headerComponent;
        this.textAreaComponent = textAreaComponent;
        this.transparencyState = transparencyState;
    }

    protected JButton create() {
        return super.create(Constants.ALPHA_BUTTON_STRING, Constants.ALPHA_BUTTON_SIZE);
    }

    @Override
    protected void setAction(JButton alphaButton) {
        var settings = new AlphaSettings();
        alphaButton.addActionListener(e -> {
            transparencyState.toggle();
            settings.setAlpha(headerComponent, textAreaComponent, transparencyState.isTransparent());
        });
    }

}