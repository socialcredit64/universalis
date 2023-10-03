import javax.swing.ImageIcon;

public class Titan extends Character{
	public Titan() {
		super();
	}
	//changes to create multiple mages
	public Titan(int x, int y, Weapon t) {
		super(x,y,150,150,1000,new ImageIcon("Titan.jpg"), t);
	}
	public String toString() {
		return "a battleship-class";
	}
}
