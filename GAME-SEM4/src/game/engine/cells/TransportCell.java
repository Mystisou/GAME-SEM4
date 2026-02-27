package game.engine.cells;

public abstract class TransportCell extends Cell {

    // READ ONLY
    private final int effect;

    // Constructor
    public TransportCell(String name, int effect) {
        super(name);     
        this.effect = effect;
    }

    public int getEffect() {
        return effect;
    }
}
