package com.crashit;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Car{
    static final double gravity=0.2;
    double positionX,positionY;
    double velocityX,velocityY;
    double angle;
    double width,height;
    double startX,startY;
    void draw(GraphicsContext gc){
    gc.setFill(Color.RED);
    gc.fillRect(positionX,positionY,width,height);
    }

    void applyGravity(){
        velocityY+=gravity;
        positionY+=velocityY;
         }
    boolean isCollidingWith(Car other){
        return(positionX+width>other.positionX)&&
              (positionX<other.positionX+other.width)&&
              (positionY+height>other.positionY)&&
              (positionY<other.positionY+other.height);
    }
    boolean isHeadHit(Car other){
    return (other.positionY + other.height > positionY) &&
           (other.positionY < positionY + height * 0.3) &&
           (other.positionX + other.width > positionX) &&
           (other.positionX < positionX + width);
}
boolean isInsideOval(double px, double py){
    if(px >= 200 && px <= 600 && py >= 50 && py <= 420) return true;
    double dx = px - 200;
    double dy = py - 235;
    if(dx*dx + dy*dy <= 185*185) return true;
    dx = px - 600;
    if(dx*dx + dy*dy <= 185*185) return true;
    return false;
}
void handleWallCollision(){
    boolean allInside=
    isInsideOval(positionX, positionY)&&
     isInsideOval(positionX + width, positionY)&&
     isInsideOval(positionX, positionY +height )&&
    isInsideOval(positionX + width, positionY +height );
    
    if(!allInside){
        positionX -= velocityX;
        positionY -= velocityY;
        velocityX *= -0.6;
        velocityY *= 0.85;
        if(velocityY>0)
            velocityY=0;
    }
}
void reset(){
    positionX=startX;
    positionY=startY;
    velocityX=0;
    velocityY=0;
    angle=0;
}
}