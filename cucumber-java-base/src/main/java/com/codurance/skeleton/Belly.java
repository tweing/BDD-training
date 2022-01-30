package com.codurance.skeleton;

public class Belly {

    private Boolean growled = false;
    private int cukesEaten = 0;
    public void eat(int cukes) {
        cukesEaten += cukes;
    }

    public void iWait(int hours) {
        if(hours >= 1)
            growled = true;
    }

    public Boolean hasGrowled() {
        return growled;
    }
}
