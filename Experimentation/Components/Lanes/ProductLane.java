package Experimentation.components.lanes;

import Experimentation.components.block.creator.ProductLaneBlockCreator;
import Experimentation.components.input.Input;
import Experimentation.game.GameProgress;

public class ProductLane extends Lane {
    public static final int IDENTITY = 1;

    public ProductLane(int operand) {
        super(operand, LaneType.PRODUCT, "×",
            new ProductLaneBlockCreator(), GameProgress.getInstance().getLevelContext());
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