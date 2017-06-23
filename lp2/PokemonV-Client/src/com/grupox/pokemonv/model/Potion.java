package com.grupox.pokemonv.model;

public class Potion {
    //public enum  { MENU, MOVING };
    private int _id;
    private String namePotion;
    private String description;
    private int hpRecovered;

    public Potion(int _id, String namePotion, String description, int hpRecovered) {
        this._id = _id;
        this.namePotion = namePotion;
        this.description = description;
        this.hpRecovered = hpRecovered;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNamePotion() {
        return namePotion;
    }

    public void setNamePotion(String namePotion) {
        this.namePotion = namePotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHpRecovered() {
        return hpRecovered;
    }

    public void setHpRecovered(int hpRecovered) {
        this.hpRecovered = hpRecovered;
    }

}
