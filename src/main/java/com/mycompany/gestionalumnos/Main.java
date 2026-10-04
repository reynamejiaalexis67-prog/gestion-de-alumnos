/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionalumnos;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Main {
        public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion = 0;
        Alumnos lista = new Alumnos();

        do {
            try {
                // Mostrar el menú
                String respuesta = JOptionPane.showInputDialog(null,
                        "1.- registrar alumno\n"
                        + "2.- Ver todos los alumnos\n"
                        + "3.-  Buscar alumno por ID\n"
                        + "4.- Actualizar nombre de alumno\n"
                        + "5.-  Eliminar alumno\n"
                        + "6.- salir\n"
                        
                        + "Ingrese una opción:"
                );

                if (respuesta == null) {
                    opcion = 6; // Si presiona "Cancelar", sale del programa
                    break;
                }

                opcion = Integer.parseInt(respuesta);

                switch (opcion) {
                    case 1:
                 String id = JOptionPane.showInputDialog(null, "Ingrese ID:");
    String nombre = JOptionPane.showInputDialog(null, "Ingrese Nombre Completo:");

    if (id != null && nombre != null && !id.trim().isEmpty() && !nombre.trim().isEmpty()) {
        try {
            lista.registrarAlumno(id.trim(), nombre.trim());
            JOptionPane.showMessageDialog(null, "¡Alumno registrado con éxito!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en archivo: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Campos inválidos. No se guardó el alumno.");
    }
                        break;

                    case 2:
                        try {
        String listaAlumnos = lista.obtenerTodos();
        JOptionPane.showMessageDialog(null, listaAlumnos);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
    }
                        break;

                    case 3:
                       String idBuscar = JOptionPane.showInputDialog(null, "Ingrese el ID del alumno a buscar:");
    
    if (idBuscar != null && !idBuscar.trim().isEmpty()) {
        try {
            String alumnoEncontrado = lista.buscarPorId(idBuscar);
            
            if (alumnoEncontrado != null) {
                JOptionPane.showMessageDialog(null, "Alumno encontrado:\n" + alumnoEncontrado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún alumno con el ID: " + idBuscar);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage());
        }
    } 
                        break;

                    case 4:
                       String idActualizar = JOptionPane.showInputDialog(null, "Ingrese el ID del alumno a modificar:");
    
    if (idActualizar != null && !idActualizar.trim().isEmpty()) {
        try {
            // Primero verificamos si existe para pedir el nuevo nombre
            if (lista.existeId(idActualizar)) {
                String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre Completo:");
                
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    boolean exito = lista.actualizarAlumno(idActualizar, nuevoNombre);
                    
                    if (exito) {
                        JOptionPane.showMessageDialog(null, "¡Nombre actualizado con éxito!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: No se encontró ningún alumno con el ID: " + idActualizar);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }
                        break;

                    case 5:
                       String idEliminar = JOptionPane.showInputDialog(null, "Ingrese el ID del alumno a eliminar:");
    
    if (idEliminar != null && !idEliminar.trim().isEmpty()) {
        try {
            // Usamos .trim() para quitar espacios accidentales al escribir
            boolean borrado = lista.eliminarAlumno(idEliminar.trim());
            
            if (borrado) {
                JOptionPane.showMessageDialog(null, "¡Alumno eliminado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: No se encontró ningún alumno con el ID: " + idEliminar);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
        }
    }
                       
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                      
                        break;

               
                    default:
                       JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa un número entero válido.");
            } catch (Exception e) {
                System.out.println("Error al ingresar la opción: " + e.getMessage());
            }

        } while (opcion != 6);
    }
}
    

