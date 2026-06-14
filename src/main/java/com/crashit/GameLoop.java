package com.crashit;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class GameLoop {
    GraphicsContext gc;
    PlayerCar player;
    AICar ai;
     GameLoop(GraphicsContext gc, PlayerCar player, AICar ai){
     this.gc=gc;
     this.player=player;
     this.ai=ai;
}
void start(){
    AnimationTimer timer =new AnimationTimer(){
        @Override
        public void handle(long now){
            //update
            player.update();
            ai.update();
            player.applyGravity();
            ai.applyGravity();
        //clear scene
        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0,0,800,500);
        // draw ground
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(0,450,800,50);
        // draw car
        player.draw(gc);
        ai.draw(gc);
        if(player.isCollidingWith(ai)){
        player.velocityX= -player.velocityX*0.8;
        ai.velocityX= -ai.velocityX*0.8;

        if(player.positionX<ai.positionX){
            player.positionX-=5;
            ai.positionX+=5;
        }else{
            player.positionX+=5;
            ai.positionX-=5;
        }
    }
    if(player.isHeadHit(ai)||ai.isHeadHit(player)){
        player.reset();
        ai.reset();
    }
        }
    };
    timer.start();
    }
}