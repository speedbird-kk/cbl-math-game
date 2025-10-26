package Experimentation.view.styles.constants;

/**
 * Global constants for swing timer.
 */
public enum TimerConstants {
    FPS(60),
    DELAY_MS(1000 / FPS.get());

    private int value;

    TimerConstants(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
