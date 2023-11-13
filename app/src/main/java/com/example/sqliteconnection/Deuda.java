package com.example.sqliteconnection;

public class Deuda {
    private String detalle;
    private double valor;
    private int dni;

    public Deuda(int dni, double valor, String detalle) {
        this.dni = dni;
        this.valor = valor;
        this.detalle = detalle;
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
                "detalle='" + detalle + '\'' +
                ", valor=" + valor +
                ", dni=" + dni +
                '}';
    }
}
