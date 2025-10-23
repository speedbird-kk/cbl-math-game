package Experimentation.Components;

public class SumLane extends Lane {
    public static final int IDENTITY = 0;
    private int summand;

    public SumLane(int summand) {
        this.summand = summand;
        operationSymbol = "+";
    }

    @Override
    public boolean checkResponse() {
        return response + summand == currentBlock.getNumber();
    }

    public int getSummand() {
        return summand;
    }
}
