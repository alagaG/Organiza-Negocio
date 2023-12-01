/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3;

import java.sql.*;

/**
 *
 * @author 82323467
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3306/organiza_negocio";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "anima123";
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
