package BLL.Services.AuthDecorator;

import DAL.Interfaces.IUserRepository;
import DAL.Models.User;

public class LogDecorator extends Decorator{

    @Override
    public User login(String password, String email) {
        User user = super.authService.login(password, email);
        System.out.println("User with email " + email + " was log in into the system");
        return user;
    }

    @Override
    public User register(User user) {
        User newUser = super.authService.register(user);
        System.out.println("User with email " + newUser.getEmail() + " was registered in into the system");
        return newUser;
    }

    @Override
    public String hashPassword(String password, String salt) {
        return super.authService.hashPassword(password, salt);
    }

    @Override
    public boolean isValidPassword(String password, String salt, String hash) {
        return super.authService.isValidPassword(password, salt, hash);
    }
}
