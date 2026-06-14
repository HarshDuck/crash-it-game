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
        positionX+=velocityX;
        if(positionX<0){
            positionX=0;
            velocityX=0;
        }
        if(positionX+width>800){
            positionX=800-width;
            velocityX=0;
        }


    }
    @Override
    void draw(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(positionX, positionY, width, height);
    }
}