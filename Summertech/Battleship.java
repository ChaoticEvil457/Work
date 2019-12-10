package Summertech;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Battleship extends JFrame implements ActionListener{

	int winp1=0;
	int winp2=0;
	int winp3=0;
	//	boolean turn=false;
	//String Scanner = (JOptionPane.showInputDialog("1 or 2 players"));

	JPanel contentPane;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Battleship();
	}
	public String[][] ships=new String[10][10];

	public String[][] ships2=new String[10][10];

	public String[][] ships3=new String[10][10];

	public JButton[][] board=new JButton[10][10];

	public JButton[][] board2=new JButton[10][10];

	public JButton[][] board3=new JButton[10][10];

	public Battleship(){
		//	if(!Scanner.equalsIgnoreCase("1")&&!Scanner.equalsIgnoreCase("2")){
		//		Scanner = (JOptionPane.showInputDialog("Please input either 1 or 2"));
		//	}
		contentPane=new JPanel();
		setVisible(true);
		setBounds(0,0,1920,1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setLayout(new GridLayout(10,10));

		for(int q=0; q<10; q++){
			for(int w=0; w<10; w++){
				board[q][w]=new JButton();
				board[q][w].setBackground(Color.BLUE.darker().darker());
				contentPane.add(board[q][w]);
				board[q][w].addActionListener(this);
				ships[q][w]="";

			}
		}
		//		if(Scanner.equals("2")){
		//			for(int q=0; q<10; q++){
		//				for(int w=0; w<10; w++){
		//					board3[q][w]=new JButton();
		//					board3[q][w].setBackground(Color.BLUE.darker().darker());
		//					contentPane.add(board3[q][w]);
		//					board3[q][w].addActionListener(this);
		//					ships3[q][w]="";

		//				}
		//			}
		//		}

		//		if(Scanner.equals("2")){
		for(int q=0; q<10; q++){
			for(int w=0; w<10; w++){
				ships2[q][w]="";
				board2[q][w]=new JButton();
			}
		}
		//		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//TODO Auto-generated method stub

		int s5y = Integer.parseInt(JOptionPane.showInputDialog("Intput your 5 length ship's x coordinates 0-4 Player 1"));
		int s5x = Integer.parseInt(JOptionPane.showInputDialog("Intput your 5 length ship's y coordinates 0-4 Player 1"));
		String s5d = (JOptionPane.showInputDialog("Intput your 5 length ship's direction (please enter up or left) Player 1"));

		while(s5y>4||s5x>4||!s5d.equals("up")&&!s5d.equals("left")||s5y<0||s5x<0){
			System.out.println(s5y);
			System.out.println(s5x);
			System.out.println(s5d);
			s5y = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 5 length ship's x coordinates 0-4 Player 1"));
			s5x = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 5 length ship's y coordinates 0-4 Player 1"));
			s5d = (JOptionPane.showInputDialog("Stop fooling around. Intput your 5 length ship's direction (please enter up or left) Player 1"));

		}

		while((ships[s5x][s5y]==" O"||ships[s5x][s5y+1]==" O"||ships[s5x][s5y+2]==" O"||ships[s5x][s5y+3]==" O"||ships[s5x][s5y+4]==" O")){

			s5y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's x coordinates 0-4 Player 1"));
			s5x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's y coordinates 0-4"));
		}
		while((ships[s5x][s5y]==" O"||ships[s5x+1][s5y]==" O"||ships[s5x+2][s5y]==" O"||ships[s5x+3][s5y]==" O"||ships[s5x+4][s5y ]==" O Player 1")){

			s5y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's x coordinates 0-4 Player 1"));
			s5x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's y coordinates 0-4 Player 1"));
		}

		if((ships[s5x][s5y]!=" O"&& ships[s5x][s5y+1]!=" O"&& ships[s5x][s5y+2]!=" O"&& ships[s5x][s5y+3]!=" O"&& ships[s5x][s5y+4]!=" O")){

			if(s5d.equals("left")){
				ships[s5x][s5y]=" O";
				ships[s5x][s5y+1]=" O";
				ships[s5x][s5y+2]=" O";
				ships[s5x][s5y+3]=" O";
				ships[s5x][s5y+4]=" O";
			}
			else if(s5d.equals("up")){
				ships[s5x][s5y]=" O";
				ships[s5x+1][s5y]=" O";
				ships[s5x+2][s5y]=" O";
				ships[s5x+3][s5y]=" O";
				ships[s5x+4][s5y]=" O";
			}
		}

		int s4y = Integer.parseInt(JOptionPane.showInputDialog("Intput your 4 length ship's x coordinates 0-5 Player 1"));
		int s4x = Integer.parseInt(JOptionPane.showInputDialog("Intput your 4 length ship's y coordinates 0-5 Player 1"));
		String s4d = (JOptionPane.showInputDialog("Intput your 4 length ship's direction (please enter up or left) Player 1"));

		while(s4y>5||s4x>5||!s4d.equals("up")&&!s4d.equals("left")||s4y<0||s4x<0){

			s4y = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's x coordinates 0-5 Player 1"));
			s4x = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's y coordinates 0-5 Player 1"));
			s4d = (JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's direction (please enter up or left) Player 1"));

		}

		while((ships[s4x][s4y]==" O"||ships[s4x][s4y+1]==" O"||ships[s4x][s4y+2]==" O"||ships[s4x][s4y+3]==" O")){

			s4y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's x coordinates 0-5 Player 1"));
			s4x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's y coordinates 0-5 Player 1"));
		}
		while((ships[s4x][s4y]==" O"||ships[s4x+1][s4y]==" O"||ships[s4x+2][s4y]==" O"||ships[s4x+3][s4y]==" O")){

			s4y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's x coordinates 0-5 Player 1"));
			s4x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's y coordinates 0-5 Player 1"));
		}

		if((ships[s4x][s4y]!=" O"&& ships[s4x][s4y+1]!=" O"&& ships[s4x][s4y+2]!=" O"&& ships[s4x][s4y+3]!=" O")){

			if(s4d.equals("left")){
				ships[s4x][s4y]=" O";
				ships[s4x][s4y+1]=" O";
				ships[s4x][s4y+2]=" O";
				ships[s4x][s4y+3]=" O";
			}
			else if(s4d.equals("up")){
				ships[s4x][s4y]=" O";
				ships[s4x+1][s4y]=" O";
				ships[s4x+2][s4y]=" O"; 
				ships[s4x+3][s4y]=" O";
			}
		}

		int s3y = Integer.parseInt(JOptionPane.showInputDialog("Intput your 3 length ship's x coordinates 0-6 Player 1"));
		int s3x = Integer.parseInt(JOptionPane.showInputDialog("Intput your 3 length ship's y coordinates 0-6 Player 1"));
		String s3d = (JOptionPane.showInputDialog("Intput your 3 length ship's direction (please enter up or left)"));

		while(s3y>6||s3x>6||!s3d.equals("up")&&!s3d.equals("left")||s3y<0||s3x<0){

			s3y = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's x coordinates 0-6 Player 1"));
			s3x = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's y coordinates 0-6 Player 1"));
			s3d = (JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's direction (please enter up or left)"));

		}

		while((ships[s3x][s3y]==" O"||ships[s3x][s3y+1]==" O"||ships[s3x][s3y+2]==" O")){

			s3y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's x coordinates 0-6 Player 1"));
			s3x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's y coordinates 0-6 Player 1"));
		}
		while((ships[s3x][s3y]==" O"||ships[s3x+1][s3y]==" O"||ships[s3x+2][s3y]==" O")){

			s3y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's x coordinates 0-6 Player 1"));
			s3x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's y coordinates 0-6 Player 1"));
		}

		if((ships[s3x][s3y]!=" O"&& ships[s3x][s3y+1]!=" O"&& ships[s3x][s3y+2]!=" O")){
			if(s3d.equals("left")){
				ships[s3x][s3y]=" O";
				ships[s3x][s3y+1]=" O";
				ships[s3x][s3y+2]=" O";
			}
			else if(s3d.equals("up")){
				ships[s3x][s3y]=" O";
				ships[s3x+1][s3y]=" O";
				ships[s3x+2][s3y]=" O";
			}
		}

		int s3y_ = Integer.parseInt(JOptionPane.showInputDialog("Intput your other 3 length ship's x coordinates 0-6 Player 1"));
		int s3x_ = Integer.parseInt(JOptionPane.showInputDialog("Intput your other 3 length ship's y coordinates 0-6 Player 1"));
		String s3d_ = (JOptionPane.showInputDialog("Intput your other 3 length ship's direction (please enter up or left)"));

		while(s3y_>6||s3x_>6||!s3d_.equals("up")&&!s3d_.equals("left")||s3y_<0||s3x_<0){

			s3y_ = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your other 3 length ship's x coordinates 0-6 Player 1"));
			s3x_ = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your other 3 length ship's y coordinates 0-6 Player 1"));
			s3d_ = (JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's direction (please enter up or left)"));

		}

		while((ships[s3x_][s3y_]==" O"||ships[s3x_][s3y_+1]==" O"||ships[s3x_][s3y_+2]==" O")){

			s3y_ = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's x coordinates 0-6 Player 1"));
			s3x_ = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's y coordinates 0-6 Player 1"));
		}
		while((ships[s3x_][s3y_]==" O"||ships[s3x_+1][s3y_]==" O"||ships[s3x_+2][s3y_]==" O")){

			s3y_ = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's x coordinates 0-6 Player 1"));
			s3x_ = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's y coordinates 0-6 Player 1"));
		}

		if((ships[s3x_][s3y_]!=" O"&& ships[s3x_][s3y_+1]!=" O"&& ships[s3x_][s3y_+2]!=" O")){
			if(s3d_.equals("left")){
				ships[s3x_][s3y_]=" O";
				ships[s3x_][s3y_+1]=" O";
				ships[s3x_][s3y_+2]=" O";
			}
			else if(s3d_.equals("up")){
				ships[s3x_][s3y_]=" O";
				ships[s3x_+1][s3y_]=" O";
				ships[s3x_+2][s3y_]=" O";
			}
		}

		int s2y = Integer.parseInt(JOptionPane.showInputDialog("Intput your 2 length ship's x coordinates 0-7 Player 1"));
		int s2x = Integer.parseInt(JOptionPane.showInputDialog("Intput your 2 length ship's y coordinates 0-7 Player 1"));
		String s2d = (JOptionPane.showInputDialog("Intput your 2 length ship's direction (please enter up or left)"));

		while(s2y>7||s2x>7||!s2d.equals("up")&&!s2d.equals("left")||s2y<0||s2x<0){

			s2y = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 2 length ship's x coordinates 0-7 Player 1"));
			s2x = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 2 length ship's y coordinates 0-7 Player 1"));
			s2d = (JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's direction (please enter up or left)"));

		}

		while((ships[s2x][s2y]==" O"||ships[s2x][s2y+1]==" O")){

			s2y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's x coordinates 0-7 Player 1"));
			s2x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's y coordinates 0-7 Player 1"));
		}
		while((ships[s2x][s2y]==" O"||ships[s2x+1][s2y]==" O")){

			s2y = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's x coordinates 0-7 Player 1"));
			s2x = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's y coordinates 0-7 Player 1"));
		}

		if((ships[s2x][s2y]!=" O"&& ships[s2x][s2y+1]!=" O")){
			if(s2d.equals("left")){
				ships[s2x][s2y]=" O";
				ships[s2x][s2y+1]=" O";
			}
			else if(s2d.equals("up")){
				ships[s2x][s2y]=" O";
				ships[s2x+1][s2y]=" O";
			}
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//TODO Auto-generated method stub
		/*
		if(Scanner.equals("2")){

			for(int q=0; q<10; q++){
				for(int w=0; w<10; w++){
					ships3[q][w]="";
					board3[q][w]=new JButton();
				}
			}

			int s5y2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 5 length ship's x coordinates 0-4 Player 2"));
			int s5x2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 5 length ship's y coordinates 0-4 Player 2"));
			String s5d2 = (JOptionPane.showInputDialog("Intput your 5 length ship's direction (please enter up or left)"));

			while(s5y2>4||s5x2>4||!s5d2.equals("up")&&!s5d2.equals("left")||s5y2<0||s5x2<0){
				System.out.println(s5y2);
				System.out.println(s5x2);
				System.out.println(s5d2);
				s5y2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 5 length ship's x coordinates 0-4 Player 2"));
				s5x2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 5 length ship's y coordinates 0-4 Player 2"));
				s5d2 = (JOptionPane.showInputDialog("Stop fooling around. Intput your 5 length ship's direction (please enter up or left)"));

			}

			while((ships3[s5x2][s5y2]==" O"||ships3[s5x2][s5y2+1]==" O"||ships3[s5x2][s5y2+2]==" O"||ships3[s5x2][s5y2+3]==" O"||ships3[s5x2][s5y2+4]==" O")){

				s5y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's x coordinates 0-4 Player 2"));
				s5x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's y coordinates 0-4 Player 2"));
			}
			while((ships3[s5x2][s5y2]==" O"||ships3[s5x2+1][s5y2]==" O"||ships3[s5x2+2][s5y2]==" O"||ships3[s5x2+3][s5y2]==" O"||ships3[s5x2+4][s5y2 ]==" O")){

				s5y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's x coordinates 0-4 Player 2"));
				s5x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 5 length ship's y coordinates 0-4 Player 2"));
			}

			if((ships3[s5x2][s5y2]!=" O"&& ships3[s5x2][s5y2+1]!=" O"&& ships3[s5x2][s5y2+2]!=" O"&& ships3[s5x2][s5y2+3]!=" O"&& ships3[s5x2][s5y2+4]!=" O")){

				if(s5d2.equals("left")){
					ships3[s5x2][s5y2]=" O";
					ships3[s5x2][s5y2+1]=" O";
					ships3[s5x2][s5y2+2]=" O";
					ships3[s5x2][s5y2+3]=" O";
					ships3[s5x2][s5y2+4]=" O";
				}
				else if(s5d2.equals("up")){
					ships3[s5x2][s5y2]=" O";
					ships3[s5x2+1][s5y2]=" O";
					ships3[s5x2+2][s5y2]=" O";
					ships3[s5x2+3][s5y2]=" O";
					ships3[s5x2+4][s5y2]=" O";
				}
			}

			int s4y2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 4 length ship's x coordinates 0-5 Player 2"));
			int s4x2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 4 length ship's y coordinates 0-5 Player 2"));
			String s4d2 = (JOptionPane.showInputDialog("Intput your 4 length ship's direction (please enter up or left)"));

			while(s4y2>5||s4x2>5||!s4d2.equals("up")&&!s4d2.equals("left")||s4y2<0||s4x2<0){

				s4y2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's x coordinates 0-5 Player 2"));
				s4x2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's y coordinates 0-5 Player 2"));
				s4d2 = (JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's direction (please enter up or left)"));

			}

			while((ships3[s4x2][s4y2]==" O"||ships3[s4x2][s4y2+1]==" O"||ships3[s4x2][s4y2+2]==" O"||ships3[s4x2][s4y2+3]==" O")){

				s4y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's x coordinates 0-5 Player 2"));
				s4x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's y coordinates 0-5 Player 2"));
			}
			while((ships3[s4x2][s4y2]==" O"||ships3[s4x2+1][s4y2]==" O"||ships3[s4x2+2][s4y2]==" O"||ships3[s4x2+3][s4y2]==" O")){

				s4y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's x coordinates 0-5 Player 2"));
				s4x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 4 length ship's y coordinates 0-5 Player 2"));
			}

			if((ships3[s4x2][s4y2]!=" O"&& ships3[s4x2][s4y2+1]!=" O"&& ships3[s4x2][s4y2+2]!=" O"&& ships3[s4x2][s4y2+3]!=" O"&& ships3[s4x2][s4y2+4]!=" O")){

				if(s4d2.equals("left")){
					ships3[s4x2][s4y2]=" O";
					ships3[s4x2][s4y2+1]=" O";
					ships3[s4x2][s4y2+2]=" O";
					ships3[s4x2][s4y2+3]=" O";
				}
				else if(s4d2.equals("up")){
					ships3[s4x2][s4y2]=" O";
					ships3[s4x2+1][s4y2]=" O";
					ships3[s4x2+2][s4y2]=" O";
					ships3[s4x2+3][s4y2]=" O";
				}
			}

			int s3y2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 3 length ship's x coordinates 0-6 Player 2"));
			int s3x2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 3 length ship's y coordinates 0-6 Player 2"));
			String s3d2 = (JOptionPane.showInputDialog("Intput your 3 length ship's direction (please enter up or left)"));

			while(s3y2>6||s3x2>6||!s3d2.equals("up")&&!s3d2.equals("left")||s3y2<0||s3x2<0){

				s3y2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's x coordinates 0-6 Player 2"));
				s3x2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's y coordinates 0-6 Player 2"));
				s3d2 = (JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's direction (please enter up or left)"));

			}

			while((ships3[s3x2][s3y2]==" O"||ships3[s3x2][s3y2+1]==" O"||ships3[s3x2][s3y2+2]==" O")){

				s3y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's x coordinates 0-6 Player 2"));
				s3x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's y coordinates 0-6 Player 2"));
			}
			while((ships3[s3x2][s3y2]==" O"||ships3[s3x2+1][s3y2]==" O"||ships3[s3x2+2][s3y2]==" O")){

				s3y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's x coordinates 0-6 Player 2"));
				s3x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 3 length ship's y coordinates 0-6 Player 2"));
			}

			if((ships3[s3x2][s3y2]!=" O"&& ships3[s3x2][s3y2+1]!=" O"&& ships3[s3x2][s3y2+2]!=" O"&& ships3[s3x2][s3y2+3]!=" O"&& ships3[s3x2][s3y2+3]!=" O")){
				if(s3d2.equals("left")){
					ships3[s3x2][s3y2]=" O";
					ships3[s3x2][s3y2+1]=" O";
					ships3[s3x2][s3y2+2]=" O";
				}
				else if(s3d2.equals("up")){
					ships3[s3x2][s3y2]=" O";
					ships3[s3x2+1][s3y2]=" O";
					ships3[s3x2+2][s3y2]=" O";
				}
			}

			int s3y_2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your other 3 length ship's x coordinates 0-6 Player 2"));
			int s3x_2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your other 3 length ship's y coordinates 0-6 Player 2"));
			String s3d_2 = (JOptionPane.showInputDialog("Intput your other 3 length ship's direction (please enter up or left)"));

			while(s3y_2>6||s3x_2>6||!s3d_2.equals("up")&&!s3d_2.equals("left")||s3y_2<0||s3x_2<0){

				s3y_2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your other 3 length ship's x coordinates 0-6 Player 2"));
				s3x_2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your other 3 length ship's y coordinates 0-6 Player 2"));
				s3d_2 = (JOptionPane.showInputDialog("Stop fooling around. Intput your 3 length ship's direction (please enter up or left)"));

			}

			while((ships3[s3x_2][s3y_2]==" O"||ships3[s3x_2][s3y_2+1]==" O"||ships3[s3x_2][s3y_2+2]==" O")){

				s3y_2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's x coordinates 0-6 Player 2"));
				s3x_2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's y coordinates 0-6 Player 2"));
			}
			while((ships3[s3x_2][s3y_2]==" O"||ships3[s3x_2+1][s3y_2]==" O"||ships3[s3x_2+2][s3y_2]==" O")){

				s3y_2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's x coordinates 0-6 Player 2"));
				s3x_2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your other 3 length ship's y coordinates 0-6 Player 2"));
			}

			if((ships3[s3x_2][s3y_2]!=" O"&& ships3[s3x_2][s3y_2+1]!=" O"&& ships3[s3x_2][s3y_2+2]!=" O"&& ships3[s3x_2][s3y_2+3]!=" O"&& ships3[s3x_2][s3y_2+3]!=" O")){
				if(s3d_2.equals("left")){
					ships3[s3x_2][s3y_2]=" O";
					ships3[s3x_2][s3y_2+1]=" O";
					ships3[s3x_2][s3y_2+2]=" O";
				}
				else if(s3d_2.equals("up")){
					ships3[s3x_2][s3y_2]=" O";
					ships3[s3x_2+1][s3y_2]=" O";
					ships3[s3x_2+2][s3y_2]=" O";
				}
			}

			int s2y2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 2 length ship's x coordinates 0-7 Player 2"));
			int s2x2 = Integer.parseInt(JOptionPane.showInputDialog("Intput your 2 length ship's y coordinates 0-7 Player 2"));
			String s2d2 = (JOptionPane.showInputDialog("Intput your 2 length ship's direction (please enter up or left)"));

			while(s2y2>7||s2x2>7||!s2d2.equals("up")&&!s2d2.equals("left")||s2y2<0||s2x2<0){

				s2y2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 2 length ship's x coordinates 0-7 Player 2"));
				s2x2 = Integer.parseInt(JOptionPane.showInputDialog("Stop fooling around. Intput your 2 length ship's y coordinates 0-7 Player 2"));
				s2d2 = (JOptionPane.showInputDialog("Stop fooling around. Intput your 4 length ship's direction (please enter up or left)"));

			}

			while((ships3[s2x2][s2y2]==" O"||ships3[s2x2][s2y2+1]==" O")){

				s2y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's x coordinates 0-7 Player 2"));
				s2x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's y coordinates 0-7 Player 2"));
			}
			while((ships3[s2x2][s2y2]==" O"||ships3[s2x2+1][s2y2]==" O")){

				s2y2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's x coordinates 0-7 Player 2"));
				s2x2 = Integer.parseInt(JOptionPane.showInputDialog("That coordinate is taken. Intput your 2 length ship's y coordinates 0-7 Player 2"));
			}

			if((ships3[s2x2][s2y2]!=" O"&& ships3[s2x2][s2y2+1]!=" O"&& ships3[s2x2][s2y2+2]!=" O"&& ships3[s2x2][s2y2+2]!=" O"&& ships3[s2x2][s2y2+2]!=" O")){
				if(s2d2.equals("left")){
					ships3[s2x2][s2y2]=" O";
					ships3[s2x2][s2y2+1]=" O";
				}
				else if(s2d2.equals("up")){
					ships3[s2x2][s2y2]=" O";
					ships3[s2x2+1][s2y2]=" O";
				}
			}
		}
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//TODO Auto-generated method stub

		//if(Scanner.equals("1")){
		int k=(int)(Math.random()*5);
		int l=(int)(Math.random()*5);

		int j=(int)(Math.random()*2); 
		while((ships2[k][l]==" X"||ships2[k][l+1]==" X"||ships2[k][l+2]==" X"||ships2[k][l+3]==" X"||ships2[k][l+4]==" X")&& j==0){
			k=(int)(Math.random()*5);
			l=(int)(Math.random()*5);
		}
		while((ships2[k][l]==" X"||ships2[k+1][l]==" X"||ships2[k+2][l]==" X"||ships2[k+3][l]==" X"||ships2[k+4][l]==" X")&& j==1){
			k=(int)(Math.random()*5);
			l=(int)(Math.random()*5);
		}
		if(ships2[k][l]!=" X"&& ships2[k][l+1]!=" X"&& ships2[k][l+2]!=" X"&& ships2[k][l+3]!=" X"&& ships2[k][l+4]!=" X"){

			if(j==0){
				ships2[k][l]=" X";
				ships2[k][l+1]=" X";
				ships2[k][l+2]=" X";
				ships2[k][l+3]=" X";
				ships2[k][l+4]=" X";
			}
		}
		if(ships2[k][l]!=" X"&& ships2[k+1][l]!=" X"&& ships2[k+2][l]!=" X"&& ships2[k+3][l]!=" X"&& ships2[k+4][l]!=" X"){
			if(j==1){
				ships2[k][l]=" X";
				ships2[k+1][l]=" X";
				ships2[k+2][l]=" X";
				ships2[k+3][l]=" X";
				ships2[k+4][l]=" X";
			}
		}

		k=(int)(Math.random()*6);
		l=(int)(Math.random()*6);
		j=(int)(Math.random()*2); 

		while((ships2[k][l]==" X"||ships2[k][l+1]==" X"||ships2[k][l+2]==" X"||ships2[k][l+3]==" X")&& j==0){
			k=(int)(Math.random()*6);
			l=(int)(Math.random()*6);
		}
		while((ships2[k][l]==" X"||ships2[k+1][l]==" X"||ships2[k+2][l]==" X"||ships2[k+3][l]==" X")&& j==1){
			k=(int)(Math.random()*6);
			l=(int)(Math.random()*6);
		}

		if(ships2[k][l]!=" X"&& ships2[k][l+1]!=" X"&& ships2[k][l+2]!=" X"&& ships2[k][l+3]!=" X"){

			if(j==0){
				ships2[k][l]=" X";
				ships2[k][l+1]=" X";
				ships2[k][l+2]=" X";
				ships2[k][l+3]=" X";
			}
		}
		if(ships2[k][l]!=" X"&& ships2[k+1][l]!=" X"&& ships2[k+2][l]!=" X"&& ships2[k+3][l]!=" X"){
			if(j==1){
				ships2[k][l]=" X";
				ships2[k+1][l]=" X";
				ships2[k+2][l]=" X";
				ships2[k+3][l]=" X";
			}
		}

		k=(int)(Math.random()*7);
		l=(int)(Math.random()*7);
		j=(int)(Math.random()*2);

		while((ships2[k][l]==" X"||ships2[k][l+1]==" X"||ships2[k][l+2]==" X")&& j==0){
			k=(int)(Math.random()*7);
			l=(int)(Math.random()*7);
		}
		while((ships2[k][l]==" X"||ships2[k+1][l]==" X"||ships2[k+2][l]==" X")&& j==1){
			k=(int)(Math.random()*7);
			l=(int)(Math.random()*7);
		}

		if(ships2[k][l]!=" X"&& ships2[k][l+1]!=" X"&& ships2[k][l+2]!=" X"){

			if(j==0){
				ships2[k][l]=" X";
				ships2[k][l+1]=" X";
				ships2[k][l+2]=" X";
			}
		}
		if(ships2[k][l]!=" X"&& ships2[k+1][l]!=" X"&& ships2[k+2][l]!=" X"){
			if(j==1){
				ships2[k][l]=" X";
				ships2[k+1][l]=" X";
				ships2[k+2][l]=" X";
			}
		}

		k=(int)(Math.random()*7);
		l=(int)(Math.random()*7);
		j=(int)(Math.random()*2); 

		while((ships2[k][l]==" X"||ships2[k][l+1]==" X"||ships2[k][l+2]==" X")&& j==0){
			k=(int)(Math.random()*7);
			l=(int)(Math.random()*7);
		}
		while((ships2[k][l]==" X"||ships2[k+1][l]==" X"||ships2[k+2][l]==" X")&& j==1){
			k=(int)(Math.random()*7);
			l=(int)(Math.random()*7);
		}

		if(ships2[k][l]!=" X"&& ships2[k][l+1]!=" X"&& ships2[k][l+2]!=" X"){

			if(j==0){
				ships2[k][l]=" X";
				ships2[k][l+1]=" X";
				ships2[k][l+2]=" X";
			}
		}
		if(ships2[k][l]!=" X"&& ships2[k+1][l]!=" X"&& ships2[k+2][l]!=" X"){
			if(j==1){
				ships2[k][l]=" X";
				ships2[k+1][l]=" X";
				ships2[k+2][l]=" X";
			}
		}

		k=(int)(Math.random()*8);
		l=(int)(Math.random()*8);
		j=(int)(Math.random()*2); 

		while((ships2[k][l]==" X"||ships2[k][l+1]==" X")&& j==0){
			k=(int)(Math.random()*8);
			l=(int)(Math.random()*8);
		}
		while((ships2[k][l]==" X"||ships2[k+1][l]==" X")&& j==1){
			k=(int)(Math.random()*8);
			l=(int)(Math.random()*8);
		}

		if(ships2[k][l]!=" X"&& ships2[k][l+1]!=" X"){

			if(j==0){
				ships2[k][l]=" X";
				ships2[k][l+1]=" X";
			}
		}
		if(ships2[k][l]!=" X"&& ships2[k+1][l]!=" X"){
			if(j==1){
				ships2[k][l]=" X";
				ships2[k+1][l]=" X";
			}
		}
//	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	add(contentPane);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

	///////////////////////////////////////////
	//if(turn==false){
	for(int x=0;x<10;x++){
		for(int y=0;y<10;y++){
			System.out.println(board[x][y].equals(arg0.getSource()));
			if(board[x][y].equals(arg0.getSource())&&ships2[x][y].equals(" X")){
				board[x][y].setBackground(Color.RED);
				board[x][y].setText("HIT");
				ships2[x][y]="12345";
				winp1++; 
				System.out.println(winp1);
				if(winp1==17&&winp2!=17){
					for(int w=0;w<10;w++){
						for(int e=0;e<10;e++){
							//		if(Scanner.equals("1")){
							board[w][e].setText("YOU WIN!!!!");
							//	}
							//if(Scanner.equals("2")){
							//	board[w][e].setText("PLAYER 1 WINS!!!!");
							//	}
						}
					}
				}
				}
				
				else if(board[x][y].equals(arg0.getSource())&&ships2[x][y].equals("")){
					board[x][y].setBackground(Color.WHITE);
					board[x][y].setText("MISS");
				}
			}
		}
	//}

	///////////////////////////////////////////

	int x=(int)(Math.random()*10);
	int y=(int)(Math.random()*10);
	System.out.println(x);
	System.out.println(y);
	System.out.println(winp2);
	if(board2[x][y].equals(arg0.getSource().toString())&&ships[x][y].equals(" O")/*&&Scanner.equalsIgnoreCase("1")*/){
		board2[x][y].setText("HIT");
		ships[x][y]="12345";
		winp2++;
		if(winp2==17&&winp1!=17){
			for(int w=0;w<10;w++){
				for(int e=0;e<10;e++){
					board[w][e].setText("YOU LOSE :(");

				}
			}
		}
	}
	else if(board2[x][y].equals(arg0.getSource())&&ships2[x][y].equals("")/*&&Scanner.equalsIgnoreCase("1")*/){
		board2[x][y].setText("MISS");
	}

	///////////////////////////////////////////

	/*		
		if(turn==true){
			for(int o=0;o<10;o++){
				for(int p=0;p<10;p++){
					if(board3[o][p].equals(arg0.getSource())&&ships2[x][y].equals(" X")&&Scanner.equalsIgnoreCase("2")){
						board3[o][p].setBackground(Color.RED);
						board3[o][p].setText("HIT");
						ships[o][p]="12345";
						winp3++; 
						System.out.println(winp3);
						if(winp3==17&&winp2!=17){
							for(int w=0;w<10;w++){
								for(int e=0;e<10;e++){
									board[w][e].setText("PLAYER 2 WINS!!!!");

								} 
							}
						}
					}
					else if(board3[o][p].equals(arg0.getSource())&&ships3[o][p].equals("")&&Scanner.equalsIgnoreCase("2")){
						board3[o][p].setBackground(Color.WHITE);
						board3[o][p].setText("MISS");
					}
				}
			}
		}
	 */
}
}



























