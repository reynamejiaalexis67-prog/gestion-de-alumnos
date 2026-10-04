/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionalumnos;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Alumnos {
    private final Path ruta = Path.of("alumnos.txt");
     public Alumnos (){
    try{ if (!Files.exists(ruta)){
        Files.createFile(ruta);
    }
}catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
    public void registrarAlumno(String id,String nombre)throws IOException {
      if (existeId(id)) {
        throw new IllegalArgumentException("El ID " + id + " ya está registrado.");
    }

    String linea = id + " - " + nombre + "\n";
    Files.writeString(ruta, linea, StandardOpenOption.APPEND);

        
        
    }
    
    public String obtenerTodos() throws IOException {
    List<String> lineas = Files.readAllLines(ruta);

    // Si la lista está vacía, avisamos que no hay registros
    if (lineas.isEmpty()) {
        return "No hay alumnos registrados.";
    }

    // Unimos todas las líneas en un solo texto con saltos de línea
    StringBuilder resultado = new StringBuilder("=== LISTA DE ALUMNOS ===\n\n");
    for (String linea : lineas) {
        resultado.append(linea).append("\n");
    }

    return resultado.toString();
}
public boolean existeId(String idBuscado) throws IOException {
    // 1. Lee todas las líneas del archivo
    List<String> lineas = Files.readAllLines(ruta);

    // 2. Recorre cada línea del archivo
    for (String linea : lineas) {
        // Separamos el ID del Nombre
        String[] partes = linea.split(" - ");
        
        // Verificamos que la línea tenga el formato correcto y comparamos el ID
        if (partes.length >= 1 && partes[0].trim().equals(idBuscado.trim())) {
            return true; // ¡El ID ya existe!
        }
    }
    return false; // El ID no está en el archivo
}
public String buscarPorId(String idBuscado) throws IOException {
    List<String> lineas = Files.readAllLines(ruta);

    for (String linea : lineas) {
        String[] partes = linea.split(" - ");
        // Comparamos el ID (limpiando espacios con trim)
        if (partes.length >= 1 && partes[0].trim().equals(idBuscado.trim())) {
            return linea; // Retorna la línea completa "ID - Nombre"
        }
    }
    return null; // Si no lo encuentra
    
    
}
public boolean actualizarAlumno(String idBuscado, String nuevoNombre) throws IOException {
    List<String> lineas = Files.readAllLines(ruta);
    boolean encontrado = false;

    // Recorremos la lista para buscar y modificar
    for (int i = 0; i < lineas.size(); i++) {
        String[] partes = lineas.get(i).split(" - ");
        
        if (partes.length >= 1 && partes[0].trim().equals(idBuscado.trim())) {
            // Reemplazamos la línea vieja por la nueva en la lista
            lineas.set(i, idBuscado.trim() + " - " + nuevoNombre.trim());
            encontrado = true;
            break; // Ya lo encontramos, salimos del bucle
        }
    }

    // Si lo encontramos y modificamos la lista, sobrescribimos el archivo
    if (encontrado) {
        Files.write(ruta, lineas); // Reemplaza todo el archivo con las líneas actualizadas
        return true;
    }

    return false; // El ID no existía
}
public boolean eliminarAlumno(String idBuscado) throws IOException {
    List<String> lineas = Files.readAllLines(ruta);
    boolean encontrado = false;

    for (int i = 0; i < lineas.size(); i++) {
        String linea = lineas.get(i).trim(); // Limpiamos espacios y saltos de línea
        
        if (linea.isEmpty()) continue; // Ignoramos líneas vacías

        String[] partes = linea.split(" - ");
        
        // Verificamos que tenga al menos el ID y comparamos ambos limpios (.trim())
        if (partes.length >= 1 && partes[0].trim().equals(idBuscado.trim())) {
            lineas.remove(i);
            encontrado = true;
            break;
        }
    }

    if (encontrado) {
        Files.write(ruta, lineas); // Reescribe el archivo con la lista actualizada
        return true;
    }

    return false;
}

}
