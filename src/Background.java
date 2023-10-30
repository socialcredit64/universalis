import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Background {
	private int x,y,w,h;
	private int dx;
	private ImageIcon img;
	public Background() {
		x=0;
		y=0;
		w=150;
		h=150;
		img= new ImageIcon();
		dx=0;
	}
	public Background(int xv,int yv, ImageIcon i) {
		x=xv;
		y=yv;
		w=1800;
		h=1600;
		img=i;
		dx=1;
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
	public void scroll() {
		x-=dx;
	}
	public void drawBackground(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, 9000, 3000, null);
		

	}
	public ImageIcon getimg() {
		return img;
	}
}
