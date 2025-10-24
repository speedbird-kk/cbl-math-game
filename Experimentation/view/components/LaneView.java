package Experimentation.view.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Experimentation.view.styles.ApplyStyles;
import Experimentation.view.styles.DimensionConstants;
import Experimentation.view.styles.LengthConstants;
import Experimentation.view.styles.Style;

public class LaneView extends JPanel {
    private JLabel operand;
    private JTextField inputField;
    public LaneView(int x, int y) {
        this.setBounds(
            x,
            y,
            DimensionConstants.LANE.get().width,
            DimensionConstants.LANE.get().height
        );

        this.operand = new JLabel();
        Style.OPERAND_LABEL.accept(operand);
        this.add(operand);
        
        inputField = new JTextField();
        inputField.setFocusTraversalKeysEnabled(false);

        inputField.setBounds(
            0,
            (int) (6.25 * LengthConstants.GRID_HEIGHT.get()),
            this.getWidth(),
            (int) (0.75 * LengthConstants.GRID_HEIGHT.get())
        );

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int textFieldNumber = Integer.parseInt(inputField.getText().trim());
                    submissions.add(textFieldNumber);
                    inputField.setText("");
                    System.out.println("Number set to: " + textFieldNumber);
                } catch (NumberFormatException ex) {
                    System.out.println("Not a valid number!");
                }
            }
        });
        // Makes it so that when you focus the text field it highlights the text inside
        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Schedule on the event queue so it happens *after* focus is officially set
                SwingUtilities.invokeLater(() -> inputField.selectAll());
            }
        });
        ApplyStyles.INPUT_STYLE.on(inputField);
        this.add(inputField);
    }

    public JLabel getOperand() {
        return operand;
    }

    public JTextField getInputField() {
        return inputField;
    }
}
