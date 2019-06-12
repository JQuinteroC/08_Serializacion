/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import java.io.Serializable;

/**
 *
 * @author Estudiantes
 */
public class Estudiante implements Serializable {

    private int cod;
    private String nombre;
    private int nota1;
    private int nota2;
    private int nota3;
    private double notaF;

    public Estudiante() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public double getNotaF() {
        return notaF;
    }

    public void setNotaF() {
        notaF = nota1 * 0.35 + nota2 * 0.35 + nota3 * 0.3;
    }

}
