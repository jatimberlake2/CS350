/*
CS 350-001
Project #2
Justin Anthony Timberlake
This class is what was executed in order to test the CTetriMino and Cmino java classes. 
*/

import javax.swing.JFrame;

public class TestCMino
{
   public static void main( String[] args )
   { 
      JFrame application = new JFrame( "Building Blocks" );
      
      CTetriMino CTetriMino = new CTetriMino();
      application.add(CTetriMino);
  
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.setSize( 800, 540 ); // set frame size
      application.setVisible( true ); // display frame
   }
}