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
    public void system(String name){
        Filesystem system = new Filesystem(name);
    }
    
    public void addDrive(String letter, String name, int capacity){
        // Verificar que no exista
        if(filesystem.buscarDrive(letter) == false){
            // Agregar a la ArrayList
            Drive newDrive = new Drive(letter,name,capacity);
            filesystem.agregarDrive(newDrive);
        }
    }
    
    public void register(String userName){
        // Verificar que no exista
        if(filesystem.buscarUser(userName) == false){
            // Agregar a la ArrayList
            User newUser = new User(userName);
            filesystem.agregarUser(newUser);
            System.out.println("El usuario se registró correctamente.");
            return;
        }
        System.out.println("El usuario ya existe.");
    }
    
    public void login(String userName){
        // Verificar que exista
        if(filesystem.buscarUser(userName) == true){
            // Cambiar el usuario
            filesystem.setLoggedUser(userName);
            System.out.println("Se inició sesión correctamente.");
        }
    }
    
    public void logout(){
        // Verficar que exista un usuario loggeado
        if(!filesystem.getLoggedUser().equals("")){
            // Cerrar sesión
            filesystem.setLoggedUser("");
            System.out.println("Se cerró la sesión correctamente.");
            return;
        }
        
        System.out.println("No existe una sesión iniciada.");
    }
}
