import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;


public class filechoosetest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		saveMap();

	}
	
	public static void saveMap() {
	    String sb = "TEST CONTENT";
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile());
	            fw.write(sb);
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}

}
