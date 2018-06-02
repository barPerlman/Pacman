package ViewComponents;

import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.EAST;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
    
    private Image bgImage;
    
    public ImagePanel() {
    	try{
    	bgImage=pathToImage("images/block.png");
    	}
    	catch(Exception e){
    		System.out.println("the path is not available");
    	}
    	this.setLayout(new GridBagLayout());
    	
    	
    }
    public void paintComponent(Graphics g){
		g.drawImage(bgImage, 0, 0, getWidth(),getHeight(),this);
	}
    public static Image pathToImage(String path) throws IOException {
		Image tImg = ImageIO.read(new File(path));
		return tImg;

	}
}