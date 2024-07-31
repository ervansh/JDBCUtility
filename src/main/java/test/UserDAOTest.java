package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import dao.UserDAO;
import dataModels.User;

public class UserDAOTest {

    @Test(enabled=true)
    public void testGetUserById() {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals(1, user.getId());
        System.out.println(user);
    }
    
    @Test(enabled=true)
    public void testGetUserByName() {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(2);
        Assert.assertNotNull(user);
        Assert.assertEquals("vanshraj", user.getName());
        System.out.println(user);
    }
}
