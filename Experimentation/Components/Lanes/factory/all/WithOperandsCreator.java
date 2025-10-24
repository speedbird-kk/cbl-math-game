package Experimentation.components.lanes.factory.all;

import Experimentation.components.lanes.AllLanes;
import Experimentation.components.lanes.Lane;
import Experimentation.components.lanes.factory.each.DifferenceLaneCreator;
import Experimentation.components.lanes.factory.each.LaneFactory;
import Experimentation.components.lanes.factory.each.ProductLaneCreator;
import Experimentation.components.lanes.factory.each.QuotientLaneCreator;
import Experimentation.components.lanes.factory.each.SumLaneCreator;

public class WithOperandsCreator extends AllLanesFactory {
    @Override
    public AllLanes factoryMethod() {
        LaneFactory factoryProduct = new ProductLaneCreator();
        LaneFactory factoryQuotient = new QuotientLaneCreator();
        LaneFactory factorySum = new SumLaneCreator();
        LaneFactory factoryDifference = new DifferenceLaneCreator();
        
        // TODO: make operands sumbound and differencebound function of level
        Operands operands = new Operands(50, 90);
        Lane productLane = factoryProduct.factoryMethod(operands.multiplicand());
        Lane quotientLane = factoryQuotient.factoryMethod(operands.divisor());
        Lane sumLane = factorySum.factoryMethod(operands.summand());
        Lane differenceLane = factoryDifference.factoryMethod(operands.subtrahend());

        return new AllLanes(productLane, quotientLane, sumLane, differenceLane);
    }
}
