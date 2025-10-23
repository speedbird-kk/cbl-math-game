package Experimentation.Game.States;

import Experimentation.Components.Lanes.AllLanesFactory.AllLanesFactory;
import Experimentation.Components.Lanes.AllLanesFactory.NoOperandsCreator;
import Experimentation.Components.Lanes.AllLanes;
import Experimentation.ComponentsGUI.Windows.GameWindow;
import Experimentation.ComponentsGUI.Windows.WindowFactory.ModeTwoWindowCreator;
import Experimentation.ComponentsGUI.Windows.WindowFactory.WindowFactory;
import Experimentation.Game.GameStatesContext;

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
