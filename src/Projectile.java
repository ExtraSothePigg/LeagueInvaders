import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int x;
	int y;
	int width;
	int height;
	int speed = 5;
public Projectile(int x, int y, int width, int height){
	super();
this.x = x;
this.y = y;
this.width = width;
this.height = height;
	
}
void draw(Graphics g){
	g.drawImage(GamePanel.bulletImg, x, y, width,height,null);
}
void update(){
	super.update();
	y += -speed;
	if(y <= 0){
		isAlive = false;
	}
	collisionBox.setBounds(x,y,width,height);
}
}
