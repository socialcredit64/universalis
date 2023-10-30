import javax.swing.ImageIcon;

public class Weapon {
	private int dmg, as, dx, dy, x,y,w,h;
	private double apen, spen;
	private ImageIcon img;
	
	public Weapon() {
		dmg=0;
		dx=0;
		dy=0;
		x=0;
		y=0;
		w=0;
		h=0;
		apen=1; //100% damage modifier (penetration)
		spen=1;
		img=new ImageIcon();
	}
	
	public Weapon(int d, int a, int dxv, int dyv, int xv, int yv, int wv, int hv, ImageIcon img) {
		dmg=d;
		as = a;
		dx=dxv;
		dy=dyv;
		x=xv;
		y=yv;
		w=wv;
		h=hv;
		img = new ImageIcon();
	}
	
	
	
	
	
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
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
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public int getAs() {
		return as;
	}
	public void move() {
		 x+=dx;
	 }
	public void setAs(int as) {
		this.as = as;
	}
	
}

