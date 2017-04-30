import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	int speed;
public RocketShip(int x, int y, int w, int h){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	speed = 5;
}
void update(Graphics g){
	
}
void draw(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
}
