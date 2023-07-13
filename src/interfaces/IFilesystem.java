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
}
