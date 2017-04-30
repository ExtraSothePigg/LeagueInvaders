import javax.swing.JFrame;

public class LeagueInvaders {
	static final public int w = 500;
	static final public int h = 800;
	JFrame frame = new JFrame();
	GamePanel gp;
	
public static void main(String[] args){
	LeagueInvaders s = new LeagueInvaders();
	
}
private void setup() {
	frame.add(gp);
	frame.setSize(w, h);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gp.startGame();
	frame.addKeyListener(gp);
}
public LeagueInvaders(){
	gp = new GamePanel();
	
	frame.setVisible(true);
	setup();
	
}
}
