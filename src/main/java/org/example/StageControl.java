package org.example;

public interface StageControl {
    Stage next();
    Stage prev();
    void start(); // throws StageRejectedException;
    void stop();
}
