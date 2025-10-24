package Experimentation.view.windows.factory;

import Experimentation.view.windows.GameWindow;
import Experimentation.view.windows.ModeTwoWindow;

public class ModeTwoWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new ModeTwoWindow();
    }    
}
