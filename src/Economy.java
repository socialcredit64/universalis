import javax.swing.ImageIcon;

public class Economy {
	private ImageIcon img;
	private float gold, materials, military_goods, authority, research;
	private float Dgold, Dmaterials, Dmilitary_goods, Dauthority, Dresearch;
	public Economy() {
		gold=100;
		materials=500;
		military_goods=0;
		authority=10;
		research=0;

		Dgold=5;
		Dmaterials=10;
		Dmilitary_goods=1;
		Dauthority=10;
		Dresearch=3;

	}

	public void monthTick(){
		gold+=Dgold;
		materials+=Dmaterials;
		military_goods+=Dmilitary_goods;
		authority+=Dauthority;
		research+=Dresearch;
	}
}
