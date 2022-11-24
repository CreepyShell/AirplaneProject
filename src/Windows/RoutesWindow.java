package Windows;

import Interfaces.IRouteService;

import javax.swing.*;
import java.awt.*;

public class RoutesWindow extends JFrame {
    private final IRouteService routeService;

    public RoutesWindow(IRouteService routeService) {
        this.routeService = routeService;
        this.setTitle("Manage route");
        JPanel panel = new JPanel();
        this.setResizable(false);
        panel.setLayout(null);

        JLabel label = new JLabel("Add new route");
        label.setBounds(80, 20, 400, 21);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel startLabel = new JLabel("Enter take off city");
        startLabel.setBounds(20, 50, 400, 24);
        startLabel.setFont(new Font("Verdana", Font.ITALIC, 18));

        JTextField startCityField = new JTextField(30);
        startCityField.setFont(new Font("Verdana", Font.PLAIN, 20));
        startCityField.setBounds(220, 50, 250, 25);

        JLabel endLabel = new JLabel("Enter landing city");
        endLabel.setBounds(20, 80, 250, 24);
        endLabel.setFont(new Font("Verdana", Font.ITALIC, 18));

        JTextField endCityField = new JTextField(30);
        endCityField.setFont(new Font("Verdana", Font.PLAIN, 20));
        endCityField.setBounds(220, 80, 250, 25);

        Label startTimeLabel = new Label("Enter take off time");
        startTimeLabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        startTimeLabel.setBounds(20, 130, 200, 24);

        JTextField startTime = new JTextField();
        startTime.setBounds(250, 130, 250, 25);

        JLabel endTimeLabel = new JLabel("Enter landing time");
        endTimeLabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        endTimeLabel.setBounds(20, 160, 200, 24);

        JTextField endTime = new JTextField();
        endTime.setBounds(250, 160, 250, 25);

        JButton addRoute = new JButton();
        addRoute.setBounds(60, 250, 180, 30);
        addRoute.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        addRoute.setText("Add route");

        JButton backButton = new JButton("Back");
        backButton.setBounds(240, 650, 100, 28);
        backButton.setFont(new Font("Times new Roman", Font.PLAIN, 25));

        panel.add(label);
        panel.add(startLabel);
        panel.add(startCityField);
        panel.add(endLabel);
        panel.add(endCityField);
        panel.add(startTimeLabel);
        panel.add(startTime);
        panel.add(endTimeLabel);
        panel.add(endTime);
        panel.add(addRoute);
        panel.add(backButton);


        this.add(panel);
        this.setSize(530, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
