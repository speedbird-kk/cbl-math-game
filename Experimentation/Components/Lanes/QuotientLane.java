package Experimentation.Components.Lanes;

import Experimentation.Components.Input.Input;

public class QuotientLane extends Lane {
    public static final int IDENTITY = 1;

    public QuotientLane(int operand) {
        super(operand, "÷");
    }

    @Override
    public boolean checkResponse() {
        return response / operand == currentBlock.getNumber();
    }

    @Override
    public void parseResponse(Input input) {
        response = input.a() / input.b();
    }
}