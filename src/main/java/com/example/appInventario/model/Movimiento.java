/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.model;

import java.util.Objects;

/**
 *
 * @author sala305
 */
public class Movimiento {

    private String idMovimiento;
    private Producto producto;
    private String tipoMovimiento;
    private Double cantidad;
    private Double precio;

    public Movimiento() {
    }

    public Movimiento(String idMovimiento, Producto producto, String tipoMovimiento, Double cantidad, Double precio) {
        this.idMovimiento = idMovimiento;
        this.producto = producto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idMovimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimiento other = (Movimiento) obj;
        if (!Objects.equals(this.idMovimiento, other.idMovimiento)) {
            return false;
        }
        return true;
    }

}
