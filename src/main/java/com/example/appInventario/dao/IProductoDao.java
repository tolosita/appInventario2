/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.dao;

import com.example.appInventario.model.Producto;
import java.util.List;

/**
 *
 * @author sala305
 */
public interface IProductoDao {

    public List<Producto> obtenerProductos();

    public Producto obtenerProducto(String codigo);

    public String crearProducto(Producto producto);

    public String modificarProducto(Producto producto);


}
