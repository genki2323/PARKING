/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.controladores;

import com.aerg.app.modelos.Usuario;
import com.aerg.app.modelos.Vehiculo;
import com.aerg.app.modelos.GestionUsuario;
import com.aerg.app.modelos.GestionPagos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class VehiculoController {

    private GestionPagos gesAs;

    public VehiculoController() {
        gesAs = new GestionPagos();
    }

    public DefaultTableModel llenarTabla(LocalDate date, int now) {
        DefaultTableModel modelo = new DefaultTableModel(){
          @Override
          public boolean isCellEditable(int row, int column){
              if(now > 0){
                  return true;
              }
              return false;
          }
        }; 
        modelo.addColumn("Id");
        modelo.addColumn("Documento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Asiste");

        List<Vehiculo> asistencias = gesAs.obtenerTodos(date, now);
        String registros[] = new String[5];
        for (Vehiculo asis : asistencias) {
            registros[0] = String.valueOf(asis.getAlumno().getId());
            registros[1] = asis.getAlumno().getDocumento();
            registros[2] = asis.getAlumno().getNombre();
            registros[3] = asis.getAlumno().getApellido();
            registros[4] = String.valueOf(asis.isAsiste());
            modelo.addRow(registros);
            modelo.fireTableDataChanged();
        }
        return modelo;
    }
}
