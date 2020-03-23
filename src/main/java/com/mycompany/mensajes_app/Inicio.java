/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Gonza
 */
public class Inicio {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        while (opcion != 5) {            
            System.out.println("-----------------------------");    
            System.out.println("1.Crear Mensaje");
            System.out.println("2.Listar Mensajes");
            System.out.println("3.Editar Mensaje");
            System.out.println("4.Eliminar Mensaje");
            System.out.println("5.Salir");
            
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                case 5:
                    System.out.println("\nHasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida!");
                    break;
            }
        }
        
        /*Conexion conexion = new Conexion();
        
        try(Connection cnx = conexion.get_connection()) {
            
        } 
        catch (Exception e) {            
            System.out.println(e);
        }*/
    }
}
