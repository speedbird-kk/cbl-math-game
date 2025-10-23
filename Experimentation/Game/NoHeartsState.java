package Experimentation.Game;

import Experimentation.WindowFactory.EndWindowCreator;
import Experimentation.WindowFactory.WindowFactory;
import Experimentation.Windows.GameWindow;

public class NoHeartsState implements GameState {
    @Override
    public void handleRequest(GameContext context) {
        WindowFactory factory = new EndWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());
    }
}
