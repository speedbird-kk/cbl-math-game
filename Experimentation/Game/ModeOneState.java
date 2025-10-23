package Experimentation.Game;

import Experimentation.WindowFactory.ModeOneWindowCreator;
import Experimentation.WindowFactory.WindowFactory;
import Experimentation.Windows.GameWindow;

public class ModeOneState implements GameState {
    @Override
    public void handleRequest(GameContext context) {
        WindowFactory factory = new ModeOneWindowCreator();
        GameWindow window = factory.factoryMethod();
        context.getFrame().setContent(window.getPanel());
    }
}