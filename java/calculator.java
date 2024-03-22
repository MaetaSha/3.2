import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator extends JFrame implements ActionListener {
    JButton b10, b11, b12, b13, b14, b15, b16;
    JButton b[] = new JButton[10];
    int i;
    double n1, n2, r;
    JTextField res;
    StringBuilder expression = new StringBuilder();
    char op;

    public calculator() {
        super("Calculator");
        setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        // Add number buttons
        for (int i = 0; i <= 9; i++) {
            b[i] = new JButton(i + "");
            buttonPanel.add(b[i]);
            b[i].addActionListener(this);
        }

        // Add operation buttons
        b10 = new JButton("+");
        buttonPanel.add(b10);
        b10.addActionListener(this);
        b11 = new JButton("-");
        buttonPanel.add(b11);
        b11.addActionListener(this);
        b12 = new JButton("*");
        buttonPanel.add(b12);
        b12.addActionListener(this);
        b13 = new JButton("/");
        buttonPanel.add(b13);
        b13.addActionListener(this);
        b14 = new JButton("=");
        buttonPanel.add(b14);
        b14.addActionListener(this);
        b15 = new JButton("C");
        buttonPanel.add(b15);
        b15.addActionListener(this);
        b16 = new JButton(".");
        buttonPanel.add(b16);
        b16.addActionListener(this);

        add(buttonPanel, BorderLayout.CENTER);

        // Output text field
        res = new JTextField(20); // Increase the number of columns
        res.setFont(new Font("Arial", Font.PLAIN, 20)); // Decreased font size
        res.setEditable(false); // Make it non-editable
        add(res, BorderLayout.SOUTH); // Move result display to the bottom

        setVisible(true);
        setSize(400, 450); // Increase window height
    }

    public void actionPerformed(ActionEvent ae) {
        JButton pb = (JButton) ae.getSource();
        if (pb == b15) {
            expression.setLength(0);
            res.setText("");
        } else if (pb == b14) {
            evaluate();
        } else if (pb == b16) {
            String currentText = res.getText();
            if (!currentText.contains(".")) {
                expression.append(".");
                res.setText(expression.toString());
            }
        } else {
            boolean opf = false;
            if (pb == b10) {
                op = '+';
                opf = true;
            }
            if (pb == b11) {
                op = '-';
                opf = true;
            }
            if (pb == b12) {
                op = '*';
                opf = true;
            }
            if (pb == b13) {
                op = '/';
                opf = true;
            }
            if (opf == false) {
                for (i = 0; i < 10; i++) {
                    if (pb == b[i]) {
                        expression.append(i);
                        res.setText(expression.toString());
                    }
                }
            } else {
                expression.append(" " + pb.getText() + " ");
                res.setText(expression.toString());
            }
        }
    }

    void evaluate() {
        String[] parts = expression.toString().split("\\s+");
        if (parts.length != 3) {
            res.setText("Invalid expression");
            expression.setLength(0);
            return;
        }
        try {
            n1 = Double.parseDouble(parts[0]);
            op = parts[1].charAt(0);
            n2 = Double.parseDouble(parts[2]);
            switch (op) {
                case '+':
                    r = n1 + n2;
                    break;
                case '-':
                    r = n1 - n2;
                    break;
                case '*':
                    r = n1 * n2;
                    break;
                case '/':
                    if (n2 != 0) {
                        r = n1 / n2;
                    } else {
                        res.setText("Error: Division by zero");
                        expression.setLength(0);
                        return;
                    }
                    break;
                default:
                    res.setText("Invalid operator");
                    expression.setLength(0);
                    return;
            }
            res.setText(Double.toString(r));
        } catch (NumberFormatException e) {
            res.setText("Invalid number format");
        }
        expression.setLength(0);
    }

    public static void main(String arg[]) {
        new calculator();
    }
}
