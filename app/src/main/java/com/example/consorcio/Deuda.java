package com.example.consorcio;

import java.util.Objects;

public class Deuda {
    private long id;
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

    public Deuda(int dni, double valor, String detalle, String fecha) {
        this.dni = dni;
        this.valor=valor;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deuda deuda = (Deuda) o;
        return id == deuda.id && Double.compare(deuda.valor, valor) == 0 && dni == deuda.dni && Objects.equals(detalle, deuda.detalle) && Objects.equals(fecha, deuda.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, detalle, valor, dni, fecha);
    }
}
