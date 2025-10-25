package Experimentation.view.components;

import Experimentation.utils.SwingUtils;
import Experimentation.view.styles.Style;
import Experimentation.view.styles.constants.DimensionConstants;
import Experimentation.view.styles.constants.LengthConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaneView extends JPanel implements ActionListener {
    private final JLabel operand;
    private final JTextField input;
    private String rawInput;

    public LaneView(int x) {
        this.setBounds(
            x,
            LengthConstants.GRID_HEIGHT.get(),
            DimensionConstants.LANE.get().width,
            DimensionConstants.LANE.get().height
        );

        this.operand = new JLabel();
        Style.OPERAND_LABEL.accept(operand);
        
        input = new JTextField();
        Style.INPUT_TEXTFIELD.accept(input);
        input.addActionListener(this);

        SwingUtils.addAll(this, operand, input);
    }

    public void wrongAnswer() {
        Style.INPUT_TEXTFIELD_WRONG.accept(input);
    }

    public void correctAnswer() {
        Style.INPUT_TEXTFIELD_CORRECT.accept(input);
    }

    public void actionPerformed(ActionEvent evt) {
        rawInput = input.getText();
    }

    public String getRawInput() {
        return rawInput;
    }
}