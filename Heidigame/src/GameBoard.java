import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	JLabel[][] cards = new JLabel[3][3];
	BufferedImage[] images = new BufferedImage[9];
	//public static BufferedImage image;

	GameBoard() {
		JPanel tophalf = new JPanel();
		JPanel bottomhalf = new JPanel();
		tophalf.setBackground(Color.YELLOW);
		bottomhalf.setBackground(Color.CYAN);
		this.add(tophalf);
		this.add(bottomhalf);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		loadImages();
		System.out.println("action`");
		cards [0] [0] = new JLabel();
		cards [0] [0].setIcon(new ImageIcon(images[0]));
		// Add image to JLabel
		bottomhalf.add(cards [0] [0]);
	}

	void loadImages() {
		try {
			images[0] = ImageIO.read(this.getClass().getResourceAsStream("apple.png"));
			images[1] = ImageIO.read(this.getClass().getResourceAsStream("avocado.png"));
			images[2] = ImageIO.read(this.getClass().getResourceAsStream("Banana.png"));
			images[3] = ImageIO.read(this.getClass().getResourceAsStream("broccoli.png"));
			images[4] = ImageIO.read(this.getClass().getResourceAsStream("cucumber.png"));
			images[5] = ImageIO.read(this.getClass().getResourceAsStream("Mango.png"));
			images[6] = ImageIO.read(this.getClass().getResourceAsStream("orange.png"));
			images[7] = ImageIO.read(this.getClass().getResourceAsStream("Papaya.png"));
			images[8] = ImageIO.read(this.getClass().getResourceAsStream("Watermelon.png"));
		} catch (Exception e) {

		}
	}
}
