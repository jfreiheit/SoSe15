package sose15.vorbereitungen.LSP;

public class Square extends Rectangle
{
	
	Square(final int sideLength)
	{
		super(sideLength, sideLength);
	}
	
	public void setSideLength(final int sideLength)
	{
		super.setWidth(sideLength);
		super.setHeight(sideLength);
	}
	
	@Override
	public void setWidth(final int width)
	{
		setSideLength(width);
	}
	
	@Override
	public void setHeight(final int height)
	{
		setSideLength(height);
	}
}
