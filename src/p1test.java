/*
CS 350-001
Project #1
Justin Anthony Timberlake
Not much editing here; changed a few names in order to work with objects of p1 type rather than "Shapes"
*/

import java.io.*;	// added by Zhang
	import java.util.*;	// added by Zhang
	import javax.swing.JFrame;
public class p1test {

	   public static void main( String[] args )
	   {

		  int choice=1;
		  int iter = 10;
		  Scanner input;
		  try {
			  input=new Scanner(new File("curve.txt"));
			  choice=input.nextInt();
			  iter = input.nextInt();
			  input.close();
		  }

		  catch (IOException e) {
			   System.err.println(e);
			   System.exit(1);
		  }
		  // end of addition by Zhang
		   
	      p1 panel = new p1( choice, iter ); //utilizes modified constructor in p1 class
	      
	      JFrame application = new JFrame("Curves"); // creates a new JFrame

	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      application.add( panel ); // add the panel to the frame
	      application.setSize( 300, 300 ); // set the desired size
	      application.setVisible( true ); // show the frame
	   } // end main
	
}
