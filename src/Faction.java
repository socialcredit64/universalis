

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Faction {
	
	private ImageIcon img;
	private ArrayList<String> tooltip;
	private int x,y,w,h;
	
	
	

	public Faction() {
		img = new ImageIcon();
		x=0;
		y=0;
		w=150;
		h=150;
		tooltip=new ArrayList<String>();
	}
	
	public Faction(int xv, int yv, ImageIcon i, ArrayList<String> text) {
		img = i;
		x=xv;
		y=yv;
		w=i.getIconWidth();
		h=i.getIconHeight();
		tooltip=text;
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

	public void setTip(String s) { //super.setTip("dgjdijdojf);
		tooltip.add(s);
	}
	
	
}


