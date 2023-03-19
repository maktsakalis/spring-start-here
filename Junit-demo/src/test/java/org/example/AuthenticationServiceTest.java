package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    private AuthenticationService authenticationService;

    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = mock(UserRepository.class);
        authenticationService = new AuthenticationService(userRepository);
    }

    @Test
    public void testAuthenticate() {
        when(userRepository.findByUsername(Mockito.anyString())).thenThrow(new IllegalArgumentException());
//                .thenReturn(new User("makis", "pass"));

        boolean result = authenticationService.authenticate("makis", "pass");

        Assert.assertTrue(result);
    }
}