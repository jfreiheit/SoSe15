package sose15.vorbereitungen.events;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

class ComponentRepaintAdapter extends ComponentAdapter
{
  public void componentMoved(ComponentEvent event)
  {
    event.getComponent().repaint();
    System.out.println("window moved");
  }

  public void componentResized(ComponentEvent event)
  {
    event.getComponent().repaint();
    System.out.println("window size changed");
  }
}

class WindowClosingAdapter  extends WindowAdapter{
	
	private boolean exitSystem;
	
	public WindowClosingAdapter(boolean exitSystem){
		this.exitSystem=exitSystem;		// Fenster schliessen, Programm beenden
	}

	public WindowClosingAdapter()
	{
		this(false);	//Fenster schliessen, Programm NICHT beenden
	}

	public void windowClosing(WindowEvent event) // WindowListener interface
	{
		event.getWindow().setVisible(false);
		event.getWindow().dispose();
		if (exitSystem){
			System.exit(0);
		}
	}
}

class BirdsEyeFrame extends JFrame
{
  public BirdsEyeFrame()
  {
    super("BirdsEyeFrame");
    addWindowListener(new WindowClosingAdapter(true));
    addComponentListener(new ComponentRepaintAdapter());
    setBackground(Color.lightGray);
  }

  public void paint(Graphics g)
  {
    Dimension screensize = getToolkit().getScreenSize();
    Dimension framesize  = getSize();
    double qx = framesize.width  / (double)screensize.width;
    double qy = framesize.height / (double)screensize.height;
    g.setColor(Color.white);
    g.fillRect(
      (int)(qx * getLocation().x),
      (int)(qy * getLocation().y),
      (int)(qx * framesize.width),
      (int)(qy * framesize.height)
    );
    g.setColor(Color.darkGray);
    g.fillRect(
      (int)(qx * getLocation().x),
      (int)(qy * getLocation().y),
      (int)(qx * framesize.width),
      (int)(qy * getInsets().top)
    );
    g.drawRect(
      (int)(qx * getLocation().x),
      (int)(qy * getLocation().y),
      (int)(qx * framesize.width),
      (int)(qy * framesize.height)
    );
  }
}

public class TestComponentEvents {

	public static void main(String[] args) 
	{
	    BirdsEyeFrame wnd = new BirdsEyeFrame();
	    wnd.setSize(300,200);
	    wnd.setLocation(200,100);
	    wnd.setVisible(true);
	  }

}
