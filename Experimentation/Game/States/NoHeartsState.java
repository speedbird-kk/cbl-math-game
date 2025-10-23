package Experimentation.Game.States;

import Experimentation.ComponentsGUI.Windows.GameWindow;
import Experimentation.ComponentsGUI.Windows.WindowFactory.EndWindowCreator;
import Experimentation.ComponentsGUI.Windows.WindowFactory.WindowFactory;
import Experimentation.Game.GameStatesContext;

public class NoHeartsState implements GameState {
    @Override
    public void handleRequest(GameStatesContext context) {
        WindowFactory factory = new EndWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());
    }
}
