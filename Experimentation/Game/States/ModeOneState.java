package Experimentation.Game.States;

import Experimentation.Components.Lanes.AllLanes;
import Experimentation.Components.Lanes.AllLanesFactory.AllLanesFactory;
import Experimentation.Components.Lanes.AllLanesFactory.WithOperandsCreator;
import Experimentation.ComponentsGUI.Windows.GameWindow;
import Experimentation.ComponentsGUI.Windows.WindowFactory.ModeOneWindowCreator;
import Experimentation.ComponentsGUI.Windows.WindowFactory.WindowFactory;
import Experimentation.Game.GameStatesContext;

public class ModeOneState implements GameState {
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