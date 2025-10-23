package Experimentation.LaneFactory;

import Experimentation.Components.Lane;
import Experimentation.Components.SumLane;

public class SumLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int summand) {
        return new SumLane(summand);
    }
}
