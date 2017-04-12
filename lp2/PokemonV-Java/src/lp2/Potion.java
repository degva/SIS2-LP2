package lp2;

public class Potion extends Item {

    private int hp;

    public Potion(int hp, String name, String description) {
        super(name, description);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void pour() {

    }
}
