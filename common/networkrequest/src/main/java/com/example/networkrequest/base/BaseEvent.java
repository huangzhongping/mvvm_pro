package com.example.networkrequest.base;

/**
 *
 */
public class BaseEvent {

    private int action;

    public BaseEvent(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

}