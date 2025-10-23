package Experimentation.Game.States;

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
    }
}
