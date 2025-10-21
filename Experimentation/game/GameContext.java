package Experimentation.game;

public class GameContext {
    private GameState state;

    public void setState(GameState state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}
