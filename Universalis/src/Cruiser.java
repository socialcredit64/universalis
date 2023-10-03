import javax.swing.ImageIcon;

public class Cruiser extends Character{
	public Cruiser() {
		super();
	}
	//changes to create multiple mages
	public Cruiser(int x, int y, Weapon t) {
		super(x,y,100,100,1000,new ImageIcon("Cruiser.png"), t);
	}
	public String toString() {
		return "a cruiser-class" + super.getImg().getImage();
	}
}
