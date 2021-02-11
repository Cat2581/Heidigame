import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;
	Rectangle collisionbox;

	GameObject(int x, int y, int width, int height) {
		this.y = y;
		this.x = x;
		this.width = width;
		this.height = height;
		speed = 10;
		collisionbox = new Rectangle(x, y, width, height);
	}

	void update() {
		collisionbox.setBounds(x, y, width, height);
	}
}
