package ru.igor.tests.game;

import javax.swing.*;
import java.awt.*;

public class TetrisFrame extends JFrame {
    private TetrisPanel tp;
    private JLabel jl;

    TetrisFrame(){
        tp = new TetrisPanel();
        jl = new JLabel("Deleted lines:");
        add(jl, BorderLayout.SOUTH);
        setName("Tetris by Igor");
        setSize(317,655);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        addKeyListener(new TetrisListener(tp));
        add(tp);
        setVisible(true);
    }
}
