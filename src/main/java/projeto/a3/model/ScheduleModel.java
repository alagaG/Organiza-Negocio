/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.model;

import projeto.a3.utils.DateTime;

/**
 *
 * @author 82323467
 */
public class ScheduleModel {
        
    private int id;
    private int userId;
    private int clientId;
    private int employeeId;
    private String title;
    private String description;
    private DateTime date;

    public ScheduleModel(int id, int userId, int clientId, int employeeId, String title, String description, String date) {
        this.id = id;
        this.userId = userId;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.title = title;
        this.description = description;
        this.date = new DateTime(date);
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
    
    public int getEmployeeID() {
        return this.employeeId;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public DateTime getDateTime() {
        return this.date;
    }
    
}