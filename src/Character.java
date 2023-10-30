import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Character {
	
	private ImageIcon img;
	private float hp,armor,shield;
	private double apen,spen; //armor/shield penetration x%
	private int x,y,w,h;
	private String fac;
	private ArrayList<Weapon> gunslot;
	
	

	public Character() {
		img = new ImageIcon();
		x=0;
		y=0;
		w=150;
		h=150;
		gunslot=new ArrayList<Weapon>();
		hp=0;
	}
	
	public Character(int xv, int yv, int hitpoints, ImageIcon i, ArrayList<Weapon> g) {
		img = i;
		x=xv;
		y=yv;
		w=i.getIconWidth();
		h=i.getIconHeight();
		gunslot=g;
		hp=hitpoints;
		
	}
	
	public void drawShip(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, w, h, null);
		
	}
	public void drawLaser(Graphics g2d) {
		for(int i=0; i<gunslot.size(); ++i) {
			g2d.fillRect(gunslot.get(i).getX(), gunslot.get(i).getY(), gunslot.get(i).getW(), gunslot.get(i).getH());
		}
	
	}
	public void drawProjectile(Graphics g2d) {
		for(int i=0; i<gunslot.size(); ++i) {
			g2d.fillRect(gunslot.get(i).getX(), gunslot.get(i).getY(), 50, gunslot.get(i).getH());
			gunslot.get(i).move();
		}
	}
	
	
	
	public ImageIcon getImg() {
		return img;
	}
	
	public String toString() {
		return "default";
	}
	
	public void addgun(Weapon w) {
		
		gunslot.add(w);
	}
	
	public int getNSlots() {
		return gunslot.size();
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

	public double getApen() {
		return apen;
	}

	public void setApen(float apen) {
		this.apen = apen;
	}

	public double getSpen() {
		return spen;
	}

	public void setSpen(float spen) {
		this.spen = spen;
	}

	public ArrayList<Weapon> getGunslot() {
		return gunslot;
	}

	public void setGunslot(ArrayList<Weapon> gunslot) {
		this.gunslot = gunslot;
	}

	public String getFac() {
		return fac;
	}

	public void setFac(String fac) {
		this.fac = fac;
	}
	
	
}
