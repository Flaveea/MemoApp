package com.memo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResizableFrameHelper {
    private static final int BORDER = 6;
    private JFrame frame;
    private int resizeDir = Cursor.DEFAULT_CURSOR;
    private Point clickPoint;
    private Dimension clickSize;

    public ResizableFrameHelper(JFrame frame) {
        this.frame = frame;

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                resizeDir = getCursor(e);
                clickPoint = e.getLocationOnScreen();
                clickSize = frame.getSize();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                resizeDir = Cursor.DEFAULT_CURSOR;
            }
        });

        frame.addMouseMotionListener(getMouseMotionAdapter(frame));
    }

    private MouseMotionAdapter getMouseMotionAdapter(JFrame frame) {
        return new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                frame.setCursor(Cursor.getPredefinedCursor(getCursor(e)));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (resizeDir == Cursor.DEFAULT_CURSOR)
                    return;

                var dragPoint = e.getLocationOnScreen();
                var dx = dragPoint.x - clickPoint.x;
                var dy = dragPoint.y - clickPoint.y;

                var newWidth = Math.max(50, clickSize.width + dx);
                var newHeight = Math.max(50, clickSize.height + dy);

                switch (resizeDir) {
                    case Cursor.SE_RESIZE_CURSOR -> frame.setSize(newWidth, newHeight);
                    case Cursor.S_RESIZE_CURSOR -> frame.setSize(clickSize.width, newHeight);
                    case Cursor.E_RESIZE_CURSOR -> frame.setSize(newWidth, clickSize.height);
                }
            }
        };
    }

    private int getCursor(MouseEvent e) {
        int w = frame.getWidth();
        int h = frame.getHeight();
        int x = e.getX();
        int y = e.getY();

        if (x >= w - BORDER && y >= h - BORDER)
            return Cursor.SE_RESIZE_CURSOR;
        if (y >= h - BORDER)
            return Cursor.S_RESIZE_CURSOR;
        if (x >= w - BORDER)
            return Cursor.E_RESIZE_CURSOR;
        return Cursor.DEFAULT_CURSOR;
    }
}
