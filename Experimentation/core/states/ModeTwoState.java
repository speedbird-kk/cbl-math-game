package Experimentation.core.states;

import Experimentation.components.lanes.AllLanes;
import Experimentation.components.lanes.factory.all.AllLanesFactory;
import Experimentation.components.lanes.factory.all.NoOperandsCreator;
import Experimentation.core.GameStatesContext;
import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.factory.ModeTwoWindowCreator;
import Experimentation.view.windows.factory.WindowFactory;

public class ModeTwoState implements GameState {
    @Override
    public void handleRequest(GameStatesContext context) {
        WindowFactory factory = new ModeTwoWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());

        AllLanesFactory lanesFactory = new NoOperandsCreator();
        AllLanes lanes = lanesFactory.factoryMethod();
        context.setLanes(lanes);
    }
}
