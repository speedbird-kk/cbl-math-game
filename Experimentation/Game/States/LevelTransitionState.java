package Experimentation.Game.States;

import Experimentation.ComponentsGUI.Windows.GameWindow;
import Experimentation.ComponentsGUI.Windows.WindowFactory.LevelTransitionWindowCreator;
import Experimentation.ComponentsGUI.Windows.WindowFactory.WindowFactory;
import Experimentation.Game.GameStatesContext;

public class LevelTransitionState implements GameState {
    @Override
    public void handleRequest(GameStatesContext context) {
        WindowFactory factory = new LevelTransitionWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent((window.getPanel()));
    }
}
