package com.cs4256.drinkmorewater;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.cs4256.drinkmorewater.mapper.UserMapper;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private IUserService iUserService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        User retUser = new User(1, "John", "Doe", "jd123@gmail.com", "15874678", 1);

        Mockito.when(userMapper.selectById(testId)).thenReturn(retUser);

        assertEquals(iUserService.getById(testId).getUserId(), testId);
    }
}
