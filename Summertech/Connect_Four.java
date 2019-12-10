package Summertech;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
///////////////////////////////////////////////////
public class Connect_Four extends JFrame implements ActionListener{
	///////////////////////////////////////////////////
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Connect_Four news=new Connect_Four();

	}
	public JButton[] buttons=new JButton[7];
	public JLabel[][] board=new JLabel[7][7];
	int c0=6;
	int c1=6;
	int c2=6;
	int c3=6;
	int c4=6;
	int c5=6;
	int c6=6;
	boolean turn=false;
	///////////////////////////////////////////////////
	public Connect_Four(){
		JPanel pan=new JPanel();
		setVisible(true);
		setBounds(0,0,1920,1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(8,7));
		///////////////////////////////////////////////////
		for(int x=0;x<7;x++){
			for(int y=0;y<7;y++){
				board[x][y]=new JLabel();
				pan.add(board[x][y]);
			}
		}
		///////////////////////////////////////////////////
		for(int y=0;y<7;y++){
			buttons[y]=new JButton();
			pan.add(buttons[y]);
			buttons[y].addActionListener(this);
		}
		///////////////////////////////////////////////////
		add(pan);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(board[c0][0].getText().equals("")){

			if(arg0.getSource()==buttons[0]&&turn==false){
				board[c0][0].setText("                     X");
				c0--;
				turn=true;
			}
			else if(arg0.getSource()==buttons[0]&&turn==true){
				board[c0][0].setText("                     O");
				c0--;
				turn=false;
			}
			if(c0<0){
				c0=0;
			}

		}
		if(arg0.getSource()==buttons[1]){
			if(board[c1][1].getText().equals("")){

				if(arg0.getSource()==buttons[1]&&turn==false){
					board[c1][1].setText("                     X");
					c1--;
					turn=true;
				}
				else if(arg0.getSource()==buttons[1]&&turn==true){
					board[c1][1].setText("                     O");
					c1--;
					turn=false;
				}
				if(c1<0){
					c1=0;
				}

			}
		}
		if(arg0.getSource()==buttons[2]){
			if(board[c2][2].getText().equals("")){

				if(arg0.getSource()==buttons[2]&&turn==false){
					board[c2][2].setText("                     X");
					c2--;
					turn=true;
				}
				else if(arg0.getSource()==buttons[2]&&turn==true){
					board[c2][2].setText("                     O");
					c2--;
					turn=false;
				}
				if(c2<0){
					c2=0;
				}

			}
		}
		if(arg0.getSource()==buttons[3]){
			if(board[c3][3].getText().equals("")){

				if(arg0.getSource()==buttons[3]&&turn==false){
					board[c3][3].setText("                     X");
					c3--;
					turn=true;
				}
				else if(arg0.getSource()==buttons[3]&&turn==true){
					board[c3][3].setText("                     O");
					c3--;
					turn=false;
				}
				if(c3<0){
					c3=0;
				}

			}
		}
		if(arg0.getSource()==buttons[4]){
			if(board[c4][4].getText().equals("")){

				if(arg0.getSource()==buttons[4]&&turn==false){
					board[c4][4].setText("                     X");
					c4--;
					turn=true;
				}
				else if(arg0.getSource()==buttons[4]&&turn==true){
					board[c4][4].setText("                     O");
					c4--;
					turn=false;
				}
				if(c4<0){
					c4=0;
				}

			}
		}
		if(arg0.getSource()==buttons[5]){
			if(board[c5][5].getText().equals("")){

				if(arg0.getSource()==buttons[5]&&turn==false){
					board[c5][5].setText("                     X");
					c5--;
					turn=true;
				}
				else if(arg0.getSource()==buttons[5]&&turn==true){
					board[c5][5].setText("                     O");
					c5--;
					turn=false;
				}
				if(c5<0){
					c5=0;
				}

			}
		}
		if(arg0.getSource()==buttons[6]){
			if(board[c6][6].getText().equals("")){

				if(arg0.getSource()==buttons[6]&&turn==false){
					board[c6][6].setText("                     X");
					c6--;
					turn=true;
				}
				else if(arg0.getSource()==buttons[6]&&turn==true){
					board[c6][6].setText("                     O");
					c6--;
					turn=false;
				}
				if(c6<0){
					c6=0;
				}
			}
		}
		for(int winX1=0;winX1<7;winX1++){
			for(int winX2=0;winX2<4;winX2++){
				if(board[winX1][winX2].getText().equals("                     X")
						&&board[winX1][winX2+1].getText().equals("                     X")
						&&board[winX1][winX2+2].getText().equals("                     X")
						&&board[winX1][winX2+3].getText().equals("                     X")){

					System.out.println("X Wins");
					System.exit(0);
				}
			}
		}
		for(int winX1=0;winX1<4;winX1++){
			for(int winX2=0;winX2<7;winX2++){
				if(board[winX1][winX2].getText().equals("                     X")
						&&board[winX1+1][winX2].getText().equals("                     X")
						&&board[winX1+2][winX2].getText().equals("                     X")
						&&board[winX1+3][winX2].getText().equals("                     X")){

					System.out.println("X Wins");
					System.exit(0);
				}
			}
		}
		for(int winX1=0;winX1<4;winX1++){
			for(int winX2=0;winX2<4;winX2++){
				if(board[winX1][winX2].getText().equals("                     X")
						&&board[winX1+1][winX2+1].getText().equals("                     X")
						&&board[winX1+2][winX2+2].getText().equals("                     X")
						&&board[winX1+3][winX2+3].getText().equals("                     X")){

					System.out.println("X Wins");
					System.exit(0);
				}
			}
		}
		for(int winX1=0;winX1<4;winX1++){
			for(int winX2=0;winX2<4;winX2++){
				if(board[winX1+3][winX2].getText().equals("                     X")
						&&board[winX1+2][winX2+1].getText().equals("                     X")
						&&board[winX1+1][winX2+2].getText().equals("                     X")
						&&board[winX1][winX2+3].getText().equals("                     X")){

					System.out.println("X Wins");
					System.exit(0);
				}
			}
		}


		for(int winO1=0;winO1<7;winO1++){
			for(int winO2=0;winO2<4;winO2++){
				if(board[winO1][winO2].getText().equals("                     O")
						&&board[winO1][winO2+1].getText().equals("                     O")
						&&board[winO1][winO2+2].getText().equals("                     O")
						&&board[winO1][winO2+3].getText().equals("                     O")){

					System.out.println("O Wins");
					System.exit(0);
				}
			}
		}
		for(int winO1=0;winO1<4;winO1++){
			for(int winO2=0;winO2<7;winO2++){
				if(board[winO1][winO2].getText().equals("                     O")
						&&board[winO1+1][winO2].getText().equals("                     O")
						&&board[winO1+2][winO2].getText().equals("                     O")
						&&board[winO1+3][winO2].getText().equals("                     O")){
					System.out.println("O Wins");
					System.exit(0);
				}
			}
		}
		for(int winO1=0;winO1<4;winO1++){
			for(int winO2=0;winO2<4;winO2++){
				if(board[winO1][winO2].getText().equals("                     O")
						&&board[winO1+1][winO2+1].getText().equals("                     O")
						&&board[winO1+2][winO2+2].getText().equals("                     O")
						&&board[winO1+3][winO2+3].getText().equals("                     O")){
					System.out.println("O Wins");
					System.exit(0);
				}
			}
		}
		for(int winO1=0;winO1<4;winO1++){
			for(int winO2=0;winO2<4;winO2++){
				if(board[winO1+3][winO2].getText().equals("                     O")
						&&board[winO1+2][winO2+1].getText().equals("                     O")
						&&board[winO1+1][winO2+2].getText().equals("                     O")
						&&board[winO1][winO2+3].getText().equals("                     O")){
					System.out.println("O Wins");
					System.exit(0);
				}
			}
		}
	}
}