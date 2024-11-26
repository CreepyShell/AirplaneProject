package BLL.Services.AuthDecorator;

import BLL.Services.AuthenticationService;
import DAL.Interfaces.IUserRepository;
import DAL.Models.User;

public abstract class Decorator extends AuthenticationService {
    protected AuthenticationService authService;

    public Decorator(IUserRepository repository) {
        super(repository);
    }

    public void setAuthService(AuthenticationService service) {
        this.authService = service;
    }

    @Override
    public User login(String password, String email) {
        if (authService != null) {
            return authService.login(password, email);
        }
        return null;
    }

    @Override
    public User register(User user) {
        if (authService != null) {
            return authService.register(user);
        }
        return null;
    }
}
