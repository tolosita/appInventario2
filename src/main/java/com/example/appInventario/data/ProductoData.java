/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.appInventario.data;

import com.example.appInventario.model.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sala305
 */
public class ProductoData {

    private static List<Producto> listado;

    static {
        listado = new ArrayList<Producto>() {
            {
                add(new Producto("10", "Agua", 10D, 10D));
                add(new Producto("20", "Gaseosa", 5D, 5D));
                add(new Producto("30", "Malta", 2D, 2D));
            }
        };
    }

    public static List<Producto> getListado() {
        return listado;
    }

    public static void setListado(List<Producto> listado) {
        ProductoData.listado = listado;
    }

}
