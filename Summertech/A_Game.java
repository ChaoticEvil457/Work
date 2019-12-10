package Summertech;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class A_Game extends JFrame implements MouseListener{//KeyListener{
	static int turn=1;
	static int xax=0;
	static int yax=0;
	static int zax=0;
	static int cax=0;
	static int vax=0;
	static int bax=0;
	static int nax=0;
	static int max=0;
	static int aax=0;
	static int sax=0;
	static int dax=0;
	static int fax=0;
	static int mausix=0;
	static int mausey=0;
	static String turn1=("X's Turn");
	static String turn2=("O's Turn");
	static boolean x=false;
	static boolean o=false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		////////////////////////////////////////
		A_Game game=new A_Game();
	}
	public A_Game(){
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(25,25,800,800);
		addMouseListener(this);
		JPanel print=new JPanel(){
			public void paint(Graphics g){
				g.setColor(Color.BLACK);
				g.fillRect(250,0,40,1000);
				g.fillRect(500,0,40,1000);
				g.fillRect(0,200,1000,40);
				g.fillRect(0,500,1000,40);
				g.setColor(Color.BLUE);
				Graphics2D g2=(Graphics2D)g;
				g2.setStroke(new BasicStroke(8));
				g.setFont(new Font("arial",Font.BOLD,50));
				if (turn==1){
					g.drawString(turn1,295,236);
				}
				if(turn==0){	
					g.drawString(turn2,290,236);

				}

				if(x&&turn==1){
					g.setColor(Color.BLUE);
					g.drawLine(xax, yax, zax, cax);
					g.drawLine(vax, bax, nax, max);
					turn=0;
					x=false;
				}

				if(o&&turn==0){
					g.setColor(Color.BLUE);
					g.drawOval(aax,sax,dax,fax);
					turn=1;
					o=false;
				}

				repaint();
			}
		};
		add(print);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mausix=e.getX();
		mausey=e.getY();
		if(mausix<=257 && mausey<=228 && turn==0 ){
			aax=10;
			sax=0;
			dax=200;
			fax=200;
			o=true;
		} 
		if(mausix<=257 && mausey<=228 && turn==1){
			xax=0;
			yax=0;
			zax=250;
			cax=200;
			vax=250;
			bax=0;
			nax=0;
			max=200;
			x=true;
		}
		if(mausix>=300 && mausey<=228 && mausix<=500 && turn==1){
			xax=295;
			yax=-5;
			zax=495;
			cax=200;
			vax=495;
			bax=-5;
			nax=295;
			max=200;
			x=true;
		}
		if(mausix>=300 && mausey<=228 && mausix<=500 && turn==0){
			aax=295;
			sax=-5;
			dax=200;
			fax=200;
			o=true;
		}
		if(mausix>=550 && mausey<=228 && turn==1){
			xax=550;
			yax=0;
			zax=820;
			cax=225;
			vax=780;
			bax=0;
			nax=545;
			max=200;
			x=true;
		}
		if(mausix>=550 && mausey<=228 && turn==0){
			aax=550;
			sax=0;
			dax=195;
			fax=195;
			o=true;
		}
		//////////////////////////////////////////////////////////////////////////////////////
		if(mausix<=255 && mausey>=270 && mausey<=530 && turn==1){
			xax=5;
			yax=500;
			zax=255;
			cax=240;
			vax=-5;
			bax=230;
			nax=275;
			max=530;
			x=true;
		}
		if(mausix<=255 && mausey>=270 && mausey<=530 && turn==0){
			aax=10;
			sax=250;
			dax=210;
			fax=210;
			o=true;
		}

		if(mausix<=510 && mausix>=300 && mausey>=270 && mausey<=530 && turn==1){
			xax=280;
			yax=510;
			zax=505;
			cax=240;
			vax=280;
			bax=230;
			nax=500;
			max=500;
			x=true;
		}
		if(mausix<510 && mausix>=300 && mausey>=270 && mausey<=530 && turn==0){
			aax=290;
			sax=250;
			dax=210;
			fax=210;
			o=true;
		}
		if(mausix>=550 && mausey>=270 && mausey<=530 && turn==1){
			xax=540;
			yax=240;
			zax=820;
			cax=535;
			vax=780;
			bax=240;
			nax=545;
			max=500;
			x=true;
		}
		if(mausix>=550 && mausey>=270 && mausey<=530 && turn==0){
			aax=560;
			sax=260;
			dax=195;
			fax=195;
			o=true;
		}
		/////////////////////////////////////////////////////////////////////////////
		if(mausix<=255 && mausey>=570 && mausey<=830 && turn==1){
			xax=-50;
			yax=800;
			zax=255;
			cax=540;
			vax=-5;
			bax=530;
			nax=320;
			max=830;
			x=true;
		}
		if(mausix<=255 && mausey>=570 && mausey<=830 && turn==0){
			aax=20;
			sax=550;
			dax=210;
			fax=210;
			o=true;
		}
		if(mausix<=510 && mausix>=300 && mausey>=570 && mausey<=830 && turn==1){
			xax=280;
			yax=780;
			zax=505;
			cax=540;
			vax=280;
			bax=530;
			nax=500;
			max=760;
			x=true;
		}
		if(mausix<510 && mausix>=300 && mausey>=570 && mausey<=830 && turn==0){
			aax=290;
			sax=550;
			dax=210;
			fax=210;
			o=true;
		}
		if(mausix>=550 && mausey>=570 && mausey<=830 && turn==1){
			xax=830;
			yax=800;
			zax=545;
			cax=540;
			vax=790;
			bax=540;
			nax=545;
			max=760;
			x=true;
		}
		if(mausix>=550 && mausey>=570 && mausey<=830 && turn==0){
			aax=560;
			sax=550;
			dax=195;
			fax=195;
			o=true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
//TODO Auto-generated method stub