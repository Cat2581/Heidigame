import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements MouseListener, ActionListener, MouseMotionListener, KeyListener {
	JLabel[][] cards = new JLabel[3][3];
	BufferedImage[] images = new BufferedImage[9];
	Fruit[][] fruit = new Fruit[3][3];
	String[][] names = { { "apple.png", "avocado.png", "Banana.png" }, { "broccoli.png", "cucumber.png", "Mango.png" },
			{ "orange.png", "Papaya.png", "Watermelon.png" } };
	ArrayList<String> shuffle;
	JPanel bottomhalf = new JPanel();
	Timer frameDraw;
	Timer blockertimer;
	Fruit starfruit;
	CustomCursor cursor;
	Random random;
	Font titleFont;
	Font subtitleFont;
	int score = 0;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	// public static BufferedImage image;

	GameBoard() {
		currentState = MENU;
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		random = new Random();
		starfruit = new Fruit(160, 50, 150, 150, names[random.nextInt(names.length)][random.nextInt(names.length)]);
		cursor = new CustomCursor(0, 0, 25, 25);
		blockertimer = new Timer(5000, this);
		blockertimer.start();
		titleFont = new Font("Arial", Font.PLAIN, 70);
		subtitleFont = new Font("Arial", Font.ROMAN_BASELINE, 35);
		shuffle = new ArrayList<String>();
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				shuffle.add((names[i][j]));
			}
		}
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				fruit[i][j] = new Fruit(10 + 160 * i, 250 + 160 * j, 140, 140,
						shuffle.remove(random.nextInt(shuffle.size())));
			}
		}
		starfruit.hidden = true;
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.PINK);
		g.drawString("Memory 101", 45, 100);
		g.setFont(subtitleFont);
		g.setColor(Color.PINK);
		g.drawString("By Heidi Weise", 240, 170);
		g.setFont(subtitleFont);
		g.setColor(Color.DARK_GRAY);
		g.drawString("- Press ENTER to play!", 15, 450);
		g.setFont(subtitleFont);
		g.setColor(Color.DARK_GRAY);
		g.drawString("- If its your first time playing", 15, 325);
		g.setFont(subtitleFont);
		g.setColor(Color.DARK_GRAY);
		g.drawString("press SPACE for instructions", 15, 370);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				fruit[i][j].draw(g);
			}
		}
		starfruit.draw(g);
		cursor.draw(g);
		g.setFont(subtitleFont);
		g.setColor(Color.pink);
		g.drawString("Your score = " + score, 10, 35);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		//g.drawString("text", x, y);
	}

	public void randomizing() {
		starfruit = new Fruit(160, 50, 150, 150, names[random.nextInt(names.length)][random.nextInt(names.length)]);
		blockertimer = new Timer(5000, this);
		blockertimer.start();
		shuffle = new ArrayList<String>();
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				shuffle.add((names[i][j]));
			}
		}
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				fruit[i][j] = new Fruit(10 + 160 * i, 250 + 160 * j, 140, 140,
						shuffle.remove(random.nextInt(shuffle.size())));
			}
		}
		starfruit.hidden = true;
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}
	void removeImage() {
		bottomhalf.removeAll();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				Rectangle fruitbox = fruit[i][j].collisionbox;
				Rectangle cursorbox = cursor.collisionbox;
				if (fruitbox.intersects(cursorbox)) {
					if (fruit[i][j].fruit.equals(starfruit.fruit)) {
						score += 1;
						fruit[i][j].green = true;
						fruit[i][j].hidden = false;
					} else {
						JOptionPane.showMessageDialog(null, "You got it wrong click \"ok\" to know where it was");
						findCorrectFruit();
						fruit[i][j].red = true;
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Nice! Now press \"ok\" to start new round");
		randomizing();
	}

	public void findCorrectFruit() {
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				if (fruit[i][j].fruit.equals(starfruit.fruit)) {
					fruit[i][j].hidden = false;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		removeImage();
		repaint();
	};

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == frameDraw) {
			repaint();
		}
		if (blockertimer == e.getSource()) {
			blockertimer.stop();
			for (int i = 0; i < fruit.length; i++) {
				for (int j = 0; j < fruit.length; j++) {
					fruit[i][j].hidden = true;
				}
			}
			starfruit.hidden = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseY = e.getY();
		int mouseX = e.getX();
		cursor.update(mouseY, mouseX);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
