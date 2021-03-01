import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	
	protected int x, y;			// Origin top left
	protected int xPrev, yPrev;	// x and y from previous frame
	protected int xVel, yVel;
	protected int width, height;
	protected BufferedImage spriteModel;
	
	protected int health;
	protected int bodyDamage;
	protected SpriteID id;
	protected int speed;
	
	Handler handler;
	int yVelMax = 45;
	protected boolean sideCollision = false;
	protected ObjectID standingOn = null;
	protected boolean falling = true;
	protected boolean facingRight = true;
	
	public Sprite(int x, int y, int width, int height, SpriteID id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getxPrev() {
		return xPrev;
	}

	public void setxPrev(int xPrev) {
		this.xPrev = xPrev;
	}

	public int getyPrev() {
		return yPrev;
	}

	public void setyPrev(int yPrev) {
		this.yPrev = yPrev;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public SpriteID getId() {
		return id;
	}

	public void setId(SpriteID id) {
		this.id = id;
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(x, y, width, height);
	}
}
