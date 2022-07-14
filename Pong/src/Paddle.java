
public class Paddle {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dy;
	public int score;
	//private String background;

	public Paddle() {
		x= 0;
		y=0;
		width=0;
		height=0;
		dy=0;
		score=0;
		//background= "ocean.jpg";
	}
	public Paddle(int posx, int posy, int w, int h) {
		x=posx;
		y=posy;
		width=w;
		height=h;
		dy=0;
		score=0;
		//background="ocean.jpg";
	}
	/*public String getBackground() {
		return background;
	}*/
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void move() {
		y+=dy;
	}
	public void setdy(int dyvalue) {
		dy=dyvalue;
	}
	public int getScore() {
		return score;
	}
	public void addPoint(int s) {
		score+=s;
	}
}
