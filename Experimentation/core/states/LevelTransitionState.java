package Experimentation.core.states;

import Experimentation.core.GameStatesContext;
import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.factory.LevelTransitionWindowCreator;
import Experimentation.view.windows.factory.WindowFactory;

public final class LevelTransitionState implements GameState {
    @Override
    public void handleRequest(GameStatesContext context) {
        WindowFactory factory = new LevelTransitionWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent((window.getPanel()));
    }
}
