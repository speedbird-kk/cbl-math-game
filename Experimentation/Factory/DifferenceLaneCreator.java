package Experimentation.Factory;

import Experimentation.Components.DifferenceLane;
import Experimentation.Components.Lane;

public class DifferenceLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int subtrahend) {
        return new DifferenceLane(subtrahend);
    }
}
