/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.model;

/**
 *
 * @author 82323467
 */
public class UserModel {
        
    private int id;
    private String name;
    private String password;

    public UserModel(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
}