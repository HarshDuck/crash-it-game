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

        //create game objects
        PlayerCar player =new PlayerCar();
        AICar ai = new AICar();
        ai.player=player;
        //set starting position
        player.positionX=200;
        player.positionY=400;
        player.startX=200;
        player.startY=400;
        player.width=50;
        player.height=30;
        
        ai.positionX=550;
        ai.positionY=400;
        ai.startX=550;
        ai.startY=400;
        ai.width=50;
        ai.height=30;
        

        // Create and start gameloop
        GameLoop gameLoop = new GameLoop(gc , player , ai);
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