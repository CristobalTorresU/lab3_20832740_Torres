package clases;

import clases.*;

public class Drive {
    // Atributos
    private String letter;
    private String name;
    private int capacity;


    // Métodos
    // Constructor
    public Drive(String letter, String name, int capacity){
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
    }



    // Selectores
    public String getLetra(){
        return letter;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCapacity(){
        return capacity;
    }



    // Modificadores
    public void setLetra(String letter){
        this.letter = letter;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
