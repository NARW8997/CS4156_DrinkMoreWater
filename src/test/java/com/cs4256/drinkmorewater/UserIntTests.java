package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.mapper.UserMapper;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIntTests {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testGet() {
        assertNotNull(userServiceImpl.list());
        assertNotNull(userServiceImpl.getById(1));
    }

    @Test
    public void testChange() {
        int retId;
        User userToAdd = new User(0, "Jason", "Nieh", "jn123@gmail.com", "15874678", TypeEnum.CUSTOMER);

        assertTrue(userServiceImpl.save(userToAdd));
        retId = userToAdd.getUserId();

        userToAdd.setFirstName("Another");
        assertTrue(userServiceImpl.updateById(userToAdd));

        assertTrue(userServiceImpl.removeById(retId));
        assertNull(userServiceImpl.getById(retId));
    }
}
