package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.model.Avatar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvatarRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public List<Avatar> findAll() {

        List<Avatar> avatarList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT * FROM avatar;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                String path = resultSet.getString("name");
                Avatar newAvatar = new Avatar("", path);
                avatarList.add(newAvatar);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avatarList;
    }
}