import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	
	public Alien(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width,height,null);
	}
	void update(){
		super.update();
		y += 3;
	}
}
