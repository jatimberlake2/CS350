package Project3;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class CSample {
	public String record;
	public String zip;
	public String mediaChoice;
	public String age;
	public String useTime;

	
    public CSample(String record, String zip, String mediaChoice, String age, String useTime) {
		this.record = record;
		this.zip = zip;
		this.mediaChoice = mediaChoice;
		this.age = age;
		this.useTime = useTime;		
			    
    }
    
    public CSample(){
		this.record = "";
		this.zip = "";
		this.mediaChoice = "";
		this.age = "";
		this.useTime = "---";	
    }
    
	@Override
	public String toString()
	{
		// Formats the string so that it aligns the parts into columns under the headings by adding pad spaces to the right of each part.
		return String.format("%-21s %-22s %-21s %-21s %s", this.record, this.zip, this.mediaChoice, this.age, this.useTime);
	}

	
}
