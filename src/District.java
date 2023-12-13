public class District {
    private int level;
    private int timesIncreased;
    private int cost;
    private int upkeep;
    private int efficiency;



    public District(){
        level = 1;
        timesIncreased = 0;
        cost = 0;
        upkeep = 0;
        efficiency=1;

    }

    public District(int Level, int Cost, int Upkeep){
        level = Level;
        timesIncreased = 0;
        cost = Cost;
        upkeep =  Upkeep;
        efficiency = 1;
    }

    public void increase(){
        ++level;
        ++timesIncreased;
    }

    public void decrease(){
        --level;
        --timesIncreased;
    }


    


    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTimesIncreased() {
        return this.timesIncreased;
    }

    public void setTimesIncreased(int timesIncreased) {
        this.timesIncreased = timesIncreased;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUpkeep() {
        return this.upkeep;
    }

    public void setUpkeep(int upkeep) {
        this.upkeep = upkeep;
    }

    public int getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

}
