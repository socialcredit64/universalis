
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.*; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	private File filename;

	private BufferedImage back; 
	private int key, x, y, counter, order; 
	private Music sound;
	private ArrayList<Faction> startSel;
	private String display;
	private int text;
	private Background menu;
	private Background scrollscreen;
	private Character playership;
	private Queue<Character> enemies;
	private int gradient;
	private boolean ifOkToInit;


	//silly string
	private String selectyourfaction;
	private String Faction;

	private ArrayList<Projectile> swarmbullet;
	private ArrayList<Projectile> blorgbullet;

	private ImageIcon winscreen;
	
	private ImageIcon money;
	private ImageIcon minerals;
	private ImageIcon alloy;
	private ImageIcon authority;
	private ImageIcon science;

	private Economy economy;

	private ArrayList<Planet> planets;
	private int planet;
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		order=0;
		startSel = setStartFactions();
		System.out.println(startSel.size());
		sound=new Music();
		////////////////////////////////////////control starting position
		display="start";
		//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
		enemies = setEnemies();
		enemies.element().setMaxHP();
		enemies.element().setStartHP();
		gradient=200;
		selectyourfaction="Select your faction";
		text=1;
		counter=0;

		swarmbullet = new ArrayList<Projectile>();
		blorgbullet = new ArrayList<Projectile>();

		sound.playmusic("startmenu.wav");
		menu=new Background(0,0,new ImageIcon("spaceambience.jpg"));
		scrollscreen=new Background(0,0,new ImageIcon("scrollgame.jpg"));
		
		playership=new Cruiser(100,300,new ArrayList<Weapon>());
		playership.defaultEquip();
		playership.setMaxHP();
		playership.setStartHP();
		//playership.defaultEquip();
		
		winscreen = new ImageIcon("winscreen.png");

		money = new ImageIcon("money.png");
		minerals = new ImageIcon("minerals.png");
		alloy = new ImageIcon("alloy.jpg");
		authority = new ImageIcon("authority.png");
		science = new ImageIcon("science.jpg");

		planets = new ArrayList<Planet>();
		planet = 0;

		filename = new File("save.txt");
	} 

	public void createFile(){
		try{
			if(filename.createNewFile()){
				System.out.println("file created"+ filename.getName());
			}
			else{
				System.out.println("file already exists!");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}

	public void readFile(){
		try {
			Scanner sc = new Scanner(filename);
			while(sc.hasNext()){
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(){
		try {
			FileWriter myWriter = new FileWriter(filename);
			myWriter.write("You have "+ enemies.size()+" enemies left\n");
			System.out.println(enemies.size());
			

			myWriter.write(playership.getFac()+"\n");

			myWriter.write(display+"\n");

			
			
			
			myWriter.close();
			System.out.println("Written to file successfully");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Queue<Character> setEnemies(){
		Queue<Character> temp = new LinkedList<>();

		temp.add(new Pirate(1260,400,1250,new ArrayList<Weapon>()));
		temp.add(new Cultist(1260,400,1250,new ArrayList<Weapon>()));
		temp.add(new Rebels(1260,400,1250,new ArrayList<Weapon>()));
		
		return temp;
	}


	/*"Weapon Type: Energy\n"
			  + "Faction Modifiers:\n"
			  + "\t	Monthly Credits +15%\n"
			  + "\t Ship armor and shield health +10%\n"
			  + "\t ship repair cost +10%"
			  
			  "Weapon Type: Explosive\n"
			  + "Faction Modifiers:\n"
			  + "\t Ship attack speed +25%\n"
			  + "\t Ship repair cost -15%\n"
			  + "\t Ship health -10%"
			  
			  *"Weapon Type: Explosive\n"
			  + "Faction Modifiers:\n"
			  + ""*/
	
	private ArrayList<Faction> setStartFactions() {
		// TODO Auto-generated method stub
		ArrayList <Faction> temp = new ArrayList<Faction>();
		temp.add(new Faction(300,300,new ImageIcon("UNE.jpg"),new ArrayList<String>()));
		
		temp.add(new Faction(300,300,new ImageIcon("Swarm.jpg"),new ArrayList<String>()));
		
		temp.add(new Faction(300,300,new ImageIcon("Eliminators.jpg"),new ArrayList<String>()));
		
		temp.add(new Faction(300,300,new ImageIcon("Commonality.jpg"),new ArrayList<String>()));
		
		return temp;
	}


	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
	
		g2d.setFont(new Font("Century Gothic", Font.BOLD, 50));
		
		
		drawScreens(g2d);
		
		
		twoDgraph.drawImage(back, null, 0, 0);
		++counter;
		//System.out.println(counter);
	}

	public void drawScreens(Graphics g2d) {
		switch(display){
		case "start":
			drawStartScreen(g2d);
			break;
			
			
		case "combat":
			drawCombatScreen(g2d);
			break;


		case "economy":
			drawEconomyScreen(g2d);
			break;
		
		case "win":
			drawWinScreen(g2d);
			break;
		
		case "lose":
			drawLoseScreen(g2d);
		}
		
		
	}
	
	/*"Weapon Type: Energy\n"
			  + "Faction Modifiers:\n"
			  + "\t	Monthly Credits +15%\n"
			  + "\t Ship armor and shield health +10%\n"
			  + "\t ship repair cost +10%"
			  
			  "Weapon Type: Explosive\n"
			  + "Faction Modifiers:\n"
			  + "\t Ship attack speed +25%\n"
			  + "\t Ship repair cost -15%\n"
			  + "\t Ship health -10%"
			  
			  *"Weapon Type: Explosive\n"
			  + "Faction Modifiers:\n"
			  + ""*/
			  
	public void drawStartScreen(Graphics g2d) {
		menu.drawBackground(g2d);
		
		
			startSel.get(order).drawFaction(g2d);
			
			
			
		
		g2d.setColor(Color.WHITE);
		g2d.setFont( new Font("Century Gothic", Font.BOLD, 50));
		g2d.drawString(selectyourfaction.substring(0,text), 500, 100);
		
		if (text<selectyourfaction.length()) {
			if(counter%8==0) {
				++text;
			}
		}
	}

	public void drawCombatScreen(Graphics g2d) {
		scrollscreen.drawBackground(g2d);
		scrollscreen.scroll();
		
		playership.drawShip(g2d);
		
		

		enemies.element().drawShip(g2d);
		


		if(playership.getFac()=="UNE") {
			//System.out.println("vvvvvvv");
			g2d.setColor(Color.blue);
			if (counter%40==0) {
				System.out.println("eeeee");
				g2d.fillRect(677,513,500,7);
				
				enemies.element().hit(100);
			}
		}
		if(playership.getFac()=="Eliminator") {
			g2d.setColor(Color.white);
			if (counter%50==0) {
				//playership.drawLaser(g2d);
				g2d.fillRect(677,513,500,7);
				enemies.element().hit(100);
				
				}
			}
		if(playership.getFac()=="Swarm") {
			g2d.setColor(Color.DARK_GRAY);
			if (counter%100==0) {
				swarmbullet.add(new Projectile());
			}
			for (Projectile p: swarmbullet){
				g2d.fillRect(p.getX(),p.getY(),p.getW(),p.getH());
				p.setDX(5);
				p.move();
				if (p.getX()>=1213){
					swarmbullet.remove(p);
					enemies.element().hit(100);
				}
			}
		}
		if(playership.getFac()=="Blorg") {
			
			g2d.setColor(Color.yellow);
			if (counter%100==0) {
				blorgbullet.add(new Projectile());
				System.out.println("here");
			}
			for (Projectile p: blorgbullet){
				g2d.fillRect(p.getX(),p.getY(),p.getW(),p.getH());
				p.setDX(3);
				p.move();
				if (p.getX()>=1213){
					blorgbullet.remove(p);
					enemies.element().hit(100);
				}
			}
		}

		//enemies fight
		g2d.setColor(new Color(200,0,0));
		
		//using InstanceOf to give different enemies different attack type and attack speeds
		if(enemies.element() instanceof Pirate){
			if(counter%50==0){
				g2d.fillRect(677,420,500,12); //the laser bullet
				playership.hit(20);
			}
		}
		if(enemies.element() instanceof Rebels){
			g2d.setColor(new Color(200,200,0));
			if(counter%60==0){
				g2d.fillRect(677,420,500,12); 
				playership.hit(25);
			}
		}
		if(enemies.element() instanceof Cultist){
			if(counter%40==0){
				g2d.fillRect(677,420,500,12); 
				playership.hit(18);
			}
		}


		

		
	


		//player hp bars
		
		if(enemies.element().gethp()<=0){
			enemies.remove();
			if(enemies.isEmpty()){
				display="economy";
			}

			if(enemies.isEmpty()==false){
				enemies.element().setMaxHP();
				enemies.element().setStartHP();
			}
		}

		if(enemies.isEmpty()){
			display="economy";
		}
		if(playership.gethp()<=0){
			display="lose";
		}

		g2d.setColor(new Color(255,Math.round(gradient*(playership.gethp()/playership.getmaxHP())),Math.round(gradient*(playership.gethp()/playership.getmaxHP()))));
		g2d.drawRect(70,70,500,50);
		g2d.fillRect(70,70,Math.round((playership.gethp()/playership.getmaxHP())*500),50);
		//enemy instance hp bars
		g2d.setColor(new Color(255,Math.round(gradient*(enemies.element().gethp()/enemies.element().getmaxHP())),Math.round(gradient*(enemies.element().gethp()/enemies.element().getmaxHP()))));
		g2d.drawRect(1030,70,500,50);
		g2d.fillRect(1030,70,Math.round((enemies.element().gethp()/enemies.element().getmaxHP())*500),50);
		
		//end
		
		



	}
	
	public void drawWinScreen(Graphics g2d){
		g2d.drawImage(winscreen.getImage(),0,0,1800,1600, this);
		g2d.setColor(Color.white);
		g2d.drawString("Complete Victory",50,50);
	}

	public void drawLoseScreen(Graphics g2d){
		g2d.drawImage(winscreen.getImage(),0,0,1800,1600, this);
		g2d.setColor(Color.white);
		g2d.drawString("Absolute Defeat",50,50);
	}

	public void drawEconomyScreen(Graphics g2d){
		g2d.setColor(Color.black);
		g2d.fillRect(0,0,1800,1600);

		g2d.drawImage(money.getImage(),20,10,50,50, this);
		g2d.drawImage(minerals.getImage(),20,60,50,50,this);
		g2d.drawImage(alloy.getImage(),20,110,50,50,this);
		g2d.drawImage(authority.getImage(),20,160,50,50,this);
		g2d.drawImage(science.getImage(),20,210,50,50,this);

		g2d.setColor(Color.white);
		g2d.setFont(new Font("Century Gothic", Font.BOLD, 40));

		g2d.drawString(""+economy.getMoney(), 20+58, 40+10);
		g2d.drawString(""+economy.getMinerals(), 20+58, 40+60);
		g2d.drawString(""+economy.getAlloy(), 20+58, 40+110);
		g2d.drawString(""+economy.getAuthority(), 20+58, 40+160);
		g2d.drawString(""+economy.getScience(), 20+58, 40+210);

		economy.drawResourceChange(g2d,economy.getDMoney(), 20+58+150, 40+10);
		economy.drawResourceChange(g2d,economy.getDMinerals(), 20+58+150, 40+60);
		economy.drawResourceChange(g2d,economy.getDAlloy(), 20+58+150, 40+110);
		economy.drawResourceChange(g2d,economy.getDAuthority(), 20+58+150, 40+160);
		economy.drawResourceChange(g2d,economy.getDScience(), 20+58+150, 40+210);
		
		//draw planet (planet is an index)
		planets.get(planet).drawPlanet(g2d);
		

	}



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if(display=="start") {

				if(key==39&&order<=4) {
					order+=1;
				}
				if(key==37&&order>=0) {
					order-=1;
				}
			
			
		}
		if(display=="combat"){
			if(key==76){
				enemies.remove();
				enemies.element().setMaxHP();
				enemies.element().setStartHP();
			}
		}
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
		
		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at ("+ arg0.getX()+", "+arg0.getY()+")");
		x=arg0.getX();
		y=arg0.getY();
		
		if(x>=300&&x<=1300&&y>=300&&y<=900&&display.equals("start")) {
			if(order==0) {
				playership.setFac("UNE");
				
				System.out.println("une");
			}
			if(order==1) {
				playership.setFac("Swarm");
				
			}
			if(order==2) {
				playership.setFac("Eliminator");
				
				System.out.println("eliminator");
			}
			if(order==3) {
				playership.setFac("Blorg");
				
			}
			// economy constructor
			display = "economy";
			economy = new Economy(playership.getFac());
			//planet load
			planets.add(new Planet(playership.getFac(), "Homeworld"));
		}
		
		
	}
		
	


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}



