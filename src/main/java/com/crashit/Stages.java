package com.crashit;
import java.util.ArrayList;
import java.util.List;

public class Stages {
    private List<Stage> stages;

    public Stages() {
        this.stages = new ArrayList<>();
    }

    public void addStage(Stage stage) {
        this.stages.add(stage);
    }

    public List<Stage> getStages() {
        return this.stages;
    }
}