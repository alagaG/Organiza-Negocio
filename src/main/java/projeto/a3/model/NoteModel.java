/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.model;

/**
 *
 * @author 82323467
 */
public class NoteModel {
        
    private int id;
    private int userId;
    private int clientId;
    private String title;
    private String content;

    public NoteModel(int id, int userId, int clientId, String title, String content) {
        this.id = id;
        this.userId = userId;
        this.clientId = clientId;
        this.title = title;
        this.content = content;
    }

    public int getID() {
        return this.id;
    }
    
    public int getUserID() {
        return this.userId;
    }
    
    public int getClientID() {
        return this.clientId;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getContent() {
        return this.content;
    }
    
}