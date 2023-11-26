/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.controller;

import projeto.a3.model.AbstractController;

import java.sql.*;
import java.util.List;
import projeto.a3.ConnectionFactory;
import projeto.a3.model.ScheduleModel;

/**
 *
 * @author 82323467
 */
public class ScheduleController extends AbstractController<ScheduleModel> {

    @Override
    public void create(ScheduleModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "INSERT INTO schedules(user_id, client_id, employee_id, title, description, date) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            statement.setInt(2, data.getClientID());
            statement.setInt(3, data.getEmployeeID());
            statement.setString(4, data.getTitle());
            statement.setString(5, data.getDescription());
            statement.setString(6, String.valueOf(data.getDateTime()));
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ScheduleModel read(int id) {
        return null;
    }

    @Override
    public ScheduleModel[] readAll() { 
        return null;
    }
    
    @Override
    public void update(ScheduleModel lastData, ScheduleModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE schedules SET client_id = ?, employee_id = ?, title = ?, description = ?, date = ? WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, newData.getClientID());
            statement.setInt(2, newData.getEmployeeID());
            statement.setString(3, newData.getTitle());
            statement.setString(4, newData.getDescription());
            statement.setString(5, String.valueOf(newData.getDateTime()));
            statement.setInt(6, lastData.getID());
            statement.setInt(7, lastData.getUserID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ScheduleModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "DELETE FROM schedules WHERE id = ? AND user_id = ?;";
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
