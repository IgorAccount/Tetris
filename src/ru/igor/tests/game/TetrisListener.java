package ru.igor.tests.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class TetrisListener implements KeyListener {
    TetrisPanel tp;
    int pressed;


    TetrisListener(TetrisPanel tp) {
        this.tp = tp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed = e.getKeyCode();
        switch (pressed) {
            case VK_UP:
                //System.out.println("VK_UP");
                if(tp.canMove(1,1)){
                    tp.currentFigure.turnArray();}
                else if (tp.canMove(-1,0)){
                    tp.currentFigure.turnArray();
                }else System.out.println("NOTHING IN TURN LEFT");
                break;
//            case VK_DOWN:
//                //System.out.println("VK_DOWN");
//                break;
            case VK_LEFT:
                //System.out.println("VK_LEFT");
                if(tp.canMove(-1,0)) {
                    tp.currentFigure.goLeft();
                } else System.out.println("Nothing happens goLeft()");
                break;
            case VK_RIGHT:
                //System.out.println("VK_RIGHT");
                if(tp.canMove(+1,0)) {
                    tp.currentFigure.goRight();
                }else System.out.println("Nothing happens turnRight()");
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
