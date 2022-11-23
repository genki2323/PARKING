/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.controladores;

import com.aerg.app.modelos.Usuario;
import com.aerg.app.modelos.GestionUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class UsuarioController {
    
    private Usuario al;
    private GestionUsuario gesAl;

    public UsuarioController() {
        gesAl = new GestionUsuario();
    }
    
    public DefaultTableModel llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel(){
          @Override
          public boolean isCellEditable(int row, int column){
              return false;
          }
        };
        modelo.addColumn("Id");
        modelo.addColumn("Documento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        
        List<Usuario> alumnos = gesAl.obtenerTodos();
        String registros[] = new String[4];
  
        for(Usuario alumno: alumnos){
            registros[0] = String.valueOf(alumno.getId());
            registros[1] = alumno.getDocumento();
            registros[2] = alumno.getNombre();
            registros[3] = alumno.getApellido();
            modelo.addRow(registros);
            modelo.fireTableDataChanged();
        }
        return modelo;
    }
    
    public int guardar(String nombre, String apellido, String documento){
        int resultado = 0;
        al = new Usuario();
               
        al.setNombre(nombre);
        al.setApellido(apellido);
        al.setDocumento(documento);
        
        resultado = gesAl.guardar(al);
        
        return resultado;
    }
    
   public boolean eliminar(int id){
        boolean resultado = false;
        resultado = gesAl.borrarPorId(id);
        return resultado;
    }
}
