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
		
	}
	public String toString() {
		return "a cruiser-class" + super.getImg().getImage();
	}
	
	
}
