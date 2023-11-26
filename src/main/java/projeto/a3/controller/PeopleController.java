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
import projeto.a3.model.NoteModel;
import projeto.a3.model.PeopleModel;

/**
 *
 * @author 82323467
 */
public class PeopleController extends AbstractController<PeopleModel> {

    @Override
    public void create(PeopleModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "INSERT INTO peoples(user_id, name, cpf, telefone, description, role) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            statement.setString(2, data.getName());
            statement.setString(3, data.getCPF());
            statement.setString(4, data.getPhone());
            statement.setString(5, data.getDescription());
            statement.setString(6, data.getRole() == PeopleModel.Role.CLIENT ? "Client" : "Employee");
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PeopleModel read(int id) {
        String query = "SELECT * FROM peoples WHERE ";
        return null;
    }
    
    @Override
    public PeopleModel[] readAll() { 
        Connection connection = ConnectionFactory.getConnection();
        String query = "SELECT * FROM peoples;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            ArrayList<PeopleModel> list = new ArrayList<>();
            while (queryResult.next()) {
                list.add(new PeopleModel(
                    queryResult.getInt("id"), 
                    queryResult.getInt("user_id"), 
                    queryResult.getString("name"), 
                    queryResult.getString("cpf"), 
                    queryResult.getString("telefone"), 
                    queryResult.getString("role").equals("Client") ? PeopleModel.Role.CLIENT : PeopleModel.Role.EMPLOYEE, 
                    queryResult.getString("description")
                ));
            }
            return list.toArray(new PeopleModel[list.size()]);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(PeopleModel lastData, PeopleModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE peoples SET name = ?, cpf = ?, telefone = ?, description = ? WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newData.getName());
            statement.setObject(2, newData.getCPF());
            statement.setObject(3, newData.getPhone());
            statement.setString(4, newData.getDescription());
            statement.setInt(5, lastData.getID());
            statement.setInt(6, lastData.getUserID());
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
