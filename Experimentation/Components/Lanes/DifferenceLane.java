package Experimentation.components.lanes;

import Experimentation.components.block.creator.DifferenceLaneBlockCreator;
import Experimentation.components.input.Input;
import Experimentation.game.GameProgress;

public class DifferenceLane extends Lane {
    public static final int IDENTITY = 0;

    public DifferenceLane(int operand) {
        super(operand, LaneType.DIFFERENCE, "−",
            new DifferenceLaneBlockCreator(), GameProgress.getInstance().getLevelContext());
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