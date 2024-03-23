import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentRegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField, fatherNameField, motherNameField, departmentField, rollField, registrationField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JCheckBox accuracyCheckBox;
    private JButton submitButton;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Father's Name:"));
        fatherNameField = new JTextField();
        add(fatherNameField);

        add(new JLabel("Mother's Name:"));
        motherNameField = new JTextField();
        add(motherNameField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);

        add(new JLabel("Roll:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Registration:"));
        registrationField = new JTextField();
        add(registrationField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        accuracyCheckBox = new JCheckBox("I confirm that the information provided is accurate");
        add(accuracyCheckBox);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submitButton) {
            if (fieldsAreValid()) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields and confirm accuracy.");
            }
        }
    }
   

    private boolean fieldsAreValid() {
        String name = nameField.getText();
        String fatherName = fatherNameField.getText();
        String motherName = motherNameField.getText();
        String department = departmentField.getText();
        String roll = rollField.getText();
        String registration = registrationField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        boolean accuracyConfirmed = accuracyCheckBox.isSelected();

        return !name.isEmpty() && !fatherName.isEmpty() && !motherName.isEmpty() &&
                !department.isEmpty() && !roll.isEmpty() && !registration.isEmpty() &&
                !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty() &&
                accuracyConfirmed && password.equals(confirmPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistrationForm::new);
    }
}
