package interfaces;

import java.util.ArrayList;

public interface IFilesystem {
    // Selectores
    public String getName();
    public long getFechaCreacion();
    public ArrayList<IDrive> getDrives();
    public String getLoggedUser();
    public ArrayList<IUser> getUsers();
    public String getDriveActual();
    public String getRutaActual();
    public ArrayList<IFolder> getFolders();
    public ArrayList<IFile> getFiles();
    // Modificadores
    public void setDrives(ArrayList<IDrive> drives);
    public void setLoggedUser(String userName);
    public void setDriveActual(String letter);
    public void setUsers(ArrayList<IUser> users);
    public void setRutaActual(String rutaActual);
    public void setFolders(ArrayList<IFolder> folders);
    public void setFiles(ArrayList<IFile> files);
    
    // Otras Operaciones
    public void agregarDrive(IDrive newDrive);
    public void agregarUser(IUser newUser);
    public void agregarFolder(IFolder newFolder);
    public void agregarFile(IFile newFile);
    public boolean buscarDrive(String letra);
    public boolean buscarUser(String userName);
    public boolean buscarFolder(String ruta);
    public boolean buscarFile(String nombre, String ruta);
    public boolean buscarFileConExtension(String nombre, String ruta);
    public void eliminarFile(String nombre, String ruta);
    public void eliminarFolder(String ruta);
    public void copiarFolder(String source, String ruta, String target);
    public void moverFolder(String source, String ruta, String target);
    public IFile getFile(String nombre, String ruta);
    public IFolder getFolder(String ruta);
    public void sobreescribirFile(String nombre, String ruta, String contenido, String extension);
    public void desaparecerFile(String nombre, String ruta);
    public String cambiarRuta(int n, String rutaOriginal, String fuenteNueva);
    public void renombrarCarpetas(String currentName, String newName);
    public IFile generarFile(String nombre, String contenido);
    
    // Requeriemientos Funcionales
    //public void system(String name);
    public void addDrive(String letter, String name, int capacity);
    public void register(String userName);
    public void login(String userName);
    public void logout();
    public void switchDrive(String letter);
    public void mkdir(String name);
    public void cd(String path);
    public void addFile(IFile archivo);
    public void del(String fileName);
    public void copy(String source, String target);
    public void move(String source, String target);
    public void ren(String currentName, String newName);
    public void dir(ArrayList<String> params);
    public void format(String letter, String name);
}
