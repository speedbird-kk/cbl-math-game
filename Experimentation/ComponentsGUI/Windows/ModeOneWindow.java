package Experimentation.ComponentsGUI.Windows;

import javax.swing.JPanel;

public class ModeOneWindow implements GameWindow {
    private final JPanel panel;

    public ModeOneWindow() {
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
