import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Planet {
    private String name;
    private String type;
    private int industries;
    private int academies;
    private int mining;
    private int energy;

    private int population;
    private int dpopulation;

    private ImageIcon up;
    private ImageIcon down;


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
            industries = 3;
            academies = 3;
            mining = 3;
            energy = 3;
            population = 10;
            dpopulation = 1;
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
        g2d.drawString(""+energy,1000,200);
        g2d.drawString(""+mining,1000,240);
        g2d.drawString(""+industries,1000,280);
        g2d.drawString(""+academies,1000,320);



        
       
       
        
    }

    public void improveInfrastructure(int district){

    }

}
