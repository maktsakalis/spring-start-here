package org.example.service;

import org.example.User;
import org.example.repository.UserRepository;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserLookupServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserLookupService userLookupService;

    @Test
    public void getRegularUsers() {
        List<User> userList = new LinkedList<>();
        userList.add(User.createRegularUser("makis", "pass"));
        userList.add(User.createRegularUser("kostas", "pass1"));
        userList.add(User.createAdminUser("dimitris", "pass2"));

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        Set<User> regularUsers = userLookupService.getRegularUsers();

        Assert.assertNotNull(regularUsers);
        Assert.assertEquals(regularUsers.size(), 2);
        Assert.assertEquals(regularUsers, userList.stream().filter(u -> u.getUserType().equals(User.UserType.REGULAR_USER)).collect(Collectors.toSet()));

        Assert.assertThat(regularUsers, IsIterableContainingInAnyOrder.containsInAnyOrder(
                allOf(hasProperty("username", equalTo("makis")), hasProperty("password", equalTo("pass"))),
                equalTo(User.createRegularUser("kostas", "pass1"))
        ));
    }

    @Test
    public void getAdminUsers() {
    }
}