package Experimentation.components.lanes.factory.each;

import Experimentation.components.lanes.Lane;
import Experimentation.components.lanes.ProductLane;

public class ProductLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int multiplicand) {
        return new ProductLane(multiplicand);
    }
}
