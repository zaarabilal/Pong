import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private Paddle player1;
	private Paddle player2;
	private Color mynewcolor;
	private Color newcolor;
	private Player p;
	private Ball ball;
	
	
	
	
	public Game() {
		
		p=new Player();
	  
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		player1= new Paddle (20,300,50,150);
		player2= new Paddle (720, 300, 50, 150);
		mynewcolor= new Color (253,171,159);
		ball= new Ball(400,300); 
	
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
		//g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(),this);
		Color rectangle1=new Color (169,235,219);
		g2d.setColor(rectangle1);
		g2d.fillRect(50, 300, 20,20);
		Color rectangle2=new Color (150,153,152);
		g2d.setColor(rectangle2);
		g2d.fillRect(400, 0, 400, 600);
		Color paddle= new Color (253,171,159);
		g2d.setColor(paddle);
		g2d.fillRect(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight());
		g2d.fillRect(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight());

		
				
			
		
		move();
		g2d.setFont(new Font ("Times New Roman", Font.BOLD,20 ));
		g2d.drawString("Press Enter to Start", 320, 20);
		g2d.drawString("Player 1 Score - " +player1.getScore(), 40, 20);
		g2d.drawString("Player 2 Score - " +player2.getScore(), 600, 20);
		g2d.setColor(mynewcolor);
		
		g2d.fillOval(ball.getX(), ball.getY(), ball.getW(), ball.getH());
		
		if(player2.score>=10) {
			newcolor= new Color (100,100,100);
			g2d.setColor(newcolor);
			g2d.drawString("PLAYER 2 WINS!!!",300,300);
			g2d.drawString("PLAYER 1 LOSES", 100, 100);
			//g2d.fillRect(700,0,0,0);
		}
		
	

		twoDgraph.drawImage(back, null, 0, 0);

	}
	private void reset() { 
		mynewcolor= new Color(253,171,159);
		
	}


public void move() {
	player1.move();
	player2.move();
	ball.move();
	WallCollision();
}
public void WallCollision() {
if(ball.collisionp2(player2)&& ball.getX()+ball.getW()>player2.getX()) {
	player1.addPoint(1);
	ball.reset();
}
if(ball.collisionp1(player1)&&ball.getX()<player1.getX()+player1.getWidth()) {
	player2.addPoint(1);
	ball.reset();
}
}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if(key==87) {
			player1.setdy(-2);
		}
		if(key==83) {
			player1.setdy(2);
		}
	if(key==38) {
		player2.setdy(-2);
	}
	if(key==40) {
		player2.setdy(2);
	}
	if(key==10) {
		ball.setdx(2);
		ball.setdy(2);
	}
	if (key==90) {
		mynewcolor=new Color (128,231,242);
	}
	if (key==88) {
		reset();
	
		
	}
	if (key==65406) {
		player2.addPoint(5);
	}
	if (key==16) {
		player1.addPoint(5);
	}
	if (key==49) {
		Player p=new Player();
	    p.playmusic("music1.wav");
	}
	
	if (key==50) {
		p.playmusic("stop");
		
		
		if (key==51) {
			Player p2= new Player();
			p2.playmusic("track02.wav");
		}
			

		}
		
	}
	



	@Override
	public void keyReleased(KeyEvent e) {
	
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			player1.setdy(0);
		}
		if(e.getKeyCode()==38||e.getKeyCode()==40) {
			player2.setdy(0);
		}
		
	}
	
	
	

	
}

