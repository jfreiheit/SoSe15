package sose15.vorbereitungen.LSP;

public class Rectangle 
{
	
	Rectangle(final int width, final int height)
	{
		this.width = width;
		this.height = height;
	}
	
	private int width;
	private int height;
	
	public void setWidth(final int width)	{		this.width=width;	}
	public void setHeight(final int height)	{		this.height=height;	}
	
	public int calcArea()	{		return getWidth()*getHeight();	}
	
	public int getHeight() {	return this.height;	}
	public int getWidth() {		return this.width;	}

}
