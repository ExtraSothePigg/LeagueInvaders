import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	
	void startGame(){
		timer.start();
	}
void updateMenuState(){
		
	}
	void updateGameState(){
		rocket.update();
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
		rocket.draw(g);
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
		timer = new Timer(100/60,this);
		titleFont = new Font("Arial",Font.PLAIN,48);
		rocket = new RocketShip(250,700,50,50);

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
		System.out.println("type");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			currentState++;
		}
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("release");
		
	}
	
	
}
