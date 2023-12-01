/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.controller;

import projeto.a3.model.AbstractController;

import java.sql.*;
import java.util.ArrayList;
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
        String query = "INSERT INTO agendamento (id_usuario, id_cliente, id_funcionario, titulo, descricao, data) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            if (data.getCostumerID() > 0){
                statement.setInt(2, data.getCostumerID());
            } else {
                statement.setNull(2, Types.INTEGER);
            }
            if (data.getEmployeeID() > 0){
                statement.setInt(3, data.getEmployeeID());
            } else {
                statement.setNull(3, Types.INTEGER);
            }
            statement.setString(4, data.getTitle());
            statement.setString(5, data.getDescription());
            statement.setString(6, String.valueOf(data.getDateTime().toMySQL()));
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
        Connection connection = ConnectionFactory.getConnection();
        String query = "SELECT * FROM agendamento;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            ArrayList<ScheduleModel> list = new ArrayList<>();
            while (queryResult.next()) {
                list.add(new ScheduleModel(
                    queryResult.getInt("id"), 
                    queryResult.getInt("id_usuario"), 
                    queryResult.getInt("id_cliente"), 
                    queryResult.getInt("id_funcionario"), 
                    queryResult.getString("titulo"), 
                    queryResult.getString("descricao"), 
                    queryResult.getString("data")
                ));
            }
            return list.toArray(new ScheduleModel[list.size()]);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void update(ScheduleModel lastData, ScheduleModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE agendamento SET id_cliente = ?, id_funcionario = ?, titulo= ?, descricao = ?, data = ? WHERE id = ? AND id_usuario = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            if (newData.getCostumerID() > 0){
                statement.setInt(1, newData.getCostumerID());
            } else {
                statement.setNull(1, Types.INTEGER);
            }
            if (newData.getEmployeeID() > 0){
                statement.setInt(2, newData.getEmployeeID());
            } else {
                statement.setNull(2, Types.INTEGER);
            }
            statement.setString(3, newData.getTitle());
            statement.setString(4, newData.getDescription());
            statement.setString(5, String.valueOf(newData.getDateTime().toMySQL()));
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
        String query = "DELETE FROM agendamento WHERE id = ? AND id_usuario = ?;";
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
