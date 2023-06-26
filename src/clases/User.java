package clases;

import java.time.Instant;

public class User {
    // Atributos
    private String name;
    private long fechaCreacion;


    // Métodos
    // Constructor
    public User(String name){
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
    
    // Modificadores
    public void setName(String name){
        this.name = name;
    }
}
