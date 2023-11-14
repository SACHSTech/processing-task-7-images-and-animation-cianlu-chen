import processing.core.PApplet;
import processing.core.PImage; 

public class Sketch extends PApplet {
	
	PImage imgOcean;
  PImage imgSeagull;

  int seagullX = 600;
  int seagullY = 120;

  int xSpeedSeagull = 2;
  int ySpeedSeagull = 2;

  int cloudX = 10; 
  int cloudY = 400;

  int cloudSpeedX = -1;
  int cloudSpeedY = -1;
 
  public void settings() {
    size(750, 750);
  }

  public void setup() {
    imgOcean = loadImage("ocean.png");
    imgOcean.resize(750, 750);

    imgSeagull = loadImage("seagull.png");
    imgSeagull.resize(120, 120);
  }

  public void draw() {
    image(imgOcean, 0, 0);

    image(imgSeagull, seagullX, seagullY);

    seagullX = seagullX - xSpeedSeagull;
    seagullY = seagullY + ySpeedSeagull;

    if (seagullX / 2 == 0 || seagullX == 630){
      xSpeedSeagull = xSpeedSeagull * -1;
    }

    if (seagullY / 2 == 0 || seagullY == 630){
      ySpeedSeagull = ySpeedSeagull * -1;
    } 

    noStroke();

    ellipse((int) cloudX, (int) cloudY + 20, 120, 75);
    ellipse((int) cloudX + 30, (int) cloudY, 135, 90);
    ellipse((int) cloudX - 30, (int) cloudY - 10, 120, 100);
    
    cloudX = cloudX - cloudSpeedX;
    cloudY = cloudY + cloudSpeedY;

    if (cloudX / 2 < 0 || cloudX > 650){
      cloudSpeedX = cloudSpeedX * -1;
    }

    if (cloudY / 2 < 200 || cloudY > 560){
      cloudSpeedY = cloudSpeedY * -1;
    } 
  }
}