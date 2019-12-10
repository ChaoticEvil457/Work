package block_Fun;
import java.awt.Color;

public class Block {
	private int height;
	private int width;
	private int posy;
	private int posx;
	private Color color;
	public Block(int posx, int posy, int width, int height){
		this.height=height;
		this.width=width;
		this.posx=posx;
		this.posy=posy;
		color=Color.GREEN;
	}
	public int getHeight(){

		return this.height;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public int getWidth(){

		return this.width;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public int getPosx(){
		
		return this.posx;
	}
	public void setPosx(int posx){
		this.posx=posx;
	}
	public int getPosy(){
		
		return this.posy;
	}
	public void setPosy(int posy){
		this.posy=posy;
	}
	public void setColor(Color color){
		this.color=color;
	}
	public Color getColor(){
		return this.color;
	}
}
