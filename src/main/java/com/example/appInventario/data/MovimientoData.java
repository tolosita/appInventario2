/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.data;

import com.example.appInventario.model.Movimiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sala305
 */
public class MovimientoData {

    private static List<Movimiento> listado;

    static {
        listado = new ArrayList<Movimiento>() {
        };
    }

    public static List<Movimiento> getListado() {
        return listado;
    }

    public static void setListado(List<Movimiento> listado) {
        MovimientoData.listado = listado;
    }
}
