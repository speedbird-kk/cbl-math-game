package Experimentation.core.states;

import Experimentation.core.GameStatesContext;

public sealed interface GameState permits
    LevelTransitionState, ModeOneState, ModeTwoState, NoHeartsState, PauseState {
        
    void handleRequest(GameStatesContext context);
}
