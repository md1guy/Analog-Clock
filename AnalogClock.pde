import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss");
int curSecond = 0;

void setup() {
  size(640, 480);
}

void draw() {
  background(0);
  DrawTimeline();
  DrawSecondsClockwise();
}

void DrawTimeline() {
  stroke(255);
  strokeWeight(15);

  line(width / 2, height / 2, width / 2, height / 2);

  strokeWeight(10);

  for (int i = 0; i < 4; i++) {
    float angle = (360 / 4) * i;
    float radius = (height + width) / 2 / 4;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
  }
    
  strokeWeight(5);
  for (int i = 0; i < 12; i++) {
    float angle = (360 / 12) * i;
    float radius = (height + width) / 2 / 4;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
  }
  
  strokeWeight(2);
  for (int i = 0; i < 60; i++) {
    float angle = (360 / 60) * i;
    float radius = (height + width) / 2 / 4;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
  }
}

void DrawSecondsClockwise() {
  stroke(255);
  strokeWeight(1);
  
  int tmpSecond = 0;
  LocalDateTime now = LocalDateTime.now();
  curSecond = Integer.valueOf(dtf.format(now));
  
  do {
    now = LocalDateTime.now();
    tmpSecond = Integer.valueOf(dtf.format(now));
  } while(tmpSecond == curSecond);
  
  float angle = (360 / 60) *  curSecond - (90 - 360 / 60);
  float radius = (height + width) / 2 / 4 - 7;
    
  float posX = cos(radians(angle)) * radius + width / 2;
  float posY = sin(radians(angle)) * radius + height / 2;
  
  line(width / 2, height / 2, posX, posY);
}