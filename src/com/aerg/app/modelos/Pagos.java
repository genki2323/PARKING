/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerg.app.modelos;

/**
 *
 * @author JULIOCESARMARTINEZ
 */
public class Pagos {
    private int id;
    private String notas;
    private int periodo;
    private int anio;
    private Usuario alumno;

    public Pagos() {
    }

    public Pagos(int id, String notas, int periodo, int anio, Usuario alumno) {
        this.id = id;
        this.notas = notas;
        this.periodo = periodo;
        this.anio = anio;
        this.alumno = alumno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }
        
}
