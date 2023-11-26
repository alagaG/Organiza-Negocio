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

/**
 *
 * @author 82323467
 */
public class NoteController extends AbstractController<NoteModel> {

    @Override
    public void create(NoteModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "INSERT INTO notes(user_id, client_id, name, content) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            if (data.getClientID() < 1) {
                statement.setNull(2, Types.INTEGER);
            } else {
                statement.setInt(2, data.getClientID());
            }
            statement.setString(3, data.getTitle());
            statement.setString(4, data.getContent());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public NoteModel read(int id) {
        return null;
    }
    
    @Override
    public NoteModel[] readAll() {
        Connection connection = ConnectionFactory.getConnection();
        String query = "SELECT * FROM notes;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            ArrayList<NoteModel> list = new ArrayList<>();
            while (queryResult.next()) {
                list.add(new NoteModel(
                    queryResult.getInt("id"), 
                    queryResult.getInt("user_id"), 
                    queryResult.getInt("client_id"), 
                    queryResult.getString("name"), 
                    queryResult.getString("content")
                ));
            }
            return list.toArray(new NoteModel[list.size()]);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(NoteModel lastData, NoteModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE notes SET client_id = ?, name = ?, content = ? WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            if (newData.getClientID() > 0) {
                statement.setInt(1, newData.getClientID());
            } else {
                statement.setNull(1, Types.INTEGER);
            }
            statement.setString(2, newData.getTitle());
            statement.setString(3, newData.getContent());
            statement.setInt(4, lastData.getID());
            statement.setInt(5, lastData.getUserID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(NoteModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "DELETE FROM notes WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getID());
            statement.setInt(2, data.getUserID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAll(NoteModel data) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "DELETE FROM notes WHERE user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
