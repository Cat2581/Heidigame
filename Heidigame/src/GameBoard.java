import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	JLabel[][] cards = new JLabel[3][3];
	BufferedImage[] images = new BufferedImage[9];
	public static BufferedImage image;
	
	GameBoard() {
		JPanel tophalf = new JPanel();
		JPanel bottomhalf = new JPanel();
		tophalf.setBackground(Color.YELLOW);
		tophalf.setBackground(Color.CYAN);
		this.add(tophalf);
		this.add(bottomhalf);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	void loadImages() {
		try {
			images[0] = ImageIO.read(this.getClass().getResourceAsStream("apple.png"));
			images[1]= ImageIO.read(this.getClass().getResourceAsStream("avocado.jpg"));
			images[2]= ImageIO.read(this.getClass().getResourceAsStream("Banana.jpg"));
			images[3]= ImageIO.read(this.getClass().getResourceAsStream("broccoli.jpg"));
			images[4]= ImageIO.read(this.getClass().getResourceAsStream("cucumber.jpg"));
			images[5]= ImageIO.read(this.getClass().getResourceAsStream("Mango.jpg"));
			images[6]= ImageIO.read(this.getClass().getResourceAsStream("orange.jpg"));
			images[7]= ImageIO.read(this.getClass().getResourceAsStream("Papaya.jpg"));
			images[8]= ImageIO.read(this.getClass().getResourceAsStream("Watermelon.jpg"));
		} catch (Exception e) {

		}
	}
}
