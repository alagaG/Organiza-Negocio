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
        String query = "INSERT INTO pessoa (id_usuario, nome, cpf, telefone, funcao) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            statement.setString(2, data.getName());
            statement.setString(3, data.getCPF());
            statement.setString(4, data.getPhone());
            statement.setString(5, data.getRole() == PeopleModel.Role.COSTUMER ? "Cliente" : "Funcionario");
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PeopleModel read(int id) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "SELECT * FROM pessoa WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet queryResult = statement.executeQuery();
            if (queryResult.next()) {
                return new PeopleModel(
                    queryResult.getInt("id"), 
                    queryResult.getInt("id_usuario"), 
                    queryResult.getString("nome"), 
                    queryResult.getString("cpf"), 
                    queryResult.getString("telefone"), 
                    queryResult.getString("funcao").equals("Cliente") ? PeopleModel.Role.COSTUMER : PeopleModel.Role.EMPLOYEE
                );
            } else {
                return null;
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public PeopleModel[] readAll() { 
        Connection connection = ConnectionFactory.getConnection();
        String query = "SELECT * FROM pessoa;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            ArrayList<PeopleModel> list = new ArrayList<>();
            while (queryResult.next()) {
                list.add(new PeopleModel(
                    queryResult.getInt("id"), 
                    queryResult.getInt("id_usuario"), 
                    queryResult.getString("nome"), 
                    queryResult.getString("cpf"), 
                    queryResult.getString("telefone"), 
                    queryResult.getString("funcao").equals("Cliente") ? PeopleModel.Role.COSTUMER : PeopleModel.Role.EMPLOYEE
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
        String query = "UPDATE pessoa SET nome = ?, cpf = ?, telefone = ? WHERE id = ? AND id_usuario = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newData.getName());
            statement.setObject(2, newData.getCPF());
            statement.setObject(3, newData.getPhone());
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
        String query = "DELETE FROM pessoa WHERE id = ? AND id_usuario = ?;";
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
