import BLL.Services.AuthenticationService;
import DAL.Interfaces.IUserRepository;
import DAL.Models.User;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthTests {
    @Test
    public void LoginTest() {
        //mocking user repository, no need to connect or create database instance after
        //implementing repository pattern
        IUserRepository list = mock(IUserRepository.class);

        //setting up user
        User testUser = new User();
        String testEmail = "admin@gmail.com";
        testUser.setEmail(testEmail);

        //mocking finding user method
        when(list.getUser(testEmail)).thenReturn(testUser);

        AuthenticationService authenticationService = new AuthenticationService(list);
        testUser.setPassword(authenticationService.hashPassword("1234", testUser.getSalt()));

        assertEquals(authenticationService.login("1234", testEmail).getEmail(), testEmail);
    }
}
