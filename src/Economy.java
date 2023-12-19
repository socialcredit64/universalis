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
		if(faction=="Blorg"){
			repaircost*=1.25;
		}
		alloy-=repaircost;
		p.setStartHP();
	}

	public int getRepairInfo(Character p){
		repaircost = Math.round(p.getmaxHP()-p.gethp())*2;
		if(faction=="Blorg"){
			repaircost*=1.25;
		}
		return repaircost;
	}

	public void drawResourceChange(Graphics g2d, int dresource, int x, int y){
		if(faction=="UNE" && dresource==dmoney){
			dresource*=1.25;
		}
		if(faction=="UNE" && dresource==dmoney){
			dresource*=1.25;
		}
		if(faction=="Blorg" && dresource==dminerals){
			dresource*=1.25;
		}
		if(faction=="Eliminators"&& dresource==dmoney){
			dresource*=0.9;
		}


		if (dresource>0){
			g2d.setColor(Color.green);
		}
		if (dresource<0){
			g2d.setColor(Color.red);
		}
		g2d.drawString(""+dresource, x, y);

		
	}

	public void addValue(){
		money+=100000;
		minerals+=100000;
		alloy+=100000;
		authority+=1000;
		science+=100000;
	}

	

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMinerals() {
		return this.minerals;
	}

	public void setMinerals(int minerals) {
		this.minerals = minerals;
	}

	public int getAlloy() {
		return this.alloy;
	}

	public void setAlloy(int alloy) {
		this.alloy = alloy;
	}

	public int getAuthority() {
		return this.authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getScience() {
		return this.science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getDmoney() {
		return this.dmoney;
	}

	public void setDmoney(int dmoney) {
		this.dmoney = dmoney;
	}

	public int getDminerals() {
		return this.dminerals;
	}

	public void setDminerals(int dminerals) {
		this.dminerals = dminerals;
	}

	public int getDalloy() {
		return this.dalloy;
	}

	public void setDalloy(int dalloy) {
		this.dalloy = dalloy;
	}

	public int getDauthority() {
		return this.dauthority;
	}

	public void setDauthority(int dauthority) {
		this.dauthority = dauthority;
	}

	public int getDscience() {
		return this.dscience;
	}

	public void setDscience(int dscience) {
		this.dscience = dscience;
	}

	public String getFaction() {
		return this.faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public int getRepaircost() {
		return this.repaircost;
	}

	public void setRepaircost(int repaircost) {
		this.repaircost = repaircost;
	}
	


}
