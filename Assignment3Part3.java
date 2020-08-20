/* Assignment 3, Part 3 - Go Blurry! */
public class Assignment3Part3
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
    Thread.sleep(10);     //  Pause for 1 second.  You can pause for less if you like
    
    // TODO: call your averaging method here, 
    
    int i = 0;
    
    // use while loop to call averagePixelsHorizontally method x amount of times to blur //
    while (i < 8) {
      
      //call method to blur
      pic.averagePixelsHorizontally();
      
      ++i;
    }
    
    pic.repaint();
    
    while (i < 8) {
      
      //call method to blur
      pic.averagePixelsHorizontally();
      
      ++i;
    }
    
    pic.repaint();
    
  }
}
