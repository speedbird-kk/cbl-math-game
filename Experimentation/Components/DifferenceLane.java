package Experimentation.Components;

public class DifferenceLane extends Lane {
    public static final int IDENTITY = 0;
    private int subtrahend;

    public DifferenceLane(int subtrahend) {
        this.subtrahend = subtrahend;
        operationSymbol = "−";
    }

    public boolean checkResponse() {
        return response - subtrahend == currentBlock.getNumber();
    }

    public int getSubtrahend() {
        return subtrahend;
    }
}
