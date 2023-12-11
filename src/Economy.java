import java.awt.Color;
import java.awt.Graphics;

public class Economy {
	private int money;
	private int minerals;
	private int alloy;
	private int authority;
	private int science;
	
	private int dmoney;
	private int dminerals;
	private int dalloy;
	private int dauthority;
	private int dscience;

	private String faction;

	private int repaircost;
	
	public Economy() {
		money=2000;
		minerals=1500;
		alloy = 500;
		authority = 100;
		science = 0;
		
		faction = "";
		
		dmoney = 100;
		dminerals = 100;
		dalloy = 70;
		dauthority = -10;
		dscience = 50;

	}

	public Economy(String f) {
		money=2000;
		minerals=1500;
		alloy = 500;
		authority = 100;
		science = 0;

		faction = f;
		
		dmoney = 100;
		dminerals = 100;
		dalloy = 70;
		dauthority = -10;
		dscience = 50;

	}

	public void monthTick(){
		money+=dmoney;
		minerals+=dminerals;
		alloy+=dalloy;
		authority+=dauthority;
		science+=dscience;
	}	

	public void repairShip(Character p){
		repaircost = Math.round(p.getmaxHP()-p.gethp());
		alloy-=repaircost;
	}

	public int getMoney(){
		return money;
	}
	public int getMinerals(){
		return minerals;
	}
	public int getAlloy(){
		return alloy;
	}
	public int getAuthority(){
		return authority;
	}
	public int getScience(){
		return science;
	}

	public int getDMoney(){
		return dmoney;
	}
	public int getDMinerals(){
		return dminerals;
	}
	public int getDAlloy(){
		return dalloy;
	}
	public int getDAuthority(){
		return dauthority;
	}
	public int getDScience(){
		return dscience;
	}

	public void drawResourceChange(Graphics g2d, int dresource, int x, int y){
		if (dresource>0){
			g2d.setColor(Color.green);
		}
		if (dresource<0){
			g2d.setColor(Color.red);
		}
		g2d.drawString(""+dresource, x, y);

		
	}
}
