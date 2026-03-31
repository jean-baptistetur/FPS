package com.jad.juniafps;

public enum ActionPlayer {
    TURN_LEFT("TurnLeft"),
    TURN_RIGHT("TurnRight"),
    FORWARD("forward"),
    BACKWARD("backward"),
    LEFT("left"),
    RIGHT("right"),
    EXIT("exit");;

    private final String actionKey;
    private boolean isActive;

    ActionPlayer(final String actionKey) {
        this.actionKey = actionKey;
        this.isActive = false;
    }

    public String getActionKey() {
        return this.actionKey;
    }

    public boolean isActive() {
        return isActive;
    }

    public void turnOn() {
        this.isActive = true;
    }

    public void turnOff() {
        this.isActive = false;
    }
}
