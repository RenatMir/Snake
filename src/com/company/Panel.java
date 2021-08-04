package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    private final int WIDTH = 482;
    private final int HEIGHT = 482;
    private boolean pl1_chance;
    private int countWin;


    JButton[] button = new JButton[9];
    Panel(){
        new JPanel();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setFocusable(true);
        this.setLayout(new GridLayout(3,3));


        for(int i = 0; i < 9; i++){
            button[i] = new JButton();
            this.add(button[i]);
            button[i].addActionListener(this);
            button[i].setFocusable(false);
            button[i].setFont(new Font("Ink Free", Font.BOLD, 75));
        }
        startGame();
    }
    public void startGame(){
        Random random = new Random();
        int chance = random.nextInt(10);
        pl1_chance = chance % 2 == 0;
    }
    public void checkWin(String turn){
        checkRowCol(turn);
        checkDiagonal(turn);

    }

    public void checkRowCol(String turn) {

        for (int i = 0; i < 3; i++) {
            countWin = 0;
            for (int j = 0; j < 3; j++) {
                if (button[j + i * 3].getText() == turn) {
                    countWin++;
                    if (countWin == 3) {
                        setGameStop(turn);
                    }
                }
            }
            countWin = 0;
            for (int j = 0; j < 9; j+=3) {
                if (button[i + j].getText().equals(turn)) {
                    countWin++;
                    if (countWin == 3) {
                        setGameStop(turn);
                    }
                }
            }

        }
    }

    public void checkDiagonal(String turn) {
        countWin = 0;
        for (int i = 0; i < 9; i += 4) {
            if(button[i].getText().equals(turn)){
                countWin++;
                if (countWin == 3) {
                    setGameStop(turn);
                }
            }
        }
        countWin = 0;
        for (int i = 2; i < 9; i += 2) {
            if(button[i].getText().equals(turn)){
                countWin++;
                if (countWin == 3) {
                    setGameStop(turn);
                }
            }
        }
    }

    public void setGameStop(String turn){
        for (int i = 0; i < 9; i++){
            button[i].setEnabled(false);
        }
        int choice = JOptionPane.showOptionDialog(
                null,
                turn + " WIN. One more time?",
                "Tic-Tac-Toe",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                0);

        if (choice == 1)
            System.exit(0);
        else{
            for(int i = 0; i < 9; i++){
                button[i].setText("");
                button[i].setEnabled(true);
                startGame();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (pl1_chance) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText("X");
                        pl1_chance = false;
                        checkWin(button[i].getText());

                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText("O");
                        pl1_chance = true;
                        checkWin(button[i].getText());
                    }
                }
            }
        }
    }
}
