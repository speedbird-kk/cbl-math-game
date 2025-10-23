package Experimentation.Game;

import Experimentation.WindowFactory.LevelTransitionWindowCreator;
import Experimentation.WindowFactory.WindowFactory;
import Experimentation.Windows.GameWindow;

public class LevelTransitionState implements GameState {
    @Override
    public void handleRequest(GameContext context) {
        WindowFactory factory = new LevelTransitionWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent((window.getPanel()));
    }
}
