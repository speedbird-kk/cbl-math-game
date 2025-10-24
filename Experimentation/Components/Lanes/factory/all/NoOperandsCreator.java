package Experimentation.components.lanes.factory.all;

import Experimentation.components.lanes.AllLanes;
import Experimentation.components.lanes.DifferenceLane;
import Experimentation.components.lanes.Lane;
import Experimentation.components.lanes.ProductLane;
import Experimentation.components.lanes.QuotientLane;
import Experimentation.components.lanes.SumLane;
import Experimentation.components.lanes.factory.each.DifferenceLaneCreator;
import Experimentation.components.lanes.factory.each.LaneFactory;
import Experimentation.components.lanes.factory.each.ProductLaneCreator;
import Experimentation.components.lanes.factory.each.QuotientLaneCreator;
import Experimentation.components.lanes.factory.each.SumLaneCreator;


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