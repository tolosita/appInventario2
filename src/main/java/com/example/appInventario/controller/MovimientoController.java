/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.controller;

import com.example.appInventario.business.IMovimientoBusiness;
import com.example.appInventario.model.Movimiento;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class MovimientoController {

    @Autowired
    private IMovimientoBusiness movimientoBusiness;

    @GetMapping("movimientos")
    public List<Movimiento> obtenerMovimientos(HttpServletResponse hsr) {
        return movimientoBusiness.obtenerMovimientos();
    }

    @PostMapping("movimientos")
    public String crearMovimiento(@RequestBody Movimiento movimiento, HttpServletResponse hsr) {
        return movimientoBusiness.crearMovimiento(movimiento);
    }

    @PutMapping("movimientos")
    public String modificarMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoBusiness.modificarMovimiento(movimiento);
    }

    @DeleteMapping("movimientos/{codigo}")
    public String modificarMovimiento(@PathVariable String codigo, HttpServletResponse hsr) {
        return movimientoBusiness.eliminarMovimiento(codigo);
    }

}
