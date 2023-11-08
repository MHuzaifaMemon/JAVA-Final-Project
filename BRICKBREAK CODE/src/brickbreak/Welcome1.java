package brickbreak;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Welcome1 extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel titleLabel;
    private JButton playButton, helpButton,aboutButton,nextButton;
    private JPanel titlePanel, buttonPanel;

    public Welcome1() {
    	JFrame welc = new JFrame();
    	welc.setBounds(250,70,500,400);// old is 250,70,500,400   
    	welc.setTitle("welcome to brick breaker game");
    	welc.setBackground(Color.BLACK);
    	welc.setLocationRelativeTo(null); 	 
    	welc.setResizable(false);

    	//Add the image to the panel
    	ImageIcon imageIcon = new ImageIcon("G:\\SEM-II\\OOPS\\Project\\image for game\\start.jpg");
    	JLabel imageLabel = new JLabel(imageIcon);
    	welc.add(imageLabel, BorderLayout.CENTER);

    	welc.setVisible(true);

//    	JButton next = new JButton("NEXT");
//    	next.setForeground(Color.orange);
//    	next.setFont(new Font("Cooper Black",Font.PLAIN,24));
//    	next.setBounds(266, 484, 156, 37);
//    	next.addActionListener(this);
//    	welc.add(next);

    	welc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// Create a new thread to sleep the frame for 10 seconds
    	Thread thread = new Thread() {
    	    public void run() {
    	        try {
    	            Thread.sleep(10000); // Sleep for 10 seconds (10000 milliseconds)
    	            welc.dispose(); // Close the frame after sleeping
    	        } catch (InterruptedException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	};

    	// Start the thread
    	thread.start();
      //  super("Brick Breaker Game");
       //JFrame start=new JFrame();
        setVisible(true);
    	setLayout(new BorderLayout());
        setSize(900,700 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
        // Creating Title Panel
        titlePanel = new JPanel();
        titleLabel = new JLabel("Brick Breaker Game");
        titleLabel.setFont(new Font("algerian", Font.BOLD, 50));
        titleLabel.setForeground(Color.red);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.black);

        // Creating Button Panel
        buttonPanel = new JPanel(new GridLayout(0, 1, 20,30));
       // buttonPanel.setBounds(266, 484, 156, 37);
        buttonPanel.setBackground(Color.DARK_GRAY);
        
        // PLAYY BUTTON BUTTON AND ITS SIZE FONT
        playButton = new JButton("Play");
        playButton.setFont(new Font("algerian", Font.BOLD, 50));

       
       // HELP BUTTON FONT SIZE 
        helpButton = new JButton("Help");
        helpButton.setFont(new Font("algerian", Font.BOLD, 50));
        
        //ABOUT button size font 
        aboutButton = new JButton("About");
        aboutButton.setFont(new Font("algerian", Font.BOLD, 50));
        
        
        
        playButton.addActionListener(this);
        helpButton.addActionListener(this);
        aboutButton.addActionListener(this);
        buttonPanel.add(playButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(aboutButton);
       // buttonPanel.add(next);
        buttonPanel.setBackground(Color.black);

        // Adding Panels to Frame
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
   
	@Override
	  public void actionPerformed(ActionEvent e) {
             if (e.getSource() == playButton) {
            // Open new frame for Game
            dispose();
            setVisible(false);
    		JFrame obj=new JFrame();
    		GAMEPLAY gamePlay=new GAMEPLAY();
    		//obj.setSize(700, 600);
    	    obj.setBounds(250,70,700,600);
//    		obj.setForeground(Color.BLACK);
    		obj.setTitle("BRICK BREAKER GAME - PLAY ");
    		obj.setResizable(false);
    		obj.setVisible(true);
    		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		obj.getContentPane().add(gamePlay);

    		
        }
        else if (e.getSource() == helpButton) {
            // Open new frame for Help
            JFrame helpFrame = new JFrame();
            helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            helpFrame.setSize(900, 500);
            helpFrame.setTitle("BRICK BREAKER GAME - HELP");
            JTextArea helpText = new JTextArea("Instructions:\n1. Use left and right arrow keys to move the paddle.\n2. Break all the bricks using the ball to win the game.\n3. If the ball falls down below the paddle, you lose a game .\n4.the speed should be increases after the brick are breaks.\n\n\t\t\tAll the best!");
            helpText.setFont(new Font("algerian", Font.BOLD, 25));
            helpText.setBackground(Color.black);
            helpText.setForeground(Color.red);
            helpText.setEditable(false);
            helpFrame.add(helpText);
            helpFrame.setLocationRelativeTo(null);
            helpFrame.setVisible(true);
        }
        
        else if (e.getSource() == aboutButton) {
        	    // Open new frame for Help
        	    JFrame aboutFrame = new JFrame();
        	    aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	    aboutFrame.setSize(900, 500);
        	    aboutFrame.setTitle("BRICK BREAKER GAME - ABOUT");

        	    // Create a panel to hold the text area and image
        	    JPanel aboutPanel = new JPanel();
        	    aboutPanel.setLayout(new BorderLayout());

        	    // Add the text area to the panel
        	    JTextArea aboutText = new JTextArea("PROJECT CREATED BY: \nMUHAMMAD HUZAIFA \nUZAIR KHAN \nSTUDENTS OF IBA IET KHAIRPUR CAMPUS \nPROJECT ASSIGNED BY: \n MA'AM RASHIDA NAZ  ");
        	    aboutText.setFont(new Font("algerian", Font.BOLD, 25));
        	    aboutText.setBackground(Color.black);
        	    aboutText.setForeground(Color.red);
        	    aboutText.setEditable(false);
        	    aboutPanel.add(aboutText, BorderLayout.CENTER);
        	    ImageIcon imageIcon1 = new ImageIcon("G:\\SEM-II\\OOPS\\Project\\image for game\\iba.jpg");
        	    JLabel imageLabel1 = new JLabel(imageIcon1);
        	    aboutPanel.add(imageLabel1, BorderLayout.EAST);

        	    // Add the image to the panel
        	    ImageIcon imageIcon = new ImageIcon("G:\\SEM-II\\OOPS\\Project\\image for game-\\img.jpg");
        	    JLabel imageLabel = new JLabel(imageIcon);
        	    aboutPanel.add(imageLabel, BorderLayout.PAGE_END);

        	    // Add the panel to the frame
        	    aboutFrame.add(aboutPanel);
        	    aboutFrame.setLocationRelativeTo(null);
        	    aboutFrame.setVisible(true);
        	}
        

        }
	public static void main(String[] args) {
Welcome1 ob =new Welcome1();

//obj.add(gamePlay);

	}
}



