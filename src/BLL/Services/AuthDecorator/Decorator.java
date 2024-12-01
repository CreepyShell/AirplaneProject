package BLL.Services.AuthDecorator;

import BLL.Interfaces.IAuthenticationService;
import DAL.Interfaces.IUserRepository;
import DAL.Models.User;

public abstract class Decorator implements IAuthenticationService {
    protected IAuthenticationService authService;
    public void setAuthService(IAuthenticationService service) {
        this.authService = service;
    }
}
