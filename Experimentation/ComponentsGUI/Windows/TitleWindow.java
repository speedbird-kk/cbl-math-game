package Experimentation.Windows;

import javax.swing.JPanel;

public class TitleWindow implements GameWindow {
    private final JPanel panel;

    public TitleWindow() {
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
