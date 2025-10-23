package Experimentation.WindowFactory;

import Experimentation.Windows.GameWindow;
import Experimentation.Windows.EndWindow;

public class EndWindowCreator extends WindowFactory {
    public GameWindow factoryMethod() {
        return new EndWindow();
    }
}
