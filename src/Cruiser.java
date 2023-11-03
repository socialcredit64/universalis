import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Cruiser extends Character{
	public Cruiser() {
		super();
	}
	//changes to create multiple cruisers
	public Cruiser(int x, int y, ArrayList<Weapon> gunslot) {
		super(x,y,1000,new ImageIcon("Cruiser.png"), gunslot);
		defaultEquip();
	}
	public String toString() {
		return "a cruiser-class" + super.getImg().getImage();
	}
	
	private void defaultEquip() {
		if(this.getNSlots()<=3) {
			if(this.getFac()=="UNE") {
				super.addgun(new Laser(this.getX()+this.getW()+30,this.getY()+this.getH()/2));
			}
			if(this.getFac()=="Eliminator") {
				super.addgun(new Railgun(this.getX()+this.getW()+30,this.getY()+this.getH()/2));
			}
			if(this.getFac()=="Blorg") {
				super.addgun(new Missile(this.getX()+this.getW()+30,this.getY()+this.getH()/2));
			}
			if(this.getFac()=="Swarm") {
				super.addgun(new Strikecraft(this.getX()+this.getW()+30,this.getY()+this.getH()/2));
			}
		}

	}
	
}
