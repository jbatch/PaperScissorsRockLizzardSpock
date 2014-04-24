import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class PSR extends JFrame
{
	static int playerScore = 0;
	static int cpuScore = 0;
	static JLabel playerLabel = new JLabel("Player: 0  ");
	static JLabel cpuLabel = new JLabel("  Cpu: 0");
	final static JTextArea area =new JTextArea("");
	JPanel panel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel invisPanel = new JPanel();
	JButton rockButton = new JButton("Rock");
	JButton scissorsButton = new JButton("Scissors");
	JButton paperButton = new JButton("Paper");
	JButton lizzardButton = new JButton("Lizzard");
	JButton spockButton = new JButton("Spock");
	static JCheckBoxMenuItem extendGame = new JCheckBoxMenuItem("Extended game");
	static JCheckBoxMenuItem extendedDetails = new JCheckBoxMenuItem("Extra Details");

	
	public PSR()
	{
		initUI();
	}
	public final void initUI()
	{
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem exitGame = new JMenuItem("Exit");
		
		
		extendGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              if (invisPanel.isVisible()) {
            	  invisPanel.setVisible(false);
            	  setTitle("Paper Scissors Rock");
              } else {
            	  invisPanel.setVisible(true);
            	  setTitle("Paper Scissors Rock Lizzard Spock");
              }
            }

        });
		
		JMenuItem changeGame = new JMenuItem("Change Game");
		exitGame.setToolTipText("Exit Application");
		
		exitGame.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		changeGame.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				invisPanel.setVisible(true);
			}
		});
				
		file.add(newGame);
		file.add(extendGame);
		file.add(extendedDetails);
		file.add(exitGame);

		menubar.add(file);
		setJMenuBar(menubar);
		
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		getContentPane().add(panel);
		
		invisPanel.setVisible(false);
		invisPanel.add(lizzardButton);
		invisPanel.add(spockButton);
							
		area.setPreferredSize(new Dimension(160, 130));
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		//Paper, Scissors and Rock buttons
		paperButton.setToolTipText("Paper");
		paperButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				area.append("You chose paper\n");
				evaluateGame(0);

			}
		});
		
		scissorsButton.setToolTipText("Scissors");
		scissorsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				area.append("You chose scissors\n");
				evaluateGame(1);
			}
		});
		
		
		rockButton.setToolTipText("Rock");
		rockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				area.append("You chose Rock\n");
				evaluateGame(2);

			}
		});
		
		lizzardButton.setToolTipText("Lizzard");
		lizzardButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				area.append("You chose Lizzard\n");
				evaluateGame(3);

			}
		});
		
		spockButton.setToolTipText("Spock");
		spockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				area.append("You chose Spock\n");
				evaluateGame(4);

			}
		});
				
		newGame.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				area.setText("");
				playerLabel.setText("Player: 0  ");
				cpuLabel.setText("  CPU: 0");
				playerScore = 0;
				cpuScore = 0;
			}
		});
		
		buttonPanel.add(paperButton);
		buttonPanel.add(scissorsButton);
		buttonPanel.add(rockButton);
		
		panel2.add(playerLabel);
		panel2.add(area);
		panel2.add(cpuLabel);
		
		panel.add(buttonPanel);
		panel.add(invisPanel);
		panel.add(panel2);
		setTitle("Paper Scissors Rock");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private static void evaluateGame(int userChoice)
	{
		String[] choices = {"paper", "scissors", "rock", "lizzard", "spock"};
		String[] details = {"Nothing happens",
				"Scissors cut paper",
				"Paper covers rock",
				"Rock crushes lizard",
				"Lizard poisons Spock",
				"Spock melts scissors",
				"Scissors decapitate lizard",
				"Lizard eats paper",
				"Paper disproves Spock",
				"Spock vaporizes rock",
				"Rock breaks scissors"};
		area.setText("You chose " + choices[userChoice] + "\n");
		int i;
		if (extendGame.getState())
		{
			i = new Random().nextInt(5);

		}
		else
		{
			i = new Random().nextInt(3);

		}
		String[][] outcome ={ /////////////////////////////////////////CPU CHOICE/////////////////////////////  
							//	Paper			Scissors		Rock			Lizzard			Spock		//				  C
							 {"It's a draw!","You Lose!"	,"You Win!"		, "You Lose!"	,"You Win"}		//Paper			U H 
							,{"You Win!"	,"It's a draw!"	,"You Lose!"	, "You Win!"	,"You Lose!"}	//Scissors		S O 
							,{"You Lose!"	,"You Win!"		,"It's a draw!"	, "You Win!"	,"You Lose!"}	//Rock			E I 
							,{"You Win!"	,"You Lose!"	,"You Lose!"	, "It's a Draw"	,"You Win!"}	//Lizzard		R C
							,{"You Lose!"	,"You Win!"		,"You Win!"		, "You Lose!"	,"It's a draw!"}//Spock			  E
							};	
		int[][] detailInt ={ ////////////////////CPU CHOICE/////////////////////////////  
				//	Paper			Scissors		Rock			Lizzard		Spock		//				  C
				 {0				,1					,2				, 7			,8}		//Paper			U H 
				,{1				,0					,10				,6 			,5}	//Scissors		S O 
				,{2				,10					,0				,3 			,9}	//Rock			E I 
				,{7				,6					,3				,0 			,4}	//Lizzard		R C
				,{8				,5					,9				,4 			,0}//Spock			  E
				};
		
		area.append("CPU chose " + choices[i] + "\n");
		if (extendedDetails.getState())
		{
			area.append(details[detailInt[userChoice][i]] + "\n");
		}
		area.append(outcome[userChoice][i]);
		
		if (outcome[userChoice][i].equals("You Win!"))
		{
			playerScore++;
		}
		else if (outcome[userChoice][i].equals("You Lose!"))
		{
			cpuScore++;
		}
		
		playerLabel.setText("Player: " + playerScore + "   ");
		cpuLabel.setText("  CPU: " + cpuScore);
	}


	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				PSR ex = new PSR();
				ex.setVisible(true);
			}
		});
	}

}
