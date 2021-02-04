import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements MouseListener, ActionListener {
	JLabel[][] cards = new JLabel[3][3];
	BufferedImage[] images = new BufferedImage[9];
	Fruit[][] fruit = new Fruit[3][3];
	String[][] names = { { "apple.png", "avocado.png", "Banana.png" }, { "broccoli.png", "cucumber.png", "Mango.png" },{ "orange.png", "Papaya.png", "Watermelon.png" } };
	ArrayList <String> shuffle; 
	JPanel bottomhalf = new JPanel();
	Timer frameDraw;
	Timer blockertimer;
	Fruit starfruit;
	Random random;
	// public static BufferedImage image;

	GameBoard() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		random = new Random();
		starfruit = new Fruit(160 ,50, 150, 150, names[random.nextInt(names.length)][random.nextInt(names.length)] );
		blockertimer = new Timer(5000,this);
		blockertimer.start();
		JPanel tophalf = new JPanel();
		tophalf.setBackground(Color.YELLOW);
		bottomhalf.setBackground(Color.CYAN);
		// this.add(tophalf);
		// this.add(bottomhalf);
		shuffle =  new ArrayList <String> ();
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				shuffle.add((names[i][j]));
			}
		}
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				fruit[i][j] = new Fruit(10 + 160 * i, 250 + 160 * j, 140, 140, names[i][j]);
			}
		}
		starfruit.hidden = true;
//		cards[0][0] = new JLabel();
//		cards[0][0].setIcon(new ImageIcon(images[0]));
//		bottomhalf.add(cards[0][0]);
//		cards[0][1] = new JLabel();
//		cards[0][1].setIcon(new ImageIcon(images[1]));
//		bottomhalf.add(cards[0][1]);
//		cards[0][2] = new JLabel();
//		cards[0][2].setIcon(new ImageIcon(images[2]));
//		bottomhalf.add(cards[0][2]);
//		cards[1][0] = new JLabel();
//		cards[1][0].setIcon(new ImageIcon(images[3]));
//		bottomhalf.add(cards[1][0]);
//		cards[1][1] = new JLabel();
//		cards[1][1].setIcon(new ImageIcon(images[4]));
//		bottomhalf.add(cards[1][1]);
//		cards[1][2] = new JLabel();
//		cards[1][2].setIcon(new ImageIcon(images[5]));
//		bottomhalf.add(cards[1][2]);
//		cards[2][0] = new JLabel();
//		cards[2][0].setIcon(new ImageIcon(images[6]));
//		bottomhalf.add(cards[2][0]);
//		cards[2][1] = new JLabel();
//		cards[2][1].setIcon(new ImageIcon(images[7]));
//		bottomhalf.add(cards[2][1]);
//		cards[2][2] = new JLabel();
//		cards[2][2].setIcon(new ImageIcon(images[8]));
//		bottomhalf.add(cards[2][2]);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Memory.WIDTH, Memory.HEIGHT);
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < fruit.length; j++) {
				fruit[i][j].draw(g);
			}
		}
		starfruit.draw(g);
	}

	void removeImage() {
		bottomhalf.removeAll();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		removeImage();
		repaint();
	}

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

}
