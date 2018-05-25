/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.business.impl;

import com.example.appInventario.business.IMovimientoBusiness;
import com.example.appInventario.dao.IMovimientoDao;
import com.example.appInventario.dao.IProductoDao;
import com.example.appInventario.data.MovimientoData;
import com.example.appInventario.model.Movimiento;
import com.example.appInventario.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sala305
 */
@Service
public class MovimientoBusinessImpl implements IMovimientoBusiness {

    @Autowired
    private IMovimientoDao movimientoDao;

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Movimiento> obtenerMovimientos() {
        return movimientoDao.obtenerMovimientos();
    }

    @Override
    public String crearMovimiento(Movimiento movimiento) {
        String respuesta = "Movimiento Ya Registrado";
        List<Movimiento> listado = MovimientoData.getListado();
        if (!listado.contains(movimiento)) {
            Producto producto = productoDao.obtenerProducto(movimiento.getProducto().getIdProducto());
            if (producto != null) {
                if (movimiento.getTipoMovimiento().equals("Entrada")) {
                    if (movimiento.getPrecio() > 0) {
                        producto.setExistencia(producto.getExistencia() + movimiento.getCantidad());
                        productoDao.modificarProducto(producto);
                        movimiento.setProducto(producto);
                        respuesta = movimientoDao.crearMovimiento(movimiento);
                    } else {
                        respuesta = "El precio del Producto debe ser mayor a 0";
                    }
                }
                if (movimiento.getTipoMovimiento().equals("Salida")) {
                    movimiento.setPrecio(0D);
                    if (movimiento.getCantidad() > 0) {
                        if (movimiento.getCantidad() < producto.getExistencia()) {
                            producto.setExistencia(producto.getExistencia() - movimiento.getCantidad());
                            productoDao.modificarProducto(producto);
                            movimiento.setProducto(producto);
                            respuesta = movimientoDao.crearMovimiento(movimiento);
                        } else {
                            respuesta = "La cantidad del Producto debe ser menor a la existencia en inventario";
                        }
                    } else {
                        respuesta = "La cantidad del Producto debe ser mayor a 0";
                    }
                }
            } else {
                respuesta = "Producto No Registrado";
            }
        }
        return respuesta;
    }

    @Override
    public String modificarMovimiento(Movimiento movimiento) {
        String respuesta = "Movimiento No existente";
        List<Movimiento> listado = MovimientoData.getListado();
        if (listado.contains(movimiento)) {
            Producto producto = productoDao.obtenerProducto(movimiento.getProducto().getIdProducto());
            Movimiento movimiento_old = movimientoDao.obtenerMovimiento(movimiento.getIdMovimiento());
            if (producto != null) {
                if (movimiento_old.getTipoMovimiento().equals("Entrada")) {
                    movimiento.setTipoMovimiento(movimiento_old.getTipoMovimiento());
                    if (movimiento.getPrecio() > 0) {
                        Double cant = ((producto.getExistencia() - movimiento_old.getCantidad()) + movimiento.getCantidad());
                        if (cant >= 0) {
                            producto.setExistencia(cant);
                            productoDao.modificarProducto(producto);
                            movimiento.setProducto(producto);
                            respuesta = movimientoDao.modificarMovimiento(movimiento);
                        } else {
                            respuesta = "La cantidad del Producto no debe dejar la existencia en inventario menor a 0";
                        }
                    } else {
                        respuesta = "El precio del Producto debe ser mayor a 0";
                    }
                }
                if (movimiento_old.getTipoMovimiento().equals("Salida")) {
                    movimiento.setTipoMovimiento(movimiento_old.getTipoMovimiento());
                    movimiento.setPrecio(0D);
                    if (movimiento.getCantidad() > 0) {
                        Double cant = ((producto.getExistencia() + movimiento_old.getCantidad()) - movimiento.getCantidad());
                        if (cant < producto.getExistencia()) {
                            producto.setExistencia(cant);
                            productoDao.modificarProducto(producto);
                            movimiento.setProducto(producto);
                            respuesta = movimientoDao.modificarMovimiento(movimiento);
                        } else {
                            respuesta = "La cantidad del Producto no debe dejar la existencia en inventario menor a 0";
                        }
                    } else {
                        respuesta = "La cantidad del Producto debe ser mayor a 0";
                    }
                }
            } else {
                respuesta = "Producto No Registrado";
            }
        }
        return respuesta;
    }

    @Override
    public String eliminarMovimiento(String codigo) {
        String respuesta = "Movimiento No existente";
        List<Movimiento> listado = MovimientoData.getListado();
        for (Movimiento movimiento : listado) {
            if (movimiento.getIdMovimiento().equals(codigo)) {
                Producto producto = movimiento.getProducto();
                if (movimiento.getTipoMovimiento().equals("Entrada")) {
                    Double cant = (producto.getExistencia() - movimiento.getCantidad());
                    if (cant >= 0) {
                        producto.setExistencia(cant);
                        productoDao.modificarProducto(producto);
                        movimiento.setProducto(producto);
                        respuesta = movimientoDao.eliminarMovimiento(codigo);
                    } else {
                        respuesta = "La cantidad del Producto no debe dejar la existencia en inventario menor a 0";
                    }
                }
                if (movimiento.getTipoMovimiento().equals("Salida")) {
                    producto.setExistencia(producto.getExistencia() + movimiento.getCantidad());
                    productoDao.modificarProducto(producto);
                    movimiento.setProducto(producto);
                    respuesta = movimientoDao.eliminarMovimiento(codigo);
                }
                break;
            }
        }
        return respuesta;
    }

}
