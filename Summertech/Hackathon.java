package Summertech;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Hackathon extends JFrame{
	JTextArea chatbox;
	JTextArea chat;
	JTextArea notes;
	JTextField questionbox;
	JTextField screen;
	JButton askbutton;
	JButton	menu;
	JButton send;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Hackathon frame = new Hackathon();
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




	public Hackathon(){

		setLayout(null);

		chatbox = new JTextArea();
		chatbox.setLineWrap(true);
		chatbox.setBounds(1000,450,200,200);
		add(chatbox);
		
		chatbox.setText("Communicate with your peers in this box and the one above!");
		
		notes = new JTextArea();
		notes.setLineWrap(true);
		notes.setBounds(20,580,700,100);
		add(notes);
		
		notes.setText("Type notes here!");
		
		
		questionbox = new JTextField(5);
		questionbox.setBounds(20,550,300,20);
		add(questionbox);
		
		questionbox.setText("Ask questions in a private message to the teacher!");
		
		screen = new JTextField(5);
		screen.setBounds(10,10,850,470);
		add(screen);
		
		screen.setText("The teacher's webcam will show their face here!");
		
		chat = new JTextArea();
		chat.setLineWrap(true);
		chat.setBounds(1000,10,200,400);
		add(chat);
		
		menu = new JButton("Menu");
		menu.setBounds(20,690,110,20);
		add(menu);
		
		askbutton = new JButton("Ask Queston");
		askbutton.setBounds(20,520,110,20);
		add(askbutton);
		
		send = new JButton("Send");
		send.setBounds(1045,650,110,20);
		add(send);
		
		
	}
}