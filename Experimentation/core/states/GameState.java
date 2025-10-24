package Experimentation.core.states;

import Experimentation.core.GameStatesContext;

public interface GameState {
    void handleRequest(GameStatesContext context);
}
