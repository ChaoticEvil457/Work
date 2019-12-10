package Summertech;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Hackathon2 extends JFrame{

	JButton	messages;
	JButton classes;
	JButton	badges;
	JButton	profile;
	JButton	options;
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {
			Hackathon2 frame = new Hackathon2();
			Color col = new Color(100,100,100);
			frame.getContentPane().setBackground(col);
			frame.setVisible(true);
			frame.setBounds(0, 0, 1280, 760);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}




	public Hackathon2(){

		setLayout(null);
		
		classes = new JButton("Enter a class");
		classes.setBounds(300,350,150,200);
		add(classes);
		
		messages = new JButton("Messages");
		messages.setBounds(450,250,150,200);
		add(messages);
		
		profile = new JButton("Edit your profile");
		profile.setBounds(900,350,150,200);
		add(profile);
		
		badges = new JButton("Badges");
		badges.setBounds(750,250,150,200);
		add(badges);
		
		options = new JButton("Options");
		options.setBounds(600,350,150,200);
		add(options);
		
		
	}
}