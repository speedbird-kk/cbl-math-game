package Experimentation.Factory;

import Experimentation.Components.Lane;
import Experimentation.Components.QuotientLane;

public class QuotientLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int divisor) {
        return new QuotientLane(divisor);
    }
}
