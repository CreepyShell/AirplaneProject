package DAL.Repositories;

import DAL.Interfaces.IUserRepository;
import DAL.Models.PlaneDb;
import DAL.Models.User;

import java.util.List;
import java.util.Objects;

public class UserRepository implements IUserRepository {
    private PlaneDb planeDb;
    public UserRepository(PlaneDb planeDb){
        this.planeDb = planeDb;
    }

    @Override
    public User getUser(String email) {
        return planeDb.getUsers().stream().filter(u -> Objects.equals(u.getEmail(), email)).findAny().orElse(null);
    }

    @Override
    public void saveUser(User user) {
        List<User> users = planeDb.getUsers();
        users.add(user);
        planeDb.setUsers(users);
    }
}
