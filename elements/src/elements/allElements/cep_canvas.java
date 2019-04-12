
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.allElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Zeaton
 */
public class cep_canvas extends JPanel  {
    final static int FRAME_HEIGHT = 500;
    final static int FRAME_WIDTH = 500;
    public  int modeNo;
    
    private BufferedImage picStart;
    private BufferedImage pic2;
    private BufferedImage pic3;
    
    private String memeMessage;
    private Point insertPoint;
    
    
    public cep_canvas(){
        super();
        this.setBackground(Color.white);
        
       
        modeNo = 2;
       starterImage();
 
    }

      public  int getModeNo() 
      {
        return modeNo;
      }
      
      public void setModeNo(int i)
      {
          modeNo = i;
      }


    
      /**
     *causes the image created from the temp file to be displayed when the 
     * drawing object is created and for the image passed to the meme creator 
     * to also be that image unless a different file is chosen for the image.
     * 
     */
    private void starterImage(){
         try{
             File startFile = new File("C:/Clare/Code/Java/elements/images/Hydrogen.jpg");
             picStart = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
             picStart = ImageIO.read(startFile);
             pic2 = picStart;
             
         }
         catch (IOException e){}
         
     }

    /**
     * causes an image to be displayed on the cep_canvas. The source is the file
     * argument
     * @param aFile
     */
    public void loadImage(File aFile){
        pic2 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        try {
            pic2 = ImageIO.read(aFile);
        }
        catch(IOException f){}
        modeNo = 4;
        repaint();

    }
    
    public void loadSite(URI aUri){
        File file2 = new File(aUri);
        pic3 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        try{
            pic3 = ImageIO.read(file2);
        }
        catch(IOException g){}
        modeNo = 3;
        repaint();
    }
   
        public void loadSite(URL aURL){
        
        pic3 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        try{
            pic3 = ImageIO.read(aURL);
        }
        catch(IOException g){}
        modeNo = 3;
        repaint();
    }
    

    /**
     *
     * @param aString
     */
    public void addMeme(String aString, Point aPoint){
           memeMessage = aString;
           insertPoint = aPoint;
           System.out.println("success " + memeMessage);
           modeNo = 5;
           repaint();
       }
       
       
    public void paint(Graphics p){
        super.paint(p);
        //this.paintComponents(p);
    
        if(modeNo ==2){
            p.drawImage(picStart.getScaledInstance(this.getWidth(), this.getHeight(), 0),0, 0, this.getWidth(), this.getHeight(), this);
        }

        if(modeNo ==4){
             p.drawImage(pic2.getScaledInstance(this.getWidth(), this.getHeight(), 0),0, 0, this.getWidth(), this.getHeight(), this);
        }
        
        if(modeNo == 3){
            p.drawImage(pic3.getScaledInstance(this.getWidth(), this.getHeight(), 0),0, 0, this.getWidth(), this.getHeight(), this);
        }
        
        if(modeNo == 5){
            p.drawImage(pic2.getScaledInstance(this.getWidth(), this.getHeight(), 0),0, 0, this.getWidth(), this.getHeight(), this);
            p.drawString(memeMessage, insertPoint.x, insertPoint.y);
        }
    } 
}
