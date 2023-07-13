package clases;

import java.time.Instant;
import interfaces.IUser;

public class User implements IUser{
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
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    // Modificadores
    @Override
    public void setName(String name){
        this.name = name;
    }
}
