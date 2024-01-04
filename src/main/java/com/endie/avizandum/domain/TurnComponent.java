package com.endie.avizandum.domain;

public class TurnComponent {
    private long id;
    private long turnNumber;
    private long playerId;

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
}
