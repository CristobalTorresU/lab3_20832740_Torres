package clases;

import clases.*;
import interfaces.IDrive;

public class Drive implements IDrive{
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
    @Override
    public String getLetra(){
        return letter;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public int getCapacity(){
        return capacity;
    }



    // Modificadores
    @Override
    public void setLetra(String letter){
        this.letter = letter;
    }
    
    @Override
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
