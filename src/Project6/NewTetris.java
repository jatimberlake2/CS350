package Project6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewTetris {

	public static void main(String[] args) {
		// Setup application
		JFrame application = new JFrame("New Tetris");
		
		//Use CTetriPanel
		CTetriPanel mainPanel = new CTetriPanel();
		application.add(mainPanel);
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(800,600);
		application.setVisible(true);
	}

}

//CTetriPanel class
class CTetriPanel extends JPanel
	implements MouseListener, MouseMotionListener
{
	//Internal variables
	private ArrayList<CTetriMino> orig;
	private ArrayList<CTetriMino> dup;

	private CTetriMino tetriToBeMoved;
	private int offsetX;
	private int offsetY;

	private Image backBuffer;
	private Graphics graphicBuffer;

	boolean isReady;

	public CTetriPanel() {
		isReady = false;
		//Setup mouse listeners
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	//Only run this once
	private void initialize() {
		orig = new ArrayList<CTetriMino>();
		dup = new ArrayList<CTetriMino>();
		tetriToBeMoved = null;
	
		//Add original tetriminos
		orig.add(new CTetriMino(1,20,20));
		orig.add(new CTetriMino(2,100,50));
		orig.add(new CTetriMino(3,240,20));
		orig.add(new CTetriMino(4,350,20));
		orig.add(new CTetriMino(5,460,20));
		orig.add(new CTetriMino(6,570,20));
		orig.add(new CTetriMino(7,680,20));
	
		//Setup buffers
		backBuffer = createImage(getSize().width, getSize().height);
		graphicBuffer = backBuffer.getGraphics();
	}

	//Paint commands
	public void paintComponent(Graphics g) {
		if (!isReady) {
			isReady = true;
			initialize();
		}
	
		//Clear screen and paint top line
		graphicBuffer.setColor(Color.white);
		graphicBuffer.clearRect(0, 0, getSize().width, getSize().height);
		graphicBuffer.setColor(Color.black);
		graphicBuffer.drawLine(0, 100, 800, 100);
	
		//Print each tetrimino
		for (int i=0; i<orig.size(); i++)
			orig.get(i).draw(graphicBuffer);
		for (int i=0; i<dup.size(); i++)
			dup.get(i).draw(graphicBuffer);
		
		//Print bottom area
		graphicBuffer.setColor(Color.lightGray);
		graphicBuffer.fillRect(0, 450, getWidth(), getHeight()-450);
		graphicBuffer.setColor(Color.black);
		graphicBuffer.drawLine(0, 450, 800, 450);
		
		g.drawImage(backBuffer, 0, 0, null);
	}

	//Rotate tetrimino if right clicked
	public void mouseClicked(MouseEvent e) {
		if (e.isMetaDown()) {	// right button
			for (int i=dup.size()-1; i>=0; i--) {
				if (dup.get(i).containPoint(e.getX(), e.getY())) {
					dup.get(i).rotate(e.getX(), e.getY());
					if (dup.get(i).isBelow(450))
						dup.remove(i);
					repaint();
					break;
				}
			}
		}
	}

	//Handles Presses
	public void mousePressed(MouseEvent e) {
		//Don't do anything if right button pressed
		if (e.isMetaDown()) 
			return;

		//Check for duplicate being selected
    	for (int i=dup.size()-1; i>=0; i--) {
			CTetriMino p=dup.get(i);
			if (p.containPoint(e.getX(), e.getY())) {
				dup.remove(i);
				dup.add(p);	// move to the end, i.e. the top
				tetriToBeMoved=p;
				offsetX=e.getX()-tetriToBeMoved.getX();
				offsetY=e.getY()-tetriToBeMoved.getY();
				repaint();
				return;
			}
		}
    	
    	//If not a duplicate, check the originals
		for (int i=orig.size()-1; i>=0; i--) {
			CTetriMino p=orig.get(i);
			if (p.containPoint(e.getX(), e.getY())) {
				//Create duplicate
				CTetriMino p2=new CTetriMino(p);
				dup.add(p2);
				tetriToBeMoved=p2;
				offsetX=e.getX()-tetriToBeMoved.getX();
				offsetY=e.getY()-tetriToBeMoved.getY();
				repaint();
				return;
			}
		}
	}

	//Mouse release
	public void mouseReleased(MouseEvent e) {
		//Delete if it falls into the bottom area
		if (tetriToBeMoved != null && tetriToBeMoved.isBelow(450)) {
			dup.remove(tetriToBeMoved);
			repaint();
		}
		tetriToBeMoved = null;
	}

	//Completing interface
	public void mouseEntered(MouseEvent e) {	
	}

	public void mouseExited(MouseEvent e) {	
	}
	public void mouseMoved(MouseEvent e) {	
	}
	
	//Moves tetrimino if one is selected and mouse is dragged
	public void mouseDragged(MouseEvent e) {
		if (e.isMetaDown())
			return;
	
		if (tetriToBeMoved!=null) {
			tetriToBeMoved.setX(e.getX()-offsetX);
			tetriToBeMoved.setY(e.getY()-offsetY);
			repaint();
		}
	}
}
