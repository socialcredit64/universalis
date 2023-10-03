import javax.swing.ImageIcon;

public class Scout extends Character{
	public Scout() {
		super();
	}
	//changes to create multiple mages
	public Scout(int x, int y, Weapon t) {
		super(x,y,150,150,1000,new ImageIcon("Scout.jpg"), t);
	}
	public String toString() {
		return "a battleship-class";
	}
}
