package Experimentation.WindowFactory;

import Experimentation.Windows.GameWindow;
import Experimentation.Windows.ModeOneWindow;

public class ModeOneWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new ModeOneWindow();
    }
}
