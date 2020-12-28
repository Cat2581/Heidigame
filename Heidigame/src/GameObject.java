
public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;

	GameObject(int x, int y, int width, int height) {
		this.y = y;
		this.x = x;
		this.width = width;
		this.height = height;
		int speed = 10;
	}

	void update() {

	}

	public void right() {
		x += speed;
	}

	public void left() {
		y -= speed;
	}

	public void up() {
		x += speed;
	}

	public void down() {
		y -= speed;
	}
}
