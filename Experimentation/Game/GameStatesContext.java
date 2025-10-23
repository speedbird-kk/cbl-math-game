package Experimentation.Game;

import Experimentation.Components.Lanes.AllLanes;
import Experimentation.ComponentsGUI.Frame.MainFrame;

/**
 * Interface Segregation Principle.
 * State pattern only needs getFrame() method in GameContext.
 */
public interface GameStatesContext {
    public MainFrame getFrame();

    public void setLanes(AllLanes lanes);
}
