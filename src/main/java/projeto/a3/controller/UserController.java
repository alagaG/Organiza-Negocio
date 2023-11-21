/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.controller;

import projeto.a3.model.AbstractController;

import java.sql.*;
import projeto.a3.ConnectionFactory;
import projeto.a3.model.UserModel;

/**
 *
 * @author 82323467
 */
public class UserController extends AbstractController<UserModel> {

    @Override
    public void create(UserModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "INSERT INTO users(name, password) VALUES (?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, data.getName());
            statement.setString(2, data.getPassword());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel read(UserModel data) {
        return null;
    }

    @Override
    public void update(UserModel lastData, UserModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE users SET name = ?, password = ? WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newData.getName());
            statement.setString(2, newData.getPassword());
            statement.setInt(3, lastData.getID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(UserModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "DELETE FROM users WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
