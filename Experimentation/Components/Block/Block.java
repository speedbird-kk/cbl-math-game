package Experimentation.Components.Block;

public class Block {
    private int number;
    private boolean isRed;
    private boolean hasHitBottom;
    private boolean hasBeenSolved;
    
    public Block(int number, boolean isRed) {
        this.number = number;
        this.isRed = isRed;
    }

    public int getNumber() {
        return number;
    }

    public boolean getIsRed() {
        return isRed;
    }

    public boolean getHasHitBottom() {
        return hasHitBottom;
    }

    public boolean getHasBeenSolved() {
        return hasBeenSolved;
    }
}
