package clases;

import java.time.Instant;
import interfaces.IUser_20832740_TorresUndurraga;

/**
 * Clase que representa un usuario en el sistema.
 * Cada usuario tiene un nombre y una fecha de creación.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public class User_20832740_TorresUndurraga implements IUser_20832740_TorresUndurraga {
    // Atributos
    private String name;
    private long fechaCreacion;


    // Métodos
    // Constructor
    public User_20832740_TorresUndurraga(String name){
        this.name = name;
        this.fechaCreacion = Instant.now().toEpochMilli();
    }

    /**
     * Obtiene el nombre de un usuario.
     *
     * @return String Nombre del usuario.
     */
    // Selectores
    @Override
    public String getName(){
        return name;
    }

    /**
     * Obtiene la fecha de creación del usuario.
     *
     * @return long Fecha de creación en formato Epoch.
     */
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }
}
