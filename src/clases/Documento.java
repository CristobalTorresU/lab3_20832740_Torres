package clases;

import java.time.Instant;

public class Documento extends File{
    // Métodos
    // Constructor
    public Documento(String nombre, String extension, String contenido, String ruta){
        this.nombre = nombre;
        this.tipo = "Documento";
        this.extension = extension;
        this.ruta = ruta;
        this.contenido = contenido;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.eliminado = false;
    }
}