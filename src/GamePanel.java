
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
    int tileWidth;
    int tileHeight;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    int FPS = 60;
    int mode = 0;

    Lane lane1;
    Lane lane2;
    Lane lane3;
    Lane lane4;
    TitleScreenPanel titleScreenPanel;

    public GamePanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize.setSize(screenSize.getWidth() / 2, screenSize.getHeight() / 2);
        tileWidth = (int) frameSize.getWidth() / 16;
        tileHeight = (int) frameSize.getHeight() / 9;

        this.setPreferredSize(frameSize);
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override public void run() { // This gets called repeatedly when gameThread.start() is ran
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            long currentTime = System.nanoTime();

            updateGame();

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

    public void updateGame() {
        if (mode == 0) {
            loadMode1();
        }
        if (mode == 1) {
            if (keyH.wPressed == true) {
                unloadMode1();
                loadMode2();
            }
        }
    }

    // public void paintComponent(Graphics g) {
    //     // super.paintComponent(g);

    //     // Graphics2D g2 = (Graphics2D) g;
    //     // g2.setColor(Color.white);
    //     // g2.fillRect(playerX, playerY, 30, 30);
    // }

    public void loadMode1() {
        if (titleScreenPanel == null) {
            titleScreenPanel = new TitleScreenPanel();
        }
        this.add(titleScreenPanel);
        mode = 1;
    }
    public void unloadMode1() {
        this.remove(titleScreenPanel);
    }

    public void loadMode2() {
        if (lane1 == null) {
            int laneX = tileWidth;
            lane1 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
            laneX += tileWidth * 2;
            lane2 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
            laneX += tileWidth * 2;
            lane3 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
            laneX += tileWidth * 2;
            lane4 = new Lane(laneX, tileHeight, tileWidth, tileHeight);
        }
        this.add(lane1);
        this.add(lane2);
        this.add(lane3);
        this.add(lane4);

        mode = 2;
    }
}