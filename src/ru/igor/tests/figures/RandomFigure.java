package ru.igor.tests.figures;

import java.util.Random;

public class RandomFigure {
    static Random r = new Random();

    public static Figures randomFigure() {
        Figures[] randomfigures = new Figures[7];
        randomfigures[0] = new FigureStick();
        randomfigures[1] = new FigureG();
        randomfigures[2] = new FigureSquare();
        randomfigures[3] = new FigureT();
        randomfigures[4] = new FigureZ();
        randomfigures[5] = new FigureTurnedZ();
        randomfigures[6] = new FigureTurnedG();

        int random = r.nextInt(6);
        if (random >= 0 && random <= randomfigures.length) {
            return randomfigures[random];
        } else return randomfigures[0];
    }
}
