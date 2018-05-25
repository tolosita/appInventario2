/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.dao.impl;

import com.example.appInventario.dao.IMovimientoDao;
import com.example.appInventario.data.MovimientoData;
import com.example.appInventario.model.Movimiento;
import com.example.appInventario.model.Producto;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sala305
 */
@Repository
public class MovimientoDaoImpl implements IMovimientoDao {

    @Override
    public List<Movimiento> obtenerMovimientos() {
        return MovimientoData.getListado();
    }

    @Override
    public Movimiento obtenerMovimiento(String codigo) {
        Movimiento movimiento = null;
        List<Movimiento> listado = MovimientoData.getListado();
        for (Movimiento est : listado) {
            if (est.getIdMovimiento().equals(codigo)) {
                movimiento = est;
            }
        }
        return movimiento;
    }

    @Override
    public String crearMovimiento(Movimiento movimiento) {
        String respuesta = "Movimiento Registrado";
        List<Movimiento> listado = MovimientoData.getListado();
        listado.add(movimiento);
        MovimientoData.setListado(listado);
        return respuesta;
    }

    @Override
    public String modificarMovimiento(Movimiento movimiento) {
        String respuesta = "Movimiento Actualizado";
        List<Movimiento> listado = MovimientoData.getListado();
        listado.set(listado.indexOf(movimiento), movimiento);
        MovimientoData.setListado(listado);
        return respuesta;
    }

    @Override
    public String eliminarMovimiento(String codigo) {
        String respuesta = "Movimiento Eliminado";
        List<Movimiento> listado = MovimientoData.getListado();
        Movimiento movimiento = new Movimiento(codigo, new Producto(), "", 0D, 0D);
        listado.remove(movimiento);
        MovimientoData.setListado(listado);
        return respuesta;
    }

}
