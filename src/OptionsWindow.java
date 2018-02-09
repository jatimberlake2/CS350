/*
CS 350-001
Project #5
Justin Anthony Timberlake

The Options window pops up when one wishes to add or modify a specific CSample object in the list
of survey results.The first part consists largely of declaring variables and building the GUI. The
second portion (actionPerformed) describes the cases where each action is taken depending on user
interaction.

Added Save and Open buttons for project 5.

*/

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.io.Serializable;


public class OptionsWindow extends JDialog implements ActionListener, Serializable
{
	
	private JLabel RecordNumber = null;
	private JLabel recordL   = null;
	private JLabel zipL  = null;
	private JLabel SocialMedL  = null;
	private JLabel ageL   = null;
	private JLabel useTimeL = null;
	private JCheckBox FacebookBox 	 = null;
	private JCheckBox TwitterBox = null;
	private JCheckBox LinkedInBox = null;
	private JCheckBox PinterestBox  = null;
	private JCheckBox OthersBox  = null;	
	private JRadioButton Age1B = null;
	private JRadioButton Age2B = null;
	private JRadioButton Age3B = null;
	private JRadioButton Age4B = null;
	private JTextField ZipTxt = null;
	private JRadioButton LtimeB = null;
	private JRadioButton MtimeB  = null;
	private JRadioButton HtimeB  = null;
	private JRadioButton XtimeB = null;
	JFrame checkboxes;
	private JButton submitB = null;
	private JButton cancelB = null;
	private String record;
	private String zip;
	private String mediaChoice;
	private String age;
	private String useTime;
	private CSample result;
	
	public CSample getSurvey()	{ return result; }
	private boolean cancelled = true;
	
    public boolean isCancelled() { return cancelled; }
	
	public OptionsWindow(JFrame owner, String title, CSample s)
	{
		super(owner, title, true);
		
	    Container c = getContentPane();
	    c.setLayout(null);
		
	    RecordNumber = new JLabel("Record Number");
	    RecordNumber.setSize( 150, 20 );
	    RecordNumber.setLocation( 20, 20 );
	    RecordNumber.setForeground(Color.blue);
		c.add(RecordNumber);
		recordL = new JLabel(s.record);
		recordL.setSize( 150, 20 );
		recordL.setLocation( 130, 20 );
		recordL.setForeground(Color.red);
		c.add(recordL);
		zipL = new JLabel("Zipcode");
		zipL.setSize( 150, 20 );
		zipL.setLocation( 20, 60 );
		zipL.setForeground(Color.blue);
		c.add(zipL);
		SocialMedL = new JLabel("What social media do you use?");
		SocialMedL.setSize( 300, 20 );
		SocialMedL.setLocation( 20, 100 );
		SocialMedL.setForeground(Color.blue);
		c.add(SocialMedL);
		ageL = new JLabel("What is your age?");
		ageL.setSize( 150, 20 );
		ageL.setLocation( 20, 160 );
		ageL.setForeground(Color.blue);
		c.add(ageL);
		useTimeL = new JLabel("How much time do you spend on social media on an average day?");
		useTimeL.setSize( 600, 20 );
		useTimeL.setLocation( 20, 220 );
		useTimeL.setForeground(Color.blue);
		c.add(useTimeL);
		
		FacebookBox = new JCheckBox("Facebook");
		FacebookBox.setSize( 85, 25 );
		FacebookBox.setLocation( 40, 120 );
		c.add(FacebookBox);
		TwitterBox = new JCheckBox("Twitter");
		TwitterBox.setSize(85, 25 );
		TwitterBox.setLocation( 140, 120);
		c.add(TwitterBox);
		LinkedInBox = new JCheckBox("LinkedIn");
		LinkedInBox.setSize( 85, 25 );
		LinkedInBox.setLocation( 220, 120);
		c.add(LinkedInBox);
		PinterestBox = new JCheckBox("Pinterest");
		PinterestBox.setSize( 85, 25 );
		PinterestBox.setLocation( 320, 120);
		c.add(PinterestBox);
		OthersBox = new JCheckBox("Others");
		OthersBox.setSize( 85, 25 );
		OthersBox.setLocation( 420, 120);
		c.add(OthersBox);
		if (s.mediaChoice == "Facebook")
		{
			FacebookBox.setSelected(true);
		}
		else if (s.mediaChoice == "Twitter")
		{
			TwitterBox.setSelected(true);
		}
		else if (s.mediaChoice == "LinkedIn")
		{
			LinkedInBox.setSelected(true);
		}
		else if (s.mediaChoice == "Pinterest")
		{
			PinterestBox.setSelected(true);
		}
		else if (s.mediaChoice == "Others")
		{
			OthersBox.setSelected(true);
		}
		
		Age1B = new JRadioButton("19 or less");
		Age1B.setSize( 100, 25 );
		Age1B.setLocation(	40, 180 );
		c.add(Age1B);
		Age2B = new JRadioButton("20 - 35");
		Age2B.setSize( 100, 25 );
		Age2B.setLocation( 140, 180 );
		c.add(Age2B);
		Age3B = new JRadioButton("36 - 49");
		Age3B.setSize( 100, 25 );
		Age3B.setLocation( 240, 180);
		c.add(Age3B);
		Age4B = new JRadioButton("50 and up");
		Age4B.setSize( 100, 25 );
		Age4B.setLocation( 340, 180);
		c.add(Age4B);		
		if (s.age == "  -19")
		{
			Age1B.setSelected(true);
		}
		else if (s.age == "20-35")
		{
			Age2B.setSelected(true);
		}
		else if (s.age == "36-49")
		{
			Age3B.setSelected(true);
		}
		else if (s.age == "50-  ")
		{
			Age4B.setSelected(true);
		}
		
		LtimeB = new JRadioButton("< 0.5 hour (L)");
		LtimeB.setSize( 100, 25 );
		LtimeB.setVisible(true);
		LtimeB.setLocation(20, 240);
		if (s.mediaChoice.contains("L"))
		{
			LtimeB.setSelected(true);
		}
		c.add(LtimeB);
		MtimeB = new JRadioButton("between 0.5 and 1 hour (M)");
		MtimeB.setSize( 204, 25 );
		MtimeB.setVisible(true);
		MtimeB.setLocation(140, 240);
		if (s.mediaChoice.contains("M"))
		{
			MtimeB.setSelected(true);
		}
		c.add(MtimeB);
		HtimeB = new JRadioButton("between 1 and 2 hrs (H)");
		HtimeB.setSize( 204, 25 );
		HtimeB.setVisible(true);
		HtimeB.setLocation(340, 240);
		if (s.mediaChoice.contains("H"))
		{
			HtimeB.setSelected(true);
		}
		c.add(HtimeB);
		XtimeB = new JRadioButton("longer than 2 hrs (X)");
		XtimeB.setSize(204, 25);
		XtimeB.setVisible(true);
		XtimeB.setLocation(540, 240);
		if(s.mediaChoice.contains("X"))
		{
			XtimeB.setSelected(true);
		}
		c.add(XtimeB);
		
		ZipTxt = new JTextField(s.zip);
		ZipTxt.setSize(75, 30);
		ZipTxt.setLocation( 136, 60 );
		c.add(ZipTxt);
		
		submitB = new JButton("Submit");
		submitB.setSize( 150, 50 );
		submitB.setLocation( 70, 280 );
		submitB.addActionListener(this);
		c.add(submitB);
		cancelB = new JButton("Cancel");
		cancelB.setSize( 150, 50 );
		cancelB.setLocation( 300, 280 );
		cancelB.addActionListener(this);
		c.add(cancelB);
		
		setSize( 750, 400 );
	    setLocation( 100, 100 );
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==submitB)
		{
			this.record = recordL.getText();
			
			this.mediaChoice = "";
			if (FacebookBox.isSelected()){
				this.mediaChoice += "F";
			}
			else{
				this.mediaChoice += "-";
			}
			if (TwitterBox.isSelected()){
				this.mediaChoice += "T";
			}
			else{
				this.mediaChoice += "-";
			}
			if (LinkedInBox.isSelected()){
				this.mediaChoice += "L";
			}
			else{
				this.mediaChoice += "-";
			}
			if (PinterestBox.isSelected()){
				this.mediaChoice += "P";
			}
			else{
				this.mediaChoice += "-";
			}
			if (OthersBox.isSelected()){
				this.mediaChoice += "O";
			}
			else{
				this.mediaChoice += "-";
			}
			
			if (ZipTxt.getText().equals(""))
			{
				this.zip = null;
			}
			else
			{
				this.zip = ZipTxt.getText();
			}
			
			if (Age1B.isSelected()) this.age = "  - 19";
			if (Age2B.isSelected()) this.age = "20 - 35";
			if (Age3B.isSelected()) this.age = "36 - 49";
			if (Age4B.isSelected()) this.age = "50 -  ";

			
			
			if (LtimeB.isSelected())
			{
				this.useTime = "L";
			}
			if (MtimeB.isSelected())
			{
				this.useTime = "M";
			}
			if (HtimeB.isSelected())
			{
				this.useTime = "H";
			}
			if(XtimeB.isSelected())
			{
				this.useTime = "X";
			}

			result = new CSample(this.record, this.zip, this.mediaChoice, this.age, this.useTime);
			
		    cancelled = false;
		    setVisible(false);
		}
		else if(e.getSource() == cancelB)
		{
		    cancelled = true;
		    setVisible(false);
		}
	}
}
	