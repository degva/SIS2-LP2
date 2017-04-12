package lp2;

public class Pokeball extends Item {

    private double catchProb;

    public Pokeball(double catchProb, String name, String description) {
        super(name, description);
        this.catchProb = catchProb;
    }

    public double getCatchProb() {
        return catchProb;
    }

    public void setCatchProb(double catchProb) {
        this.catchProb = catchProb;
    }

    public void catchPokemon() {

    }
}
