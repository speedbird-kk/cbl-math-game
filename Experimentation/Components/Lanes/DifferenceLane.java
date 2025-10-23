package Experimentation.Components.Lanes;

import Experimentation.Components.Input.Input;

public class DifferenceLane extends Lane {
    public static final int IDENTITY = 0;
    private int subtrahend;

    public DifferenceLane(int subtrahend) {
        this.subtrahend = subtrahend;
        operationSymbol = "−";
    }

    @Override
    public boolean checkResponse() {
        return response - subtrahend == currentBlock.getNumber();
    }

    @Override
    public void parseResponse(Input input) {
        response = input.a() - input.b();
    }

    public int getSubtrahend() {
        return subtrahend;
    }
}
