package Experimentation.Components.Lanes.AllLanesFactory;

import Experimentation.Components.Lanes.AllLanes;
import Experimentation.Components.Lanes.DifferenceLane;
import Experimentation.Components.Lanes.ProductLane;
import Experimentation.Components.Lanes.QuotientLane;
import Experimentation.Components.Lanes.SumLane;
import Experimentation.Components.Lanes.Lane;
import Experimentation.Components.Lanes.LaneFactory.DifferenceLaneCreator;
import Experimentation.Components.Lanes.LaneFactory.LaneFactory;
import Experimentation.Components.Lanes.LaneFactory.ProductLaneCreator;
import Experimentation.Components.Lanes.LaneFactory.QuotientLaneCreator;
import Experimentation.Components.Lanes.LaneFactory.SumLaneCreator;

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
