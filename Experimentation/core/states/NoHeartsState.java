package Experimentation.core.states;

import Experimentation.core.GameStatesContext;
import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.factory.EndWindowCreator;
import Experimentation.view.windows.factory.WindowFactory;

public class NoHeartsState implements GameState {
    @Override
    public void handleRequest(GameStatesContext context) {
        WindowFactory factory = new EndWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());
    }
}
