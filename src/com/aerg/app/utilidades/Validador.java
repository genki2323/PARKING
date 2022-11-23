/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.utilidades;

import javax.swing.JTextField;

public interface Validador {
    
    public static boolean sonVacios(JTextField campos[]){
        boolean vacios = false;
        int i = 0;
        
        while(i < campos.length && !vacios){
            vacios = (campos[i].getText()).isEmpty();
            if(vacios){
                Mensajes.mensajeErr("WARNING", 
                        "El campo"+ campos[i].getName() + " no puede ser vacío");
            }   campos[i].grabFocus();
            i++;
        }
        
        return vacios;
    }
    
}
