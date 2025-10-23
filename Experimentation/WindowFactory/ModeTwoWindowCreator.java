package Experimentation.WindowFactory;

import Experimentation.Windows.GameWindow;
import Experimentation.Windows.ModeTwoWindow;

public class ModeTwoWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new ModeTwoWindow();
    }    
}
