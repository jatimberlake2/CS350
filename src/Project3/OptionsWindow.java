package Project3;

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


public class OptionsWindow extends JDialog implements ActionListener
{
	
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
	
	
	private JRadioButton early_age_rbutton 	= null;
	private JRadioButton lower_age_rbutton 	= null;
	private JRadioButton mid_age_rbutton 		= null;
	private JRadioButton upper_age_rbutton 		= null;
	
	
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

	
	public OptionsWindow(JFrame owner, String title, CSample s)
	{
		super(owner, title, true);
		
	    Container c = getContentPane();
	    c.setLayout(null);
		
	    record_label = new JLabel("Record Number");
	    record_label.setSize( 150, 20 );
	    record_label.setLocation( 20, 20 );
	    record_label.setForeground(Color.blue);
		c.add(record_label);
		
		record_no_label = new JLabel(s.record);
		record_no_label.setSize( 150, 20 );
		record_no_label.setLocation( 130, 20 );
		record_no_label.setForeground(Color.red);
		c.add(record_no_label);
		
		zipcode_label = new JLabel("Zipcode");
		zipcode_label.setSize( 150, 20 );
		zipcode_label.setLocation( 20, 60 );
		zipcode_label.setForeground(Color.blue);
		c.add(zipcode_label);
		
		social_media_label = new JLabel("What social media do you use?");
		social_media_label.setSize( 300, 20 );
		social_media_label.setLocation( 20, 100 );
		social_media_label.setForeground(Color.blue);
		c.add(social_media_label);
		
		age_group_label = new JLabel("What is your age?");
		age_group_label.setSize( 150, 20 );
		age_group_label.setLocation( 20, 160 );
		age_group_label.setForeground(Color.blue);
		c.add(age_group_label);
		
		avg_time_label = new JLabel("How much time do you spend on social media on an average day?");
		avg_time_label.setSize( 600, 20 );
		avg_time_label.setLocation( 20, 220 );
		avg_time_label.setForeground(Color.blue);
		c.add(avg_time_label);
		
		facebook_rbutton = new JCheckBox("Facebook");
		facebook_rbutton.setSize( 85, 25 );
		facebook_rbutton.setLocation( 40, 120 );
		c.add(facebook_rbutton);
		
		twitter_rbutton = new JCheckBox("Twitter");
		twitter_rbutton.setSize(85, 25 );
		twitter_rbutton.setLocation( 140, 120);
		c.add(twitter_rbutton);
		
		linkedin_rbutton = new JCheckBox("LinkedIn");
		linkedin_rbutton.setSize( 85, 25 );
		linkedin_rbutton.setLocation( 220, 120);
		c.add(linkedin_rbutton);
		
		pinterest_rbutton = new JCheckBox("Pinterest");
		pinterest_rbutton.setSize( 85, 25 );
		pinterest_rbutton.setLocation( 320, 120);
		c.add(pinterest_rbutton);
		
		others_rbutton = new JCheckBox("Others");
		others_rbutton.setSize( 85, 25 );
		others_rbutton.setLocation( 420, 120);
		c.add(others_rbutton);
		
		if (s.mediaChoice == "Facebook")
		{
			facebook_rbutton.setSelected(true);
		}
		else if (s.mediaChoice == "Twitter")
		{
			twitter_rbutton.setSelected(true);
		}
		else if (s.mediaChoice == "LinkedIn")
		{
			linkedin_rbutton.setSelected(true);
		}
		else if (s.mediaChoice == "Pinterest")
		{
			pinterest_rbutton.setSelected(true);
		}
		else if (s.mediaChoice == "Others")
		{
			others_rbutton.setSelected(true);
		}
		
		early_age_rbutton = new JRadioButton("19 or less");
		early_age_rbutton.setSize( 100, 25 );
		early_age_rbutton.setLocation(	40, 180 );
		c.add(early_age_rbutton);
		
		lower_age_rbutton = new JRadioButton("20 - 35");
		lower_age_rbutton.setSize( 100, 25 );
		lower_age_rbutton.setLocation( 140, 180 );
		c.add(lower_age_rbutton);
		
		mid_age_rbutton = new JRadioButton("36 - 49");
		mid_age_rbutton.setSize( 100, 25 );
		mid_age_rbutton.setLocation( 240, 180);
		c.add(mid_age_rbutton);
		
		upper_age_rbutton = new JRadioButton("50 and up");
		upper_age_rbutton.setSize( 100, 25 );
		upper_age_rbutton.setLocation( 340, 180);
		c.add(upper_age_rbutton);
		
		
		if (s.age == "  -19")
		{
			early_age_rbutton.setSelected(true);
		}
		else if (s.age == "20-35")
		{
			lower_age_rbutton.setSelected(true);
		}
		else if (s.age == "36-49")
		{
			mid_age_rbutton.setSelected(true);
		}
		else if (s.age == "50-  ")
		{
			upper_age_rbutton.setSelected(true);
		}
		
		lease_hours_checkbox = new JRadioButton("< 0.5 hour (L)");
		lease_hours_checkbox.setSize( 100, 25 );
		lease_hours_checkbox.setVisible(true);
		lease_hours_checkbox.setLocation(20, 240);
		if (s.mediaChoice.contains("L"))
		{
			lease_hours_checkbox.setSelected(true);
		}
		c.add(lease_hours_checkbox);
		
		lower_hours_checkbox = new JRadioButton("between 0.5 and 1 hour (M)");
		lower_hours_checkbox.setSize( 204, 25 );
		lower_hours_checkbox.setVisible(true);
		lower_hours_checkbox.setLocation(140, 240);
		if (s.mediaChoice.contains("M"))
		{
			lower_hours_checkbox.setSelected(true);
		}
		c.add(lower_hours_checkbox);
		
		upper_hours_checkbox = new JRadioButton("between 1 and 2 hrs (H)");
		upper_hours_checkbox.setSize( 204, 25 );
		upper_hours_checkbox.setVisible(true);
		upper_hours_checkbox.setLocation(340, 240);
		if (s.mediaChoice.contains("H"))
		{
			upper_hours_checkbox.setSelected(true);
		}
		c.add(upper_hours_checkbox);
		
		top_hours_checkbox = new JRadioButton("longer than 2 hrs (X)");
		top_hours_checkbox.setSize(204, 25);
		top_hours_checkbox.setVisible(true);
		top_hours_checkbox.setLocation(540, 240);
		if(s.mediaChoice.contains("X"))
		{
			top_hours_checkbox.setSelected(true);
		}
		c.add(top_hours_checkbox);
		
		zipcode_txt = new JTextField(s.zip);
		zipcode_txt.setSize(75, 30);
		zipcode_txt.setLocation( 136, 60 );
		c.add(zipcode_txt);
		
		submit_button = new JButton("Submit");
		submit_button.setSize( 150, 50 );
		submit_button.setLocation( 70, 360 );
		submit_button.addActionListener(this);
		c.add(submit_button);
		
		cancel_button = new JButton("Cancel");
		cancel_button.setSize( 150, 50 );
		cancel_button.setLocation( 300, 360 );
		cancel_button.addActionListener(this);
		c.add(cancel_button);
		
		
		setSize( 800, 700 );
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
	