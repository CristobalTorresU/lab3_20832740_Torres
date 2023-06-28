package clases;

import java.time.Instant;
import java.util.ArrayList;
import clases.*;

public class Filesystem {
    // Atributos
    private String name;
    private long fechaCreacion;
    private String loggedUser;
    private String driveActual;
    private String rutaActual;
    private ArrayList<Drive> drives;
    public ArrayList<User> users;
    
    // Métodos
    
    // Constructor
    public Filesystem(String name){
        this.name = name;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.loggedUser = "";
        this.driveActual = "";
        this.users = new ArrayList<>();
        this.drives = new ArrayList<>();
    }
    
    // Selectores
    public String getName(){
        return name;
    }
    
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    public ArrayList<Drive> getDrives(){
        return drives;
    }
    
    public String getLoggedUser(){
        return loggedUser;
    }
    
    public ArrayList<User> getUsers(){
        return users;
    }
    
    public String getDriveActual(){
        return driveActual;
    }
    
    public String getRutaActual(){
        return rutaActual;
    }
    
    // Modificadores
    public void setDrives(ArrayList<Drive> drives){
        this.drives = drives;
    }
    
    public void setLoggedUser(String userName){
        this.loggedUser = userName;
    }
    
    public void setDriveActual(String letter){
        this.driveActual = letter;
    }
    
    public void setUsers(ArrayList<User> users){
        this.users = users;
    }
    
    public void setRutaActual(String rutaActual){
        this.rutaActual = rutaActual;
    }
    
    // Otras Operaciones
    public void agregarDrive(Drive newdrive){
        ArrayList<Drive> listaDrives = getDrives();
        listaDrives.add(newdrive);
        setDrives(listaDrives);
    }
    
    public void agregarUser(User newUser){
        ArrayList<User> listaUsers = getUsers();
        listaUsers.add(newUser);
        setUsers(listaUsers);
    }
    
    public boolean buscarDrive(String letra){
        int largo = this.folders.size();
        for(int i = 0 ; i < largo ; ++i){
            Drive drive = drives.get(i);
            if(drive.letter.equals(letra)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean buscarUser(String userName){
        int largo = this.users.size();
        for(int i = 0 ; i < largo ; ++i){
            User user = users.get(i);
            if(user.userName.equals(userName)){
                return true;
            }
        }
        
        return false;
    }
}
