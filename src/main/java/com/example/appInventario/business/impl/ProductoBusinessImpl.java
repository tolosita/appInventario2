/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.business.impl;

import com.example.appInventario.business.IProductoBusiness;
import com.example.appInventario.dao.IProductoDao;
import com.example.appInventario.data.ProductoData;
import com.example.appInventario.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sala305
 */
@Service
public class ProductoBusinessImpl implements IProductoBusiness {

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> obtenerProductos() {
        return productoDao.obtenerProductos();
    }

    @Override
    public String crearProducto(Producto producto) {
        String respuesta = "Producto Ya Registrado";
        List<Producto> listado = ProductoData.getListado();
        if (!listado.contains(producto)) {
            respuesta = productoDao.crearProducto(producto);
        }
        return respuesta;
    }

    @Override
    public String modificarProducto(Producto producto) {
        String respuesta = "Producto No existente";
        List<Producto> listado = ProductoData.getListado();
        if (listado.contains(producto)) {
            respuesta = productoDao.modificarProducto(producto);
        }
        return respuesta;
    }

    @Override
    public String valorDelInventario() {
        String respuesta = "El valor del inventario es ";
        
        return respuesta;
    }

}
