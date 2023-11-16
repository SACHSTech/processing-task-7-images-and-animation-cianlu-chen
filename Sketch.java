import processing.core.PApplet;
import processing.core.PImage; 

public class Sketch extends PApplet {
	// Images
	PImage imgOcean;
  PImage imgSeagull;

  // Seagull coordinates & speed
  int seagullX = 600;
  int seagullY = 120;

  int xSpeedSeagull = 2;
  int ySpeedSeagull = 2;

  // Cloud coordinates & speed
  float cloudX = 120; 
  float cloudY = 120;

  int cloudSpeedX = 1;
  int cloudSpeedY = 1;

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

    if (seagullX / 2 == -20 || seagullX == 630){
      xSpeedSeagull = xSpeedSeagull * -1;
    }

    if (seagullY / 2 == -20 || seagullY == 630){
      ySpeedSeagull = ySpeedSeagull * -1;
    } 

    noStroke();
    fill(247, 245, 240);

    ellipse((int) cloudX, (int) cloudY + 20, 120, 75);
    ellipse((int) cloudX + 30, (int) cloudY, 135, 90);
    ellipse((int) cloudX - 30, (int) cloudY - 10, 120, 100);
    
    cloudX = cloudX - 750*sin(10 * X) + cloudSpeedX;
    cloudY = cloudY - 750*sin(10 * X) + cloudSpeedY;

    if (cloudX / 2 == 0 || cloudX == 750){
      cloudSpeedX = cloudSpeedX * -1;
    }

    if (cloudY / 2 == 30 || cloudY == 750){
      cloudSpeedY = cloudSpeedY * -1;
    } 

  }
}