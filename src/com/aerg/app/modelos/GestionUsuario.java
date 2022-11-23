/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.modelos;

import com.aerg.app.utilidades.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestionUsuario {
    
    private Conexion conn;
    private PreparedStatement stm;
    
    public List<Usuario> obtenerTodos(){
        conn = new Conexion();
        List<Usuario> resultado = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        ResultSet rS;
        try{
            stm = conn.getCon().prepareStatement(sql);
            rS = stm.executeQuery();
            while(rS.next()){
                Usuario alumno = new Usuario();
                alumno.setId(rS.getInt("id"));
                alumno.setNombre(rS.getString("nombre"));
                alumno.setApellido(rS.getString("apellido"));
                alumno.setDocumento(rS.getString("documento"));
                resultado.add(alumno);
            }
            conn.getCon().close();
        }catch (SQLException ex) {
            Mensajes.mensajeErr("Error SQL", ex.getMessage());
        }
        return resultado;
    } 
    
    public int guardar(Usuario alumno){
        int resultado = 0;
        conn = new Conexion();
        
        String sql = "INSERT INTO alumnos "
                + "(nombre, apellido, documento)"
                + "VALUES (?, ?, ?)";
        
        try {
            stm = conn.getCon().prepareStatement(sql);
            stm.setString(1, alumno.getNombre());
            stm.setString(2, alumno.getApellido());
            stm.setString(3, alumno.getDocumento());
            resultado = stm.executeUpdate();
            conn.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeErr("Error SQL", ex.getMessage());
        }
        return resultado;
    }
    
    
    public boolean borrarPorId(int id){
        boolean resultado = false;
        conn = new Conexion();
        String sql = "DELETE FROM alumnos WHERE id=?";
        try {
            stm = conn.getCon().prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            conn.getCon().close();
            resultado = true;
        } catch (SQLException ex) {
            Mensajes.mensajeErr("Error:", ex.getMessage());
        }
        return resultado;
    }
}
