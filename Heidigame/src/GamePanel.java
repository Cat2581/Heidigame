import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static boolean needImage = true;
	public static boolean gotImage = false;

	final int MENU = 0;
	final int INSTRUCTIONS = 3;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font subtitleFont;
	Font font;
	ObjectManager Om;
	Timer frameDraw;

	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		titleFont = new Font("Arial", Font.BOLD, 80);
		subtitleFont = new Font("Arial", Font.PLAIN, 30);
		font = new Font("Arial", Font.BOLD, 48);
		// Om = new ObjectManager(rs);
		// if (needImage) {
		// loadImage("space.png");
		// }
	}

	void startGame() {
	}

	void updateMenuState() {
	}

	void updateInstructionsState() {

	}

	void updateGameState() {
		// Om.update();
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Memory 101", 10, 200);
		g.setFont(subtitleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to play", 100, 400);
		g.setFont(subtitleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 50, 500);
	}

	void drawInstructionsState(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Instructions + Rules:", 0, 80);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("1. You need to use your mouse to", 5, 150);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("click", 30, 180);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("2.", 5, 230);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("3.", 5, 310);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("4.", 5, 390);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("5.", 5, 470);
		g.setFont(subtitleFont );
		g.setColor(Color.black);
		g.drawString("6.", 5, 550);
		g.setFont(subtitleFont);
		g.setColor(Color.WHITE);
		g.drawString("Now press ENTER to play!", 65, 630);
		g.setFont(font);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		if (gotImage) {
			// g.drawImage(image, 0, 0, Memory.WIDTH, Memory.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		}
		// Om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 3, 300);
		g.setFont(subtitleFont);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to play again", 65, 350);

	}

	void loadImage(String imageFile) {
		if (needImage) {
			needImage = false;
		}
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == INSTRUCTIONS) {
			drawInstructionsState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == INSTRUCTIONS) {
			updateInstructionsState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == INSTRUCTIONS) {
				currentState = GAME;
			}
			else if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			currentState = INSTRUCTIONS;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}