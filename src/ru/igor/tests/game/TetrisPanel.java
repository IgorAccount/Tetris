package ru.igor.tests.game;

import ru.igor.tests.figures.Figures;
import ru.igor.tests.figures.RandomFigure;

import javax.swing.*;
import java.awt.*;

import static ru.igor.tests.constants.Constants.*;

public class TetrisPanel extends JPanel implements Runnable {
    Figures currentFigure;
    private int width = 10;
    private int heigth = 20;
    private int[][] gameField = new int[heigth][width];
    boolean stopGame = false;

    TetrisPanel() {
        setSize(width * CELLSIZE, heigth * CELLSIZE);
        setBackground(Color.GRAY);
        Thread th = new Thread(this);
        init();
        th.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (int i = 1; i < width; i++) {
            g.drawLine(i * CELLSIZE, 0, i * CELLSIZE, CELLSIZE * heigth - 1);
        }
        for (int j = 1; j < heigth; j++) {
            g.drawLine(0, j * CELLSIZE, CELLSIZE * width - 1, j * CELLSIZE);
        }

        g.setColor(currentFigure.getColor());
        int cfg[][] = currentFigure.getFigure();
        for (int i = 0; i < cfg.length; i++) {
            for (int j = 0; j < cfg[i].length; j++) {
                if (cfg[i][j] == FIGURECELL) {
                    g.fillRect((currentFigure.getX() + j) * CELLSIZE, (currentFigure.getY() + i) * CELLSIZE, CELLSIZE, CELLSIZE);
                }
            }
        }

        g.setColor(Color.RED);
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == FIGURECELL) {
                    g.fillRect(j * CELLSIZE, i * CELLSIZE, CELLSIZE, CELLSIZE);
                }
            }
        }

    }

    void addRandomFigure() {
        if (currentFigure == null) {
            currentFigure = RandomFigure.randomFigure();
        }
    }

    void leaveFigure() {
        int x = currentFigure.getX();
        int y = currentFigure.getY();

        int currentArray[][] = currentFigure.getFigure();
        System.out.println("currentFigure.getX(); " + currentFigure.getX());
        System.out.println("currentFigure.getY(); " + currentFigure.getY());


        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                if (currentArray[i][j] == FIGURECELL) {
                    gameField[y + i][x + j] = FIGURECELL;
                    currentFigure = null;
                    addRandomFigure();
                }
            }
        }
    }

    int defineNumberOfFreeCells() {
        int[][] tempArray = currentFigure.getFigure();
        int yCells = 0;

        int returnCellsY = 0;
        int returnCellsX = 0;


        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                int xCells = 0;
                if (tempArray[i][j] == FIGUREEMPTYCELL) {
                    xCells++;
                }
                if (xCells == 3) returnCellsX++;
            }
        }

        return returnCellsY;
    }

    void checkedFilledLines() {
        for (int i = 0; i < gameField.length; i++) {
            int filledCells = 0;
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == FIGURECELL) filledCells++;
                if (filledCells == gameField[i].length) {
                    for (int k = 0; k < gameField[i].length; k++) {
                        gameField[i][k] = FIGUREEMPTYCELL;
                    }
                }
            }
        }
    }

    void init() {
        currentFigure = RandomFigure.randomFigure();
    }

    boolean canMove(int addNumberX, int addNumberY) {
        int[][] tempArray = currentFigure.getFigure();
        int x = currentFigure.getX() + addNumberX;
        int y = currentFigure.getY() + addNumberY;

        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                if (tempArray[i][j] == FIGURECELL) {
                    if (x + j < 0 || j + x >= gameField[i].length || y + i < -2 || y + i >= gameField.length)
                        return false;

                    if (gameField[y + i][x + j] == 1) return false;
                }
            }
        }

        return true;
    }

    void goFigureDown() {
        currentFigure.goDown();
    }

    @Override
    public void run() {
        int u = 0;
        while (u < 200) {
            try {
                Thread.sleep(300);
                if (canMove(0, 1)) {
                    goFigureDown();
                } else {
                    leaveFigure();
                }
                checkedFilledLines();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            u++;
        }
    }
}
