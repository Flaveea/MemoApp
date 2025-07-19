package com.memo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DraggableFrameHelper {

    private Point mousePosition;
    private boolean dragging = false;

    public DraggableFrameHelper(JFrame frame) {
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePosition = e.getPoint();
                dragging = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });
        
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging && mousePosition != null) {
                    var currentPosition = frame.getLocation();
                    frame.setLocation(
                        currentPosition.x + (e.getX() - mousePosition.x),
                        currentPosition.y + (e.getY() - mousePosition.y)
                    );
                }
            }
        });
    }
}