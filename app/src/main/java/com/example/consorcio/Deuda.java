package com.example.consorcio;

import java.util.Objects;

public class Deuda {
    private double valor;
    private int dni;
    private String referencia;
    private String depto;
    private String detalle;
    private String fecha;

    public Deuda(int dni, double valor, String detalle, String fecha, String referencia, String depto) {
        this.dni = dni;
        this.valor = valor;
        this.detalle = detalle;
        this.fecha = fecha;
        this.referencia = referencia;
        this.depto = depto;
    }

    public String getDepto() {
        return depto;
    }

    public Deuda setDepto(String depto) {
        this.depto = depto;
        return this;
    }

    public String getReferencia() {
        return referencia;
    }

    public Deuda setReferencia(String referencia) {
        this.referencia = referencia;
        return this;
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
                "valor=" + valor +
                ", dni=" + dni +
                ", referencia='" + referencia + '\'' +
                ", depto='" + depto + '\'' +
                ", detalle='" + detalle + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deuda deuda = (Deuda) o;
        return Double.compare(deuda.valor, valor) == 0 && dni == deuda.dni && Objects.equals(referencia, deuda.referencia) && Objects.equals(depto, deuda.depto) && Objects.equals(detalle, deuda.detalle) && Objects.equals(fecha, deuda.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, dni, referencia, depto, detalle, fecha);
    }
}
