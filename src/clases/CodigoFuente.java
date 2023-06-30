package clases;

import java.time.Instant;

public class CodigoFuente extends File{
    // Métodos
    // Constructor
    public CodigoFuente(String nombre, String extension, String contenido, String ruta){
        this.nombre = nombre;
        this.tipo = "Código Fuente";
        this.extension = extension;
        this.ruta = ruta;
        this.contenido = contenido;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.eliminado = false;
    }
}
