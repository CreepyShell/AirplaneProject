package Windows;

import Interfaces.ILocationService;
import Interfaces.IRouteService;
import Interfaces.ITicketService;
import Models.Location;
import Models.Route;
import Models.Ticket;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicketsWindow extends JFrame {
    private final ITicketService ticketService;
    private final IRouteService routeService;
    private final ILocationService locationService;
    private final User currentUser;

    public TicketsWindow(ITicketService ticketService, IRouteService routeService, ILocationService locationService, User user) {
        this.routeService = routeService;
        this.ticketService = ticketService;
        this.currentUser = user;
        this.locationService = locationService;
        this.setTitle("Buy ticket");
        JPanel panel = new JPanel();
        this.setResizable(false);
        panel.setLayout(null);

        JLabel label = new JLabel("Welcome to the funny airlines!");
        label.setBounds(80, 20, 400, 21);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel startLabel = new JLabel("Enter take off city");
        startLabel.setBounds(20, 50, 400, 24);
        startLabel.setFont(new Font("Verdana", Font.ITALIC, 18));

        JTextField startCityField = new JTextField(30);
        startCityField.setFont(new Font("Verdana", Font.PLAIN, 20));
        startCityField.setBounds(220, 50, 250, 25);

        JLabel endLabel = new JLabel("Enter landing city");
        endLabel.setBounds(20, 80, 400, 24);
        endLabel.setFont(new Font("Verdana", Font.ITALIC, 18));

        JTextField endCityField = new JTextField(30);
        endCityField.setFont(new Font("Verdana", Font.PLAIN, 20));
        endCityField.setBounds(220, 80, 250, 25);

        JButton findRoutesButton = new JButton();
        findRoutesButton.setBounds(60, 120, 180, 30);
        findRoutesButton.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        findRoutesButton.setText("Find routes");

        JButton backButton = new JButton("Back");
        backButton.setBounds(240, 300, 100, 28);
        backButton.setFont(new Font("Times new Roman", Font.PLAIN, 25));

        panel.add(label);
        panel.add(startLabel);
        panel.add(startCityField);
        panel.add(endLabel);
        panel.add(endCityField);
        panel.add(findRoutesButton);
        panel.add(backButton);
        showAvailableRoutes(this.locationService.findLocationByCity(startCityField.getText()), this.locationService.findLocationByCity(endCityField.getText()));

        this.add(panel);
        this.setSize(530, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void showAvailableRoutes(Location start, Location end) {
        ArrayList<String> routesStr = new ArrayList<>();
        for (Route r : this.routeService.findRoutesByLocation(start, end)) {
            routesStr.add(r.getId() + "--" + r.getTakeOffLocation() + "--");
        }

        JComboBox cb = new JComboBox(routesStr.toArray());
        cb.setBounds(50, 180, 400, 30);

        JButton buyTicket = new JButton();
        buyTicket.setBounds(130, 220, 180, 35);
        buyTicket.setFont(new Font("Times new Roman", Font.PLAIN, 23));
        buyTicket.setText("Buy ticket");
        this.add(cb);
        this.add(buyTicket);
    }
}
