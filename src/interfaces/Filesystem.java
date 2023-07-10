package interfaces;

import java.util.ArrayList;

public interface Filesystem {
    // Selectores
    public String getName();
    public long getFechaCreacion();
    public ArrayList<Drive> getDrives();
    public String getLoggedUser();
    public ArrayList<User> getUsers();
    public String getDriveActual();
    public String getRutaActual();
    public ArrayList<Folder> getFolders();
    public ArrayList<File> getFiles();
    // Modificadores
    public void setDrives(ArrayList<Drive> drives);
    public void setLoggedUser(String userName);
    public void setDriveActual(String letter);
    public void setUsers(ArrayList<User> users);
    public void setRutaActual(String rutaActual);
    public void setFolders(ArrayList<Folder> folders);
    public void setFiles(ArrayList<File> files);
    
    // Otras Operaciones
    public void agregarDrive(Drive newDrive);
    public void agregarUser(User newUser);
    public void agregarFolder(Folder newFolder);
    public void agregarFile(File newFile);
    public boolean buscarDrive(String letra);
    public boolean buscarUser(String userName);
    public boolean buscarFolder(String ruta);
    public boolean buscarFile(String nombre, String ruta);
    public boolean buscarFileConExtension(String nombre, String ruta);
    public void eliminarFile(String nombre, String ruta);
    public void eliminarFolder(String ruta);
    public void copiarFolder(String source, String ruta, String target);
    public void moverFolder(String source, String ruta, String target);
    public File getFile(String nombre, String ruta);
    public Folder getFolder(String ruta);
    public void sobreescribirFile(String nombre, String ruta, String contenido, String extension);
    public void desaparecerFile(String nombre, String ruta);
    public String cambiarRuta(int n, String rutaOriginal, String fuenteNueva);
    public void renombrarCarpetas(String currentName, String newName);
}
