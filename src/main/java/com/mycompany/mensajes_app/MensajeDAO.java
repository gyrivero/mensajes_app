/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gonza
 */
public class MensajeDAO {
    
    static public void crearMensajeDB(Mensaje mensaje) {
        Conexion conexionDB = new Conexion();
        
        try(Connection conexion = conexionDB.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query="INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getTexto());
                ps.setString(2,mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente!");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }       
    }
    
    static public void leerMensajeDB() {
        Conexion conexionDB = new Conexion();
        
        try(Connection conexion = conexionDB.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query="SELECT * FROM mensajes";
                ps = conexion.prepareStatement(query);              
                rs = ps.executeQuery();                
                
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println("");
                }
                System.out.println("Lectura de mensajes realizado correctamente!");                
            } catch (SQLException ex) {
                System.out.println("No se pudieron recuperar los mensajes!");
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }        
    }
    
    static public void borrarMensajeDB(int idMensaje) {
        Conexion conexionDB = new Conexion();
        try(Connection conexion = conexionDB.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes WHERE id_mensaje=?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                rs = ps.executeQuery();
                if (!rs.next()) {
                    System.out.println("Ese mensaje no existe!");                                       
                }
                else {
                    query = "DELETE FROM mensajes WHERE id_mensaje=?";
                    ps = conexion.prepareStatement(query);
                    ps.setInt(1, idMensaje);
                    ps.executeUpdate();                
                    System.out.println("Mensaje borrado con exito!");   
                }                                                     
            } catch (SQLException ex) {
                System.out.println("No se pudo borrar el mensaje!");
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    static public void actualizarMensajeDB(Mensaje mensaje) {
        Conexion conexionDB = new Conexion();
        try(Connection conexion = conexionDB.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes WHERE id_mensaje=?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getIdMensaje());
                rs = ps.executeQuery();
                if (!rs.next()) {
                    System.out.println("Ese mensaje no existe!");                                       
                }
                else {
                    query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, mensaje.getTexto());
                    ps.setInt(2, mensaje.getIdMensaje());
                    ps.executeUpdate();
                    System.out.println("Se actualizo el mensaje correctamente!");  
                }
            } catch (SQLException ex) {
                System.out.println("No se pudo actualizar el mensaje!");
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
