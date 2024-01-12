package com.endie.avizandum.domain;

public class Unit {
    private String name;
    private long id;
    private long playerId;
    private long[] unitComponentIds;

    public Unit(String name, long id, long playerId, long[] unitComponentIds) {
        this.name = name;
        this.id = id;
        this.playerId = playerId;
        this.unitComponentIds = unitComponentIds;
    }

    public Unit() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long[] getUnitComponentIds() {
        return unitComponentIds;
    }

    public void setUnitComponentIds(long[] unitComponentIds) {
        this.unitComponentIds = unitComponentIds;
    }
}
