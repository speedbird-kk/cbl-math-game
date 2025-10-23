package Experimentation.Components.Lanes;

import Experimentation.Components.Input.Input;

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

    @Override
    public void parseResponse(Input input) {
        response = input.a() / input.b();
    }

    public int getDivisor() {
        return divisor;
    }
}
