/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.controller;

import projeto.a3.model.AbstractController;

import java.sql.*;
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
        String query = "INSERT INTO notes(user_id, client_id, title, content) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getUserID());
            statement.setInt(2, data.getClientID());
            statement.setString(3, data.getTitle());
            statement.setString(4, data.getContent());
            statement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public NoteModel read(NoteModel data) {
        return null;
    }

    @Override
    public void update(NoteModel lastData, NoteModel newData) {
        Connection connection = ConnectionFactory.getConnection();
        String query = "UPDATE notes SET client_id = ?, title = ?, content = ? WHERE id = ? AND user_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, newData.getClientID());
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
    
}
