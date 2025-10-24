package Experimentation.view.windows.factory;

import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.TitleWindow;

public class TitleWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new TitleWindow();
    }
}
