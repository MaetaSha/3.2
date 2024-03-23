import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class billTAX extends JFrame implements ActionListener {
    JCheckBox cb1, cb2, cb3;
    JLabel label;
    JTextField quantityField1, quantityField2, quantityField3;

    public billTAX() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        label = new JLabel("<html><font color=\"#000000\">Food Ordering System</font></html>");
        label.setBounds(50, 50, 300, 20);
        cb1 = new JCheckBox("Pizza @100");
        cb1.setBounds(100, 100, 150, 20);
        cb2 = new JCheckBox("Burger @30");
        cb2.setBounds(100, 150, 150, 20);
        cb3 = new JCheckBox("Tea @10");
        cb3.setBounds(100, 200, 150, 20);
        quantityField1 = new JTextField();
        quantityField1.setBounds(260, 100, 50, 20);
        quantityField2 = new JTextField();
        quantityField2.setBounds(260, 150, 50, 20);
        quantityField3 = new JTextField();
        quantityField3.setBounds(260, 200, 50, 20);
        JButton btn = new JButton("Order");
        btn.setBounds(100, 250, 150, 20);
        btn.addActionListener(this);
        add(cb1);
        add(cb2);
        add(cb3);
        add(quantityField1);
        add(quantityField2);
        add(quantityField3);
        add(btn);
        add(label);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double amount = 0;
        if (cb1.isSelected()) {
            int quantity1 = Integer.parseInt(quantityField1.getText());
            amount += 100 * quantity1;
        }
        if (cb2.isSelected()) {
            int quantity2 = Integer.parseInt(quantityField2.getText());
            amount += 30 * quantity2;
        }
        if (cb3.isSelected()) {
            int quantity3 = Integer.parseInt(quantityField3.getText());
            amount += 10 * quantity3;
        }

        // Calculate VAT and tax
        double vat = 0.15 * amount;
        double tax = 0.02 * amount;

        // Add VAT and tax to the total amount
        amount += vat + tax;

        // Create a custom panel with the same background color as the frame
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);

        // Add the message to the panel
        JLabel messageLabel = new JLabel("Total: " + amount + "\nVAT (15%): " + vat + "\nTax (2%): " + tax);
        panel.add(messageLabel);

        // Show the message dialog with the custom panel
        JOptionPane.showMessageDialog(this, panel, "Bill", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new billTAX());
    }
}
