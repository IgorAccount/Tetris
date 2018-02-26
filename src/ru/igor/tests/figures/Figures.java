package ru.igor.tests.figures;

import java.awt.*;

public interface Figures {
    int[][] getFigure();
    int getX();
    int getY();
    void goLeft();
    void goRight();
    void goDown();
    void turnArray();
    Color getColor();
}
