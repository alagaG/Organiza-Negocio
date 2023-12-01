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
    private int costumerId;
    private int employeeId;
    private String title;
    private String description;
    private DateTime date;

    public ScheduleModel(int id, int userId, int clientId, int employeeId, String title, String description, DateTime date) {
        this.id = id;
        this.userId = userId;
        this.costumerId = clientId;
        this.employeeId = employeeId;
        this.title = title;
        this.description = description;
        this.date = date;
    }
    
    public ScheduleModel(int id, int userId, int clientId, int employeeId, String title, String description, String date) {
        this(id, userId, clientId, employeeId, title, description, new DateTime(date));
    }

    public int getID() {
        return this.id;
    }
    
    public int getUserID() {
        return this.userId;
    }
    
    public int getCostumerID() {
        return this.costumerId;
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