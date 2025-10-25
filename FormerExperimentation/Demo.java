package FormerExperimentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Experiment");
        frame.setSize(400, 400);
        frame.setVisible(true);

        JLabel test = new JLabel("Hello world");
        Style.OPERAND_LABEL.accept(test);

        JLabel label = new JLabel("""
            <html>
            <h1><u>Demonstration</u></h1>
            <ul>
                <li>Hello world !</li>
                <li>Hallo wereld ! </li>
            </ul>
            <table border="1">
                <thead>
                    <tr><th>English</th><th>Dutch</th></tr>
                </thead>
                <tbody>
                    <tr><th>Nice !</th><th>Leuk !</th></tr>
                </tbody>
            </table>
            </html>""".stripLeading());

        JButton btn = new JButton("Click here");

        ClassList.add(btn, "BUTTON", "BUTTON_EXTRA");
        
        ClassList.TITLE.add(label);
        
        frame.add(label);
        frame.add(btn);
        frame.add(test);
    }
}