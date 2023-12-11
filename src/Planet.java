import java.awt.Font;
import java.awt.Graphics;

public class Planet {
    private String name;
    private String type;
    private int industries;
    private int academies;
    private int mining;
    private int energy;

    private int population;
    private int dpopulation;


    public Planet(){
        //starting planet
        name = "Home Planet";
        type = "Homeworld";
        industries = 1;
        academies = 1;
        mining = 1;
        energy = 1;
        population = 0;
        dpopulation = 3;
    }

    public Planet(String n, String t){
        if(n=="UNE"){
            name = "Earth";
        }
        if(n=="Eliminator"){
            name = "XT-489.00";
        }
        if(n=="Blorg"){
            name = "Blorg";
        }
        if(n=="Swarm"){
            name = "Esclishtjwslkbfim";
        }
        
        
        type = t;
    }

    public void drawPlanet(Graphics g2d){
        g2d.setFont(new Font("Century Gothic", Font.BOLD, 50));
        g2d.drawString(name, 400, 10);

    }

    public void improveInfrastructure(){

    }

}
