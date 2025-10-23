package Experimentation.WindowFactory;

import Experimentation.Windows.GameWindow;

public abstract class WindowFactory {
    public GameWindow show() {
        GameWindow window = factoryMethod();
        window.show();
        return window;
    }

    public abstract GameWindow factoryMethod();
}
