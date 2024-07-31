package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataModels.User;

public class UserDAO extends GenericDAO<User> {

    @Override
    protected User mapResultSetToEntity(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        return user;
    }

    public User getUserById(int id) {
        String query = "SELECT * FROM user WHERE id = " + id;
        return executeQuery(query).stream().findFirst().orElse(null);
    }
}
