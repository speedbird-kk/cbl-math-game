import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LanePanel extends JPanel {
    Dimension panelSize = new Dimension();

    LanePanel(Dimension frameSize) {
        panelSize.setSize(frameSize.getWidth() / 2, frameSize.getHeight() * 7 / 9);
        this.setBounds((int) frameSize.getWidth() / 16, (int) frameSize.getHeight() / 9,
                (int) panelSize.getWidth(), (int) panelSize.getHeight());

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.setBackground(Color.RED);

        this.add(new Lane(panelSize));
        this.add(new Lane(panelSize));
        this.add(new Lane(panelSize));
        this.add(new Lane(panelSize));
    }
}