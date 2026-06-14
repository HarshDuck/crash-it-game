package com.crashit;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Car{
    static final double gravity=0.5;
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
        if(positionY>=420){
            positionY=420;
            velocityY=0;
        }
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
void reset(){
    positionX=startX;
    positionY=startY;
    velocityX=0;
    velocityY=0;
    angle=0;
}
}