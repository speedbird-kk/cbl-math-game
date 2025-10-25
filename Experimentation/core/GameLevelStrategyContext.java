package Experimentation.core;

import Experimentation.components.lanes.AllLanes;

public sealed interface GameLevelStrategyContext permits GameContext {
    public AllLanes getLanes();
}
