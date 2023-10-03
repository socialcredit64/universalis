import javax.swing.ImageIcon;

public class Battleship extends Character{
	public Battleship() {
		super();
	}
	//changes to create multiple mages
	public Battleship(int x, int y, Weapon t) {
		super(x,y,150,150,1000,new ImageIcon("Battleship.png"), t);
	}
	public String toString() {
		return "a battleship-class";
	}
}
