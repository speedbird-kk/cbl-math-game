package Experimentation.Game;

import Experimentation.ComponentsGUI.Frame.MainFrame;

/**
 * Interface Segregation Principle.
 * State pattern only needs getFrame() method in GameContext.
 */
public interface GameStatesContext {
    public MainFrame getFrame();
}
