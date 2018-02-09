/*
CS 350-001
Project #2
Justin Anthony Timberlake
This class contained the constructors as well as the
	method for drawing Cmino objects. CTetriMino.java
	references this class when determining if the mouse
	has been clicked within a space that allows the user
	to drag a Cmino object (group of circles). Each of
	the cases in the draw method corresponded with the
	cases in the containPoint method showing which co-
	ordinates can be clicked in order to drag a Cmino
	object.
*/
import java.awt.Color;
import java.awt.Graphics;

public class Cmino {
	
	private int Type;	// 0: oval; 1: rectangle
	private int X;
	private int Y;
	private int Width;
	private int Height;
	private Color FillColor;
	
	public Cmino(int type, int x, int y, int w, int h, Color c) {
		Type=type;
		X=x;
		Y=y;
		Width=w;
		Height=h;
		FillColor=c;
	}
	public Cmino(Cmino src) {	// copy constructor
		Type=src.Type;
		X=src.X;
		Y=src.Y;
		Width=src.Width;
		Height=src.Height;
		FillColor=src.FillColor;
	}

	public int getX() { return X; }
	public void setX(int x) { X=x; }
	public int getY() { return Y; }
	public void setY(int y) { Y=y; }

	public void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.drawLine(0, Height + 60, 800, Height + 60);
		g.setColor(Color.gray);
		g.fillRect(0, 400, 800, 85);
		g.setColor(Color.black);
		g.drawLine(0, 400, 800, 400);
		
		g.setColor(FillColor);
		switch (Type) {
		case 0:
			g.fillOval(X, Y, Width, Height);
			break;
		case 1:
			g.fillRect(X, Y, Width, Height);
			break;
		case 2:
			g.setColor(FillColor);
			g.fillOval(X,  Y, Width, Height);
			g.fillOval(X + Width,  Y, Width, Height);
			g.fillOval(X,  Y + Height, Width, Height);
			g.fillOval(X + Width,  Y + Height, Width, Height);
			g.setColor(Color.black);
			g.drawOval(X,  Y, Width, Height);
			g.drawOval(X + Width,  Y, Width, Height);
			g.drawOval(X,  Y + Height, Width, Height);
			g.drawOval(X + Width,  Y + Height, Width, Height);
			break;
		case 3:
			g.setColor(FillColor);
			g.fillOval(X, Y + Height, Width, Height);
			g.fillOval(X - Width, Y + Height, Width, Height);
			g.fillOval(X + Width, Y + Height, Width, Height);
			g.fillOval(X + Width*2, Y + Height, Width, Height);
			g.setColor(Color.black);			
			g.drawOval(X, Y + Height, Width, Height);
			g.drawOval(X - Width, Y + Height, Width, Height);
			g.drawOval(X + Width, Y + Height, Width, Height);
			g.drawOval(X + Width*2, Y + Height, Width, Height);
			break;
		case 4:
			g.setColor(FillColor);
			g.fillOval(X + Width, Y + Height, Width, Height);
			g.fillOval(X, Y + Height, Width, Height);
			g.fillOval(X + Width*2, Y + Height, Width, Height);
			g.fillOval(X + Width , Y, Width, Height);
			g.setColor(Color.black);
			g.drawOval(X + Width, Y + Height, Width, Height);
			g.drawOval(X, Y + Height, Width, Height);
			g.drawOval(X + Width*2, Y + Height, Width, Height);
			g.drawOval(X + Width , Y, Width, Height);	
			break;
		case 5:
			g.setColor(FillColor);
			g.fillOval(X + Width, Y + Height, Width, Height);
			g.fillOval(X, Y + Height, Width, Height);
			g.fillOval(X + Width*2, Y + Height, Width, Height);
			g.fillOval(X + Width*2 , Y, Width, Height);
			g.setColor(Color.black);
			g.drawOval(X + Width, Y + Height, Width, Height);
			g.drawOval(X, Y + Height, Width, Height);
			g.drawOval(X + Width*2, Y + Height, Width, Height);
			g.drawOval(X + Width*2 , Y, Width, Height);	
			break;
		case 6:
			g.setColor(FillColor);
			g.fillOval(X + Width, Y + Height, Width, Height);
			g.fillOval(X, Y + Height, Width, Height);
			g.fillOval(X + Width*2, Y + Height, Width, Height);
			g.fillOval(X , Y, Width, Height);
			g.setColor(Color.black);
			g.drawOval(X + Width, Y + Height, Width, Height);
			g.drawOval(X, Y + Height, Width, Height);
			g.drawOval(X + Width*2, Y + Height, Width, Height);
			g.drawOval(X , Y, Width, Height);	
			break;
		case 7:
			g.setColor(FillColor);
			g.fillOval(X + Width, Y + Height, Width, Height);
			g.fillOval(X, Y + Height, Width, Height);
			g.fillOval(X + Width*2, Y, Width, Height);
			g.fillOval(X + Width , Y, Width, Height);	
			g.setColor(Color.black);
			g.drawOval(X + Width, Y + Height, Width, Height);
			g.drawOval(X, Y + Height, Width, Height);
			g.drawOval(X + Width*2, Y, Width, Height);
			g.drawOval(X + Width , Y, Width, Height);	
			break;
		case 8:
			g.setColor(FillColor);
			g.fillOval(X + Width, Y + Height, Width, Height);
			g.fillOval(X, Y, Width, Height);
			g.fillOval(X + Width*2, Y + Height, Width, Height);
			g.fillOval(X + Width , Y, Width, Height);
			g.setColor(Color.black);
			g.drawOval(X + Width, Y + Height, Width, Height);
			g.drawOval(X, Y, Width, Height);
			g.drawOval(X + Width*2, Y + Height, Width, Height);
			g.drawOval(X + Width , Y, Width, Height);
			break;
			
		}
	}

	public boolean containPoint(int x, int y) {
		switch (Type) {
		case 0:
			{
				double a=Width/2.0;
				double b=Height/2.0;
				double xc=X+a;
				double yc=Y+b;
				return ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0);
			}
		case 1:
			return (x>=X && y>=Y && x<X+Width && y<Y+Height);
		case 2:
			{
				double a=Width/2.0;
				double b=Height/2.0;
				double xc=X+a;
				double yc=Y+b;
				if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
				{
					return true;
				}
				xc += Width;
				if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
				{
					return true;
				}
				xc -= Width;
				yc += Height;
				if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
				{
					return true;
				}
				xc += Width;
				if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		case 3:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a;
			double yc=Y+b+Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc -= Width*3;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		case 4:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a+Width;
			double yc=Y+b;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			yc += Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc -= Width*2;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		case 5:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a;
			double yc=Y+b+Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			yc -= Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		case 6:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a;
			double yc=Y+b;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			yc += Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		case 7:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a + Width;
			double yc=Y+b;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			yc += Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			yc -= Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc -= Width*2;
			yc += Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		case 8:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a;
			double yc=Y+b;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			yc += Height;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			xc += Width;
			if ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		}


		return false;
	}

}
