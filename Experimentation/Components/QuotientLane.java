package Experimentation.Components;

public class QuotientLane extends Lane {
    public static final int IDENTITY = 1;
    private int divisor;

    public QuotientLane(int divisor) {
        this.divisor = divisor;
        operationSymbol = "÷";
    }

    public int getDivisor() {
        return divisor;
    }
}
