package clases;

import java.time.Instant;

public class TextoPlano extends File{
    // Métodos
    // Constructor
    public TextoPlano(String nombre, String extension, String contenido, String ruta){
        this.nombre = nombre;
        this.tipo = "Texto Plano";
        this.extension = extension;
        this.ruta = ruta;
        this.contenido = contenido;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.eliminado = false;
    }
}
