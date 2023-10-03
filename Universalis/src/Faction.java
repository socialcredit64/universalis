

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Faction {
	
	private ImageIcon img;
	private float hp,armor,shield,apen,spen; //armor/shield penetration x%
	private int x,y,w,h;
	private Weapon unknown;
	
	

	public Faction() {
		img = new ImageIcon();
		x=0;
		y=0;
		w=150;
		h=150;
	}
	
	public Faction(int xv, int yv, ImageIcon i) {
		img = i;
		x=xv;
		y=yv;
		w=0;
		h=0;

	}
	
	public void drawFaction(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, w, h, null);
	}
	
	public String toString() {
		return "faction";
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

	
	
	
}


