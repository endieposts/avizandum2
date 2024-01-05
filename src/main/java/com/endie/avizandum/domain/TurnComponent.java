package com.endie.avizandum.domain;

public class TurnComponent {
    private long id;
    private long turnNumber;
    private long playerId;
    private String turnAction;


    public TurnComponent(long id, long turnNumber, long playerId) {
        this.id = id;
        this.turnNumber = turnNumber;
        this.playerId = playerId;
    }

    public TurnComponent() {

    }

    public long getId() {
        return id;
    }

    public long getTurnNumber() {
        return turnNumber;
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getTurnAction() {
        return turnAction;
    }

    public void setTurnAction(String turnAction) {
        this.turnAction = turnAction;
    }
}
