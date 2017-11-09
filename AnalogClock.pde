void setup() {
  size(1024, 720);
  background(0);
  DrawTimeline();
}

void draw() {
  
}

void DrawTimeline() {
  stroke(255);
  strokeWeight(10);

  for(int i = 0; i < 4; i++)
  {
    float angle = (360 / 4) * i;
    float radius = 250;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
/*
    switch(i) {
      case 0: line(posX, posY, posX + 10, posY);
      break;

      case 1: line(posX, posY, posX, posY + 10);
      break;

      case 2: line(posX, posY, posX - 10, posY);
      break;

      case 3: line(posX, posY, posX, posY - 10);
      break;
    }*/
  }
    
  strokeWeight(5);
  for(int i = 0; i < 12; i++)
  {
    float angle = (360 / 12) * i;
    float radius = 250;
      
    float posX = cos(radians(angle)) * radius + width / 2;
    float posY = sin(radians(angle)) * radius + height / 2;
    
    line(posX, posY, posX, posY);
    
    /*switch(i) {
      case 0: line(posX, posY, posX + 5, posY);
      break;

      case 1: line(posX, posY, posX + 5, posY - 5);
      break;

      case 2: line(posX, posY, posX + 5, posY -5);
      break;

      case 3: line(posX, posY, posX, posY - 10);
      break;
      
      case 4: line(posX, posY, posX + 10, posY);
      break;
      
      case 5: line(posX, posY, posX + 10, posY);
      break;
      
      case 6: line(posX, posY, posX + 10, posY);
      break;
      
      case 7: line(posX, posY, posX + 10, posY);
      break;
      
      case 8: line(posX, posY, posX + 10, posY);
      break;
      
      case 9: line(posX, posY, posX + 10, posY);
      break;
      
      case 10: line(posX, posY, posX + 10, posY);
      break;
      
      case 11: line(posX, posY, posX + 10, posY);
      break;
    }*/
  }
}