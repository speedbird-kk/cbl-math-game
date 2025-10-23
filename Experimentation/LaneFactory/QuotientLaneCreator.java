package Experimentation.LaneFactory;

import Experimentation.Components.Lane;
import Experimentation.Components.QuotientLane;

public class QuotientLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int divisor) {
        return new QuotientLane(divisor);
    }
}
