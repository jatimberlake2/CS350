package Project6;

import java.awt.Color;
import java.awt.Graphics;

public class CMino {
	private int X;
	private int Y;
	private int width;
	private Color fillColor;
	
	//Sets up new mino
	public CMino(int x, int y, Color c) {
		X=x;
		Y=y;
		fillColor=c;
		width = 30;
	}
	//Clones a mino
	public CMino(CMino clone) {
		X = clone.getX();
		Y = clone.getY();
		fillColor = clone.getColor();
		width = 30;
	}
	
	//Draws mino
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(X, Y, width, width);
		g.setColor(Color.black);
		g.drawOval(X, Y, width, width);
	}
	
	//Checks if point is in mino
	public boolean containPoint(int x, int y) {
		double a = width/2.0;
		double xc = X+a;
		double yc = Y+a;
		return ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(a*a)<=1.0);
	}
	//Checks if mino falls below certain line
	public boolean isBelow(int x) {
		return Y+width > x;
	}
	
	//Getters and setters for private variables
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X=x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y=y;
	}
	public Color getColor() {
		return fillColor;
	}
	public void setColor(Color c) {
		fillColor = c;
	}
}