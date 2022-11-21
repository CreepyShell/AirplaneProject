package Services;

import Interfaces.IAuthenticationService;
import Models.PlaneDb;
import Models.User;

import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService {
    private final PlaneDb db;

    public AuthenticationService(PlaneDb db) {
        this.db = db;
    }

    @Override
    public User login(String password, String email) {
        User user = db.getUsers().stream().filter(u -> u.getEmail() == email).findAny().orElse(null);
        if (user == null)
            throw new IllegalArgumentException("did not find user with given email");
        if (!isValidPassword(password, user.getSalt(), user.getPasswordHash())) {
            throw new InvalidParameterException("password is not correct");
        }
        return user;
    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            return new String(md.digest(password.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException ex) {
            return salt;
        }
    }

    @Override
    public boolean isValidPassword(String password, String salt, String hash) {
        return Objects.equals(hashPassword(password, salt), hash);
    }
}
