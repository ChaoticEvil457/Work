package Summertech;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class Bouncy_Ball extends JFrame implements KeyListener{
	static int x=190;
	static int j=1;
	static int y=290;
	static int k=1;
	static int up=400;
	static int up1=405;
	static int up2=400;
	static int up3=405;
	static int rebound1=1;
	static int rebound2=1;
	static int p1=0;
	static int p2=0;
	static boolean up0=false;
	static boolean down1=false;
	static boolean up9=false;
	static boolean down2=false;
	static String str1=(p1+"");
	static String str2=(p2+"");
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bouncy_Ball ball = new Bouncy_Ball();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){

			x+=j;
			y+=k;

			ball.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x>=720){
				x=190;
				y=290;
				k=1;
				j=1;
				p1++;
				str1=(p1+(""));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(x<=40){
				x=190;
				y=290;
				k=1;
				j=1;
				p2++;
				str2=(p2+(""));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(up<=0){
				up=0;
				up1=5;
			}
			if(up>=660){
				up=660;
				up1=665;
			}
			if(up2<=0){
				up2=0;
				up3=5;
			}
			if(up2>=660){
				up2=660;
				up3=665;
			}
			if(y>=730){
				k=-1;	
			}
			if(y<=0){
				k=1;	
			}
			if(up0){
				up2-=2;
				up3-=2;
			}
			if(down1){
				up2+=2;
				up3+=2;
			} 
			if(up9){
				up-=2;
				up1-=2;
			}
			if(down2){
				up+=2;
				up1+=2;
			}

			if(x==45 && y>=up-80 && y<=up+130){
				j=+1;	
			}

			//up2=y;
			//up3=y+5;
			if(x>=710 && y>=up2-80 && y<=up2+130){
				j=-1;
			}
			
		}
	}






	////////////////////////////////////////
	public Bouncy_Ball(){
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(25,25,800,800);
		addKeyListener(this);
		JPanel print=new JPanel(){
			public void paint(Graphics g){
				g.setColor(Color.BLACK);
				g.fillRect(0,0,1000000,1000000);

				g.setColor(Color.BLUE);
				g.fillOval(x,y,50,50);

				g.setColor(Color.GREEN);
				g.fillRect(10,up,30,110);
				g.setColor(Color.BLACK);
				g.fillRect(15,up1,20,100);
				g.setColor(Color.GREEN);
				g.fillRect(745,up2,30,110);
				g.setColor(Color.BLACK);
				g.fillRect(750,up3,20,100);
				g.setColor(Color.BLUE);
				g.setFont(new Font("arial",Font.BOLD,70));
				g.drawString(str1,230,100);
				g.drawString(str2,480,100);
				g.fillRect(350,70,40,15);
								}
			
		};
		add(print);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP){
			up0=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			down1=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_W){
			up9=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			down2=true;
		}
	}






	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			down1=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			up0=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_W){
			up9=false;
		}
			if(e.getKeyCode()==KeyEvent.VK_S){
				down2=false;
			}
	}






	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}