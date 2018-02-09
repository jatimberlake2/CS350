/*
CS 350-001
Project #1
Justin Anthony Timberlake
Choose a number between 1 and 5 inclusive to generate 5 different
	kinds of graphs as well as a second number for how many line segments
	you want to use in order to create said graph. Enter both numbers into
	a "curve.txt" file on two separate lines in order to read them into 
	this program. The graph will be generated in a window labeled "Curves".
*/

import java.awt.*;
import javax.swing.JPanel;
	
public class p1 extends JPanel{

	   private int choice; // user's choice of which function
	   private int iter; // how many lines drawn
	   
	   // constructor sets the user's choice
	   public p1( int userChoice, int iterations )
	   {
	      choice = userChoice;
	      iter = iterations;
	   } // end p1 constructor
	   
	   public void paintComponent( Graphics g )
	   {
	      super.paintComponent( g );
	      
	      g.setColor(Color.black);
	      
	      int xaxis = 213; //distance from top of graph to the x-axis
	      int yaxis = 30;  //distance from the left of the graph to the y-axis	    
	      int lenx = 220;  //distance from the y-axis to the last tick of the x-axis
	      int leny = 200;  //distance from the x-axis to the top tick of the y-axis
	      g.drawLine(yaxis, 5, yaxis, getHeight() - 15);  //draw the initial y-axis
	      g.drawLine(15, xaxis, lenx + 35, xaxis);		  //draw the initial x-axis

	      for ( int j = 1; j < 5; j++)			//for loop to generate ticks on y-axis as well as numbering
	      {
	    	  g.drawLine(27, xaxis - (leny/4)*j, 37, xaxis - (leny/4)*j);
		      g.drawString(String.format("%s",j*.25), 3, xaxis - (leny/4)*j + 6);
	      }
	      
	      g.drawString("0", yaxis - 10, xaxis + 13);	//add the zero onto the graph

	      for ( int k = 1; k <= 10; k++)		//for loop to generate ticks on the x-axis as well as numbering
	      {
	    	  g.drawLine(yaxis + (lenx/10)*k, xaxis+5, (yaxis + (lenx/10)*k), xaxis-5);
	    	  double tick = Math.floor((.1*k) * 100) / 100;		//round off to one decimal place
	    	  g.drawString(String.format("%s", tick), (lenx/10)*k+23, xaxis+15);
	      }
	      double interval = 1.0/iter;			//dividing the values between 0 and 1 evenly depending on user's preferred number of line segments
	      for ( double i = 0; i < 1; i += interval)		//for loop to increment through whatever intervals were just defined
	      {
	         switch ( choice )
	         {
	            case 1:						//y = x - 1
	            	double y1 = 1 - i;
	            	y1 = (1-y1)*leny + 13;
	            	double y2 = 1 - (i+interval);
	            	y2 = (1-y2)*leny + 13;
	            	g.drawLine((int)(lenx*i+yaxis),(int) y1, (int)(lenx*(i+interval)+yaxis),(int) y2);
	            		break;
	            case 2: 					//y = e^(-0.25*x)
	            	double yy1 = Math.pow(Math.E, (-.25)*i);
	            	yy1 = (1-yy1)*leny + 13;
	            	double yy2 = Math.pow(Math.E, (-.25)*(i+interval));
	            	yy2 = (1-yy2)*leny + 13;
	            	g.drawLine((int)(lenx*i+yaxis),(int) yy1, (int)(lenx*(i+interval)+yaxis),(int) yy2);
	 	                break;
	            case 3: 					//y = e^(-0.5*x)
	            	double yyy1 = Math.pow(Math.E, (-.5)*i);
	            	yyy1 = (1-yyy1)*leny + 13;
	            	double yyy2 = Math.pow(Math.E, (-.5)*(i+interval));
	            	yyy2 = (1-yyy2)*leny + 13;
	            	g.drawLine((int)(lenx*i+yaxis),(int) yyy1, (int)(lenx*(i+interval)+yaxis),(int) yyy2);
	 	                break;
	            case 4: 					//y = e^(-0.75*x)
	            	double yyyy1 = Math.pow(Math.E, (-.75)*i);
	            	yyyy1 = (1-yyyy1)*leny + 13;
	            	double yyyy2 = Math.pow(Math.E, (-.75)*(i+interval));
	            	yyyy2 = (1-yyyy2)*leny + 13;
	            	g.drawLine((int)(lenx*i+yaxis),(int) yyyy1, (int)(lenx*(i+interval)+yaxis),(int) yyyy2);
	 	                break;
	            case 5:						//y = e^(-x)
	            	double yyyyy1 = Math.pow(Math.E, -i);
	            	yyyyy1 = (1-yyyyy1)*leny + 13;
	            	double yyyyy2 = Math.pow(Math.E, -(i+interval));
	            	yyyyy2 = (1-yyyyy2)*leny + 13;
	            	g.drawLine((int)(lenx*i+yaxis),(int) yyyyy1, (int)(lenx*(i+interval)+yaxis),(int) yyyyy2);
	            		break;

	         } // end switch
	      } // end for
	   } 
	}