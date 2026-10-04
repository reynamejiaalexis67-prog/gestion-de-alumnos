# Sistema de Gestión de Alumnos (CRUD con Java NIO)

Aplicación Java orientada a objetos para la administración de registros de alumnos mediante una interfaz de ventanas emergentes (JOptionPane) y persistencia de datos en un archivo de texto plano (`alumnos.txt`).

##  Descripción del Proyecto

El sistema permite gestionar un catálogo de alumnos realizando las 4 operaciones fundamentales (CRUD):
C (Create):Registrar nuevos alumnos validando que el ID no se encuentre duplicado.
R (Read): Consultar todos los alumnos guardados o buscar a uno en específico por su ID.
U (Update): Actualizar el nombre de un alumno manteniendo su ID.
D (Delete): Eliminar un alumno del registro.

Los datos se guardan automáticamente en la raíz del proyecto dentro del archivo `alumnos.txt` bajo el formato estricto:
```text
ID - Nombre Completo



Dado que yo no se mucho sobre Java este proyecto fue hecho con apoyo de Gemini con algunos de los siguientes prompts:

"Quiero construir una aplicación CRUD de gestión de alumnos en Java usando consola con JOptionPane y persisencia en texto con Files y Path. Guíame paso a paso."

"Dime exactamente en qué línea está la llave } mal colocada."

"Me sale este error al ejecutar en NetBeans: ClassNotFoundException: com.mycompany.gestionalumnos.Gestionalumnos. ¿Cómo lo arreglo si tengo 2 clases: Alumnos y Main?"

"Cuando intento eliminar a alguien después de agregarlo me dice que no existe, ¿por qué pasa y cómo se arregla?"