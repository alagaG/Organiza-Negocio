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
    private String cpf;
    private String phone;
    private Role role;
    
    public enum Role {
        COSTUMER,
        EMPLOYEE
    }

    public PeopleModel(int id, int userId, String name, String cpf, String phone, Role role) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.role = role;
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
    
    public String getCPF() {
        return this.cpf;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public Role getRole() {
        return this.role;
    }
    
}