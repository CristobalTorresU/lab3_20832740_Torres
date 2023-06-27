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
    private ArrayList<Drive> drives;
    
    // Métodos
    
    // Constructor
    public Filesystem(String name){
        this.name = name;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.loggedUser = "";
        this.driveActual = "";
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
    
    public String getDriveActual(){
        return driveActual;
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
    
    // Otras Operaciones
    public void agregarDrive(Drive newdrive){
        ArrayList<Drive> listaDrives = getDrives();
        listaDrives.add(newdrive);
        setDrives(listaDrives);
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
}
