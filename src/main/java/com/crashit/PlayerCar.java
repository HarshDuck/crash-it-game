package com.crashit;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PlayerCar extends Car{
    boolean leftPressed;
    boolean rightPressed;
    void update(){
        if(rightPressed){
            velocityX+=0.5;
            angle+=2.0;
        }
        if(leftPressed){
            velocityX-=0.5;
            angle-=2.0;
        }
        velocityX=velocityX*0.9;
        positionX+=Math.cos(Math.toRadians(angle))*velocityX;
        positionY+=Math.sin(Math.toRadians(angle))*velocityX;
        
    }
    @Override
    void draw(GraphicsContext gc){
        gc.save();
        gc.translate(positionX+width/2,positionY+height/2);
        gc.rotate(angle);
        gc.setFill(Color.RED);
        gc.fillRect(-width/2,-height/2,width,height);
        gc.restore();
    }
}