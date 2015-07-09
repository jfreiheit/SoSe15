package sose15.vorbereitungen.iofile11;

import java.io.File;

public class Dateien {
	
	private static void printFileInfo(final File file)
	{
		if(file.exists())
		{
			if(file.isFile())
				System.out.println(	"Dateiname '"+file.getName() +"'");
			else // file.isDirectory()
				System.out.println(	"Verzeichnisname '"+file.getName() +"'");
			System.out.println(	"Path '"+file.getAbsolutePath() +"'");
		}
		else
		{
			System.out.println("Datei oder Verzeichnis " + file.getName() + " existiert nicht!");
		}
	}
	
	private static void printDirectory(final File dir)
	{
		if(dir.exists() && dir.isDirectory())
		{
			String[] content = dir.list();
			for(String c : content)
			{
				System.out.println(c);
			}
		}
	}

	public static void main(String[] args) {
		File myFile = new File("/usr/bin/java");
		File myDir	= new File("/usr/bin");
		printFileInfo(myFile);
		printFileInfo(myDir);	
		printDirectory(myDir);
	}

}
