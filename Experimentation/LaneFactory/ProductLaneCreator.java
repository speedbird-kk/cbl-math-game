package Experimentation.LaneFactory;

import Experimentation.Components.Lane;
import Experimentation.Components.ProductLane;

public class ProductLaneCreator extends LaneFactory {
    @Override
    public Lane factoryMethod(int multiplicand) {
        return new ProductLane(multiplicand);
    }
}
