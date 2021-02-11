import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Memory {

	public static final int HEIGHT = 750;
	public static final int WIDTH = 500;
	JFrame frame;
	GameBoard gboard;

	Memory() {
		frame = new JFrame();
		gboard = new GameBoard();
	}

	void setup() {
		frame.add(gboard);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(gboard);
		frame.addMouseMotionListener(gboard);
		
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		frame.getContentPane().setCursor(blankCursor);

	}

	public static void main(String[] args) {
		new Memory().setup();
	}

}