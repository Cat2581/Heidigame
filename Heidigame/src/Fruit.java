import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fruit extends GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	public boolean hidden = false;
	public boolean red = false;
	public boolean green = false;
	String fruit;

	Fruit(int x, int y, int width, int height, String fruit) {
		super(x, y, width, height);
		this.fruit = fruit;
		if (needImage) {
			loadImage(fruit);
		}

	}

	void draw(Graphics g) {
		if (green) {
			g.setColor(new Color(0, 250, 0, 45));
			g.fillRect(x, y, width, height);
		}
		if (red) {
			g.setColor (new Color(250, 0, 0, 45) );
			g.fillRect(x, y, width, height);
		}
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		if (hidden == true) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
