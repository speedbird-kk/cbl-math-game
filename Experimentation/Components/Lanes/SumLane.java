package Experimentation.Components.Lanes;

import Experimentation.Components.Block.CreatorStrategy.SumLaneBlockCreator;
import Experimentation.Components.Input.Input;

public class SumLane extends Lane {
    public static final int IDENTITY = 0;

    public SumLane(int operand) {
        super(operand, LaneType.SUM, "+", new SumLaneBlockCreator());
    }

    @Override
    public boolean checkResponse() {
        return response + operand == currentBlock.getNumber();
    }

    @Override
    public void parseResponse(Input input) {
        response = input.a() + input.b();
    }
}
