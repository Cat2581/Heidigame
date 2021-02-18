import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class CustomCursor extends GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	public boolean hidden = false;

	CustomCursor(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImage("cursor.png");
		}

	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}
	}

	void update(int y, int x) {
		this.y = y;
		this.x = x;
		super.update();
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
