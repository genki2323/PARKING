/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.modelos;

import java.time.LocalDate;

/**
 *
 * @author JULIOCESARMARTINEZ
 */
public class Vehiculo {
    private int id;
    private Usuario alumno;
    private LocalDate fecha;
    private boolean asiste;

    public Vehiculo() {
    }
    
    public Vehiculo(int id, Usuario alumno, LocalDate fecha, boolean asiste) {
        this.id = id;
        this.alumno = alumno;
        this.fecha = fecha;
        this.asiste = asiste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isAsiste() {
        return asiste;
    }

    public void setAsiste(boolean asiste) {
        this.asiste = asiste;
    }
    
    
}
