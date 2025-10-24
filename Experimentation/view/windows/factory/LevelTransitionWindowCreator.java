package Experimentation.view.windows.factory;

import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.LevelTransitionWindow;

public class LevelTransitionWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new LevelTransitionWindow();
    }
}
