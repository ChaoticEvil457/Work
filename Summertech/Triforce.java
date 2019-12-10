package Summertech;

import java.awt.*;
import javax.swing.*;
public class Triforce extends JFrame {
	int [] x={400,0,a};
	int [] y={0,600,600};
	int [] x1={asd+(as/2),asd,asd+as};
	int [] y1={asdf*2,asdf,asdf};
	static int Int=780;
	static int asd=780/4+5;
	static int asdf=300;
	static int a=780;
	static int as=390;
	static Boolean Double=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triforce tri=new Triforce();
		
		
		
		
	}
	/////////////////////////////////////
	public Triforce(){
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(25,25,800,800);
		JPanel print=new JPanel(){
			public void paint(Graphics g){
				g.setColor(Color.BLACK);
				g.fillPolygon(x,y,3);
				g.setColor(Color.BLUE);
				//g.fillPolygon(x1,y1,3);
					Integer(0,300,4,g,300);
			}
		};
		add(print);
	}
	public static Integer Integer(int Intx, int Inty, int Intz,Graphics g, int h){
		if(Intz==128){
		return(null);
		}
		Intx=Int/Intz;
		int w=595-Intx;
		int e=400-Inty;
		int q=Int-Intx;
		//left
		int [] x2={Intx+(as/2),Intx,Intx+as};
		int [] y2={Inty+h,Inty,Inty};
		//top
		int [] x3={w+(as/2-200),w-200,w-200+as};
		int [] y3={e+h+200,e+200,e+200};
		//right
		int [] x4={q+(as/2)-Intx*2,q-Intx*2,q+as-Intx*2};
		int [] y4={Inty+h,Inty,Inty};
		as=as/2;
		g.fillPolygon(x2,y2,3);
		g.fillPolygon(x3,y3,3);
		g.fillPolygon(x4,y4,3);
		Integer(Intx,Inty+h/2,Intz*2,g,h/2);
		
		return(null);
	}
}