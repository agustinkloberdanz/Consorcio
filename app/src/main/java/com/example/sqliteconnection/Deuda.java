package com.example.sqliteconnection;

public class Deuda {
    private String detalle;
    private double valor;

    @Override
    public String toString() {
        return "Deuda{" +
                "detalle='" + detalle + '\'' +
                ", valor=" + valor +
                '}';
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
}
