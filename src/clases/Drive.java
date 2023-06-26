package clases;

public class Drive {
    // Atributos
    private char letter;
    private String name;
    private int capacity;


    // Métodos
    // Constructor
    public Drive(char letter, String name, int capacity){
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
    }



    // Selectores
    public char getLetra(){
        return letter;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCapacity(){
        return capacity;
    }



    // Modificadores
    public void setLetra(char letter){
        this.letter = letter;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
}
