package Project6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class CTetriMino {
	private int type;
	private Color fillColor;
	private ArrayList<CMino> minos;
	
	//Setup Tetrimino
	public CTetriMino(int t, int x, int y) {
		type=t;
		minos = new ArrayList<CMino>();
		setupMinos(t, x, y);
	}
	//Clone Tetrimino
	public CTetriMino(CTetriMino clone) {
		type = clone.getType();
		fillColor = clone.getColor();
		ArrayList<CMino> cloneMinos = clone.getMinos();
		minos = new ArrayList<CMino>();
		for (int i=0; i<cloneMinos.size(); i++)
			minos.add(new CMino(cloneMinos.get(i)));
	}
	//Checks if point is in any of the minos
	public boolean containPoint(int x, int y) {
		for (int i=0; i<minos.size(); i++) {
			if (minos.get(i).containPoint(x, y))
				return true;
		}
		return false;
	}
	
	//Draws the minos
	public void draw(Graphics g) {
		for (int i=0; i<minos.size(); i++)
			minos.get(i).draw(g);
	}
	
	//Rotates the minos
	public void rotate(int x, int y) {
		CMino center = minos.get(0);
		for (int i=0; i<minos.size(); i++) {
			if (minos.get(i).containPoint(x, y)) {
				center = minos.get(i);
				i = minos.size();
			}
		}
		for (int i=0; i<minos.size(); i++) {
			CMino me = minos.get(i);
			if (me == center)
				continue;
			int newX = center.getX() - (me.getY() - center.getY());
			int newY = center.getY() + (me.getX() - center.getX());
			me.setX(newX);
			me.setY(newY);
		}
	}
	
	//Checks if minos are below a certain x-value
	public boolean isBelow(int x) {
		for (int i=0; i<minos.size(); i++) {
			if (minos.get(i).isBelow(x))
				return true;
		}
		return false;
	}
	
	//Getters and setters for private variables
	public int getX(){
		return minos.get(0).getX();
	}
	public int getY(){
		return minos.get(0).getY();
	}
	public void setX(int x){
		int ref = minos.get(0).getX()-x;
		for (int i=0; i<minos.size(); i++) {
			minos.get(i).setX(minos.get(i).getX()-ref);
		}			
	}
	public void setY(int y){
		int ref = minos.get(0).getY()-y;
		for (int i=0; i<minos.size(); i++) {
			minos.get(i).setY(minos.get(i).getY()-ref);
		}			
	}	
	public int getType() {
		return type;
	}
	public Color getColor() {
		return fillColor;
	}
	public ArrayList<CMino> getMinos() {
		return minos;
	}
	
	//Switch case for different types of tetriminos
	public void setupMinos(int type, int x, int y) {
		int mW = 30; //Mino Width
		switch(type) {
		case 1:
			fillColor = Color.yellow;
			minos.add(new CMino(x, y, fillColor));
			minos.add(new CMino(x+mW, y, fillColor));
			minos.add(new CMino(x, y+mW, fillColor));
			minos.add(new CMino(x+mW, y+mW, fillColor));
			break;
		case 2:
			fillColor = Color.orange;
			minos.add(new CMino(x, y, fillColor));
			minos.add(new CMino(x+mW, y, fillColor));
			minos.add(new CMino(x+2*mW, y, fillColor));
			minos.add(new CMino(x+3*mW, y, fillColor));
			break;
		case 3:
			fillColor = Color.blue;
			minos.add(new CMino(x+mW, y, fillColor));
			minos.add(new CMino(x, y+mW, fillColor));
			minos.add(new CMino(x+mW, y+mW, fillColor));
			minos.add(new CMino(x+2*mW, y+mW, fillColor));
			break;
		case 4:
			fillColor = Color.magenta;
			minos.add(new CMino(x+2*mW, y, fillColor));
			minos.add(new CMino(x, y+mW, fillColor));
			minos.add(new CMino(x+mW, y+mW, fillColor));
			minos.add(new CMino(x+2*mW, y+mW, fillColor));
			break;
		case 5:
			fillColor = Color.cyan;
			minos.add(new CMino(x, y, fillColor));
			minos.add(new CMino(x, y+mW, fillColor));
			minos.add(new CMino(x+mW, y+mW, fillColor));
			minos.add(new CMino(x+2*mW, y+mW, fillColor));
			break;
		case 6:
			fillColor = Color.green;
			minos.add(new CMino(x+mW, y, fillColor));
			minos.add(new CMino(x+2*mW, y, fillColor));
			minos.add(new CMino(x, y+mW, fillColor));
			minos.add(new CMino(x+mW, y+mW, fillColor));
			break;
		case 7:
			fillColor = Color.red;
			minos.add(new CMino(x, y, fillColor));
			minos.add(new CMino(x+mW, y, fillColor));
			minos.add(new CMino(x+mW, y+mW, fillColor));
			minos.add(new CMino(x+2*mW, y+mW, fillColor));
			break;
		}
	}
}