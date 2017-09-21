public class Coordinates {
	private int x;
	private int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void addX(int speed) {
		x += speed;
	}

	public void addY(int speed) {
		y += speed;
	}

	public void subX(int speed) {
		x -= speed;
	}

	public void subY(int speed) {
		y -= speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}