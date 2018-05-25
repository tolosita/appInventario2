/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.business;

import com.example.appInventario.model.Producto;
import java.util.List;

/**
 *
 * @author sala305
 */
public interface IProductoBusiness {

    public List<Producto> obtenerProductos();

    public String crearProducto(Producto producto);

    public String modificarProducto(Producto producto);

    public String valorDelInventario();
    
}
