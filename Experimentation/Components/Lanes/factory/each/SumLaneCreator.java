package Experimentation.components.lanes.factory.each;

import Experimentation.components.lanes.Lane;
import Experimentation.components.lanes.SumLane;

public class SumLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int summand) {
        return new SumLane(summand);
    }
}
