import processing.core.PApplet;
import processing.core.PImage; 

public class Sketch extends PApplet {
	
	PImage imgOcean;
  PImage imgSeagull;

  int seagullX = width / 2;
  int seagullY = height / 2;

  int xDirection = 10;
  int yDirection = 10;
 
  public void settings() {
    size(800, 800);
  }

  public void setup() {
    imgOcean = loadImage("ocean.png");
    imgOcean.resize(800, 800);

    imgSeagull = loadImage("seagull.png");
    imgSeagull.resize(150, 150);
  }

  public void draw() {
    image(imgOcean, 0, 0);

    image(imgSeagull, seagullX, seagullY);

    seagullX = seagullX - xDirection;
    seagullY = seagullY + yDirection;

    if ((seagullX / 2) == 0 || seagullX == 800){
      xDirection = xDirection * -1;
    }

    if ((seagullY / 2) == 0 || seagullY == 800){
      yDirection = yDirection * -1;
    }


  }
  
}