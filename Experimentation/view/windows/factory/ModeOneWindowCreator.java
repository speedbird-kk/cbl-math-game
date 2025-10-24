package Experimentation.view.windows.factory;

import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.ModeOneWindow;

public class ModeOneWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new ModeOneWindow();
    }
}
