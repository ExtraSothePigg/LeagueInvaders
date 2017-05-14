import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	int speed;
	int fast;
	boolean left = false;
	boolean right = false;
	boolean a = false;
	boolean d = false;
public RocketShip(int x, int y, int w, int h){
	super();
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	speed = 2;
	fast = 7;
}
void update(){
	
	if(left){
		x -= speed;
	}if(right){
		x += speed;
	}if(a){
		x -= fast;
	}if(d){
		x += fast;
	}
	collisionBox.setBounds(x,y,4,4);
}
void draw(Graphics g){
	
	g.drawImage(GamePanel.rocketImg, x, y, 4, 4, null);
}
}
