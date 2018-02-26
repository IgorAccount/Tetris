package ru.igor.tests.figures;

import ru.igor.tests.colors.Colors;

import java.awt.*;

import static ru.igor.tests.constants.Constants.*;
import static ru.igor.tests.constants.Constants.LINES;

public class FigureTurnedZ implements Figures{
    int[][] figureStick = new int[LINES][LINES];
    int x = CELLSIZE / 3 - 4;
    int y = -1;
    Color myColor = getColor();

    public FigureTurnedZ() {
        figureStick[0][0] = FIGUREEMPTYCELL;
        figureStick[0][1] = FIGUREEMPTYCELL;
        figureStick[0][2] = FIGUREEMPTYCELL;
        figureStick[0][3] = FIGUREEMPTYCELL;
        figureStick[1][0] = FIGUREEMPTYCELL;
        figureStick[1][1] = FIGUREEMPTYCELL;
        figureStick[1][2] = FIGURECELL;
        figureStick[1][3] = FIGURECELL;
        figureStick[2][0] = FIGUREEMPTYCELL;
        figureStick[2][1] = FIGURECELL;
        figureStick[2][2] = FIGURECELL;
        figureStick[2][3] = FIGUREEMPTYCELL;
        figureStick[3][0] = FIGUREEMPTYCELL;
        figureStick[3][1] = FIGUREEMPTYCELL;
        figureStick[3][2] = FIGUREEMPTYCELL;
        figureStick[3][3] = FIGUREEMPTYCELL;

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int[][] getFigure() {
        return figureStick;
    }

    @Override
    public void goLeft() {
        x--;
    }

    @Override
    public void goRight() {
        x++;
    }

    @Override
    public void goDown() {
        y++;
    }

    @Override
    public void turnArray(){
        System.out.println("TURNED");
        int[][] temp = new int[LINES][LINES];
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < LINES; j++) {
                temp[i][j] = figureStick[LINES - j - 1][i];
            }
        }
        figureStick = temp;
    }

    @Override
    public Color getColor() {
        return Colors.getColor();
    }
}

