import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Pirate extends Character{
	public Pirate() {
		super();
	}
	
	public Pirate(int x, int y, int hitpoints, ArrayList<Weapon> gunslot)  {
		super(x,y,hitpoints,new ImageIcon("Pirate.png"), gunslot);
		super.setHPlocation(1230, 1230);
		super.setAS(100);
	}

}

