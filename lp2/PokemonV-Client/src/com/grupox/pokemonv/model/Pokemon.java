package com.grupox.pokemonv.model;

public class Pokemon {
    /* Enum declaration */
    public enum TypeP { Fire, Water, Earth, Wind }

    /* Attributes */
    public int id;
    public int attack1_pts;
    public String attack1_name;
    public int attack2_pts;
    public String attack2_name;
    public int defense_pts;
    public int life;
    public String name;
    public TypeP type;
    public boolean isSelected;
    
    /* Constructors */
    public Pokemon( int id, int attack_pts, int defense_pts, int life, String name, TypeP type ) {
        this.id = id;
        this.attack1_pts = attack_pts;
        this.defense_pts = defense_pts;
        this.life = life;
        this.name = name;
        this.type = type;
        this.isSelected = false;
    }

    public Pokemon(int id, int attack1_pts, String attack1_name, int attack2_pts, String attack2_name, int defense_pts, int life, String name, TypeP type, boolean isSelected) {
        this.id = id;
        this.attack1_pts = attack1_pts;
        this.attack1_name = attack1_name;
        this.attack2_pts = attack2_pts;
        this.attack2_name = attack2_name;
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

    public int getAttack1_pts() {
        return attack1_pts;
    }

    public void setAttack1_pts(int attack1_pts) {
        this.attack1_pts = attack1_pts;
    }

    public String getAttack1_name() {
        return attack1_name;
    }

    public void setAttack1_name(String attack1_name) {
        this.attack1_name = attack1_name;
    }

    public int getAttack2_pts() {
        return attack2_pts;
    }

    public void setAttack2_pts(int attack2_pts) {
        this.attack2_pts = attack2_pts;
    }

    public String getAttack2_name() {
        return attack2_name;
    }

    public void setAttack2_name(String attack2_name) {
        this.attack2_name = attack2_name;
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


}

