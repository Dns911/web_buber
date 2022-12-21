package com.epam.webproject.buber.dao.impl;

import com.epam.webproject.buber.connection.ConnectionPool;
import com.epam.webproject.buber.dao.BaseDao;
import com.epam.webproject.buber.dao.UserDao;
import com.epam.webproject.buber.entity.User;
import org.intellij.lang.annotations.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements BaseDao<User>, UserDao {

    private static UserDaoImpl userDaoImplInstance;

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (userDaoImplInstance == null) {
            userDaoImplInstance = new UserDaoImpl();
        }
        return userDaoImplInstance;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
        boolean match = false;
        try (Statement statement = ConnectionPool.getInstance().getConnection().createStatement()){
            @Language("SQL")
            String sql = "SELECT password FROM users WHERE email = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            String passFromDb;
            if (resultSet.next()){
                passFromDb = resultSet.getString("password");
                match = password.equals(passFromDb);
            }

        } catch (SQLException e){
            e.getMessage();
        }
        return match;
    }
}
