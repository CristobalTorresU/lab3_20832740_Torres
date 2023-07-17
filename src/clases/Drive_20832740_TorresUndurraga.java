package clases;

import interfaces.IDrive_20832740_TorresUndurraga;

/**
 * Clase que representa una unidad en el sistema.
 * Cada unidad tiene una letra que la identifica, un nombre,
 * y una capacidad.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public class Drive_20832740_TorresUndurraga implements IDrive_20832740_TorresUndurraga {
    // Atributos
    private String letter;
    private String name;
    private int capacity;


    // Métodos
    // Constructor
    public Drive_20832740_TorresUndurraga(String letter, String name, int capacity){
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
    }

    // Selectores
    /**
     * Obtiene la letra de la unidad.
     *
     * @return String Letra de la unidad.
     */
    @Override
    public String getLetra(){
        return letter;
    }

    /**
     * Obtiene en el nombre de la unidad.
     *
     * @return String Nombre de la unidad.
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * Obtiene la capacidad de la unidad.
     *
     * @return int Capacidad de la unidad
     */
    @Override
    public int getCapacity(){
        return capacity;
    }

    /**
     * Modifica el nombre de la unidad.
     *
     * @param name (String) Nombre que se reemplazará en la unidad.
     */
    @Override
    public void setName(String name){
        this.name = name;
    }
}
