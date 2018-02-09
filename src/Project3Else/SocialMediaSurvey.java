package Project3Else;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class SocialMediaSurvey extends JFrame implements ActionListener{
	private static int WINDOW_WIDTH = 720;
	private static int WINDOW_HEIGHT = 320;
	private static int BUTTON_WIDTH = 162;
	private static int BUTTON_HEIGHT = 40;
	private static int BUTTON_Y = 230;
	private static int LABEL_WIDTH = 156;
	private static int LABEL_HEIGHT = 30;
	private static int SPACE = 10;
	
	private static long ID_COUTNER = 0; // used to generate IDs
	
	private JLabel id_label  = null;
	private JLabel zipcode_label  = null;
	private JLabel carrier_label  = null;
	private JLabel rating_label  = null;
	private JLabel services_label = null;
	private ArrayList<CSample> surveyArray;
    private DefaultListModel surveys;
    private JList surveyList;
	private JScrollPane scrollPane = null;
	private JButton add_button = null;
	private JButton modify_button = null;
	private JButton delete_button = null;
	private JButton delete_all_button = null;

    public SocialMediaSurvey()
    {
		super("Social Media Survey");
	
	    Container c = getContentPane();
	    c.setLayout(null);
	
	    id_label = new JLabel("Record No.");
	    id_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
	    id_label.setLocation( SPACE, 0 );
	    id_label.setForeground(Color.blue);
		c.add(id_label);
		
		zipcode_label = new JLabel("Zip Code");
		zipcode_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		zipcode_label.setLocation( SPACE + LABEL_WIDTH , 0 );
		zipcode_label.setForeground(Color.blue);
		c.add(zipcode_label);
	
		carrier_label = new JLabel("Social Media");
		carrier_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		carrier_label.setLocation( SPACE + 2*LABEL_WIDTH, 0 );
		carrier_label.setForeground(Color.blue);
		c.add(carrier_label);
		
		rating_label = new JLabel("Age Group");
		rating_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		rating_label.setLocation( SPACE + 3*LABEL_WIDTH, 0 );
		rating_label.setForeground(Color.blue);
		c.add(rating_label);
		
		services_label = new JLabel("Avg Time");
		services_label.setSize( LABEL_WIDTH, LABEL_HEIGHT );
		services_label.setLocation( SPACE + 4*LABEL_WIDTH, 0 );
		services_label.setForeground(Color.blue);
		c.add(services_label);
		
		surveyArray = new ArrayList(); 
		surveys = new DefaultListModel();
		surveyList = new JList(surveys);
		surveyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		surveyList.setFont(new Font("Monospaced", Font.PLAIN, 12));
		surveyList.setLayoutOrientation(1);
	    scrollPane = new JScrollPane(surveyList);
	    scrollPane.setSize(680, 190);
	    scrollPane.setLocation(SPACE, LABEL_HEIGHT);
	    c.add( scrollPane );
		
		add_button = new JButton("Add");
		add_button.setSize( BUTTON_WIDTH, BUTTON_HEIGHT );
		add_button.setLocation( SPACE, BUTTON_Y );
		add_button.addActionListener(this);
		c.add(add_button);

		modify_button = new JButton("Modify");
		modify_button.setSize( BUTTON_WIDTH, BUTTON_HEIGHT );
		modify_button.setLocation( 2*SPACE + BUTTON_WIDTH, BUTTON_Y );
		modify_button.addActionListener(this);
		c.add(modify_button);
		
		delete_button = new JButton("Delete");
		delete_button.setSize( BUTTON_WIDTH, BUTTON_HEIGHT );
		delete_button.setLocation( 3*SPACE + 2*BUTTON_WIDTH, BUTTON_Y );
		delete_button.addActionListener(this);
		c.add(delete_button);

		delete_all_button = new JButton("Delete All");
		delete_all_button.setSize( BUTTON_WIDTH, BUTTON_HEIGHT );
		delete_all_button.setLocation( 4*SPACE + 3*BUTTON_WIDTH, BUTTON_Y );
		delete_all_button.addActionListener(this);
		c.add(delete_all_button);
		
		setSize( WINDOW_WIDTH, WINDOW_HEIGHT );
	    setLocation( 100, 100 );
	    setVisible(true);
    }

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == add_button)
		{
			// makes the id always 6 digits, and generates it from the static variable. post-increments to ensure uniqueness
			String newID = String.format("%06d", ID_COUTNER++);
			CSample s = new CSample(newID, "", "", "", "---");
			SurveyWindow surveyWindow = new SurveyWindow(this, "Add A Survey Sample", s);
		    if (!surveyWindow.isCancelled())
		    {
		    	surveyArray.add(surveyWindow.getSurvey());
		    	surveys.addElement(surveyWindow.getSurvey().toString());
                surveyList.setSelectedIndex(surveys.size()-1);
                surveyList.ensureIndexIsVisible(surveys.size()-1);
		    }
		}
	    else if(e.getSource() == modify_button)
	    {
	    	int index = surveyList.getSelectedIndex();
	    	if (index >= 0)
	    	{
	    		SurveyWindow dialogWnd = new SurveyWindow(this, "Modify A Survey Sample", surveyArray.get(index));
			    if (!dialogWnd.isCancelled())
			    {
			    	surveyArray.set(index, dialogWnd.getSurvey());
			    	surveys.set(index, dialogWnd.getSurvey());
			    }
	    	}
		}
	    else if(e.getSource() == delete_button)
	    {
	    	int index = surveyList.getSelectedIndex();
	    	if (index >= 0)
	    	{
	    		surveyArray.remove(index);
			    surveys.remove(index);
			    if (surveys.size() > 0)
			    {	// not empty
			    	if (index == surveys.size())
			    	{	// last one deleted
			    		index--;
			    	}
			    	surveyList.setSelectedIndex(index);
			    	surveyList.ensureIndexIsVisible(index);
			    }
	    	}
		}
	    else if(e.getSource() == delete_all_button)
	    {
	    	while (surveyArray.size() != 0) // loop through and delete all surveys until list is empty
	    	{
	    		surveyArray.remove(0);
	    		surveys.remove(0);
	    	}
		}
    }
}
