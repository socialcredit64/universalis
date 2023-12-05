import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Battleship extends Character{
	public Battleship() {
		super();
	}
	//changes to create multiple mages
	public Battleship(int x, int y, ArrayList<Weapon> gunslot) {
		super();
		//super(x,y,150,150,1000,new ImageIcon("Battleship.png"), gunslot);
	}
	public String toString() {
		return "a battleship-class";
	}
}
