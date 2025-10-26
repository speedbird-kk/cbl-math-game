package Experimentation.core;

import Experimentation.core.states.ModeState;

public sealed interface GameModeContext permits GameContext {
    public ModeState getMode();
}
