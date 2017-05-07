import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	RocketShip rocket;
	ObjectManager manager = new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	int bulletCount = 20;

	void startGame(){
		timer.start();
	}
void updateMenuState(){
		
	}
	void updateGameState(){
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if(rocket.isAlive == false){
			currentState = END_STATE;
			manager.reset();
			rocket = new RocketShip(rocket.x,rocket.y,rocket.width,rocket.height);
			manager.addObject(rocket);
			bulletCount = 20;
		}
		manager.getScore();
	}
	void updateEndState(){
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("League Invaders", 75, 300);
		g.drawString("Press enter to start", 50, 400);
	}
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString(""+bulletCount, 400, 700);
		manager.draw(g);
		
		
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 85, 300);
		g.drawString("You should give up", 45, 500);
	}
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}
	}
	
	
	
	public GamePanel(){
		timer = new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.PLAIN,48);
		rocket = new RocketShip(250,700,50,50);
		manager.addObject(rocket);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			currentState++;
		}
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			rocket.left = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rocket.right = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE&&bulletCount > 0){
			manager.addObject(new Projectile(rocket.x + 20, rocket.y, 10, 10));
			bulletCount -= 1;
			System.out.println(bulletCount);
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
			rocket.a = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_D){
			rocket.d = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			rocket.left = false;
		}if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rocket.right = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
			rocket.a = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D){
			rocket.d = false;
		}
		
	}
	
	
}
