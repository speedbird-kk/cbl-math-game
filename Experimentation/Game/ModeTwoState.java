package Experimentation.Game;

import Experimentation.WindowFactory.ModeTwoWindowCreator;
import Experimentation.WindowFactory.WindowFactory;
import Experimentation.Windows.GameWindow;

public class ModeTwoState implements GameState {
    @Override
    public void handleRequest(GameContext context) {
        WindowFactory factory = new ModeTwoWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());
    }
}
