/*
CS 350-001
Project #5
Justin Anthony Timberlake

This class was merely used in order to test the other classes presented.

*/

import javax.swing.JFrame;

import java.io.File;
import java.io.Serializable;

public class TestSurvey {
		private static File save_file = null;
		public static void main( String[] args )
		{
			if (args.length != 0)
			{
				save_file = new File(args[0]);
			}
			SocialSurvey mainWnd = new SocialSurvey(save_file);
		}
	}

