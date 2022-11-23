/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    // atributos
    private Connection con;
    
    // métodos
    // constructor
    public Conexion(){
        String URL = "jdbc:mysql://localhost:3306/autosColombia?serverTimezone=America/Bogota";
        String USUARIO = "root";
        String PASSWORD = "";
        
        try{
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            con.createStatement(); 
        }catch(SQLException ex){
            System.out.println("Error: "+ ex.getMessage());
        } 
    }
    
    public Connection getCon(){
        return this.con;
    }
}
