/* Assignment 3, Part 2 - Go Dutch! */
import java.awt.Color;

public class Assignment3Part2
{
//
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
    Picture pic = new Picture(filename);   // Picture to modify
    //
    pic.show();             // Show the original picture
    Thread.sleep(1000);     //  Pause for 1 second.  You can pause for less if you like
    
    
    // TODO: put your flag tinting code here
    Pixel[] pixelArray = pic.getPixels();
    Pixel pixel = null;
    int i = 0; 
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
          pixel.setColor(new Color (170, 35, blueValue));
          
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
        pixel.setColor(new Color((int) (sourceXY.getRed() * 0.5 + redValue * 0.5), (int) (sourceXY.getGreen() * 0.5 + greenValue * 0.5), (int) (sourceXY.getBlue() * 0.5 + blueValue * 0.5)) );
        
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
    
    pic.repaint();
  }  // End of main
}  // End of Class