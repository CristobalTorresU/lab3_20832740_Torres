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
    private ArrayList<User> users;
    private ArrayList<Folder> folders;
    private ArrayList<File> files;
    
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
            if(file.getNombreSinExtension().equals(nombre) && file.getRuta().equals(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean buscarFileConExtension(String nombre, String ruta){
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
    
    public void eliminarFolder(String ruta){
        int largoF = getFolders().size();
        String rutaF;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta) || folders.get(i).subdirectorio(ruta) == false){
                folders.get(i).setEliminado(true);
            }
        }
        
        int largoFi = getFiles().size();
        String rutaFi;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta) || files.get(i).subdirectorio(ruta) == false){
                files.get(i).setEliminado(true);
            }
        }
    }
    
    public void copiarFolder(String source, String ruta, String target){
        int largoF = getFolders().size();
        String rutaF;
        Folder folder;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta) || folders.get(i).subdirectorio(ruta) == false){
                folder = new Folder(folders.get(i).getNombre(), target + source + "/", folders.get(i).getCreador());
                agregarFolder(folder);
            }
        }
        
        int largoFi = getFiles().size();
        String rutaFi;
        File file;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta) || files.get(i).subdirectorio(ruta) == false){
                String extension = files.get(i).getExtension();
                switch(extension){
                    case "txt":
                    case "md":
                        file = new TextoPlano(files.get(i).getNombre(), extension, files.get(i).getContenido(), target + source + "/");
                        agregarFile(file);
                        break;
                    case "docx":
                    case "pdf":
                    case "tex":
                        file = new Documento(files.get(i).getNombre(), extension, files.get(i).getContenido(), target + source + "/");
                        agregarFile(file);
                        break;
                    case "py":
                    case "c":
                    case "java":
                    case "rkt":
                    case "pl":
                        file = new CodigoFuente(files.get(i).getNombre(), extension, files.get(i).getContenido(), target + source + "/");
                        agregarFile(file);
                        break;
                }
            }
        }
    }
    
    public void moverFolder(String source, String ruta, String target){
        int largoF = getFolders().size();
        String rutaF;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta)){
                folders.get(i).setRuta(target + source + "/");
            } else if(folders.get(i).subdirectorio(ruta) == false){
                folders.get(i).setRuta(cambiarRuta(ruta.split("/").length, folders.get(i).getRuta(), target + source + "/"));
            }
        }
        
        int largoFi = getFiles().size();
        String rutaFi;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta)){
                getFiles().get(i).setRuta(target + source + "/");
            } else if(files.get(i).subdirectorio(ruta) == false){
                getFiles().get(i).setRuta(cambiarRuta(ruta.split("/").length, getFiles().get(i).getRuta() , target + source + "/"));
            }
        }
    }
    
    public File getFile(String nombre, String ruta){
        int largo = getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            File file = files.get(i);
            if(file.getNombreSinExtension().equals(nombre) && file.getRuta().equals(ruta)){
                return file;
            }
        }
        return null;
    }
    
    public Folder getFolder(String ruta){
        int largo = getFolders().size();
        for(int i = 0 ; i < largo ; ++i){
            Folder folder = folders.get(i);
            if(folder.getRuta().equals(ruta)){
                return folder;
            }
        }
        return null;
    }
    
    public void sobreescribirFile(String nombre, String ruta, String contenido, String extension){
        int largo = this.files.size();
        String nombreSinExtension = nombre.split("\\.")[0];
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombreSinExtension().equals(nombreSinExtension) && files.get(i).getRuta().equals(ruta)){
                files.get(i).setNombre(nombre);
                files.get(i).setExtension(extension);
                files.get(i).setContenido(contenido);
                files.get(i).setTipo(extension);
                return;
            }
        }
    }
    
    public void desaparecerFile(String nombre, String ruta){
        int largo = files.size();
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombre().equals(nombre) && files.get(i).getRuta().equals(ruta)){
                files.remove(i);
                return;
            }
        }
    }
    
    public String cambiarRuta(int n, String rutaOriginal, String fuenteNueva){
        String[] rO = rutaOriginal.split("/");
        int largoRestante = rO.length;
        String rutaSinFuente = "";
        
        for(int i = n ; i < largoRestante ; ++i){
            rutaSinFuente += rO[i] + "/";
        }
        String rutaNueva = fuenteNueva + rutaSinFuente;
        return rutaNueva;
    }
    
    public void renombrarCarpetas(String currentName, String newName){
        int largo = getFolders().size();
        int n = (getRutaActual()+newName+"/").split("/").length;
        for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getRuta().equals(getRutaActual()+currentName+"/") == true){
                    folders.get(i).cambiarNombre(newName);
                } else if(getFolders().get(i).subdirectorio(getRutaActual()+currentName+"/") == false){
                    folders.get(i).setRuta(cambiarRuta(n, folders.get(i).getRuta(), getRutaActual()+newName+"/"));
                }
        }
    }
}
