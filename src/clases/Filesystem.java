package clases;

import java.time.Instant;
import java.util.ArrayList;
import clases.*;
import interfaces.*;

/**
 *
 * @author Usach
 */
public class Filesystem implements IFilesystem{
    // Atributos
    private String name;
    private long fechaCreacion;
    private String loggedUser;
    private String driveActual;
    private String rutaActual;
    private ArrayList<IDrive> drives;
    private ArrayList<IUser> users;
    private ArrayList<IFolder> folders;
    private ArrayList<IFile> files;
    
    // Métodos
    
    // Constructor

    /**
     *
     * @param name
     */
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
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    @Override
    public ArrayList<IDrive> getDrives(){
        return drives;
    }
    
    @Override
    public String getLoggedUser(){
        return loggedUser;
    }
    
    @Override
    public ArrayList<IUser> getUsers(){
        return users;
    }
    
    @Override
    public String getDriveActual(){
        return driveActual;
    }
    
    @Override
    public String getRutaActual(){
        return rutaActual;
    }
    
    @Override
    public ArrayList<IFolder> getFolders(){
        return folders;
    }
    
    @Override
    public ArrayList<IFile> getFiles(){
        return files;
    }
    
    
    
    
    // Modificadores
    @Override
    public void setDrives(ArrayList<IDrive> drives){
        this.drives = drives;
    }
    
    @Override
    public void setLoggedUser(String userName){
        this.loggedUser = userName;
    }
    
    @Override
    public void setDriveActual(String letter){
        this.driveActual = letter;
    }
    
    @Override
    public void setUsers(ArrayList<IUser> users){
        this.users = users;
    }
    
    @Override
    public void setRutaActual(String rutaActual){
        this.rutaActual = rutaActual;
    }
    
    @Override
    public void setFolders(ArrayList<IFolder> folders){
        this.folders = folders;
    }
    
    @Override
    public void setFiles(ArrayList<IFile> files){
        this.files = files;
    }
    
    
    
    
    // Otras Operaciones
    @Override
    public void agregarDrive(IDrive newDrive){
        ArrayList<IDrive> listaDrives = getDrives();
        listaDrives.add(newDrive);
        setDrives(listaDrives);
    }
    
    @Override
    public void agregarUser(IUser newUser){
        ArrayList<IUser> listaUsers = getUsers();
        listaUsers.add(newUser);
        setUsers(listaUsers);
    }
    
    @Override
    public void agregarFolder(IFolder newFolder){
        ArrayList<IFolder> listaFolders = getFolders();
        listaFolders.add(newFolder);
        setFolders(listaFolders);
    }
    
    @Override
    public void agregarFile(IFile newFile){
        ArrayList<IFile> listaFiles = getFiles();
        listaFiles.add(newFile);
        setFiles(listaFiles);
    }
    
    @Override
    public boolean buscarDrive(String letra){
        int largo = this.drives.size();
        for(int i = 0 ; i < largo ; ++i){
            IDrive drive = drives.get(i);
            if(drive.getLetra().equals(letra)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean buscarUser(String userName){
        int largo = this.users.size();
        for(int i = 0 ; i < largo ; ++i){
            IUser user = users.get(i);
            if(user.getName().equals(userName)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean buscarFolder(String ruta){
        int largo = this.folders.size();
        for(int i = 0 ; i < largo ; ++i){
            IFolder folder = folders.get(i);
            if(folder.getRuta().equals(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean buscarFile(String nombre, String ruta){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            IFile file = files.get(i);
            if(file.getNombreSinExtension().equals(nombre) && file.getRuta().equals(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean buscarFileConExtension(String nombre, String ruta){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            IFile file = files.get(i);
            if(file.getNombre().equals(nombre) && file.getRuta().equals(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void eliminarFile(String nombre, String ruta){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombre().equals(nombre) && files.get(i).getRuta().equals(ruta)){
                files.get(i).setEliminado(true);
            }
        }
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
    public IFile getFile(String nombre, String ruta){
        int largo = getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            IFile file = files.get(i);
            if(file.getNombreSinExtension().equals(nombre) && file.getRuta().equals(ruta)){
                return file;
            }
        }
        return null;
    }
    
    @Override
    public IFolder getFolder(String ruta){
        int largo = getFolders().size();
        for(int i = 0 ; i < largo ; ++i){
            IFolder folder = folders.get(i);
            if(folder.getRuta().equals(ruta)){
                return folder;
            }
        }
        return null;
    }
    
    @Override
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
    
    @Override
    public void desaparecerFile(String nombre, String ruta){
        int largo = files.size();
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombre().equals(nombre) && files.get(i).getRuta().equals(ruta)){
                files.remove(i);
                return;
            }
        }
    }
    
    @Override
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
    
    @Override
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
