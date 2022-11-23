/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.utilidades;

import javax.swing.JOptionPane;

public interface Mensajes {
 
    public static void mostrarMensaje(String titulo, String mensaje, int tipo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
    }
    
    public static void mensajeInf(String titulo, String mensaje){
        mostrarMensaje(titulo, mensaje, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void mensajeErr(String titulo, String mensaje){
        mostrarMensaje(titulo, mensaje, JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean mensajeConf(String titulo, String mensaje){
        JOptionPane jP = new JOptionPane();
        return jP.showConfirmDialog(null, mensaje, titulo, jP.YES_NO_OPTION) == jP.YES_OPTION;
    }
}
