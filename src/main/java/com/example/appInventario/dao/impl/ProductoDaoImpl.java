/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.dao.impl;

import com.example.appInventario.dao.IProductoDao;
import com.example.appInventario.data.ProductoData;
import com.example.appInventario.model.Producto;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sala305
 */
@Repository
public class ProductoDaoImpl implements IProductoDao {

    @Override
    public List<Producto> obtenerProductos() {
        return ProductoData.getListado();
    }

    @Override
    public Producto obtenerProducto(String codigo) {
        Producto producto = null;
        List<Producto> listado = ProductoData.getListado();
        for (Producto est : listado) {
            if (est.getIdProducto().equals(codigo)) {
                producto = est;
            }
        }
        return producto;
    }

    @Override
    public String crearProducto(Producto producto) {
        String respuesta = "Producto Registrado";
        List<Producto> listado = ProductoData.getListado();
        listado.add(producto);
        ProductoData.setListado(listado);
        return respuesta;
    }

    @Override
    public String modificarProducto(Producto producto) {
        String respuesta = "Producto Actualizado";
        List<Producto> listado = ProductoData.getListado();
        listado.set(listado.indexOf(producto), producto);
        ProductoData.setListado(listado);
        return respuesta;
    }

}
