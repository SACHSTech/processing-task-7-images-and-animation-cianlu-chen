import processing.core.PApplet;
import processing.core.PImage; 

/**
 * A program Sketch.java that shows an animation with a seagull and clouds
 * @author L. Chen
 */

public class Sketch extends PApplet {
  // Variables
	PImage imgOcean;
  PImage imgSeagull;
  PImage imgSeagullFlipped;

  int intSeagullX = 600;
  int intSeagullY = 120;

  int intSeagullXSpeed = 2;
  int intSeagullYSpeed = 3;

  float fltCloudX = 0; 
  float fltCloudY = 0;

  float fltCloudX2 = 0; 
  float fltCloudY2 = 0;

  float fltCloudAngle = 0;
  float fltCloudAngle2 = 0;

  public void settings() {
    size(750, 750);
  }

  public void setup() {
    imgOcean = loadImage("ocean.png");
    imgOcean.resize(750, 750);

    imgSeagull = loadImage("seagull.png");
    imgSeagull.resize(130, 130);

    imgSeagullFlipped = loadImage("seagullFlipped.png");
    imgSeagullFlipped.resize(130, 130);
  }

  public void draw() {
    // Imports the background
    image(imgOcean, 0, 0);

    // Changes the seagull image based on its direction
    if (intSeagullYSpeed < 0){
      image(imgSeagullFlipped, intSeagullX, intSeagullY);
    }

    if (intSeagullYSpeed > 0){
      image(imgSeagull, intSeagullX, intSeagullY);
    }

    // Seagull movement
    intSeagullX = intSeagullX - intSeagullXSpeed;
    intSeagullY = intSeagullY + intSeagullYSpeed;

    // Seagull boundaries 
    if (intSeagullX / 2 == 0 || intSeagullX == 630){
      intSeagullXSpeed = intSeagullXSpeed * -1;
    }

    if (intSeagullY / 2 == 0 || intSeagullY == 630){
      intSeagullYSpeed = intSeagullYSpeed * -1;
    } 

    // Draws the first cloud
    noStroke();
    fill(247, 245, 240);

    ellipse((int) fltCloudX, (int) fltCloudY + 20, 120, 75);
    ellipse((int) fltCloudX + 30, (int) fltCloudY, 135, 90);
    ellipse((int) fltCloudX - 30, (int) fltCloudY - 10, 120, 100);

    // Lets the cloud move in a sin wave
    fltCloudX = (fltCloudAngle) * 90; 
    fltCloudY = 150 + sin(fltCloudAngle) * 60;

    // "Speed" of the wave
    fltCloudAngle += 0.03;

    // Resets the wave once it's out of the screen
    if (fltCloudAngle > 9.75) {
      fltCloudAngle = -1;
    }

    // Draws the second cloud
    ellipse((int) fltCloudX2, (int) fltCloudY2 + 20, 120, 75);
    ellipse((int) fltCloudX2 + 30, (int) fltCloudY2, 135, 90);
    ellipse((int) fltCloudX2 - 30, (int) fltCloudY2 - 10, 120, 100);

    // Lets the cloud move in a cos wave
    fltCloudX2 = -100 + (fltCloudAngle2) * 70; 
    fltCloudY2 = 550 + cos(fltCloudAngle2) * 100;

    // "Speed" of the wave
    fltCloudAngle2 += 0.02;

    // Resets the wave once it's out of the screen
    if (fltCloudAngle2 > 14) {
      fltCloudAngle2 = -1;
    }

  }
}