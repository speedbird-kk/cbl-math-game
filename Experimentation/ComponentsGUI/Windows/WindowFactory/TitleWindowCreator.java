package Experimentation.WindowFactory;

import Experimentation.Windows.GameWindow;
import Experimentation.Windows.TitleWindow;

public class TitleWindowCreator extends WindowFactory {
    @Override
    public GameWindow factoryMethod() {
        return new TitleWindow();
    }
}
