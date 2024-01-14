package com.endie.avizandum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TurnComponent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long turnNumber;
    private long playerId;
    private String turnAction;


    public TurnComponent(long id, long turnNumber, long playerId, String turnAction) {
        this.id = id;
        this.turnNumber = turnNumber;
        this.playerId = playerId;
        this.turnAction = turnAction;
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
