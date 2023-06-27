package control;

import java.util.ArrayList;
import clases.*;

public class Control {
    private Filesystem filesystem;
    
    // Constructor
    public Control(Filesystem filesystem){
        this.filesystem = filesystem;
    }
    
    // Métodos
    public void addDrive(String letter, String name, int capacity){
        // Verificar que no exista
        if(filesystem.buscarDrive(letter) == false){
            // Agregar a la ArrayList
            Drive newDrive = new Drive(letter,name,capacity);
            filesystem.agregarDrive(newDrive);
        }
    }
}
