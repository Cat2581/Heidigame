import javax.swing.JFrame;

public class Memory {

	public static final int HEIGHT = 750;
	public static final int WIDTH = 500;
	JFrame frame;
	GamePanel gpanel;
	GameBoard gboard;

	Memory() {
		frame = new JFrame();
		gpanel = new GamePanel();
		gboard = new GameBoard();
	}

	void setup() {
		frame.add(gboard);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.addKeyListener(gpanel);
	}

	public static void main(String[] args) {
		new Memory().setup();
	}

}