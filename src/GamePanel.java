
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final Dimension frameSize = new Dimension(300, 300);
    final int screenWidth = (int) frameSize.getWidth();
    final int screenHeight = (int) frameSize.getHeight();

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    GameContext gameContext = new GameContext();

    TitleScreenPanel titleScreenPanel;
    Mode1Panel mode1Panel;

    public GamePanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize.setSize(screenSize.getWidth() / 2, screenSize.getHeight() / 2);
        gameContext.tileWidth = (int) frameSize.getWidth() / 16;
        gameContext.tileHeight = (int) frameSize.getHeight() / 9;

        this.setPreferredSize(frameSize);
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        gameContext.FPS = 60;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override public void run() { // This gets called repeatedly when gameThread.start() is ran
        double drawInterval = 1000000000 / gameContext.FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        long lastCurrentTimeMs = System.currentTimeMillis();
        while (gameThread != null) {
            long currentTimeMs = System.currentTimeMillis();
            int timeElapsedMs = (int) (currentTimeMs - lastCurrentTimeMs);
            lastCurrentTimeMs = currentTimeMs;

            updateGame(timeElapsedMs);

            this.revalidate();
            this.repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateGame(int timeElapsedMs) {
        if (gameContext.state == 0) {
            loadState1();
        }
        if (gameContext.state == 1) {
            if (titleScreenPanel.titleButton.isPressed == true) {
                unloadState1();
                loadState2();
                titleScreenPanel.titleButton.isPressed = false;
            }
            titleScreenPanel.timeUpdate(timeElapsedMs);
        }
        if (gameContext.state == 2) {
            if (keyH.escapePressed == true) {
                unloadState2();
                loadState1();
            }
            mode1Panel.timeUpdate(timeElapsedMs);
        }
    }

    public void loadState1() {
        if (titleScreenPanel == null) {
            titleScreenPanel = new TitleScreenPanel(gameContext);
        }
        this.add(titleScreenPanel);
        gameContext.state = 1;
    }
    public void unloadState1() {
        this.remove(titleScreenPanel);
    }

    public void loadState2() {
        if (mode1Panel == null) {
            mode1Panel = new Mode1Panel(keyH, gameContext);
        }
        this.add(mode1Panel);
        gameContext.state = 2;
    }
    public void unloadState2() {
        this.remove(mode1Panel);
    }
}