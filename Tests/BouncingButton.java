import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class BouncingButton {
    public static void main(String[] args) {
        Random random = new Random();

        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        int contentPaneWidth = frame.getContentPane().getWidth();
        int contentPaneHeitght = frame.getContentPane().getHeight();
        JButton button = new JButton("text within the button");
        int buttonWidth = 220;
        int buttonHeight = 50;

        // 400 width and 500 height

        // x axis, y axis, width, height
        // button.setBounds(frame.getWidth()-220, frame.getHeight() - 50, 220, 50);
        button.setBounds(random.nextInt(contentPaneWidth - buttonWidth),
                random.nextInt(contentPaneHeitght - buttonHeight), 220, 50);
        // button.setBounds(100, 100, 220, 50);

        frame.setLayout(null);
        frame.add(button);

        // using no layout managers

        frame.setVisible(true);
        MyActionListenerClass myActionListenerClass = new MyActionListenerClass(button, frame);
        Timer timer = new Timer(7, myActionListenerClass);
        timer.start();
    }
}

class MyActionListenerClass implements ActionListener {
    JButton button;
    JFrame frame;
    int buttonX;
    int buttonY;
    double speed = 2.5;
    int dirX = 1;
    int dirY = 1;
    int contentPaneWidth;
    int contentPaneHeitght;

    MyActionListenerClass(JButton button, JFrame frame) {
        this.button = button;
        this.frame = frame;
        this.contentPaneWidth = frame.getContentPane().getWidth();
        this.contentPaneHeitght = frame.getContentPane().getHeight();
        this.buttonX = button.getX();
        this.buttonY = button.getY();
    }

    public void actionPerformed(ActionEvent e) {
        contentPaneWidth = frame.getContentPane().getWidth();
        contentPaneHeitght = frame.getContentPane().getHeight();

        if (buttonY + speed * dirY > contentPaneHeitght - button.getHeight())
            dirY *= -1;
        if (buttonX + speed * dirX > contentPaneWidth - button.getWidth())
            dirX *= -1;
        if (buttonY + speed * dirY < 0)
            dirY *= -1;
        if (buttonX + speed * dirX < 0)
            dirX *= -1;

        buttonX += speed * dirX;
        buttonY += speed * dirY;

        button.setBounds(buttonX, buttonY, button.getWidth(), button.getHeight());
        frame.invalidate();
        frame.repaint();
    }
}