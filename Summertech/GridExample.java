package Summertech;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridExample extends JFrame{
	public static void main(String[] args) {
		new GridExample();
	}
	public GridExample(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0,400,500);
		setVisible(true);
		setLayout(new GridLayout(2,3));
		JButton b1 = new JButton("asdf");
		JButton b2 = new JButton("asdf");
		JButton b3 = new JButton("asdf");
		JButton b4 = new JButton("asdf");
		JButton b5 = new JButton("asdf");
		JButton b6 = new JButton("asdf");
		JButton b7 = new JButton("asdf");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		
	}
}
