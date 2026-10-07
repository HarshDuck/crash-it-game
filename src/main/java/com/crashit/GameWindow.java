package com.crashit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameWindow extends Application {

    // Window size constants
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;

    @Override
    public void start(Stage stage) {

        // Create the drawing canvas
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        com.crashit.Stage s1=new com.crashit.Stage(1,20,0.5);
        //Straight top wall
        s1.addWall(200,50,600,50);
        //Straight bottom wall
        s1.addWall(200,420,600,420);
        //Leftcurved cap 180 to 360 degree
        s1.addCurveCap(200,235,185,90,270);
        //Right curved cap 0 to 180 degree
        s1.addCurveCap(600,235,185,270,450);
        s1.playerStartX=350;
        s1.playerStartY=250;
        s1.aiStartX=450;
        s1.aiStartY=250;

        //create game objects
        PlayerCar player =new PlayerCar();
        AICar ai = new AICar();
        ai.player=player;
        //set starting position
        player.positionX=s1.playerStartX;
        player.positionY=s1.playerStartY;
        player.startX=s1.playerStartX;
        player.startY=s1.playerStartY;
        player.width=50;
        player.height=30;
        
        ai.positionX=s1.aiStartX;
        ai.positionY=s1.aiStartY;
        ai.startX=s1.aiStartX;
        ai.startY=s1.aiStartY;
        ai.width=50;
        ai.height=30;
        

        // Create and start gameloop
        GameLoop gameLoop = new GameLoop(gc , player , ai,s1);
        gameLoop.start();

        // setup window
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root , WIDTH , HEIGHT);
        stage.setTitle("Crash It");
        stage.setScene(scene);
        stage.setResizable(false);
        // key listener
        scene.setOnKeyPressed(event ->{
            switch(event.getCode()){
                case LEFT -> player.leftPressed=true;
                case RIGHT -> player.rightPressed=true;
            }
        });
        scene.setOnKeyReleased(event ->{
            switch(event.getCode()){
                case LEFT ->player.leftPressed=false;
                case RIGHT->player.rightPressed=false;
            }
        });
        //show window
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}