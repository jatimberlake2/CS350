package Project3;

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

import Project3.CSample;
import Project3.OptionsWindow;

public class SocialSurvey extends JFrame implements ActionListener {
		JLabel myLabel;
	    JButton myButton;
	    
	    JLabel RecordNo;
	    JLabel ZipCode;
	    JLabel SocialMedia;
	    JLabel AgeGroup;
	    JLabel AvgTime;
	    
		private ArrayList<CSample> sArray;
	    private DefaultListModel surveys;
	    private JList sList;
		private JScrollPane scrollPane = null;
		
		private JButton add = null;
		private JButton modify = null;
		private JButton delete = null;
		private JButton deleteAll = null;
		
		private static long ID = 1;

	    public SocialSurvey() {
			super("Survey on Social Media");

		    Container c = getContentPane();
		    c.setLayout(null);		
			
			RecordNo = new JLabel("Record No.");
			RecordNo.setSize(250, 25);
			RecordNo.setLocation(15,15);
		    RecordNo.setForeground(Color.blue);
			c.add(RecordNo);
			
			ZipCode = new JLabel("Zip Code");
			ZipCode.setSize(250, 25);
			ZipCode.setLocation(115,15);
		    ZipCode.setForeground(Color.blue);
			c.add(ZipCode);
			
			SocialMedia = new JLabel("Social Media");
			SocialMedia.setSize(250, 25);
			SocialMedia.setLocation(215,15);
		    SocialMedia.setForeground(Color.blue);
			c.add(SocialMedia);
			
			AgeGroup = new JLabel("Age Group");
			AgeGroup.setSize(250, 25);
			AgeGroup.setLocation(315,15);
		    AgeGroup.setForeground(Color.blue);
			c.add(AgeGroup);
			
			AgeGroup = new JLabel("Avg Time");
			AgeGroup.setSize(250, 25);
			AgeGroup.setLocation(415,15);
		    AgeGroup.setForeground(Color.blue);
			c.add(AgeGroup);
			
			surveys = new DefaultListModel();
			
			sList = new JList(surveys);
			sList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
			sList.setFont(new Font("Monospaced", Font.PLAIN, 12));
			sList.setLayoutOrientation(1);
			
		    scrollPane = new JScrollPane(sList);
		    scrollPane.setSize(475, 220);
		    scrollPane.setLocation(10, 50);
		    
		    c.add( scrollPane );
		    
		    add = new JButton("Add");
			add.setSize( 100, 20 );
			add.setLocation( 20, 280 );
			add.addActionListener(this);
			c.add(add);

			modify = new JButton("Modify");
			modify.setSize( 100, 20 );
			modify.setLocation( 135, 280 );
			modify.addActionListener(this);
			c.add(modify);
			
			delete = new JButton("Delete");
			delete.setSize( 100, 20 );
			delete.setLocation( 250, 280 );
			delete.addActionListener(this);
			c.add(delete);

			deleteAll= new JButton("Delete All");
			deleteAll.setSize( 100, 20 );
			deleteAll.setLocation( 365, 280 );
			deleteAll.addActionListener(this);
			c.add(deleteAll);
			
		    setSize( 520, 375 );
		    setLocation( 100, 100 );
		    setVisible(true);
	   }
	    
	    public void actionPerformed(ActionEvent e) {
	    	{
	    		if(e.getSource() == add)
	    		{
	    			String ID_number = String.format("%06d", ID++);
	    			CSample s = new CSample(ID_number, "", "", "", "---");
	    			OptionsWindow sWindow = new OptionsWindow(this, "Add A Survey Sample", s);
	    		    if (!sWindow.isCancelled())
	    		    {
	    		    	sArray.add(sWindow.getSurvey());
	    		    	surveys.addElement(sWindow.getSurvey().toString());
	                    sList.setSelectedIndex(surveys.size()-1);
	                    sList.ensureIndexIsVisible(surveys.size()-1);
	    		    }
	    		}
	    	    else if(e.getSource() == modify)
	    	    {
	    	    	int index = sList.getSelectedIndex();
	    	    	if (index >= 0)
	    	    	{
	    	    		OptionsWindow dialogWnd = new OptionsWindow(this, "Modify A Survey Sample", sArray.get(index));
	    			    if (!dialogWnd.isCancelled())
	    			    {
	    			    	sArray.set(index, dialogWnd.getSurvey());
	    			    	surveys.set(index, dialogWnd.getSurvey());
	    			    }
	    	    	}
	    		}
	    	    else if(e.getSource() == delete)
	    	    {
	    	    	int index = sList.getSelectedIndex();
	    	    	if (index >= 0)
	    	    	{
	    	    		sArray.remove(index);
	    			    surveys.remove(index);
	    			    if (surveys.size() > 0)
	    			    {	// not empty
	    			    	if (index == surveys.size())
	    			    	{	// last one deleted
	    			    		index--;
	    			    	}
	    			    	sList.setSelectedIndex(index);
	    			    	sList.ensureIndexIsVisible(index);
	    			    }
	    	    	}
	    		}
	    	    else if(e.getSource() == deleteAll)
	    	    {
	    	    	while (sArray.size() != 0) // loop through and delete all surveys until list is empty
	    	    	{
	    	    		sArray.remove(0);
	    	    		surveys.remove(0);
	    	    	}
	    		}
	        }

	    }
    }