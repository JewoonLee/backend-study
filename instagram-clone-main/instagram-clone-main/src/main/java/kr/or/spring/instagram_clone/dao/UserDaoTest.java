package kr.or.spring.instagram_clone.dao;

import kr.or.spring.instagram_clone.config.ApplicationConfig; 
import kr.or.spring.instagram_clone.dto.User;
import kr.or.spring.instagram_clone.service.security.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class UserDaoTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao memberRoleDao;

    @Test
    public void configTest() throws Exception{
        // 아무 작업도 하지 않는다. 실행이 잘된다는 것은 Spring 설정이 잘 되어 있다는 것을 의미한다.
    }

    @Test
    public void connnectionTest() throws Exception{
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void getUser() throws Exception{
        User user = userDao.getUserByEmail("jewoonlee@naver.com");
        Assert.assertNotNull(user);
        Assert.assertEquals("이제운", user.getName());
    }
}