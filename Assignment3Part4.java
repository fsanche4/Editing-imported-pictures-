/* Assignment 3, Part 4 - Animate! */
import java.awt.Color;


public class Assignment3Part4
{
  
  public static void main(String [] args) throws InterruptedException
  {
    String filename;
    if (args.length > 0) {
      // got a filename passed into program as a parameter
      // don't change this part of the code needed by TA for grading
      filename = args[0];      
      System.out.println("Filename passed in: " + filename);
      
    } else {
      // ask user for a picture
      filename = FileChooser.pickAFile();
      System.out.println("User picked file: " + filename);
    }
    
    Picture pic = new Picture(filename);  
    
    pic.copyPixelsFromSource(pic);
    pic.show();             // Show original picture
    Thread.sleep(100);
    
    //insert method to make headshot go psychedelic four times//
    pic.changeRedTint(1.5); 
    pic.repaint();          // Show the tinted picture
    Thread.sleep(200);
    
    pic.changeGreenTint(.5);
    pic.repaint();          // Show the tinted picture
    Thread.sleep(200);
    
    pic.changeBlueTint(1.5);
    pic.repaint();          // Show the tinted picture
    
    pic.changeColors(2.5, 1.5, 2.5);
    
    pic.repaint();
    int i = 0;
    
    //insert method to make headshot go Dutch//
    Pixel[] pixelArray = pic.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;
    
    //create three while loops for each third of the image to create the flag
    
    while(i < pixelArray.length)
    {
      while(i < pixelArray.length* 2/3)
      {
        while(i < pixelArray.length/3)
        {
          //get the current pixel
          pixel = pixelArray[i];
          
          //get the current red, green, blue values
          redValue = pixel.getRed();
          greenValue = pixel.getGreen();
          blueValue = pixel.getBlue();
          
          //set the pixels color towards orange
          pixel.setColor(new Color (180, 35, blueValue));
          
          i = i + 1;
        }
        
        //get the current pixel
        pixel = pixelArray[i];
        
        //get the current red, green, blue values
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        //get X and Y Pos of a white colored pixel
        int srcX = 303;
        int srcY = 492;
        
        // create local variables for source pixel //
        Pixel sourcePixel = null;
        
        // get one pixel from source image //
        Pixel sourceXY = pic.getPixel(srcX, srcY);
        
        //set the pixels color towards white by averaging original RGB values with that of the white src pixel //
        pixel.setColor(new Color((int) (sourceXY.getRed() * .5 + redValue * .5), (int) (sourceXY.getGreen() * .5 + greenValue * .5), (int) (sourceXY.getBlue() * 0.5 + blueValue * 0.5)) );
        
        i = i + 1;
      }
      
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the current red, green, blue values
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();
      
      //set the pixels color towards green
      pixel.setColor(new Color (redValue, 130, 20));
      
      i = i + 1;
    }
    
    Thread.sleep(100);
    pic.repaint();
    
    //insert method to make headshot get more and more blurred//
    int index = 0;
    //call method to blur
    while (index < 20) {
      
      //call method to blur
      pic.averagePixelsHorizontally();
      
      ++index;
      pic.repaint();
    }
    
    while (index < 20) {
      
      //call method to blur
      pic.averagePixelsHorizontally();
      
      ++index;
      pic.repaint();
    }
   
    while (index < 20) {
      
      //call method to blur
      pic.averagePixelsHorizontally();
      
      ++index;
    }
    pic.repaint();
    Thread.sleep(100);
   
  }
}

