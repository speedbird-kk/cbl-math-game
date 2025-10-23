package Experimentation.Game.States;

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
    }
}