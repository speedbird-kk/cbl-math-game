package Experimentation.components.lanes.factory.each;

import Experimentation.components.lanes.DifferenceLane;
import Experimentation.components.lanes.Lane;

public class DifferenceLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int subtrahend) {
        return new DifferenceLane(subtrahend);
    }
}
