package Windows;

import javax.swing.*;
import java.awt.*;

public class AuthWindow {
    private final JFrame auth;

    public AuthWindow(boolean isLogin) {
        String text = "Register";
        if (isLogin)
            text = "Login";
        auth = new JFrame(text);
        JPanel panel = new JPanel();
        auth.setResizable(false);
        panel.setLayout(null);

        JLabel label = new JLabel("Please " + text.toLowerCase());
        label.setBounds(150, 20, 400, 35);
        label.setFont(new Font("Verdana", Font.PLAIN, 30));

        JLabel emailLabel = new JLabel("Enter your email: ");
        emailLabel.setBounds(50, 80, 200, 21);
        emailLabel.setFont(new Font("Verdana", Font.PLAIN, 16));

        JTextField emailText = new JTextField(30);
        emailText.setFont(new Font("Verdana", Font.PLAIN, 16));
        emailText.setBounds(210, 80, 250, 25);

        JLabel passwordLabel = new JLabel("Enter your password: ");
        passwordLabel.setBounds(50, 120, 200, 21);
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 16));

        JPasswordField passwordField = new JPasswordField(30);
        passwordField.setFont(new Font("Verdana", Font.PLAIN, 16));
        passwordField.setBounds(240, 120, 250, 25);


        if (!isLogin) {
            JLabel confirmPasswordLabel = new JLabel("Confirm your password: ");
            confirmPasswordLabel.setBounds(50, 160, 200, 21);
            confirmPasswordLabel.setFont(new Font("Verdana", Font.PLAIN, 16));

            JPasswordField confirmPasswordField = new JPasswordField(30);
            confirmPasswordField.setBounds(250, 160, 250, 25);
            passwordField.setFont(new Font("Verdana", Font.PLAIN, 16));
            panel.add(confirmPasswordLabel);
            panel.add(confirmPasswordField);
        }

        JButton authButton = new JButton();
        authButton.setBounds(180, 220, 150, 50);
        authButton.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        authButton.setText(text);

        panel.add(label);
        panel.add(emailLabel);
        panel.add(passwordLabel);
        panel.add(authButton);

        panel.add(emailText);
        panel.add(passwordField);

        auth.add(panel);
        auth.setSize(530, 380);
        auth.setLocationRelativeTo(null);
        auth.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        auth.setVisible(true);
    }

    public void showErrorMessage() {

    }
}
