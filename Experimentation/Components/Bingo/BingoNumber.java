package Experimentation.components.bingo;

public class BingoNumber {
    private int value;
    private boolean isUsed;

    BingoNumber(int value) {
        this.value = value;
        isUsed = false;
    }

    public int getValue() {
        return value;
    }

    public boolean getIsUsed() {
        return isUsed;
    }
}