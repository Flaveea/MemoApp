package com.memo.utility;

import java.awt.Color;
import java.util.List;

public final class Colors {

    public static final Color YELLOW = new Color(240, 235, 100);
    public static final Color LIGHT_YELLOW = new Color(255, 255, 150);

    public static final Color GREEN = new Color(120, 200, 120);
    public static final Color LIGHT_GREEN = new Color(200, 255, 200) ;

    public static final Color BLUE = new Color(100, 180, 220);
    public static final Color LIGHT_BLUE = new Color(180, 240, 255) ;

    public static final Color PINK = new Color(220, 100, 150);
    public static final Color LIGHT_PINK = new Color(255, 200, 220)  ;

    public static List<Color[]> getHeaderColor() {
        return List.of(
                new Color[] { YELLOW, LIGHT_YELLOW },
                new Color[] { GREEN, LIGHT_GREEN},
                new Color[] { BLUE, LIGHT_BLUE},
                new Color[] { PINK, LIGHT_PINK });
    }

}