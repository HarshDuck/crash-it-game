package com.crashit;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AICar extends Car{
    PlayerCar player;
    int difficulty=1;
    void update(){
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
        gc.setFill(Color.BLUE);
        gc.fillRect(positionX , positionY , width , height);
    }
}