package Experimentation.Components.Lanes.LaneFactory;

import Experimentation.Components.Lanes.Lane;
import Experimentation.Components.Lanes.QuotientLane;

public class QuotientLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int divisor) {
        return new QuotientLane(divisor);
    }
}
