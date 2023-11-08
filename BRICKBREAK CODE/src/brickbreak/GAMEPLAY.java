package brickbreak;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GAMEPLAY extends JPanel implements KeyListener,ActionListener
{
	private boolean play=false;//bcz game automatic play na ho
	private int score=0;
	
	private int totalBricks=30; // change it latter old  21
	
	private Timer time;
	private int delay= 8;//speed
	
	private int PlayerX=310;
	 private int ballposX=320;//ball positionx old value
     private int ballposY=530;//ball positiony old value 350
     private int ballXdir= -1;//increment/dec in x direction
     private int ballYdir=-2;//increment/dec in Y direction
	private MapGanerator map;
	
	public GAMEPLAY()
	{
		map=new MapGanerator(5,6);// old 3 7
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	    time =new Timer(delay, this);
		time.start();
	}
	//in built
	public void paint(Graphics g)
	{
		//Background
		g.setColor(Color.gray); 
		g.fillRect(1, 1, 692, 592);
		
		
		//Drawing map
		map.draw((Graphics2D)g);
		
		//Borders
		g.setColor(Color.red);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
	
		//Scores
		g.setColor(Color.black);
		g.setFont(new Font("algerian",Font.BOLD,25)); //name font,style,size 
		g.drawString("SCORE: "+score, 530, 30);//string,x,y 530 is size throug it will come on the center and the of 30 it is used on the corner up and down 
		
		
		//The paddle
		g.setColor(Color.black);
		g.fillRect(PlayerX, 550, 100,500);//x,y,width,height here is 550 size  is used to come in base line if we decrease the paddle will come
		// up and if we  100 is a size of a width paddle 8 is old if we increse it will be thick  
		
		//The Ball
		g.setColor(Color.red);
		g.fillOval(ballposX,ballposY, 20, 20);//x,y,width,height if we increase x it will wil be big in x axis 
		
		if(totalBricks<=0)
		{
			play=false;
			ballXdir=0; //the direction of x will be stop 
			ballYdir=0; //the direction of y will be stop 
			
			g.setColor(Color.RED); // this is an a color of a statement which come on the end of the program if the game is won by player
			g.setFont(new Font("algerian",Font.BOLD,30)); // size style font of statement
			g.drawString("You Won: ", 190, 300);

			g.setFont(new Font("algerian",Font.BOLD,20));
			g.drawString("Press Enter to restart a gamr", 230, 350);
		}
		
		
		if(ballposY>570)
		{
			play=false;
			ballXdir=0;
			ballYdir=0;
			
			g.setColor(Color.RED);
			g.setFont(new Font("algerian",Font.BOLD,30));
			g.drawString("Game Over, Scores: "+score, 190, 300);
			
			g.setFont(new Font("algerian",Font.BOLD,20));
			g.drawString("Press Enter to Restart", 230, 350);
		}
		
		
		
		
		g.dispose();
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time.start();
		if(play)
		{
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(PlayerX,550,100,500)))
			{
				ballYdir=-ballYdir;
			}
			
			A:for(int i=0; i<map.map.length; i++)
			{
				for(int j=0; j<map.map[0].length; j++)
				{
					if(map.map[i][j]>0)
					{
						int brickX=j*map.brickWidth+80;
						int brickY=i*map.brickHeight+50;
						int brickWidth=map.brickWidth;
						int brickHeight=map.brickHeight;
						
						Rectangle rect =new Rectangle(brickX,brickY,brickWidth,brickHeight);
						Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
						Rectangle brickRect=rect;
						
						if(ballRect.intersects(brickRect))
						{
							map.setBrickValue(0, i, j);
							totalBricks--;
							score+=10;
							delay--;
							ballYdir--;
							
							if(ballposX+19<=brickRect.x||ballposX+1>=brickRect.x+brickRect.width)
							{
								ballXdir=-ballXdir;
							}
							else
							{
								ballYdir=-ballYdir;
							}
							break A;
						}
						
					}
				}
			}
			
			ballposX+=ballXdir;
			ballposY+=ballYdir;
			
			if(ballposX<0)
			{
				ballXdir= -ballXdir;
			}
			
			if(ballposY<0)
			{
				ballYdir= -ballYdir;
			}
			
			if(ballposX>670)
			{
				ballXdir= -ballXdir;
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(PlayerX>=600)
			{
				PlayerX=600;
			}
			else
			{
				moveRight();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(PlayerX<10)
			{
				PlayerX=10;
			}
			else
			{
				moveLeft();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			play=true;
			ballposX=320;
			ballposY=530;
			ballXdir=-1;
			ballYdir=-2;
			PlayerX=310;
			score=0;
			totalBricks=30;
			map=new MapGanerator(5,6);
			
			repaint();
		}
		
	}
	public void moveRight()
	{
		play=true;
		PlayerX+=20;
	}
	public void moveLeft()
	{
		play=true;
		PlayerX-=20;
	}

}
