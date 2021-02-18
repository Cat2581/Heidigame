import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fruit extends GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	public boolean hidden = false;
	String fruit;

	Fruit(int x, int y, int width, int height, String fruit) {
		super(x, y, width, height);
		this.fruit = fruit;
		if (needImage) {
			loadImage(fruit);
		}

	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		if (hidden == true) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
			System.out.println("run");
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
