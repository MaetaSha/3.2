

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "%", "!"
    };
    private double num1, num2, result;
    private char operator;
    private boolean newInput;

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." -> {
                if (newInput) {
                    textField.setText("");
                    newInput = false;
                }
                textField.setText(textField.getText() + command);
            }
            case "+", "-", "*", "/", "%" -> {
                num1 = Double.parseDouble(textField.getText());
                operator = command.charAt(0);
                newInput = true;
            }
            case "=" -> {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+' -> result = num1 + num2;
                    case '-' -> result = num1 - num2;
                    case '*' -> result = num1 * num2;
                    case '/' -> result = num1 / num2;
                    case '%' -> result = num1 % num2;
                }
                textField.setText(String.valueOf(result));
                newInput = true;
            }
            case "!" -> {
                num1 = Double.parseDouble(textField.getText());
                result = factorial((int) num1);
                textField.setText(String.valueOf(result));
                newInput = true;
            }
            case "C" -> {
                textField.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
                newInput = false;
            }
        }
    }

    private double factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}