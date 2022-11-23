/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.utilidades;

import com.aerg.app.vistas.FrameMain;
import com.aerg.app.vistas.InternalFrameConsultaAsistencia;
import com.aerg.app.vistas.InternalFrameConsultaCalificacion;
import com.aerg.app.vistas.InternalFrameRegistraAlumno;
import com.aerg.app.vistas.InternalFrameRegistraAsistencia;
import com.aerg.app.vistas.InternalFrameRegistraCalificacion;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class InternalFrame {
     
    public void llamarInternalFrame(JInternalFrame formNueva, JDesktopPane padre){
        padre.add(formNueva);
        formNueva.setLocation(padre.getWidth()/2 - formNueva.getWidth(),
                padre.getHeight() / 2 - formNueva.getHeight() / 2);
        formNueva.setVisible(true);
    }
    
    public void llamarFormConsultaAsistencia(){
        InternalFrameConsultaAsistencia form = new InternalFrameConsultaAsistencia();
        llamarInternalFrame(form, FrameMain.jDPFormPadre);
    }
    
    public void llamarFormConsultaCalificacion(){
        InternalFrameConsultaCalificacion form = new InternalFrameConsultaCalificacion();
        llamarInternalFrame(form, FrameMain.jDPFormPadre);
    }
    
    public void llamarFormRegistraAsistencia(){
        InternalFrameRegistraAsistencia form = new InternalFrameRegistraAsistencia();
        llamarInternalFrame(form, FrameMain.jDPFormPadre);
    }
        
    public void llamarFormRegistraCalificacion(){
        InternalFrameRegistraCalificacion form = new InternalFrameRegistraCalificacion();
        llamarInternalFrame(form, FrameMain.jDPFormPadre);
    }
    
    public void llamarFormRegistraAlumno(){
        InternalFrameRegistraAlumno form = new InternalFrameRegistraAlumno();
        llamarInternalFrame(form, FrameMain.jDPFormPadre);
    }
}
