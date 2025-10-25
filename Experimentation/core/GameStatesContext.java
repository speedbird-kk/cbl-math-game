package Experimentation.core;

import Experimentation.view.frame.MainFrame;
import Experimentation.components.lanes.AllLanes;

/**
 * Interface Segregation Principle.
 * State pattern only needs getFrame() method in GameContext.
 */
public sealed interface GameStatesContext permits GameContext {
    public MainFrame getFrame();

    public void setLanes(AllLanes lanes);
}
