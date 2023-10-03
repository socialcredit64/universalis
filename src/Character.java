import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Character {
	
	private ImageIcon img;
	private float hp,armor,shield,apen,spen; //armor/shield penetration x%
	private int x,y,w,h;
	private Weapon unknown;
	
	

	public Character() {
		img = new ImageIcon();
		x=0;
		y=0;
		w=150;
		h=150;
		unknown=new Weapon();
		hp=0;
	}
	
	public Character(int xv, int yv, int hitpoints, int wv, int hv, ImageIcon i, Weapon gun) {
		img = i;
		x=xv;
		y=yv;
		w=wv;
		h=hv;
		unknown=gun;
		hp=hitpoints;
		
	}
	
	public void drawShip(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, w, h, null);
		System.out.println("this");
	}
	public ImageIcon getImg() {
		return img;
	}
	
	public String toString() {
		return "default";
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

	public float getArmor() {
		return armor;
	}

	public void setArmor(float armor) {
		this.armor = armor;
	}

	public float getShield() {
		return shield;
	}

	public void setShield(float shield) {
		this.shield = shield;
	}

	public float getApen() {
		return apen;
	}

	public void setApen(float apen) {
		this.apen = apen;
	}

	public float getSpen() {
		return spen;
	}

	public void setSpen(float spen) {
		this.spen = spen;
	}
	
	
}
