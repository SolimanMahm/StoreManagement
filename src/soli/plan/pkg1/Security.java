/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Soliman Mahmoud
 * @Phone 01028721772
 */
public class Security {
    /*private final String user = "root";
    private final String password = "root";
    private  final String url = "jdbc:mysql://localhost:3300/soli_plan_1";*/
    
    private static final String url = "jdbc:sqlite:soli_plan_1.db";
    
    public Connection coneect () throws SQLException{
         return DriverManager.getConnection(url);
    }
}
