package DAL.Interfaces;

import DAL.Models.User;

public interface IUserRepository {
    User getUser(String email);
    void saveUser(User user);
}
