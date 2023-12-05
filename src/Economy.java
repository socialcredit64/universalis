
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

	private int repaircost;
	
	public Economy() {
		money=2000;
		minerals=1500;
		alloy = 500;
		authority = 100;
		science = 0;
		
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



	
}
