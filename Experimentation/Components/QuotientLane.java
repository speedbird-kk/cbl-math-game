package Experimentation.Components;

public class QuotientLane extends Lane {
    public static final int IDENTITY = 1;
    private int divisor;

    public QuotientLane(int divisor) {
        this.divisor = divisor;
        operationSymbol = "÷";
    }

    @Override
    public boolean checkResponse() {
        return response / divisor == currentBlock.getNumber();
    }

    public int getDivisor() {
        return divisor;
    }
}
