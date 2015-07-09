package sose15.vorbereitungen.uebungen.uebung7;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FIWIconMain {

	public static void main(String[] args) {
        String fileURL = "http://www.htw-berlin.de/fileadmin/HTW/Zentral/DE/HTW/ZR1_Presse/Corporate_Design/Piktogramme_Studiengaenge/FB4_I_W.jpg";
        String saveDir = "/Users/joernfreiheit/Downloads/";
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(saveDir));
        //fileChooser.setSelectedFile(new File("FB4_I_W.jpg"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG-Images","jpg");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            String filename = fileChooser.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "You selected " + filename);
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(filename));
            } catch (IOException e) {
            }
        }
        else if (result == JFileChooser.CANCEL_OPTION)
        {   
            JOptionPane.showMessageDialog(null, "You selected nothing.");
        }
        else if (result == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(null, "An error occurred.");  
        }

	}

}
