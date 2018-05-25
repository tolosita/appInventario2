/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.dao;

import com.example.appInventario.model.Movimiento;
import java.util.List;

/**
 *
 * @author sala305
 */
public interface IMovimientoDao {

    public List<Movimiento> obtenerMovimientos();

    public Movimiento obtenerMovimiento(String codigo);

    public String crearMovimiento(Movimiento movimiento);

    public String modificarMovimiento(Movimiento movimiento);

    public String eliminarMovimiento(String codigo);
}
