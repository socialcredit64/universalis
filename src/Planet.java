import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Planet {
    private String name;
    private String type;
    private District industries;
    private District academies;
    private District mining;
    private District energy;

    private int population;
    private int dpopulation;

    private ImageIcon up;
    private ImageIcon down;


    public Planet(){
        
        name = "Home Planet";
        type = "Homeworld";

        energy = new District();;
        mining = new District();;
        industries = new District();
        academies = new District();;
        population = 1;

        dpopulation = 3;

        up = new ImageIcon("uparrow.png");
        down = new ImageIcon("downarrow.png");
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
        if(t=="Homeworld"){
            energy = new District(3,4000,0);
            mining = new District(3,3000,0);
            industries = new District(3,5000,0);
            academies = new District(3,6000,1000);

            population = 10;
            dpopulation = 1;
        }

        if(t=="Colony"){
            energy = new District(0,4000,0);
            mining = new District(0,3000,0);
            industries = new District(0,5000,0);
            academies = new District(0,6000,1000);

        }
        
        up = new ImageIcon("uparrow.png");
        down = new ImageIcon("downarrow.png");
    }

    public void drawPlanet(Graphics g2d){
        g2d.setColor(new Color(0,184,217));
        g2d.setFont(new Font("Century Gothic", Font.BOLD, 50));
        g2d.drawString(name, 800, 50);

        g2d.setColor(Color.white);
         g2d.setFont(new Font("Century Gothic", Font.BOLD, 30));

        g2d.drawString("Planetary Infrastructure", 500, 200);
        g2d.drawString("Mining Industries", 500, 240);
        g2d.drawString("Military Industries", 500, 280);
        g2d.drawString("Scientific Laboratories", 500, 320);

        for(int i=0;i<4;++i){
            g2d.drawImage(down.getImage(),900,173+40*i,30,30,null);
            g2d.drawImage(up.getImage(),1160,173+40*i,30,30,null);
        }


        g2d.drawString(""+energy.getLevel(),1000,200);
        g2d.drawString(""+mining.getLevel(),1000,240);
        g2d.drawString(""+industries.getLevel(),1000,280);
        g2d.drawString(""+academies.getLevel(),1000,320);

       
    }

    public void improve(String district, Economy e){
        if (district == "energy"){
           
        }
    }

    public void cancelImprove(String district, Economy e){
        if (district == "energy"){
            if(energy.getTimesIncreased()>0){
                
            }
        }
    }

    public void generateIncome(Economy e){
        
    }
    
}
