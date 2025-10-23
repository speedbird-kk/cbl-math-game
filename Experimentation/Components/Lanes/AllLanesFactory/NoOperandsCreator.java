package Experimentation.Components.Lanes.AllLanesFactory;

import Experimentation.Components.Lanes.*;
import Experimentation.Components.Lanes.LaneFactory.*;

public class NoOperandsCreator extends AllLanesFactory {
    @Override
    public AllLanes factoryMethod() {
        LaneFactory factoryProduct = new ProductLaneCreator();
        LaneFactory factoryQuotient = new QuotientLaneCreator();
        LaneFactory factorySum = new SumLaneCreator();
        LaneFactory factoryDifference = new DifferenceLaneCreator();
        
        Lane productLane = factoryProduct.factoryMethod(ProductLane.IDENTITY);
        Lane quotientLane = factoryQuotient.factoryMethod(QuotientLane.IDENTITY);
        Lane sumLane = factorySum.factoryMethod(SumLane.IDENTITY);
        Lane differenceLane = factoryDifference.factoryMethod(DifferenceLane.IDENTITY);

        return new AllLanes(productLane, quotientLane, sumLane, differenceLane);
    }
}