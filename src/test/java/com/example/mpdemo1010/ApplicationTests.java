package com.example.mpdemo1010;

import com.example.mpdemo1010.entity.User;
import com.example.mpdemo1010.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    //查询user表中的所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void addUser(){
        User user = new User();
        user.setName("刘畅");
        user.setAge(30);
        user.setEmail("lucy@qq.com");

        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        int insert = userMapper.insert(user);
        System.out.println("insert"+insert);
    }

    @Test
    public void updateUser(){
        User user = new User();

        user.setId(1637094465476804610L);
        user.setAge(120);


        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test
    public void testOptimsticLocker(){
        User user = userMapper.selectById(1637103591640530946L);
        user.setAge(200);
        userMapper.updateById(user);
    }
}
