package com.example.sqliteconnection;

import androidx.annotation.Nullable;

public class Deuda { private int id;
    private String detalle;
    private double valor;
    private int dni;
    private String fecha;

    public Deuda(int id, int dni, double valor, String detalle, String fecha) {
        this.id = id;
        this.dni = dni;
        this.valor = valor;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public Deuda(Integer integer, int dni, double valor, String detalle, String fecha) {
        this.dni = dni;
        this.valor=valor;
        this.detalle = detalle;
        this.fecha = fecha;
    }

//    public Deuda(int dni, double valor, String detalle, String fecha) {
//        this.dni = dni;
//        this.valor = valor;
//        this.detalle = detalle;
//        this.fecha = fecha;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Deuda{" +
                "id=" + id +
                ", detalle='" + detalle + '\'' +
                ", valor=" + valor +
                ", dni=" + dni +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
