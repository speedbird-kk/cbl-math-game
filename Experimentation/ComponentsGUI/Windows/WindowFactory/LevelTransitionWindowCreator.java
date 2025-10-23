package Experimentation.WindowFactory;

import Experimentation.Windows.GameWindow;
import Experimentation.Windows.LevelTransitionWindow;

public class LevelTransitionWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new LevelTransitionWindow();
    }
}
