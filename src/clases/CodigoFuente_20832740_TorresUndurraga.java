package clases;

import java.time.Instant;

/**
 * Clase que representa un archivo especificado como código fuente.
 * Hereda los atributos y métodos que posee la clase abstracta File_20832740_TorresUndurraga.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public class CodigoFuente_20832740_TorresUndurraga extends File_20832740_TorresUndurraga {
    // Métodos
    // Constructor
    public CodigoFuente_20832740_TorresUndurraga(String nombre, String extension, String contenido, String ruta){
        this.nombre = nombre;
        this.tipo = "Código Fuente";
        this.extension = extension;
        this.ruta = ruta;
        this.contenido = contenido;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.eliminado = false;
    }
}
