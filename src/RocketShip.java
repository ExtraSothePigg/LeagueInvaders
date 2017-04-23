import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	
public RocketShip(int x, int y, int w, int h){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
}
void update(Graphics g){
	
}
void draw(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
}
