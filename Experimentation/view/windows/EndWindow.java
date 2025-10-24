package Experimentation.view.windows;

import javax.swing.JPanel;

public class EndWindow implements GameWindow {
    private final JPanel panel;

    public EndWindow() {
        panel = new JPanel();
        // TODO: Add components
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void show() {
        panel.setVisible(true);
    }

    @Override
    public void hide() {
        panel.setVisible(false);
    }
}
