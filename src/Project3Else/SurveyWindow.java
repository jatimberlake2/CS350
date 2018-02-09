package Project3Else;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SurveyWindow extends JDialog implements ActionListener
{
	private static int WINDOW_WIDTH = 800;
	private static int WINDOW_HEIGHT = WINDOW_WIDTH - 100;
	private static int BUTTON_WIDTH = 162;
	private static int BUTTON_HEIGHT = 40;
	private static int LABEL_WIDTH = 156;
	private static int LABEL_HEIGHT = 20;
	private static int SPACE = 20;
	
	private JLabel record_label  	  = null;
	private JLabel record_no_label   = null;
	private JLabel zipcode_label  = null;
	private JLabel social_media_label  = null;
	private JLabel age_group_label   = null;
	private JLabel avg_time_label = null;
	
	private JCheckBox facebook_rbutton 	 = null;
	private JCheckBox twitter_rbutton = null;
	private JCheckBox linkedin_rbutton = null;
	private JCheckBox pinterest_rbutton  = null;
	private JCheckBox others_rbutton  = null;
	
	private ButtonGroup media_group;
	
	private JRadioButton early_age_rbutton 	= null;
	private JRadioButton lower_age_rbutton 	= null;
	private JRadioButton mid_age_rbutton 		= null;
	private JRadioButton upper_age_rbutton 		= null;
	
	
	private ButtonGroup age_group;
	
	private JTextField zipcode_txt = null;
	
	private JRadioButton lease_hours_checkbox = null;
	private JRadioButton lower_hours_checkbox  = null;
	private JRadioButton upper_hours_checkbox  = null;
	private JRadioButton top_hours_checkbox = null;
	
	JFrame checkboxes;
	
	private JButton submit_button = null;
	private JButton cancel_button = null;
	
	private String recordNo;
	private String zipcode;
	private String socialMedia;
	private String AgeGroup;
	private String AvgTime;
	
	private CSample survey;
	
	public CSample getSurvey()	{ return survey; }
	
	private boolean cancelled = true;
    public boolean isCancelled() { return cancelled; }
    
    
    
    
	
	
	public SurveyWindow(JFrame owner, String title, CSample s)
	{
		super(owner, title, true);
		
	    Container c = getContentPane();
	    c.setLayout(null);
		
	    record_label = new JLabel("Record Number");
	    record_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
	    record_label.setLocation( SPACE, SPACE );
	    record_label.setForeground(Color.blue);
		c.add(record_label);
		
		record_no_label = new JLabel(s.recordNo);
		record_no_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		record_no_label.setLocation( LABEL_WIDTH - SPACE, SPACE );
		record_no_label.setForeground(Color.red);
		c.add(record_no_label);
		
		zipcode_label = new JLabel("Zipcode");
		zipcode_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		zipcode_label.setLocation( SPACE, (int)2*LABEL_HEIGHT + SPACE );
		zipcode_label.setForeground(Color.blue);
		c.add(zipcode_label);
		
		social_media_label = new JLabel("What social media do you use?");
		social_media_label.setSize( LABEL_WIDTH + LABEL_WIDTH, LABEL_HEIGHT );
		social_media_label.setLocation( SPACE, (int)4*LABEL_HEIGHT + SPACE );
		social_media_label.setForeground(Color.blue);
		c.add(social_media_label);
		
		age_group_label = new JLabel("What is your age?");
		age_group_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		age_group_label.setLocation( SPACE, (int)7*LABEL_HEIGHT + SPACE );
		age_group_label.setForeground(Color.blue);
		c.add(age_group_label);
		
		avg_time_label = new JLabel("How much time do you spend on social media on an average day?");
		avg_time_label.setSize( 4*LABEL_WIDTH, LABEL_HEIGHT );
		avg_time_label.setLocation( SPACE, 11*LABEL_HEIGHT );
		avg_time_label.setForeground(Color.blue);
		c.add(avg_time_label);
		
		facebook_rbutton = new JCheckBox("Facebook");
		facebook_rbutton.setSize( 85, 25 );
		facebook_rbutton.setLocation( 2*SPACE, 6*LABEL_HEIGHT );
		c.add(facebook_rbutton);
		
		twitter_rbutton = new JCheckBox("Twitter");
		twitter_rbutton.setSize(85, 25 );
		twitter_rbutton.setLocation( 6*SPACE + SPACE, 6*LABEL_HEIGHT);
		c.add(twitter_rbutton);
		
		linkedin_rbutton = new JCheckBox("LinkedIn");
		linkedin_rbutton.setSize( 85, 25 );
		linkedin_rbutton.setLocation( 10*SPACE+SPACE, 6*LABEL_HEIGHT);
		c.add(linkedin_rbutton);
		
		pinterest_rbutton = new JCheckBox("Pinterest");
		pinterest_rbutton.setSize( 85, 25 );
		pinterest_rbutton.setLocation( 15*SPACE+SPACE, 6*LABEL_HEIGHT);
		c.add(pinterest_rbutton);
		
		others_rbutton = new JCheckBox("Others");
		others_rbutton.setSize( 85, 25 );
		others_rbutton.setLocation( 20*SPACE+SPACE, 6*LABEL_HEIGHT);
		c.add(others_rbutton);
		
		if (s.socialMedia == "Facebook")
		{
			facebook_rbutton.setSelected(true);
		}
		else if (s.socialMedia == "Twitter")
		{
			twitter_rbutton.setSelected(true);
		}
		else if (s.socialMedia == "LinkedIn")
		{
			linkedin_rbutton.setSelected(true);
		}
		else if (s.socialMedia == "Pinterest")
		{
			pinterest_rbutton.setSelected(true);
		}
		else if (s.socialMedia == "Others")
		{
			others_rbutton.setSelected(true);
		}
		
		early_age_rbutton = new JRadioButton("19 or less");
		early_age_rbutton.setSize( 100, 25 );
		early_age_rbutton.setLocation(	2*SPACE, (int)9*LABEL_HEIGHT );
		c.add(early_age_rbutton);
		
		lower_age_rbutton = new JRadioButton("20 - 35");
		lower_age_rbutton.setSize( 100, 25 );
		lower_age_rbutton.setLocation( 6*SPACE + SPACE, (int)9*LABEL_HEIGHT );
		c.add(lower_age_rbutton);
		
		mid_age_rbutton = new JRadioButton("36 - 49");
		mid_age_rbutton.setSize( 100, 25 );
		mid_age_rbutton.setLocation( 11*SPACE+SPACE, (int)9*LABEL_HEIGHT);
		c.add(mid_age_rbutton);
		
		upper_age_rbutton = new JRadioButton("50 and up");
		upper_age_rbutton.setSize( 100, 25 );
		upper_age_rbutton.setLocation( 16*SPACE+SPACE, (int)9*LABEL_HEIGHT);
		c.add(upper_age_rbutton);
		
		
		if (s.AgeGroup == "  -19")
		{
			early_age_rbutton.setSelected(true);
		}
		else if (s.AgeGroup == "20-35")
		{
			lower_age_rbutton.setSelected(true);
		}
		else if (s.AgeGroup == "36-49")
		{
			mid_age_rbutton.setSelected(true);
		}
		else if (s.AgeGroup == "50-  ")
		{
			upper_age_rbutton.setSelected(true);
		}
		
		lease_hours_checkbox = new JRadioButton("< 0.5 hour (L)");
		lease_hours_checkbox.setSize( 100, 25 );
		lease_hours_checkbox.setVisible(true);
		lease_hours_checkbox.setLocation(SPACE, (int)12*LABEL_HEIGHT);
		if (s.socialMedia.contains("L"))
		{
			lease_hours_checkbox.setSelected(true);
		}
		c.add(lease_hours_checkbox);
		
		lower_hours_checkbox = new JRadioButton("between 0.5 and 1 hour (M)");
		lower_hours_checkbox.setSize( 204, 25 );
		lower_hours_checkbox.setVisible(true);
		lower_hours_checkbox.setLocation(6*SPACE+SPACE, (int)12*LABEL_HEIGHT);
		if (s.socialMedia.contains("M"))
		{
			lower_hours_checkbox.setSelected(true);
		}
		c.add(lower_hours_checkbox);
		
		upper_hours_checkbox = new JRadioButton("between 1 and 2 hrs (H)");
		upper_hours_checkbox.setSize( 204, 25 );
		upper_hours_checkbox.setVisible(true);
		upper_hours_checkbox.setLocation(16*SPACE+SPACE, (int)12*LABEL_HEIGHT);
		if (s.socialMedia.contains("H"))
		{
			upper_hours_checkbox.setSelected(true);
		}
		c.add(upper_hours_checkbox);
		
		top_hours_checkbox = new JRadioButton("longer than 2 hrs (X)");
		top_hours_checkbox.setSize(204, 25);
		top_hours_checkbox.setVisible(true);
		top_hours_checkbox.setLocation(26*SPACE + SPACE, (int)12*LABEL_HEIGHT);
		if(s.socialMedia.contains("X"))
		{
			top_hours_checkbox.setSelected(true);
		}
		c.add(top_hours_checkbox);
		
		zipcode_txt = new JTextField(s.zip);
		zipcode_txt.setSize(75, 30);
		zipcode_txt.setLocation( 136, (int)2*LABEL_HEIGHT + SPACE );
		c.add(zipcode_txt);
		
		submit_button = new JButton("Submit");
		submit_button.setSize( BUTTON_WIDTH, BUTTON_HEIGHT );
		submit_button.setLocation( BUTTON_WIDTH - 4*SPACE, 18*LABEL_HEIGHT );
		submit_button.addActionListener(this);
		c.add(submit_button);
		
		cancel_button = new JButton("Cancel");
		cancel_button.setSize( BUTTON_WIDTH, BUTTON_HEIGHT );
		cancel_button.setLocation( BUTTON_WIDTH *2, 18*LABEL_HEIGHT );
		cancel_button.addActionListener(this);
		c.add(cancel_button);
		
		
		setSize( WINDOW_WIDTH, WINDOW_HEIGHT );
	    setLocation( 100, 100 );
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==submit_button)
		{
			this.recordNo = record_no_label.getText();
			
			this.socialMedia = "";
			if (facebook_rbutton.isSelected()){
				this.socialMedia += "F";
			}
			else{
				this.socialMedia += "-";
			}
			if (twitter_rbutton.isSelected()){
				this.socialMedia += "T";
			}
			else{
				this.socialMedia += "-";
			}
			if (linkedin_rbutton.isSelected()){
				this.socialMedia += "L";
			}
			else{
				this.socialMedia += "-";
			}
			if (pinterest_rbutton.isSelected()){
				this.socialMedia += "P";
			}
			else{
				this.socialMedia += "-";
			}
			if (others_rbutton.isSelected()){
				this.socialMedia += "O";
			}
			else{
				this.socialMedia += "-";
			}
			
			if (zipcode_txt.getText().equals(""))
			{
				this.zipcode = null;
			}
			else
			{
				this.zipcode = zipcode_txt.getText();
			}
			
			if (early_age_rbutton.isSelected()) this.AgeGroup = "  - 19";
			if (lower_age_rbutton.isSelected()) this.AgeGroup = "20 - 35";
			if (mid_age_rbutton.isSelected()) this.AgeGroup = "36 - 49";
			if (upper_age_rbutton.isSelected()) this.AgeGroup = "50 -  ";

			
			
			if (lease_hours_checkbox.isSelected())
			{
				this.AvgTime = "L";
			}
			if (lower_hours_checkbox.isSelected())
			{
				this.AvgTime = "M";
			}
			if (upper_hours_checkbox.isSelected())
			{
				this.AvgTime = "H";
			}
			if(top_hours_checkbox.isSelected())
			{
				this.AvgTime = "X";
			}
			
			
			
			survey = new CSample(this.recordNo, this.zipcode, this.socialMedia, this.AgeGroup, this.AvgTime);
			
		    cancelled = false;
		    setVisible(false);
		}
		else if(e.getSource() == cancel_button)
		{
		    cancelled = true;
		    setVisible(false);
		}
	}
}
	