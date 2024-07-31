package runScriptsUsingMainMethod;

import dao.UserDAO;
import dataModels.User;

public class Main {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(1);
        System.out.println(user);
    }
}
