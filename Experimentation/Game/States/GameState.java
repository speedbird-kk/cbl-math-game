package Experimentation.Game.States;

import Experimentation.Game.GameStatesContext;

public interface GameState {
    void handleRequest(GameStatesContext context);
}
