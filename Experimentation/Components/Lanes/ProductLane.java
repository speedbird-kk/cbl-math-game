package Experimentation.components.lanes;

import Experimentation.components.block.creator.ProductLaneBlockCreator;
import Experimentation.components.input.Input;

public class ProductLane extends Lane {
    public static final int IDENTITY = 1;

    public ProductLane(int operand) {
        super(operand, LaneType.PRODUCT, "×", new ProductLaneBlockCreator());
    }

    @Override
    public boolean checkResponse() {
        return response * operand == currentBlock.getNumber();
    }

    @Override
    public void parseResponse(Input input) {
        response = input.a() * input.b();
    }
}