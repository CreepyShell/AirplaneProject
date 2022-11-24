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
        label.setBounds(80, 20, 400, 21);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        ArrayList<String> ticketsStr = new ArrayList<>();
        for (Ticket t : this.ticketService.getTicketsByUserId(this.currentUser.getId())) {
            ticketsStr.add(t.getId() + "--" + t.getDateBought() + "--" + t.getRoute().getTakeOffLocation().getCity()
                    + "--" + t.getRoute().getLandingLocation().getCity());
        }

        JComboBox cb = new JComboBox(ticketsStr.toArray());
        cb.setBounds(50, 60, 400, 30);

        JButton cancelTicket = new JButton();
        cancelTicket.setBounds(60, 100, 180, 30);
        cancelTicket.setFont(new Font("Times new Roman", Font.PLAIN, 15));
        cancelTicket.setText("Cancel chosen ticket");

        JButton rescheduleTicket = new JButton();
        rescheduleTicket.setBounds(250, 100, 200, 30);
        rescheduleTicket.setFont(new Font("Times new Roman", Font.PLAIN, 15));
        rescheduleTicket.setText("Reschedule chosen ticket");

        JButton buyTicket = new JButton();
        buyTicket.setBounds(100, 160, 280, 50);
        buyTicket.setFont(new Font("Times new Roman", Font.PLAIN, 19));
        buyTicket.setText("You can buy ticket here");

        JButton manageRoute = new JButton();
        manageRoute.setBounds(100, 230, 280, 50);
        manageRoute.setFont(new Font("Times new Roman", Font.PLAIN, 19));
        manageRoute.setText("Manage routes(only for admin)");

        JButton logOutButton = new JButton();
        logOutButton.setBounds(80, 300, 120, 28);
        logOutButton.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        logOutButton.setText("LogOut");

        JButton exitButton = new JButton();
        exitButton.setBounds(240, 300, 100, 28);
        exitButton.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        exitButton.setText("Exit");

        panel.add(label);
        panel.add(buyTicket);
        panel.add(manageRoute);
        panel.add(cancelTicket);
        panel.add(rescheduleTicket);
        panel.add(exitButton);
        panel.add(logOutButton);

        this.add(cb);
        this.add(panel);
        this.setSize(530, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
