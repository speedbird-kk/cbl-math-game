package Experimentation.core.states;

import Experimentation.components.lanes.AllLanes;
import Experimentation.components.lanes.factory.all.AllLanesFactory;
import Experimentation.components.lanes.factory.all.WithOperandsCreator;
import Experimentation.core.GameStatesContext;
import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.factory.ModeOneWindowCreator;
import Experimentation.view.windows.factory.WindowFactory;

public final class ModeOneState implements GameState, ModeState {
    @Override
    public void handleRequest(GameStatesContext context) {
        WindowFactory factory = new ModeOneWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());

        AllLanesFactory lanesFactory = new WithOperandsCreator();
        AllLanes lanes = lanesFactory.factoryMethod();
        context.setLanes(lanes);
    }
}