package Experimentation.components.lanes.factory.each;

import Experimentation.components.lanes.Lane;
import Experimentation.components.lanes.QuotientLane;

public class QuotientLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int divisor) {
        return new QuotientLane(divisor);
    }
}
