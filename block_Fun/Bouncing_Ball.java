package block_Fun;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bouncing_Ball extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bouncing_Ball();

	}
	int x=500;
	int y=100;
	boolean side=true;
	boolean up=true;
	int backR=0;
	int backG=0;
	int backB=0;
	
	Block block1=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
	Block block2=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
	Block block3=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
	Block block4=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
	public Bouncing_Ball(){
		setVisible(true);
		setBounds(0,0,1280,775);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Colors");
		JPanel pan=new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color(backR,backG,backB));
				g.fillRect(0,0,1920,1000);
				g.setColor(block1.getColor());
				g.fillRect(block1.getPosx(),block1.getPosy(),block1.getWidth(),block1.getHeight());
				g.setColor(block2.getColor());
				g.fillRect(block2.getPosx(),block2.getPosy(),block2.getWidth(),block2.getHeight());
				g.setColor(block3.getColor());
				g.fillRect(block3.getPosx(),block3.getPosy(),block3.getWidth(),block3.getHeight());
				g.setColor(block4.getColor());
				g.fillRect(block4.getPosx(),block4.getPosy(),block4.getWidth(),block4.getHeight());
				g.setColor(new Color((x%240)+10,(y%240)+10,((x+y)%240)+10));
				g.fillOval(x,y,40,40);
				
				if(x>1250){
					side=true;
				}
				if(x<0){
					side=false;
				}
				if(y>735){
					up=true;
				}
				if(y<0){
					up=false;
					}
				
				if(block1.getPosy()-40==y&&up==false&&x+40>block1.getPosx()&&x<block1.getPosx()+block1.getWidth()){
					up=true;
					block1=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block1.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(y==block1.getPosy()+block1.getHeight()&&up==true&&x+40>block1.getPosx()&&x<block1.getPosx()+block1.getWidth()){
					up=false;
					block1=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block1.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block1.getPosx()-40&&side==false&&y+40>block1.getPosy()&&y<block1.getPosy()+block1.getHeight()){
					side=true;
					block1=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block1.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block1.getPosx()+block1.getWidth()&&side==true&&y+40>block1.getPosy()&&y<block1.getPosy()+block1.getHeight()){
					side=false;
					block1=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block1.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				
				
				if(block2.getPosy()-40==y&&up==false&&x+40>block2.getPosx()&&x<block2.getPosx()+block2.getWidth()){
					up=true;
					block2=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(y==block2.getPosy()+block2.getHeight()&&up==true&&x+40>block2.getPosx()&&x<block2.getPosx()+block2.getWidth()){
					up=false;
					block2=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block2.getPosx()-40&&side==false&&y+40>block2.getPosy()&&y<block2.getPosy()+block2.getHeight()){
					side=true;
					block2=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block2.getPosx()+block2.getWidth()&&side==true&&y+40>block2.getPosy()&&y<block2.getPosy()+block2.getHeight()){
					side=false;
					block2=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				
				if(block3.getPosy()-40==y&&up==false&&x+40>block3.getPosx()&&x<block3.getPosx()+block3.getWidth()){
					up=true;
					block3=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block3.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(y==block3.getPosy()+block3.getHeight()&&up==true&&x+40>block3.getPosx()&&x<block3.getPosx()+block3.getWidth()){
					up=false;
					block3=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block3.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block3.getPosx()-40&&side==false&&y+40>block3.getPosy()&&y<block3.getPosy()+block3.getHeight()){
					side=true;
					block3=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block3.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block3.getPosx()+block3.getWidth()&&side==true&&y+40>block3.getPosy()&&y<block3.getPosy()+block3.getHeight()){
					side=false;
					block3=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block3.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				
				
				if(block4.getPosy()-40==y&&up==false&&x>block4.getPosx()&&x<block4.getPosx()+block4.getWidth()){
					up=true;
					block4=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block4.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(y==block4.getPosy()+block4.getHeight()&&up==true&&x>block4.getPosx()&&x<block4.getPosx()+block4.getWidth()){
					up=false;
					block4=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block4.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block4.getPosx()-40&&side==false&&y>block4.getPosy()&&y<block4.getPosy()+block4.getHeight()){
					side=true;
					block4=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block4.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				if(x==block4.getPosx()+block4.getWidth()&&side==true&&y>block4.getPosy()&&y<block4.getPosy()+block4.getHeight()){
					side=false;
					block4=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block4.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
				
				if(up==true){
					y-=1;
				}
				else if(up==false){
					y+=1;
				}
				if(side==true){
					x-=1;
				}
				else if(side==false){
					x+=1;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		};
		add(pan);
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
					block4=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block4.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
					block3=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block3.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
					block2=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
					block1=new Block(((int)(Math.random()*380))*5,((int)(Math.random()*190))*5,((int)(Math.random()*100))*5,((int)(Math.random()*100))*5);
					block1.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
