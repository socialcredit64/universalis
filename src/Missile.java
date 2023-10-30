import javax.swing.ImageIcon;

public class Missile extends Ranged{
	public Missile() {
		super();
	}
	public Missile(int x, int y) {
		super(100, 15, 0, 0, x, y, 600, 8, new ImageIcon("PLACEHOLDER"));
	}
	
}
