/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Gonza
 */
public class MensajeService {
    
    static public void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String texto = sc.nextLine();
        
        System.out.println("Tu nombre?");
        String autor = sc.nextLine();
        
        Mensaje mensaje = new Mensaje();
        mensaje.setTexto(texto);
        mensaje.setAutorMensaje(autor);
        MensajeDAO.crearMensajeDB(mensaje);
    }
    
    static public void listarMensajes() {
        MensajeDAO.leerMensajeDB();        
    }
    
    static public void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int idMensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(idMensaje);
    }
    
    static public void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo mensaje");
        String texto = sc.nextLine();
        System.out.println("Indica el ID del mensaje a editar");
        int id_mensaje = sc.nextInt();
        Mensaje actualizacionDeMensaje = new Mensaje();
        actualizacionDeMensaje.setTexto(texto);
        actualizacionDeMensaje.setIdMensaje(id_mensaje);
        MensajeDAO.actualizarMensajeDB(actualizacionDeMensaje);
    }
    
}
