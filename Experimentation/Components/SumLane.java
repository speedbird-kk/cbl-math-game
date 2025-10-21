package Experimentation.Components;

public class SumLane extends Lane {
    public static final int IDENTITY = 0;
    private int summand;

    public SumLane(int summand) {
        this.summand = summand;
        operationSymbol = "+";
    }

    public int getSummand() {
        return summand;
    }
}
