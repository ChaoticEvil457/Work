import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JFrame implements KeyListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Snake();
	}

	private int Movex1=45;
	private int Movey1=5;
	private int Length=4;
	private String Text="You Lose";
	private boolean Left=false;
	private int Randomx=((int)(Math.random()*45));
	private int Randomy=((int)(Math.random()*37));
	private boolean Right=true;
	private boolean Up=false;
	private boolean Down=false;
	private boolean Life=true;
	private boolean Input=false;

	private int[][] Time_Travel1=new int[Length][2];

	public Snake(){
		setVisible(true);
		setBounds(5,5,917,780);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Snake");

		setResizable(false);
		for(int d=0;d<3;d++){
			Time_Travel1[d][0]=Movex1;
			Time_Travel1[d][1]=Movey1;
		}
		JPanel pan=new JPanel(){
			public void paint(Graphics g){
				Input=true;
				g.setColor(Color.BLACK);
				g.fillRect(0,0,20000,20000);

				g.setColor(Color.BLUE.darker());


				for(int a=5;a<890;a=a+20){
					for(int b=5;b<890;b=b+20){
						g.fillRect(a,b,15,15);
					}
				}

				g.setColor(Color.RED);

				g.fillRect(Randomx*20+5,Randomy*20+5,15,15);
				if((Movex1-5)/20==Randomx&&(Movey1-5)/20==Randomy){
					Randomx=((int)(Math.random()*30));
					Randomy=((int)(Math.random()*30));
					g.fillRect(Randomx*20+5,Randomy*20+5,15,15);
					Length++;
				}

				g.setColor(Color.ORANGE.darker());

				for(int c=0;c<Length-1;c++){
					int x=Time_Travel1[c][0];
					int y=Time_Travel1[c][1];
					g.fillRect(x,y,15,15);

				}


				if(Movex1<880&&Right==true){
					Movex1+=20;
				}


				if(Movex1>10&&Left==true){
					Movex1-=20;
				}


				if(Movey1>10&&Up==true){
					Movey1-=20;
				}


				if(Movey1<720&&Down==true){
					Movey1+=20;
				}
				int[][] Dummy=new int[Length][2];
				for(int Update=0;Update<Length-1;Update++){
					Dummy[Update+1][0]=Time_Travel1[Update][0];
					Dummy[Update+1][1]=Time_Travel1[Update][1];
				}
				Dummy[0][0]=Movex1;
				Dummy[0][1]=Movey1;
				Time_Travel1=Dummy;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				repaint();
			}
		};
		add(pan);
		addKeyListener(this);
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(Input==true){
			if(arg0.getKeyCode()==KeyEvent.VK_RIGHT&&Left==false){
				Left=false;
				Right=true;
				Up=false;
				Down=false;
				Input=false;
				
			}
			if(arg0.getKeyCode()==KeyEvent.VK_LEFT&&Right==false){
				Left=true;
				Right=false;
				Up=false;
				Down=false;
				Input=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_UP&&Down==false){
				Left=false;
				Right=false;
				Up=true;
				Down=false;
				Input=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_DOWN&&Up==false){
				Left=false;
				Right=false;
				Up=false;
				Down=true;
				Input=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_D&&Left==false){
				Left=false;
				Right=true;
				Up=false;
				Down=false;
				Input=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_A&&Right==false){
				Left=true;
				Right=false;
				Up=false;
				Down=false;
				Input=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_W&&Down==false){
				Left=false;
				Right=false;
				Up=true;
				Down=false;
				Input=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_S&&Up==false){
				Left=false;
				Right=false;
				Up=false;
				Down=true;
				Input=false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}