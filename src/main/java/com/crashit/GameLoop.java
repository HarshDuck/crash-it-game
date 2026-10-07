package com.crashit;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class GameLoop {
    GraphicsContext gc;
    PlayerCar player;
    AICar ai;
    com.crashit.Stage stage;
     GameLoop(GraphicsContext gc, PlayerCar player, AICar ai,com.crashit.Stage stage){
     this.gc=gc;
     this.player=player;
     this.ai=ai;
     this.stage=stage;
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
            player.handleWallCollision();
            ai.handleWallCollision();
       // draw ground
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(0,0,800,500);
        //clear scene
       gc.save();
       gc.beginPath();
       gc.moveTo(200, 50);
       gc.lineTo(600, 50);
       gc.arc(600, 235, 185, 185, 90,-180);
       gc.lineTo(200, 420);
       gc.arc(200, 235, 185, 185, 270,-180);
       gc.closePath();
       gc.setFill(Color.SKYBLUE);
       gc.fill();
       gc.restore();
        //add stage 
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);
        for(Wall w:stage.walls){
            gc.strokeLine(w.x1,w.y1,w.x2,w.y2);
        }
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