package com.grupox.pokemonv.model;

public class Pokemon {

    /* Enum declaration */
    public enum TypeP {
        Fire, Water, Earth, Wind, Electric
    }

    /* Attributes */
    public int id;

    public Attack attack1;
    public Attack attack2;

    public int defense_pts;
    public int life;
    public String name;
    public TypeP type;
    public boolean isSelected;

    public Pokemon(int id, Attack attack1, Attack attack2, int defense_pts, int life, String name, TypeP type, boolean isSelected) {
        this.id = id;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.defense_pts = defense_pts;
        this.life = life;
        this.name = name;
        this.type = type;
        this.isSelected = isSelected;
    }

    /* Getters & Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefense_pts() {
        return defense_pts;
    }

    public void setDefense_pts(int defense_pts) {
        this.defense_pts = defense_pts;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeP getType() {
        return type;
    }

    public void setType(TypeP type) {
        this.type = type;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Attack getAttack1() {
        return attack1;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }

    public Attack getAttack2() {
        return attack2;
    }

    public void setAttack2(Attack attack2) {
        this.attack2 = attack2;
    }

}
