package Experimentation.view.windows.factory;

import Experimentation.view.windows.EndWindow;
import Experimentation.view.windows.GameWindow;

public class EndWindowCreator extends WindowFactory {
    public GameWindow factoryMethod() {
        return new EndWindow();
    }
}
