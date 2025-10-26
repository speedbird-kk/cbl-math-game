package Experimentation.components.lanes;

import Experimentation.Components.Lanes.AllLanesFactory.Operands;
import Experimentation.components.lanes.factory.all.AllLanesFactory;
import Experimentation.components.lanes.factory.all.NoOperandsCreator;
import Experimentation.components.lanes.factory.all.WithOperandsCreator;
import Experimentation.core.GameModeContext;
import Experimentation.core.broker.EventBroker;
import Experimentation.core.broker.Publishes;
import Experimentation.core.events.OperandsChangedEvent;
import Experimentation.core.states.ModeOneState;
import Experimentation.core.states.ModeTwoState;

public record AllLanes(
    Lane productLane, Lane quotientLane, Lane sumLane, Lane differenceLane) {

    @Publishes(event = OperandsChangedEvent.class)
    public void reinitialise(GameModeContext context) {
        if (context.getMode() instanceof ModeOneState) {
            AllLanesFactory factory = new WithOperandsCreator();
            factory.factoryMethod();
        } else if (context.getMode() instanceof ModeTwoState) {
            AllLanesFactory factory = new NoOperandsCreator();
            factory.factoryMethod();
        }

        // TODO: Fix operands ???
        EventBroker.getInstance().publish(new OperandsChangedEvent(Operands operands));
        // TODO: Fix with strategy pattern.
    }
}
