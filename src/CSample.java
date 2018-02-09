/*
CS 350-001
Project #5
Justin Anthony Timberlake

This is the given CSample class for building objects with all necessary attributes to be added to the survey result list.

*/


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;


public class CSample implements Serializable {
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
    
	public String toString()
	{
		return String.format("%-15s %-15s %-11s %-15s %s", this.record, this.zip, this.mediaChoice, this.age, this.useTime);
		//formatting
	}

	
}
