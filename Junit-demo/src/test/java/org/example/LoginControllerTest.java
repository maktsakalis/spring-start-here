package org.example;

import org.example.service.AuthenticationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

    private LoginController loginController;
    private AuthenticationService authenticationService;

    @Before
    public void setup() {
        authenticationService = mock(AuthenticationService.class);
        loginController = new LoginController(authenticationService);
    }

    @Test
    public void testService() {
        //arrange
        when(authenticationService.authenticate(anyString(), anyString())).thenReturn(true);

        //act
        String result = loginController.service("makis", "pass");

        //assert
        Assert.assertNotNull(result);
        Assert.assertEquals("home", result);
    }
}