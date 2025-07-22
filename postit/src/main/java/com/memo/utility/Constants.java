package com.memo.utility;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class Constants {

    public static final int EXIT_STATUS = 0;

    public static final String GEORGIA_FONT = "Georgia";
    public static final String TITLE = "Memo";
    public static final String PLACEHOLDER_POSTIT = "Scrivi qui i tuoi appunti...";
    public static final String CLOSE_BUTTON_STRING = "×";
    public static final String COLOR_BUTTON_STRING = "⬔";
    public static final String ALPHA_BUTTON_STRING = "❂";

    public static final int COLOR_BUTTON_SIZE = 12;
    public static final int CLOSE_BUTTON_SIZE = 15;
    public static final int ALPHA_BUTTON_SIZE = 10;

    public static final Border BORDER_LABEL = BorderFactory.createEmptyBorder(0, 8, 0, 0);
    public static final Border BORDER_BUTTON = BorderFactory.createEmptyBorder(0, 0, 0, 3);

    public static final Dimension SIZE_HEADER = new Dimension(0, 20);
    public static final int TITLE_LABEL_SIZE = 11;
}
