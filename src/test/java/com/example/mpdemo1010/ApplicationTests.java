package com.example.mpdemo1010;

import com.example.mpdemo1010.entity.User;
import com.example.mpdemo1010.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    //查询
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
