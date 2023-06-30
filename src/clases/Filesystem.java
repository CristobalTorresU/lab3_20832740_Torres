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
    public ArrayList<Drive> drives;
    public ArrayList<User> users;
    public ArrayList<Folder> folders;
    public ArrayList<File> files;
    
    // Métodos
    
    // Constructor
    public Filesystem(String name){
        this.name = name;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.loggedUser = "";
        this.driveActual = "";
        this.rutaActual = "";
        this.users = new ArrayList<>();
        this.drives = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
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
    
    public ArrayList<Folder> getFolders(){
        return folders;
    }
    
    public ArrayList<File> getFiles(){
        return files;
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
    
    public void setFolders(ArrayList<Folder> folders){
        this.folders = folders;
    }
    
    public void setFiles(ArrayList<File> files){
        this.files = files;
    }
    
    
    
    
    // Otras Operaciones
    public void agregarDrive(Drive newDrive){
        ArrayList<Drive> listaDrives = getDrives();
        listaDrives.add(newDrive);
        setDrives(listaDrives);
    }
    
    public void agregarUser(User newUser){
        ArrayList<User> listaUsers = getUsers();
        listaUsers.add(newUser);
        setUsers(listaUsers);
    }
    
    public void agregarFolder(Folder newFolder){
        ArrayList<Folder> listaFolders = getFolders();
        listaFolders.add(newFolder);
        setFolders(listaFolders);
    }
    
    public void agregarFile(File newFile){
        ArrayList<File> listaFiles = getFiles();
        listaFiles.add(newFile);
        setFiles(listaFiles);
    }
    
    public boolean buscarDrive(String letra){
        int largo = this.drives.size();
        for(int i = 0 ; i < largo ; ++i){
            Drive drive = drives.get(i);
            if(drive.getLetra().equals(letra)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean buscarUser(String userName){
        int largo = this.users.size();
        for(int i = 0 ; i < largo ; ++i){
            User user = users.get(i);
            if(user.getName().equals(userName)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean buscarFolder(String ruta){
        int largo = this.folders.size();
        for(int i = 0 ; i < largo ; ++i){
            Folder folder = folders.get(i);
            if(folder.getRuta().equals(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean buscarFile(String nombre, String ruta){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            File file = files.get(i);
            if(file.getNombre().equals(nombre) && file.getRuta().equals(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    public void eliminarFile(String nombre, String ruta){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombre().equals(nombre) && files.get(i).getRuta().equals(ruta)){
                files.get(i).setEliminado(true);
            }
        }
    }
    
    public void sobreescribirFile(String nombre, String ruta, String contenido, String extension){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombre().equals(nombre) && files.get(i).getRuta().equals(ruta)){
                files.get(i).setNombre(nombre);
                files.get(i).setExtension(extension);
                files.get(i).setContenido(contenido);
                return;
            }
        }
    }
}
