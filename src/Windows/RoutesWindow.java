package Windows;

import Interfaces.ILocationService;
import Interfaces.IRouteService;
import Models.Plane.Plane;
import Models.Route;
import Models.Ticket;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class RoutesWindow extends JFrame {
    private final IRouteService routeService;
    private final ILocationService locationService;
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public RoutesWindow(IRouteService routeService, ILocationService locationService) {
        this.locationService = locationService;
        this.routeService = routeService;
        this.setTitle("Manage route");
        JPanel panel = new JPanel();
        this.setResizable(false);
        panel.setLayout(null);

        JLabel label = new JLabel("Add new route");
        label.setBounds(80, 20, 400, 21);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        JButton backButton = new JButton("Back");
        backButton.setBounds(500, 10, 100, 28);
        backButton.setFont(new Font("Times new Roman", Font.PLAIN, 25));

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

        JLabel priceLabel = new JLabel("Enter price");
        priceLabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        priceLabel.setBounds(20, 190, 200, 24);

        JTextField priceField = new JTextField();
        priceField.setBounds(250, 190, 250, 25);

        ArrayList<String> planeStr = new ArrayList<>();
        for (Plane p : this.routeService.getAllPlanes()) {
            planeStr.add("Name: " + p.getName() + ", Amount of seats: " + p.getMaxAmountOfSeats() + ", Speed: " + p.getSpeed() + " meters per second");
        }

        JComboBox planeComboBox = new JComboBox(planeStr.toArray());
        planeComboBox.setBounds(30, 230, 450, 30);

        JButton addRoute = new JButton();
        addRoute.setBounds(60, 270, 180, 30);
        addRoute.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        addRoute.setText("Add route");

        JLabel choseRouteLabel = new JLabel("Choose route to delete or update");
        choseRouteLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        choseRouteLabel.setBounds(20, 320, 400, 24);

        ArrayList<String> routeStr = new ArrayList<>();
        for (Route r : this.routeService.getAllRoutes()) {
            routeStr.add(r.toString());
        }

        JComboBox routeComboBox = new JComboBox(routeStr.toArray());
        routeComboBox.setBounds(20, 350, 600, 30);

        Label updateStartTimeLabel = new Label("Update take off time");
        updateStartTimeLabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        updateStartTimeLabel.setBounds(20, 390, 200, 24);

        Route route = this.getRouteByString(Objects.requireNonNull(routeComboBox.getSelectedItem()).toString());
        JTextField updateStartTime = new JTextField(format.format(route.getTakeOffTime()));
        updateStartTime.setBounds(250, 390, 250, 25);

        JLabel updatePriceLabel = new JLabel("Update price");
        updatePriceLabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        updatePriceLabel.setBounds(20, 420, 200, 24);

        JTextField updatePriceField = new JTextField(String.valueOf(route.getCost()));
        updatePriceField.setBounds(250, 420, 150, 25);

        JLabel updatePlaneLabel = new JLabel("Update plane");
        updatePlaneLabel.setFont(new Font("Verdana", Font.ITALIC, 18));
        updatePlaneLabel.setBounds(20, 450, 200, 24);

        ArrayList<String> planeNameStr = new ArrayList<>();
        for (Plane p : this.routeService.getAllPlanes()) {
            planeNameStr.add(p.getName());
        }

        JComboBox planeNameComboBox = new JComboBox(planeNameStr.toArray());
        planeNameComboBox.setBounds(250, 450, 150, 30);

        JButton updateRoute = new JButton("Update route");
        updateRoute.setBounds(60, 500, 150, 30);
        updateRoute.setFont(new Font("Times new Roman", Font.PLAIN, 20));

        JButton deleteRoute = new JButton("Remove route");
        deleteRoute.setBounds(260, 500, 180, 30);
        deleteRoute.setFont(new Font("Times new Roman", Font.PLAIN, 20));

        panel.add(label);
        panel.add(startLabel);
        panel.add(startCityField);
        panel.add(endLabel);
        panel.add(endCityField);
        panel.add(startTimeLabel);
        panel.add(startTime);
        panel.add(endTimeLabel);
        panel.add(endTime);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(planeComboBox);
        panel.add(addRoute);
        panel.add(choseRouteLabel);
        panel.add(backButton);
        panel.add(routeComboBox);
        panel.add(updateStartTimeLabel);
        panel.add(updateStartTime);
        panel.add(updatePriceLabel);
        panel.add(updatePriceField);
        panel.add(updatePlaneLabel);
        panel.add(planeNameComboBox);
        panel.add(updateRoute);
        panel.add(deleteRoute);

        this.add(panel);
        this.setSize(650, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private Route getRouteByString(String str) {
        try {
            String dateStr = str.split(", ")[0].split("=")[1];
            String location1 = str.split(", ")[1].split(":")[1];
            String location2 = str.split(", ")[2].split(":")[1];
            Date date = format.parse(dateStr);
            return this.routeService.findRoutesByLocation
                            (this.locationService.findLocationByCity(location1), this.locationService.findLocationByCity(location2))
                    .stream().filter(r -> r.getTakeOffTime().equals(date)).findAny().orElse(null);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "The date format is incorrect. Ir must be dd/MM/yyyy HH:mm:ss");
            return new Route();
        }
    }
}
