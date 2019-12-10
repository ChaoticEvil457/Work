package Summertech;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Space_Invaders extends JFrame implements KeyListener{
	static int x=30;
	static int y=100;
	static int x1=300;
	static int y1=685;
	static int x2=x1;
	static int y2=650;
	static int x3=x;
	static int y3=y;
	static int bb1=0;
	static int bb2=0;
	static int bb3=0;
	static int bb4=0;
	static int bb5=0;
	static int bb6=0;
	static int a1=0;
	static int a2=0;
	static int a3=0;
	static int alienGo=2;
	static String String=("You Lose");
	static String String1=("You Win");
	static Boolean Boolean=false;
	static Boolean Boolean1=false;
	static Boolean left=false;
	static Boolean right=false;
	static Boolean shoot=false;
	static Boolean shoot2=false;
	static Boolean ashoot=false;
	static Boolean ashoot2=false;
	static Boolean a=true;
	static Boolean b=true;
	static Boolean c=true;
	static Boolean d=true;
	static Boolean nm=true;
	static Boolean t=true;
	static Boolean r=true;
	static Boolean u=true;
	static Boolean asdf1=false;
	static Boolean asdf2=false;
	static Boolean asdf3=false;
	static Boolean Boolean2=false;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Space_Invaders Space=new Space_Invaders();
		while(true){
			if(left){
				x1=x1-3;
			}
			if(right){
				x1=x1+3;
			}
			//ashoot=true;
			//ashoot2=true;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(alienGo%25==0 && Boolean2==false){
				x=x+13;
				
			}
			else if(alienGo%25==0 && Boolean2==true){
				x=x-13;
			}
			alienGo++;
			if(x<=50 && Boolean2==true){
				Boolean2=false;
				y=y+30;
			}
		if(x>=290 && Boolean2==false){
				y=y+30;
				Boolean2=true;
				
			}
			if(shoot==true){
				y2=y2-5;
			}
			if(ashoot==true){
				y2=y2+5;
			}
			if(y>=430 && x>=250){
				Boolean=true;
				Space.repaint();
				Space.repaint();
				break;
			}
			if(x2>=x-70 && x2<=x+70 && y2==y+10 && asdf1==false){
				a1++;
				y2=655;
				if(a1>=6){
					asdf1=true;
				}
				
			}
			if(x2>=x+330 && x2<=x+470 && y2==y+10 && asdf2==false){
				a2++;
				y2=655;
				if(a2>=10){
					asdf2=true;
				}
			}
			if(x2>=x+110 && x2<=x+260 && y2==y+10 && asdf3==false){
				a3++;
				y2=655;
				if(a3>=6){
					asdf3=true;
				}
			}
			if(asdf1&&asdf2&&asdf3){
				Boolean1=true;
				Space.repaint();
				Space.repaint();
				break;
			}
			Space.repaint();
		}
	}
	////////////////////////////////////////
	public Space_Invaders(){
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(25,25,800,800);
		addKeyListener(this);
		JPanel print=new JPanel(){
			public void paint(Graphics g){
				g.setColor(Color.BLACK);
				g.fillRect(0,0,2099999999,2099999999);
				g.setColor(Color.GREEN);
				//ship
				g.fillRoundRect(x1,y1+40,120,60,15,15);
				g.fillRect(x1+44,y1+5,30,45);
				if(x1>=660){
					x1=660;
				}
				if(x1<=0){
					x1=0;
				}
				//barrier1
				g.fillRect(225,500,70,40);
				g.fillRect(290,500,40,70);
				g.fillRect(190,500,40,70);
				//barrier2
				g.fillRect(535,500,70,40);
				g.fillRect(600,500,40,70);
				g.fillRect(500,500,40,70);

				//barrier 1 breaking
				if(y2==540 && x2>150 && x2<250 && a==true){

					bb1++;
					y2=655;

				}
				if(bb1>=4){
					g.setColor(Color.BLACK);
					g.fillRect(225, 500, 70, 40);
					a=false;
				}
				if(y2==570 && x2>130 && x2<190 && b==true){

					bb2++;
					y2=655;

				}
				if(bb2>=4){
					g.setColor(Color.BLACK);
					g.fillRect(190, 500, 40, 70);
					b=false;
				}
				if(y2==570 && x2>230 && x2<290 && c==true){

					bb3++;
					y2=655;

				}
				if(bb3>=4){
					g.setColor(Color.BLACK);
					g.fillRect(290, 500, 40, 70);
					c=false;
				}
				//barrier 2 breaking
				if(y2==540 && x2>500 && x2<550 && t==true){

					bb4++;
					y2=655;

				}
				if(bb4>=4){
					g.setColor(Color.BLACK);
					g.fillRect(535,500,70,40);
					t=false;
				}
				if(y2==570 && x2>550 && x2<600 && r==true){

					bb5++;
					y2=655;

				}
				if(bb5>=4){
					g.setColor(Color.BLACK);
					g.fillRect(600,500,40,70);
					r=false;
				}
				if(y2==570 && x2>450 && x2<500 && u==true){

					bb6++;
					y2=655;

				}
				if(bb6>=4){
					g.setColor(Color.BLACK);
					g.fillRect(500,500,40,70);
					u=false;
				}
				//win/lose
				g.setColor(Color.BLUE);
				g.setFont(new Font("arial",Font.BOLD,70));
				if(Boolean==true){ 
					g.drawString(String,350,70);
				}
				if(Boolean1==true){
					g.drawString(String1,350,70);
				}

				g.setColor(Color.WHITE);
				//bullet
				if(shoot2){
					x2=x1;
					shoot2=false;
				}
				if(shoot && d){
					
					g.fillRect(x2+50,y2+5,10,45);
				}
				if(y2<0){
					d=false;
				}
				if(y2<=0 || y2==655){
					shoot=false;
					d=false;
				}				
				if(d==false){
					y2=655;
					d=true;
				}
				//alien bullet
				//TODO
			
				if(ashoot2){
					x3=x;
					y3=y;
					ashoot2=false;
				}
				if(ashoot && nm){
					
					g.fillRect(x3+220,y3,10,4);
				}
				if(y3<0){
					nm=false;
				}
				if(y3==y+20 || y3>=670){
					ashoot=false;
					nm=false;
				}				
				if(nm==false){
					y3=y+20;
					nm=true;
				}
				
				// TODO Auto-generated method stub
				//alien 1
				//row 1
				if(asdf1==false){
				g.fillRect(x,y,10,10);
				g.fillRect(x+10,y,10,10);
				g.fillRect(x+20,y,10,10);
				g.fillRect(x+30,y,10,10);
				g.fillRect(x+40,y,10,10);
				g.fillRect(x+50,y,10,10);
				g.fillRect(x+60,y,10,10);
				//row 2
				g.fillRect(x-10,y+10,10,10);
				g.fillRect(x,y+10,10,10);
				g.fillRect(x+20,y+10,10,10);
				g.fillRect(x+30,y+10,10,10);
				g.fillRect(x+40,y+10,10,10);
				g.fillRect(x+60,y+10,10,10);
				g.fillRect(x+70,y+10,10,10);
				//row 3
				g.fillRect(x,y+20,10,10);
				g.fillRect(x+10,y+20,10,10);
				g.fillRect(x+20,y+20,10,10);
				g.fillRect(x+30,y+20,10,10);
				g.fillRect(x+40,y+20,10,10);
				g.fillRect(x+50,y+20,10,10);
				g.fillRect(x+60,y+20,10,10);
				g.fillRect(x+70,y+20,10,10);
				g.fillRect(x-10,y+20,10,10);
				//arm 1
				g.fillRect(x-20,y+20,10,10);
				g.fillRect(x-20,y+30,10,10);
				g.fillRect(x-20,y+40,10,10);
				//arm 2
				g.fillRect(x+80,y+20,10,10);
				g.fillRect(x+80,y+30,10,10);
				g.fillRect(x+80,y+40,10,10);
				//row4
				g.fillRect(x+10,y+30,10,10);
				g.fillRect(x+20,y+30,10,10);
				g.fillRect(x+30,y+30,10,10);
				g.fillRect(x+40,y+30,10,10);
				g.fillRect(x+50,y+30,10,10);
				g.fillRect(x+60,y+30,10,10);
				g.fillRect(x,y+30,10,10);
				//mouth
				g.fillRect(x,y+40,10,10);
				g.fillRect(x+60,y+40,10,10);
				g.fillRect(x+10,y+50,10,10);
				g.fillRect(x+50,y+50,10,10);
				g.fillRect(x+20,y+50,10,10);
				g.fillRect(x+40,y+50,10,10);
				//Head Things
				g.fillRect(x+10,y-10,10,10);
				g.fillRect(x,y-20,10,10);
				g.fillRect(x+60,y-20,10,10);
				g.fillRect(x+50,y-10,10,10);
				}
				//alien 2
				//row 1
				if(asdf3==false){
				g.fillRect(x+200,y,10,10);
				g.fillRect(x+210,y,10,10);
				g.fillRect(x+220,y,10,10);
				g.fillRect(x+230,y,10,10);
				g.fillRect(x+240,y,10,10);
				g.fillRect(x+250,y,10,10);
				g.fillRect(x+260,y,10,10);
				//row 2
				g.fillRect(x+190,y+10,10,10);
				g.fillRect(x+200,y+10,10,10);
				g.fillRect(x+220,y+10,10,10);
				g.fillRect(x+230,y+10,10,10);
				g.fillRect(x+240,y+10,10,10);
				g.fillRect(x+260,y+10,10,10);
				g.fillRect(x+270,y+10,10,10);
				//row 3
				g.fillRect(x+200,y+20,10,10);
				g.fillRect(x+210,y+20,10,10);
				g.fillRect(x+220,y+20,10,10);
				g.fillRect(x+230,y+20,10,10);
				g.fillRect(x+240,y+20,10,10);
				g.fillRect(x+250,y+20,10,10);
				g.fillRect(x+260,y+20,10,10);
				g.fillRect(x+270,y+20,10,10);
				g.fillRect(x+190,y+20,10,10);
				//arm 1
				g.fillRect(x+180,y+20,10,10);
				g.fillRect(x+180,y+30,10,10);
				g.fillRect(x+180,y+40,10,10);
				//arm 2
				g.fillRect(x+280,y+20,10,10);
				g.fillRect(x+280,y+30,10,10);
				g.fillRect(x+280,y+40,10,10);
				//row4
				g.fillRect(x+210,y+30,10,10);
				g.fillRect(x+220,y+30,10,10);
				g.fillRect(x+230,y+30,10,10);
				g.fillRect(x+240,y+30,10,10);
				g.fillRect(x+250,y+30,10,10);
				g.fillRect(x+260,y+30,10,10);
				g.fillRect(x+200,y+30,10,10);
				//mouth
				g.fillRect(x+200,y+40,10,10);
				g.fillRect(x+260,y+40,10,10);
				g.fillRect(x+210,y+50,10,10);
				g.fillRect(x+250,y+50,10,10);
				g.fillRect(x+220,y+50,10,10);
				g.fillRect(x+240,y+50,10,10);
				//Head Things
				g.fillRect(x+210,y-10,10,10);
				g.fillRect(x+200,y-20,10,10);
				g.fillRect(x+260,y-20,10,10);
				g.fillRect(x+250,y-10,10,10);
				}
				//alien 3
				//row 1
				if(asdf2==false){
				g.fillRect(x+400,y,10,10);
				g.fillRect(x+410,y,10,10);
				g.fillRect(x+420,y,10,10);
				g.fillRect(x+430,y,10,10);
				g.fillRect(x+440,y,10,10);
				g.fillRect(x+450,y,10,10);
				g.fillRect(x+460,y,10,10);
				//row 2
				g.fillRect(x+390,y+10,10,10);
				g.fillRect(x+400,y+10,10,10);
				g.fillRect(x+420,y+10,10,10);
				g.fillRect(x+430,y+10,10,10);
				g.fillRect(x+440,y+10,10,10);
				g.fillRect(x+460,y+10,10,10);
				g.fillRect(x+470,y+10,10,10);
				//row 3
				g.fillRect(x+400,y+20,10,10);
				g.fillRect(x+410,y+20,10,10);
				g.fillRect(x+420,y+20,10,10);
				g.fillRect(x+430,y+20,10,10);
				g.fillRect(x+440,y+20,10,10);
				g.fillRect(x+450,y+20,10,10);
				g.fillRect(x+460,y+20,10,10);
				g.fillRect(x+470,y+20,10,10);
				g.fillRect(x+390,y+20,10,10);
				//arm 1
				g.fillRect(x+380,y+20,10,10);
				g.fillRect(x+380,y+30,10,10);
				g.fillRect(x+380,y+40,10,10);
				//arm 2
				g.fillRect(x+480,y+20,10,10);
				g.fillRect(x+480,y+30,10,10);
				g.fillRect(x+480,y+40,10,10);
				//row4
				g.fillRect(x+410,y+30,10,10);
				g.fillRect(x+420,y+30,10,10);
				g.fillRect(x+430,y+30,10,10);
				g.fillRect(x+440,y+30,10,10);
				g.fillRect(x+450,y+30,10,10);
				g.fillRect(x+460,y+30,10,10);
				g.fillRect(x+400,y+30,10,10);
				//mouth
				g.fillRect(x+400,y+40,10,10);
				g.fillRect(x+460,y+40,10,10);
				g.fillRect(x+410,y+50,10,10);
				g.fillRect(x+450,y+50,10,10);
				g.fillRect(x+420,y+50,10,10);
				g.fillRect(x+440,y+50,10,10);
				//Head Things
				g.fillRect(x+410,y-10,10,10);
				g.fillRect(x+400,y-20,10,10);
				g.fillRect(x+460,y-20,10,10);
				g.fillRect(x+450,y-10,10,10);
				}
			}

		};
		add(print);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			right=true;
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			shoot=true;
			if(y2==655){
				shoot2=true;
			}

		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}