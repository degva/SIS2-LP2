package lp2;

enum Type {
    Fire, Water, Earth, Wind
};

public class Pokemon {

    public int id;
    public float attack_pts;
    public float defense_pts;
    public float life;
    public String name;
    public Type type;

    public Pokemon(int id, int attack_pts, int defense_pts, int life, String name, Type type) {
        this.id = id;
        this.attack_pts = attack_pts;
        this.defense_pts = defense_pts;
        this.life = life;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAttack_pts() {
        return attack_pts;
    }

    public void setAttack_pts(int attack_pts) {
        this.attack_pts = attack_pts;
    }

    public float getDefense_pts() {
        return defense_pts;
    }

    public void setDefense_pts(int defense_pts) {
        this.defense_pts = defense_pts;
    }

    public float getLife() {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void attack(Pokemon a) {
        
    }

    public void takeDamage(float attack_points) {
        
    }
}
