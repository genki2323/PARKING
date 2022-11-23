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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JULIOCESARMARTINEZ
 */
public class GestionPagos {
    
    private Conexion conn;
    private PreparedStatement stm;
    
    public List<Vehiculo> obtenerTodos(LocalDate date, int now){
        conn = new Conexion();
        List<Vehiculo> resultado = new ArrayList<>();
        String sql = "SELECT a.id id, a.documento documento," +
                "a.nombre nombre, a.apellido apellido," +
                "s.asiste asiste " +
                "FROM alumnos a " +
                "LEFT JOIN asistencias s " +
                "ON a.id = s.alumno_id ";
       if(now > 0){
           sql += "WHERE s.fecha IS NULL OR s.fecha = ? " +
                "ORDER BY a.id";
       }else{
           sql += "WHERE s.fecha = ? " +
                "ORDER BY a.id";
       }
        String dateStr = date.toString();
        ResultSet rS;
        try{
            stm = conn.getCon().prepareStatement(sql);
            stm.setString(1, dateStr);
            rS = stm.executeQuery();
            while(rS.next()){
                Vehiculo asistencia = new Vehiculo();
                Usuario alumno = new Usuario();

                alumno.setId(rS.getInt("id"));
                alumno.setNombre(rS.getString("nombre"));
                alumno.setApellido(rS.getString("apellido"));
                alumno.setDocumento(rS.getString("documento"));
                
                asistencia.setAsiste(rS.getBoolean("asiste"));
                asistencia.setAlumno(alumno);
                
                resultado.add(asistencia);
            }
            conn.getCon().close();
        }catch (SQLException ex) {
            Mensajes.mensajeErr("Error SQL", ex.getMessage());
        }
        return resultado;
    }
    
    
    public int guardar(List<Vehiculo> asistencias){
       
        int resultado = 0;
        conn = new Conexion();
        String sql = "INSERT INTO asistencias" +
                      "(fecha,asiste,alumno_id) VALUES" +
                      " (now(), ?, ?)";
        
        try {
            asistencias.stream().forEach(a -> {
                try {
                    stm = conn.getCon().prepareStatement(sql);
                    stm.setBoolean(1, a.isAsiste());
                    stm.setInt(2, a.getAlumno().getId());
                    stm.executeUpdate();
                } catch (SQLException ex) {
                    Mensajes.mensajeErr("Error SQL", ex.getMessage());
                }
            });
            resultado = 1;
            conn.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeErr("Error SQL", ex.getMessage());
            resultado = 0;
        }
        return resultado;
    }
    
    public int cerrarDia(){
        int resultado = 0;
        conn = new Conexion();
        String sql = "INSERT INTO asistencias_cerradas "
                + "(fecha)"
                + "VALUES (now())";
        try {
            stm = conn.getCon().prepareStatement(sql);
            resultado = stm.executeUpdate();
            conn.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeErr("Error SQL", ex.getMessage());
        }
        return resultado;
    }
        
}
