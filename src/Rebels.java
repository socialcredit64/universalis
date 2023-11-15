import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Rebels extends Character{
	public Rebels() {
		super();
	}
	
	public Rebels(int x, int y, int hitpoints, ArrayList<Weapon> gunslot)  {
		super(x,y,hitpoints,new ImageIcon("rebel.png"), gunslot);
		super.setAS(70);
	}
}

