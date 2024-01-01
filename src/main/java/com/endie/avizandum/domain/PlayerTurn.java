package com.endie.avizandum.domain;

import javax.persistence.*;

@Entity
@Table(name="player_turn")
public class PlayerTurn {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public PlayerTurn(long playerId, long turnNumber) {
        this.playerId = playerId;
        this.turnNumber = turnNumber;
    }

    public PlayerTurn() {

    }

    public long getId() {
        return id;
    }

    private long playerId;
    private long turnNumber;

    public long getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(long turnNumber) {
        this.turnNumber = turnNumber;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
