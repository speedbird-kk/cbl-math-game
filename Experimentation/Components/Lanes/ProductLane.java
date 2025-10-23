package Experimentation.Components.Lanes;

import Experimentation.Components.Input.Input;

public class ProductLane extends Lane {
    public static final int IDENTITY = 1;
    private int multiplicand;

    public ProductLane(int multiplicand) {
        this.multiplicand = multiplicand;
        operationSymbol = "×";
    }

    @Override
    public boolean checkResponse() {
        return response * multiplicand == currentBlock.getNumber();
    }

    @Override
    public void parseResponse(Input input) {
        response = input.a() * input.b();
    }

    public int getMultiplicand() {
        return multiplicand;
    }
}
