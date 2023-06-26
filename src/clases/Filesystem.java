package clases;

import java.time.Instant;
import java.util.ArrayList;

public class Filesystem {
    // Atributos
    private String name;
    private long fechaCreacion;
    
    // Métodos
    
    // Constructor
    public Filesystem(String name){
        this.name = name;
        this.fechaCreacion = Instant.now().toEpochMilli();
    }
    
    // Selectores
    public String getName(){
        return name;
    }
    
    public long getFechaCreacion(){
        return fechaCreacion;
    }
}
