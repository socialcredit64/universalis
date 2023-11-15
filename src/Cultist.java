import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Cultist extends Character{
	public Cultist() {
		super();
	}
	
	public Cultist(int x, int y, int hitpoints, ArrayList<Weapon> gunslot)  {
		super(x,y,hitpoints,new ImageIcon("Cultist.jpg"), gunslot);
		super.setAS(125);
	}
}

