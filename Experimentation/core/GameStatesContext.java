package Experimentation.core;

import Experimentation.view.frame.MainFrame;
import Experimentation.components.lanes.AllLanes;

/**
 * Interface Segregation Principle.
 * State pattern only needs getFrame() method in GameContext.
 */
public interface GameStatesContext {
    public MainFrame getFrame();

    public void setLanes(AllLanes lanes);
}
