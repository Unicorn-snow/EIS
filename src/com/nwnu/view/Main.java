package com.nwnu.view;

import java.awt.EventQueue;


import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->
		{
			Login frame = new Login();
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

