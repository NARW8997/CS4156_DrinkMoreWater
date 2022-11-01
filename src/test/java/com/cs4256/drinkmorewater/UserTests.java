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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        User retUser = new User(1, "John", "Doe", "jd123@gmail.com", "15874678", TypeEnum.CUSTOMER);

        Mockito.when(userMapper.selectById(testId)).thenReturn(retUser);

        assertEquals(userServiceImpl.getById(testId), retUser);
    }

    @Test
    public void testGetAll() {
        List<User> userList = Arrays.asList(
                new User(1, "John", "Doe", "jd123@gmail.com", "15874678", TypeEnum.CUSTOMER),
                new User(2, "Jane", "Nieh", "jn123@gmail.com", "15874630", TypeEnum.CUSTOMER));

        Mockito.when(userMapper.selectList(null)).thenReturn(userList);

        assertNotNull(userServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        User updateUser = new User(1, "Jason", "Nieh", "jn123@gmail.com", "15874678", TypeEnum.CUSTOMER);

        Mockito.when(userMapper.updateById(updateUser)).thenReturn(1);

        assertTrue(userServiceImpl.updateById(updateUser));
    }

    @Test
    public void testInvalidUpdate() {
        User updateUser = new User(-1, "Jason", "Nieh", "jn123@gmail.com", "15874678", TypeEnum.CUSTOMER);

        Mockito.when(userMapper.updateById(updateUser)).thenReturn(0);

        assertFalse(userServiceImpl.updateById(updateUser));
    }

    @Test
    public void testAddUser() {
        User userToAdd = new User(1, "Jason", "Nieh", "jn123@gmail.com", "15874678", TypeEnum.CUSTOMER);

        Mockito.when(userMapper.insert(userToAdd)).thenReturn(1);

        assertTrue(userServiceImpl.save(userToAdd));
    }

    @Test
    public void testRemoveUser() {
        int removeId = 1;

        Mockito.when(userMapper.deleteById(removeId)).thenReturn(1);

        assertTrue(userServiceImpl.removeById(removeId));
    }
}
