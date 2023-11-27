
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 
import java.util.LinkedList;
import java.util.Queue;

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
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
		display="start";
		enemies = setEnemies();
		enemies.element().setMaxHP();
		enemies.element().setStartHP();
		gradient=200;
		selectyourfaction="Select your faction";
		text=1;
		counter=0;

		sound.playmusic("startmenu.wav");
		menu=new Background(0,0,new ImageIcon("spaceambience.jpg"));
		scrollscreen=new Background(0,0,new ImageIcon("scrollgame.jpg"));
		
		playership=new Cruiser(100,300,new ArrayList<Weapon>());
		playership.defaultEquip();
		playership.setMaxHP();
		playership.setStartHP();
		//playership.defaultEquip();
		
	} 

	private Queue<Character> setEnemies(){
		Queue<Character> temp = new LinkedList<>();

		temp.add(new Pirate(1260,400,1000,new ArrayList<Weapon>()));
		temp.add(new Cultist(1260,400,1000,new ArrayList<Weapon>()));
		temp.add(new Rebels(1260,400,1000,new ArrayList<Weapon>()));
		
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
		
		g2d.drawString("Hello!" , x, y);
		
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
		}
		
		
	}


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
			ArrayList<Projectile> swarmbullet = new ArrayList<>();
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
			ArrayList<Projectile> blorgbullet = new ArrayList<>();
			if (counter%100==0) {
				blorgbullet.add(new Projectile());
			}
			for (Projectile p: blorgbullet){
				g2d.fillRect(p.getX(),p.getY(),p.getW(),p.getH());
				p.setDX(5);
				p.move();
				if (p.getX()>=1213){
					blorgbullet.remove(p);
					enemies.element().hit(100);
				}
			}
		}

		//enemies fight
		if(counter%enemies.element().getAS()==0){
			playership.hit(60);
		}

		
	


		//player hp bars
		g2d.setColor(new Color(255,Math.round(gradient*(playership.gethp()/playership.getmaxHP())),Math.round(gradient*(playership.gethp()/playership.getmaxHP()))));
		g2d.drawRect(70,70,500,50);
		g2d.fillRect(70,70,Math.round((playership.gethp()/playership.getmaxHP())*500),50);
		//enemy instance hp bars
		g2d.setColor(new Color(255,Math.round(gradient*(enemies.element().gethp()/enemies.element().getmaxHP())),Math.round(gradient*(enemies.element().gethp()/enemies.element().getmaxHP()))));
		g2d.drawRect(1030,70,500,50);
		g2d.fillRect(1030,70,Math.round((enemies.element().gethp()/enemies.element().getmaxHP())*500),50);
		

		//end
		if(enemies.element().gethp()==0){
			enemies.remove();
			enemies.element().setMaxHP();
			enemies.element().setStartHP();
		}



	}
	
	public void drawEconomyScreen(Graphics g2d){
		g2d.drawImage(new ImageIcon("money.png").getImage(), 100,100,50,50, this);
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

				if(key==39) {
					order+=1;
				}
				if(key==37) {
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
				display="combat";
				System.out.println("une");
			}
			if(order==1) {
				playership.setFac("Swarm");
				display="combat";
			}
			if(order==2) {
				playership.setFac("Eliminator");
				display="combat";
				System.out.println("eliminator");
			}
			if(order==3) {
				playership.setFac("Blorg");
				display="combat";
			}
			
		}
		
		
	}
		
	


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}



