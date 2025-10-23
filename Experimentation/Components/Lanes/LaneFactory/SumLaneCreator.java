package Experimentation.Components.Lanes.LaneFactory;

import Experimentation.Components.Lanes.Lane;
import Experimentation.Components.Lanes.SumLane;

public class SumLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int summand) {
        return new SumLane(summand);
    }
}
