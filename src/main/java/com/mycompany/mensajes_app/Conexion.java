/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gonza
 */
public class Conexion {
    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if (conection != null) {
                System.out.println("Conexion exitosa");
            }
        } 
        catch (Exception e) {
            System.out.println("Conexion fallida");
            System.out.println(e);
        }
        return conection;
    }
}
