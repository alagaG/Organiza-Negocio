/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.model;

/**
 *
 * @author 82323467
 */
public class PeopleModel {
        
    private int id;
    private int userId;
    private String name;
    private Role role;
    private String description;
    
    public enum Role {
        CLIENT,
        EMPLOYEE
    }

    public PeopleModel(int id, int userId, String name, Role role, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.description = description;
    }

    public int getID() {
        return this.id;
    }
    
    public int getUserID() {
        return this.userId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Role getRole() {
        return this.role;
    }
    
    public String getDescription() {
        return this.description;
    }
    
}