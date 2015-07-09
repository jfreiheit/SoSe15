package sose15.vorbereitungen.grafik;

import java.awt.*;
import javax.swing.*;

public class EinfacheGeometrie extends JFrame{

	private class Zeichenflaeche extends JPanel
	{

		@Override
		protected void paintComponent(Graphics g)
		{
			/*			// Linien, Rechtecke, Polygone
			g.drawLine(50, 150, 300, 150); 			// x1,y1,x2,y2
			g.drawRect(100, 100, 150, 150); 		// x,y,breite,h�he
			g.drawRoundRect(10, 60, 150, 150, 50, 50); // Radius f�r Ecken
			int[] arx = {80, 180, 280, 100};
			int[] ary = {200, 280, 280, 200};
			g.drawPolygon(arx,ary,4);*/

			/*			// Kreise, Ellipsen, Kreisb�gen
			for(int i=0; i<10; i++)
				g.drawOval(50+i*10, 50, 80, 80);
			for(int i=0; i<10; i++)
				g.drawOval(50+i*10, 150, 80, 180);
			g.drawArc(30, 140, 200, 100, 0, 180 ); */

			/*			// Kopieren und L�schen von Fl�chen
			g.fillRect(50, 10, 200, 150);	// gro�es Rechteck
			g.clearRect(100, 60, 100, 50);	// kl. Rechteck ausgeschnitten
			g.copyArea(150, 10, 100, 150, 0, 160); // rechte Seite nach unten
			 */			
			/*			// Ausgabe von Text
			Font font;
			String[] fonts = {"Serif", "SansSerif", "Monospaced"};
			int dy=0;
			for(String f:fonts){
				font = new Font(f, Font.PLAIN,36); 	// font, style, gr��e
				g.setFont(font);
				g.drawString(f, 30, 100+dy);
				dy+=40;
			}*/

			/*			Font font;
			String[] fonts = 	GraphicsEnvironment. 
					getLocalGraphicsEnvironment().				getAvailableFontFamilyNames();
			int dy=0;
			for (String f:fonts){
				font = new Font(f, Font.PLAIN,12);
				g.setFont(font);
				g.drawString(f, 30, 10+dy);
				dy+=14;
			}*/

/*			// Farbkreis
			Color color;
			int[] arx = {130,160,190};
			int[] ary = {60,110,60};
			int[] arr = {50,50,50};
			int[] arc = {0,0,0};
			int maxX=getSize().width;
			int maxY = getSize().height;
			boolean paintit;
			int dx, dy;
			for (int y=0; y<maxY; ++y){
				for (int x=0; x<maxX; ++x){
					paintit=false;
					for (int i=0; i<arc.length; ++i)
					{
						dx=x-arx[i];
						dy=y-ary[i];
						arc[i]=0;
						if ((dx*dx+dy*dy) <= arr[i]*arr[i])
						{
							arc[i]=255;
							paintit=true;
						}
					}
					if (paintit)
					{
						color = new Color(arc[0], arc[1], arc[2]);
						g.setColor(color);
						g.drawLine(x, y, x+1, y+1);
					}
				}
			}*/

		}
	}

	EinfacheGeometrie()
	{
		super("Einfaches Zeichnen");
		getContentPane().add(new Zeichenflaeche(), BorderLayout.CENTER);
		setSize(350,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	public static void main(String[] args) {
		new EinfacheGeometrie();
	}
}