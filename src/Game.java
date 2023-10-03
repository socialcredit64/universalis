
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, counter; 
	private Music sound;
	private ArrayList<Character> startList;
	private String display;
	private int text;

	//silly string
	private String selectyourfaction;

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		startList = setStartChars();
		System.out.println(startList.size());
		sound=new Music();
		display="start";
		
		selectyourfaction="Select your faction";
		text=1;
		counter=0;
		sound.playmusic("startmenu.wav");
	}

	
	
	private ArrayList<Character> setStartChars() {
		// TODO Auto-generated method stub
		ArrayList <Character> temp = new ArrayList<Character>();
		temp.add(new Cruiser(150,200,new Weapon())); //constructor
		temp.add(new Battleship(450,200,new Weapon()));
		temp.add(new Titan(650,200,new Weapon()));
		temp.add(new Scout(850,200,new Weapon()));
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
	
		g2d.setFont( new Font("Century Gothic", Font.BOLD, 50));
		
		g2d.drawString("Hello!" , x, y);
		
		for (Character sL: startList) {
			sL.drawShip(g2d);
			
			System.out.println(sL);
			}
		drawScreens(g2d);
		twoDgraph.drawImage(back, null, 0, 0);
		++counter;
	}

	public void drawScreens(Graphics g2d) {
		switch(display){
		case "start":
			drawStartScreen(g2d);
			System.out.println("start screen");
		}
	}


	public void drawStartScreen(Graphics g2d) {
		
		g2d.setFont( new Font("Century Gothic", Font.BOLD, 50));
		g2d.drawString(selectyourfaction.substring(0,text), 500, 100);
		
		if (text<selectyourfaction.length()) {
			if(counter%8==0) {
				++text;
			}
		}
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
		
		System.out.println("you clicked at"+ arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}



