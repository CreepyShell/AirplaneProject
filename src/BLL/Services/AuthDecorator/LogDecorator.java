package BLL.Services.AuthDecorator;

import DAL.Interfaces.IUserRepository;
import DAL.Models.User;

public class LogDecorator extends Decorator{
    public LogDecorator(IUserRepository repository) {
        super(repository);
    }

    @Override
    public User login(String password, String email) {
        User user = super.login(password, email);
        System.out.println("User with email " + email + " was log in into the system");
        return user;
    }

    @Override
    public User register(User user) {
        User newUser = super.register(user);
        System.out.println("User with email " + newUser.getEmail() + " was registered in into the system");
        return newUser;
    }
}
