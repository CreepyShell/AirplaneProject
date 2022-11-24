package Windows;

import Interfaces.ITicketService;
import Models.Ticket;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu extends JFrame {
    private final ITicketService ticketService;
    private final User currentUser;

    public MainMenu(ITicketService ticketService, User user) {
        this.ticketService = ticketService;
        this.currentUser = user;
        this.setTitle("Main menu");
        JPanel panel = new JPanel();
        this.setResizable(false);
        panel.setLayout(null);

        JLabel label = new JLabel("Welcome to the funny airlines!");
        label.setBounds(30, 20, 400, 21);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        ArrayList<String> ticketsStr = new ArrayList<>();
        for (Ticket t : this.ticketService.getTicketsByUserId(this.currentUser.getId())) {
            ticketsStr.add(t.getId() + "--" + t.getDateBought() + "--" + t.getRoute().getTakeOffLocation().getCity()
                    + "--" + t.getRoute().getLandingLocation().getCity());
        }

        JComboBox cb = new JComboBox(ticketsStr.toArray());
        cb.setBounds(50, 50, 90, 20);


        JButton buyTicket = new JButton();
        buyTicket.setBounds(80, 100, 280, 50);
        buyTicket.setFont(new Font("Times new Roman", Font.PLAIN, 19));
        buyTicket.setText("You can buy ticket here");

        JButton manageRoute = new JButton();
        manageRoute.setBounds(80, 170, 280, 50);
        manageRoute.setFont(new Font("Times new Roman", Font.PLAIN, 19));
        manageRoute.setText("Manage routes(only for admin)");

        panel.add(label);
        panel.add(buyTicket);
        panel.add(manageRoute);

        this.add(cb);
        this.add(panel);
        this.setSize(530, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
