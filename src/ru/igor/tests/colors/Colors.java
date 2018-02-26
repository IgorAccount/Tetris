package ru.igor.tests.colors;

import java.awt.*;
import java.util.Random;

public class Colors {
    static Random r = new Random();

    public static Color getColor(){
        Color[] array = new Color[4];
        array[0] = new Color(190,0,70,230);
        array[1] = new Color(140,100,130,250);
        array[2] = new Color(80,200,070,250);
        array[3] = new Color(0,60,90,250);
        int random = r.nextInt(4);
        if (random >= 0 && random <= array.length) {
            return array[random];
        } else return array[0];
    }

    }

