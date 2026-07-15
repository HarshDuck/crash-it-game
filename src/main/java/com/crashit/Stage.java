package com.crashit;

import java.util.ArrayList;
import java.util.List;

public class Stage{
    int stageId;
    List <Wall> walls;
    List <Obstacle> obstacles;
    double waterRiseDelay,waterRiseSpeed;
    double playerStartX,playerStartY;
    double aiStartX,aiStartY;
    Stage(int stageId, double waterRiseDelay, double waterRiseSpeed){
        walls=new ArrayList<>();
        obstacles=new ArrayList<>();
        this.stageId=stageId;
        this.waterRiseDelay=waterRiseDelay;
        this.waterRiseSpeed=waterRiseSpeed;
    }
    public void addWall(double x1,double x2,double y1,double y2){
        Wall w=new Wall();
        w.x1=x1;
        w.x2=x2;
        w.y1=y1;
        w.y2=y2;
        walls.add(w);
    }
    public void addObstacle(double x,double y, double radius){
    Obstacle o=new Obstacle();
    o.x=x;
    o.y=y;
    o.radius=radius;
    obstacles.add(o);
    }
    public void addCurveCap(double centerX, double centerY, double radius, double startAngleDeg, double endAngleDeg){
     int segments=12;
     double step=(endAngleDeg-startAngleDeg)/segments;
     for(double angle=startAngleDeg;angle<=endAngleDeg;angle+=step){
      double x1=centerX+radius*Math.cos(Math.toRadians(angle));
      double y1=centerY+radius*Math.sin(Math.toRadians(angle));
      double x2=centerX+radius*Math.cos(Math.toRadians(angle+step));
      double y2=centerY+radius*Math.sin(Math.toRadians(angle+step));
      add.wall(x1,y1,x2,y2);
     }
    }
}
