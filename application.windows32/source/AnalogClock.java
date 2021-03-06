import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AnalogClock extends PApplet {





DateTimeFormatter secs = DateTimeFormatter.ofPattern("ss");
DateTimeFormatter mins = DateTimeFormatter.ofPattern("mm");
DateTimeFormatter hrs = DateTimeFormatter.ofPattern("HH");
int curSecond = 0, curMinute = 0, curHour = 0;

public void setup() {
  
}

public void draw() {
  background(0);
  DrawTimeline();
  Update();
}

public void Update()
{
  DrawSecondsClockwise();
  DrawMinutesClockwise();
  DrawHourClockwise();
}

public void DrawTimeline() {
  stroke(255);
  strokeWeight(15);

  line(width / 2, height / 2, width / 2, height / 2);

  strokeWeight(10);

  for (int i = 0; i < 4; i++) {
    float angle = (360 / 4) * i;
    float radius = (height + width) / 4 - 10 ;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
  }
    
  strokeWeight(5);
  for (int i = 0; i < 12; i++) {
    float angle = (360 / 12) * i;
    float radius = (height + width) / 4 - 10 ;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
  }
  
  strokeWeight(2);
  for (int i = 0; i < 60; i++) {
    float angle = (360 / 60) * i;
    float radius = (height + width) / 4 - 10 ;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
  }
}

public void DrawSecondsClockwise() {
  stroke(255);
  strokeWeight(1);
  
  int tmpSecond = 0;
  LocalDateTime now = LocalDateTime.now();
  curSecond = Integer.valueOf(secs.format(now));
  
  do {
    now = LocalDateTime.now();
    tmpSecond = Integer.valueOf(secs.format(now));
  } while(tmpSecond == curSecond);
  
  //float angle = (360 / 60) *  curSecond - (90 - 360 / 60);
  float angle = map(curSecond, 0, 59, 0, 354) - 84;
  float radius = (height + width) / 4 - 10 - 7;
    
  float posX = cos(radians(angle)) * radius + width / 2;
  float posY = sin(radians(angle)) * radius + height / 2;
  
  line(width / 2, height / 2, posX, posY);
}

public void DrawMinutesClockwise() {
  stroke(255);
  strokeWeight(3);
  
  LocalDateTime now = LocalDateTime.now();
  curMinute = Integer.valueOf(mins.format(now));

  //float angle = (360 / 60) *  curMinute - (90);
  float angle = map(curMinute, 0, 59, 0, 354) - 90;
  float radius = 5 * ((height + width) / 4 - 10 - 7) / 6;
    
  float posX = cos(radians(angle)) * radius + width / 2;
  float posY = sin(radians(angle)) * radius + height / 2;
  
  line(width / 2, height / 2, posX, posY);
}

public void DrawHourClockwise() {
  stroke(255);
  strokeWeight(5);
  
  LocalDateTime now = LocalDateTime.now();
  curHour = Integer.valueOf(hrs.format(now));
  curMinute = Integer.valueOf(mins.format(now));

  float curTime = (curHour * 60 + curMinute) % (12 * 60);
  float angle = map(curTime, 0, 720, 0, 360) - 90;
  float radius = 4 * ((height + width) / 4 - 10 - 7) / 6;
    
  float posX = cos(radians(angle)) * radius + width / 2 - 10;
  float posY = sin(radians(angle)) * radius + height / 2 - 10;
  
  line(width / 2, height / 2, posX, posY);
}
  public void settings() {  size(300, 300); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AnalogClock" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
