import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Character {
	
	private ImageIcon img;
	private float hp,armor;
	private double apen,spen; //armor/shield penetration x%
	private int x,y,w,h;
	private int as;
	private float baseHP, maxHP; 
	//base HP is upgraded via core upgrades while max hp is base+armor
	private String fac;
	private ArrayList<Weapon> gunslot;
	
	int hplocationX, hplocationY;
	

	public Character() {
		img = new ImageIcon();
		x=0;
		y=0;
		w=150;
		h=150;
		gunslot=new ArrayList<Weapon>();
		hp=0;
		baseHP=0;
		armor=0;
		hplocationX=70;
		hplocationY=70;
		as=0;

	}
	
	public Character(int xv, int yv, int hitpoints, ImageIcon i, ArrayList<Weapon> g) {
		img = i;
		x=xv;
		y=yv;
		w=i.getIconWidth();
		h=i.getIconHeight();
		gunslot=g;
		baseHP=hitpoints;
		armor=0;
		hplocationX=70;
		hplocationY=70;
		as=0;
	}
	
	public void defaultEquip() {
		if(gunslot.size()<=3) {
			if(fac=="UNE") {
				addgun(new Laser(x+w+30,y+h/2));
			}
			if(this.getFac()=="Eliminator") {
				addgun(new Railgun(x+w+30,y+h/2));
			}
			if(this.getFac()=="Blorg") {
				addgun(new Missile(x+w+30,y+h/2));
			}
			if(this.getFac()=="Swarm") {
				addgun(new Strikecraft(x+w+30,y+h/2));
			}
		}

	}



	public void drawShip(Graphics g2d) {
		int gradient = 200;
		g2d.drawImage(img.getImage(), x, y, w, h, null);
		
		//g2d.drawRect();
		//g2d.fillRect(70,70,Math.round((hp/maxHP)*750),50);
		
	}
	
	
	public void drawLaser(Graphics g2d) {
		//System.out.println(gunslot.size());
		for(int i=0; i<gunslot.size(); ++i) {
			g2d.fillRect(gunslot.get(i).getX(), gunslot.get(i).getY(), gunslot.get(i).getW(), gunslot.get(i).getH());
			//System.out.println("drawn");
		}
	
	}
	public void drawProjectile(Graphics g2d) {
		for(int i=0; i<gunslot.size(); ++i) {
			g2d.fillRect(gunslot.get(i).getX(), gunslot.get(i).getY(), 50, gunslot.get(i).getH());
			gunslot.get(i).move();
		}
	}
	

	public void addgun(Weapon w) {

		gunslot.add(w);
	}
	
	
	
	public ImageIcon getImg() {
		return img;
	}
	
	public String toString() {
		return "default";
	}
	
	
	public int getNSlots() {
		return gunslot.size();
	}
	
	public ArrayList<Weapon> getWeaponsList(){
		return gunslot;
	}
	
	public int getAS() {
		return as;
	}

	public void setAS(int as) {
		this.as = as;
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
	
	public float getbaseHP(){
		return baseHP;
	}

	public void setbaseHP(float x){
		baseHP=x;
	}

	

	public float gethp(){
		return hp;
	}

	public void setMaxHP(){
		maxHP=baseHP+armor;
	}

	public void setStartHP(){
			hp=baseHP+armor;
		}

	//difference: hp is mutable.
	public void setHPlocation(int x, int y){
		hplocationX=x;
		hplocationY=y;

	}

	public float getmaxHP(){
		return maxHP;
	}

	public void hit(int x){
		hp-=x;
	}
}
