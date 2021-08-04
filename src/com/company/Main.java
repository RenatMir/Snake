package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	JFrame frame = new JFrame("Tic-Tac-Toe");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.add(new Panel());
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);

    }
}
