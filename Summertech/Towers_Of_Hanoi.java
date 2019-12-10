package Summertech;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Towers_Of_Hanoi extends JFrame implements MouseListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Towers_Of_Hanoi();
	}
	JPanel pan;
	int xr=230;
	int yr=550;
	int xy=205;
	int yy=600;
	int xg=180;
	int yg=650;
	boolean mover=false;
	boolean movey=false;
	boolean moveg=false;
	boolean topr=true;
	boolean topy=false;
	boolean topg=false;
	boolean red1=true;
	boolean red2=false;
	boolean red3=false;
	boolean yel1=true;
	boolean yel2=false;
	boolean yel3=false;
	boolean gre1=true;
	boolean gre2=false;
	boolean gre3=false;

	public Towers_Of_Hanoi(){

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0,1500,1000);
		setVisible(true);
		pan=new JPanel(){
			public void paint(Graphics g){
				g.setColor(Color.BLACK);
				g.fillRect(250,200,10,500);
				g.fillRect(750,200,10,500);
				g.fillRect(1250,200,10,500);

				g.fillRect(100,700,300,50);
				g.fillRect(610,700,300,50);
				g.fillRect(1110,700,300,50);

				g.setColor(Color.RED);
				g.fillRect(xr,yr,50,50);

				g.setColor(Color.YELLOW);
				g.fillRect(xy,yy,100,50);

				g.setColor(Color.GREEN);
				g.fillRect(xg,yg,150,50);

				//if()
			}
		};add(pan);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>=xr+5&&e.getX()<=xr+57&&e.getY()>=yr+25&&e.getY()<=yr+77&&topr==true){
			mover=true;
		}
		if(e.getX()>=xy+5&&e.getX()<=xy+107&&e.getY()>=yy+25&&e.getY()<=yr+77&&topr==true){
			movey=true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mover&&topr==true){
			xr=e.getX()-30;
			yr=e.getY()-30;
			System.out.println(xr);
			System.out.println(yr);
			mover=false;
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub

		if(movey&&topy==true){
			xy=e.getX()-30;
			yy=e.getY()-30;
			System.out.println(xy);
			System.out.println(yy);
			movey=false;
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub

		if(xr>=100&&xr<=400&&yr>=-100&&yr<=10000&&topr==true){

			if(gre1==true&&yel1==true){
				xr=230;
				yr=650;
			}
			if(gre1==false&&yel1==true){
				xr=230;
				yr=600;
			}
			if(gre1==true&&yel1==false){
				xr=230;
				yr=600;
			}
			if(gre1==false&&yel1==false){
				xr=230;
				yr=550;
			}
			red1=true;
			red2=false;
			red3=false;
			if(yel1==true){
				yel2=false;
				yel3=false;
				topy=false;
			}
			if(yel2==true){
				yel1=false;
				yel3=false;
				topy=true;
			}
			if(yel3==true){
				yel1=false;
				yel2=false;
				topy=true;
			}
			if(gre1==true){
				gre2=false;
				gre3=false;
				topg=false; 

			}
			if(gre2==true&&yel2==false){
				gre1=false;
				gre3=false;
				topg=true;
			}
			if(gre3==true&&yel3==false){
				gre1=false;
				gre2=false;
				topg=true;
			}
			System.out.println("hi1 " + xr+ " "+yr+" ");
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub

		if(xr>=600&&xr<=900&&yr>=-100&&yr<=10000&&topr==true){
			if(gre2==true&&yel2==true){
				xr=730;
				yr=650;
			}
			else if(gre2==false&&yel2==true){
				xr=730;
				yr=600;
			}
			else if(gre2==true&&yel2==false){
				xr=730;
				yr=600;
			}
			else if(gre2==false&&yel2==false){
				xr=730;
				yr=550;
			}
			red1=false;
			red2=true;
			red3=false;

			if(yel1==true){
				yel2=false;
				yel3=false;
				topy=true;
			}
			if(yel2==true){
				yel1=false;
				yel3=false;
				topy=false;
			}
			if(yel3==true){
				yel1=false;
				yel2=false;
				topy=true;
			}
			if(gre1==true){
				gre2=false;
				gre3=false;
				topg=false;
			}
			if(gre1==true&&yel1==false){
				gre2=false;
				gre3=false;
				topg=true;
			}
			if(gre2==true){
				gre1=false;
				gre3=false;
				topg=false;
			}
			if(gre3==true&&yel3==false){
				gre1=false;
				gre2=false;
				topg=true;
			}
			System.out.println("hi2 " + xr+ " "+yr+" ");
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub

		if(xr>=1110&&xr<=1410&&yr>=-100&&yr<=10000&&topr==true){
			if(gre3==true&&yel3==true){
				xr=1230;
				yr=650;
			}
			if(gre3==false&&yel3==true){
				xr=1230;
				yr=600;
			}
			if(gre3==true&&yel3==false){
				xr=1230;
				yr=600;
			}
			if(gre3==false&&yel3==false){
				xr=1230;
				yr=550;
			}
			red1=false;
			red2=false;
			red3=true;

			if(yel1==true){
				yel2=false;
				yel3=false;
				topy=true;
			}
			if(yel2==true){
				yel1=false;
				yel3=false;
				topy=true;
			}
			if(yel3==true){
				yel1=false;
				yel2=false;
				topy=false;
			}
			if(gre1==true&&yel1==false){
				gre2=false;
				gre3=false;
				topg=true;
			}
			if(gre2==true&&yel2==false){
				gre1=false;
				gre3=false;
				topg=true;
			}
			if(gre3==true){
				gre1=false;
				gre2=false;
				topg=false;
			}
			System.out.println("hi2 " + xr+ " "+yr+" ");
		}
		else if(red1==true){
			if(gre1==true&&yel1==true){
				xr=230;
				yr=650;
			}
			if(gre1==false&&yel1==true){
				xr=230;
				yr=600;
			}
			if(gre1==true&&yel1==false){
				xr=230;
				yr=600;
			}
			if(gre1==false&&yel1==false){
				xr=230;
				yr=550;
			}
		}
		else if(red2==true){
			if(gre2==true&&yel2==true){
				xr=730;
				yr=650;
			}
			else if(gre2==false&&yel2==true){
				xr=730;
				yr=600;
			}
			else if(gre2==true&&yel2==false){
				xr=730;
				yr=600;
			}
			else if(gre2==false&&yel2==false){
				xr=730;
				yr=550;
			}
		}
		else if(red3==true){
			if(gre3==true&&yel3==true){
				xr=1230;
				yr=650;
			}
			if(gre3==false&&yel3==true){
				xr=1230;
				yr=600;
			}
			if(gre3==true&&yel3==false){
				xr=1230;
				yr=600;
			}
			if(gre3==false&&yel3==false){
				xr=1230;
				yr=550;
			}
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub


		if(xy>=100&&xy<=400&&yy>=-100&&yy<=10000&&topy==true&&red1==false){
			if(gre1==true){
				xy=205;
				yy=600;
			}
			if(gre1==false){
				xy=205;
				yy=750;//650
			}
			yel1=false;
			yel2=false;
			yel3=true;

			if(gre1==true&&yel1==false){
				gre2=false;
				gre3=false;
				topg=true;
			}
			if(gre2==true&&yel2==false){
				gre1=false;
				gre3=false;
				topg=true;
			}
			if(gre3==true){
				gre1=false;
				gre2=false;
				topg=false;
			}
			System.out.println("higg " + xy+ " "+yy+" ");
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub 

		if(xy>=600&&xy<=900&&yy>=-100&&yy<=10000&&topy==true&&red2==false){
			if(gre2==true){
				xy=730;
				yy=600;
			}
			if(gre2==false){
				xy=730;
				yy=650;
			}
			yel1=false;
			yel2=true;
			yel3=false;

			if(gre1==true&&yel1==false){
				gre2=false;
				gre3=false;
				topg=true;
			}
			if(gre2==true&&yel2==false){
				gre1=false;
				gre3=false;
				topg=true;
			}
			if(gre3==true){
				gre1=false;
				gre2=false;
				topg=false;
			}
			System.out.println("hi2 " + xr+ " "+yr+" ");
		}

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub 

		if(xy>=1110&&xy<=1410&&yy>=-100&&yy<=10000&&topy==true&&red3==false){
			if(gre3==true){
				xy=1205;
				yy=600;
			}
			if(gre3==false){
				xy=1205;
				yy=650;
			}
			yel1=false;
			yel2=false;
			yel3=true;

			if(gre1==true&&yel1==false){
				gre2=false;
				gre3=false;
				topg=true;
			}
			if(gre2==true&&yel2==false){
				gre1=false;
				gre3=false;
				topg=true;
			}
			if(gre3==true){
				gre1=false;
				gre2=false;
				topg=false;
			}
			System.out.println("hi2 " + xr+ " "+yr+" ");
		}
		/*
		else if(yel1==true){
			if(gre1==true){
			 xy=205;
			 yy=600;
			}
			if(gre1==false){
				xy=205;
				yy=650;
			}
		}
		else if(yel2==true){
			if(gre2==true){
				 xy=730;
				 yy=600;
				}
				if(gre2==false){
					xy=730;
					yy=650;
				}
		}
		else if(yel3==true){
			if(gre3==true){
				 xy=1205;
				 yy=600;
				}
				if(gre3==false){
					xy=1205;
					yy=650;
				}
		}
		 */	
		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub 

		//////////////////////////////////////////////////////////////////////////////
		// TODO Auto-generated method stub

		repaint();
	}
}






