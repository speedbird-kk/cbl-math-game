package Experimentation.view.windows.factory;

import Experimentation.view.windows.GameWindow;

public abstract class WindowFactory {
    public GameWindow show() {
        GameWindow window = factoryMethod();
        window.show();
        return window;
    }

    public abstract GameWindow factoryMethod();
}
