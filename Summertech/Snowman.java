package Summertech;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snowman extends JFrame{

	public static void main(String[] args) {
		new Snowman();
	}
	
	public Snowman(){
		setVisible(true);
		setBounds( 0,0,1920,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pan=new JPanel(){
			public void paint(Graphics g){
				g.setColor(Color.BLACK);
				g.fillOval(710,500,380,380);
				g.fillOval(745,290,300,300);
				g.fillOval(750,90,250,250);
				g.setColor(Color.WHITE);
				g.fillOval(720,510,360,360);
				g.fillOval(755,300,280,280);
				g.fillOval(760,100,230,230);
				g.setColor(Color.BLACK);
				g.fillOval(800,170,40,40);
				g.fillOval(900,168,40,40);
				g.fillOval(780,235,25,25);
				g.fillOval(805,250,25,25);
				g.fillOval(835,255,25,25);
				g.fillOval(865,260,25,25);
				g.fillOval(895,255,25,25);
				g.fillOval(925,250,25,25);
				g.fillOval(950,235,25,25);
				g.fillPolygon(new int[]{770,830,600,600},new int[]{150,100,90,100},4);
				g.setColor(Color.ORANGE.darker().darker().darker());
				g.fillPolygon(new int[]{755,755,510,510},new int[]{470,480,310,300},4);
				//arm #2///////////
				g.fillPolygon(new int[]{1250,1250,1040,1040},new int[]{310,300,470,480},4);
			}
		};
		add(pan);
		addMouseListener(new MouseListener(){

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
			public void mousePressed(MouseEvent arg0) {
				System.out.print(arg0.getX());
				System.out.print(",");
				System.out.println(arg0.getY());
				
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}