package Experimentation.components.lanes;

import Experimentation.components.block.creator.QuotientLaneBlockCreator;
import Experimentation.components.input.Input;
import Experimentation.game.GameProgress;

public class QuotientLane extends Lane {
    public static final int IDENTITY = 1;

    public QuotientLane(int operand) {
        super(operand, LaneType.QUOTIENT, "÷",
            new QuotientLaneBlockCreator(), GameProgress.getInstance().getLevelContext());
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