package com.springstarthere.loginch9.controllers;

import com.springstarthere.loginch9.model.LoginProcessor;
import com.springstarthere.loginch9.model.LoginRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    void loginPostSuccessTest() {

        given(loginProcessor.login()).willReturn(true);
        String result = loginController.loginPost(new LoginRequest("Makis", "123"), model);

        assertEquals("redirect:/main", result);
    }
}