package Experimentation.Components.Lanes;

import Experimentation.Components.Input.Input;

public class DifferenceLane extends Lane {
    public static final int IDENTITY = 0;

    public DifferenceLane(int operand) {
        super(operand, "−");
    }

    @Override
    public boolean checkResponse() {
        return response - operand == currentBlock.getNumber();
    }

    @Override
    public void parseResponse(Input input) {
        response = input.a() - input.b();
    }
}