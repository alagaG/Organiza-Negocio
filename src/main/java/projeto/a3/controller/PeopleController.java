/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.controller;

import projeto.a3.model.AbstractController;

import java.sql.*;
import projeto.a3.ConnectionFactory;
import projeto.a3.model.PeopleModel;

/**
 *
 * @author 82323467
 */
public class PeopleController extends AbstractController<PeopleModel> {

    @Override
    public void create(PeopleModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "INSERT INTO peoples(user_id, name, description, role) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            statement.setString(2, data.getName());
            statement.setString(3, data.getDescription());
            statement.setObject(4, data.getRole());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PeopleModel read(PeopleModel data) {
        return null;
    }

    @Override
    public void update(PeopleModel lastData, PeopleModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE peoples SET name = ?, role = ?, description = ? WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newData.getName());
            statement.setObject(2, newData.getRole());
            statement.setString(3, newData.getDescription());
            statement.setInt(4, lastData.getID());
            statement.setInt(5, lastData.getUserID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PeopleModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "DELETE FROM peoples WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getID());
            statement.setInt(2, data.getUserID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
