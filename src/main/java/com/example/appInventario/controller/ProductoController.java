/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.controller;

import com.example.appInventario.business.IProductoBusiness;
import com.example.appInventario.model.Producto;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sala305
 */
@RestController
@RequestMapping(value = "/")
public class ProductoController {

    @Autowired
    private IProductoBusiness productoBusiness;

    @GetMapping("productos")
    public List<Producto> obtenerProductos(HttpServletResponse hsr) {
        return productoBusiness.obtenerProductos();
    }

    @PostMapping("productos")
    public String crearPedido(@RequestBody Producto producto, HttpServletResponse hsr) {
        return productoBusiness.crearProducto(producto);
    }

    @PutMapping("productos")
    public String modificarPedido(@RequestBody Producto producto) {
        return productoBusiness.modificarProducto(producto);
    }

    @GetMapping("inventario")
    public String valorDelInventario(HttpServletResponse hsr) {
        return productoBusiness.valorDelInventario();
    }

}
