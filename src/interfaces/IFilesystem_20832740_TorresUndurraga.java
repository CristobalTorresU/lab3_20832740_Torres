package interfaces;

import java.util.ArrayList;

/**
 * Interfaz que tiene los métodos que deben aplicar los sistemas de archivos.
 *
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public interface IFilesystem_20832740_TorresUndurraga {
    // Selectores
    /**
     * Obtiene el nombre del sistema.
     *
     * @return String nombre del sistema.
     */
    public String getName();

    /**
     * Obtiene la fecha de creación del sistema.
     *
     * @return long fecha de creación en formato Epoch.
     */
    public long getFechaCreacion();

    /**
     * Obtiene las unidades del sistema.
     *
     * @return ArrayList<IDrive> Lista con las unidades del sistema.
     */
    public ArrayList<IDrive_20832740_TorresUndurraga> getDrives();

    /**
     * Obtiene el nombre de usuario que ha iniciado sesión.
     *
     * @return String nombre del usuario con una sesión iniciada.
     */
    public String getLoggedUser();

    /**
     * Obtiene los usuarios registrados en el sistema.
     *
     * @return ArrayList<IUser> Lista de usuarios registrados en el sistema.
     */
    public ArrayList<IUser_20832740_TorresUndurraga> getUsers();

    /**
     * Obtiene la unidad con la que se está trabajando.
     *
     * @return String Letra de la unidad en la que se realizan las operaciones.
     */
    public String getDriveActual();

    /**
     * Obtiene la ruta actual del sistema.
     *
     * @return String La ruta en que se realizan las operaciones en el sistema.
     */
    public String getRutaActual();

    /**
     * Obtiene las carpetas que existen en el sistema.
     *
     * @return ArrayList<IFolder> Lista de carpetas creadas en el sistema.
     */
    public ArrayList<IFolder_20832740_TorresUndurraga> getFolders();

    /**
     * Obtiene los archivos que existen en el sistema.
     *
     * @return ArrayList<IFile> Lista de archivos creados en el sistema.
     */
    public ArrayList<IFile_20832740_TorresUndurraga> getFiles();


    // Modificadores
    /**
     * Modifica las unidades existentes en el sistema.
     *
     * @param drives (ArrayList<IDrive>) Lista de unidades que se reemplazará en el sistema.
     */
    public void setDrives(ArrayList<IDrive_20832740_TorresUndurraga> drives);

    /**
     * Modifica el usuario que ha iniciado sesión en el sistema.
     *
     * @param userName (String) Nombre del usuario que iniciará sesión.
     */
    public void setLoggedUser(String userName);

    /**
     * Modifica la unidad fijada en el sistema.
     *
     * @param letter (String) Letra del sistema que será fijado.
     */
    public void setDriveActual(String letter);

    /**
     * Modifica la lista de usuarios que existe en el sistema.
     *
     * @param users (ArrayList<IUser>) Lista de usuarios que se reemplazará en el sistema.
     */
    public void setUsers(ArrayList<IUser_20832740_TorresUndurraga> users);

    /**
     * Modifica la ruta en que se realizan las operaciones en el sistema.
     *
     * @param rutaActual (String) Ruta actual que será fijada.
     */
    public void setRutaActual(String rutaActual);

    /**
     * Modifica la lista de carpetas que existe en el sistema.
     *
     * @param folders (ArrayList<IFolder>) Lista de carpetas que se reemplazará en el sistema.
     */
    public void setFolders(ArrayList<IFolder_20832740_TorresUndurraga> folders);

    /**
     * Modifica la lista de archivos que existe en el sistema.
     *
     * @param files (ArrayList<IFile>) Lista de archivos que se reemplazará en el sistema.
     */
    public void setFiles(ArrayList<IFile_20832740_TorresUndurraga> files);
    
    // Otras Operaciones
    /**
     * Añade una unidad a la lista de unidades del sistema.
     *
     * @param newDrive (IDrive) Unidad que se agregará al sistema.
     */
    public void agregarDrive(IDrive_20832740_TorresUndurraga newDrive);

    /**
     * Añade un usuario a la lista de usuarios del sistema.
     *
     * @param newUser (IUser) Usuario que se agregará al sistema.
     */
    public void agregarUser(IUser_20832740_TorresUndurraga newUser);

    /**
     * Añade una carpeta a la lista de carpetas del sistema.
     *
     * @param newFolder (IFolder) Carpeta que se agregará al sistema.
     */
    public void agregarFolder(IFolder_20832740_TorresUndurraga newFolder);

    /**
     * Añade un archivo a la lista de archivos del sistema.
     *
     * @param newFile (IFile) Archivo que se agregará al sistema.
     */
    public void agregarFile(IFile_20832740_TorresUndurraga newFile);

    /**
     * Comprueba si existe una unidad en el sistema.
     *
     * @param letra (String) Letra de la unidad que se está buscando.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    public boolean buscarDrive(String letra);

    /**
     * Comprueba si existe un usuario en el sistema.
     *
     * @param userName (String) Nombre del usuario que se está buscando.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    public boolean buscarUser(String userName);

    /**
     * Comprueba si existe una carpeta en el sistema.
     *
     * @param ruta (String) Ruta de la carpeta que se está buscando.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    public boolean buscarFolder(String ruta);

    /**
     * Comprueba si existe un archivo en el sistema.
     *
     * @param nombre (String) Nombre del archivo que se está buscando.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    public boolean buscarFile(String nombre, String ruta);

    /**
     * Comprueba si existe un archivo en el sistema, sin utilizar la extensión del archivo.
     *
     * @param nombre (String) Nombre sin extensión del archivo que se está buscando.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    public boolean buscarFileConExtension(String nombre, String ruta);

    /**
     * Elimina un archivo del sistema, modificando el atributo "eliminado".
     *
     * @param nombre (String) Nombre del archivo que se quire eliminar.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     */
    public void eliminarFile(String nombre, String ruta);

    /**
     * Elimina una carpeta del sistema, modificando el atributo "eliminado".
     *
     * @param ruta (String) Ruta correspondiente a la carpeta que se quiere eliminar.
     */
    public void eliminarFolder(String ruta);

    /**
     * Copia una carpeta y sus contenidos a una ruta objetivo.
     *
     * @param source (String) Nombre del directorio que se copiará.
     * @param ruta (String) Ruta de la carpeta que se copiará.
     * @param target (String) Ruta objetivo a la que se copiarán los elementos.
     */
    public void copiarFolder(String source, String ruta, String target);

    /**
     * Mueve una carpeta y sus contenidos a una ruta objetivo.
     *
     * @param source (String) Nombre de la carpeta que se moverá.
     * @param ruta (String) Ruta de la carpeta que se moverá.
     * @param target (String) Ruta objetivo en la que se moverá la carpeta.
     */
    public void moverFolder(String source, String ruta, String target);

    /**
     * Obtiene un archivo en específico.
     *
     * @param nombre (String) Nombre del archivo que se busca.
     * @param ruta (String) Ruta en que se encuentra el archivo que se busca.
     * @return IFile Archivo buscado.
     */
    public IFile_20832740_TorresUndurraga getFile(String nombre, String ruta);

    /**
     * Obtiene una carpeta en específico.
     *
     * @param ruta (String) Ruta de la carpeta que se busca.
     * @return IFolder Carpeta buscada.
     */
    public IFolder_20832740_TorresUndurraga getFolder(String ruta);

    /**
     * Sobreescribe la extensión y el contenido de un archivo.
     *
     * @param nombre (String) Nombre sin extensión del archivo.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     * @param contenido (String) Contenido que se reemplazará en el archivo.
     * @param extension (String) Nombre la extensión que se sobreescribirá en el archivo.
     */
    public void sobreescribirFile(String nombre, String ruta, String contenido, String extension);

    /**
     * Quita un archivo de la lista de archivos.
     *
     * @param nombre (String) Nombre del archivo que se removerá.
     * @param ruta (String) Ruta en que se encuentra el archivo que se removerá.
     */
    public void desaparecerFile(String nombre, String ruta);

    /**
     * Quita una carpeta de la lista de carpetas.
     *
     * @param ruta (String) Ruta en que se encuentra la carpeta que se removerá.
     */
    public void desaparecerFolder(String ruta);

    /**
     * Cambia una ruta ingresada por una nueva fuente.
     *
     * @param n (int) Largo de la fuente nueva.
     * @param rutaOriginal (String) Ruta que será modificada.
     * @param fuenteNueva (String) Fuente que será reemplazada en la ruta.
     * @return String Ruta renovada.
     */
    public String cambiarRuta(int n, String rutaOriginal, String fuenteNueva);

    /**
     * Modifica el nombre de una carpeta y todas las rutas de sus subdirectorios.
     *
     * @param currentName (String) Nombre actual de la carpeta que será modificada.
     * @param newName (String) Nuevo nombre que se usará en la carpeta.
     */
    public void renombrarCarpetas(String currentName, String newName);

    /**
     * Genera un archivo del tipo correspondiente a la extensión ingresada.
     *
     * @param nombre (String)
     * @param contenido (String)
     * @return IFile el archivo generado.
     */
    public IFile_20832740_TorresUndurraga generarFile(String nombre, String contenido);
    
    // Requeriemientos Funcionales
    /**
     * Permite agregar unidades al sistema. Cada unidad es única.
     *
     * @param letter (String) Letra de la unidad que se agregará.
     * @param name (String) Nombre de la unidad que se agregará.
     * @param capacity (int) Capacidad de la unidad que se agregará.
     */
    public void addDrive(String letter, String name, int capacity);

    /**
     * Permite registrar usuarios en el sistema. Cada usuario es único.
     *
     * @param userName (String) Nombre del usuario que será registrado.
     */
    public void register(String userName);

    /**
     * Permite iniciar sesión con uno de los usuarios ya registrados en el sistema.
     *
     * @param userName (String) Nombre del usuario con el que se iniciará sesión.
     */
    public void login(String userName);

    /**
     * Permite cerrar sesión en el sistema.
     */
    public void logout();

    /**
     * Permite fijar una unidad en el sistema para realizar las operaciones en el sistema.
     * Debe existir una sesión iniciada para ejecutarse.
     *
     * @param letter (String) Letra de la unidad que se fijará.
     */
    public void switchDrive(String letter);

    /**
     * Permite crear y agregar un directorio en el sistema. Cada directorio es único en su ruta.
     *
     * @param name (String) Nombre del directorio que se creará.
     */
    public void mkdir(String name);

    /**
     * Permite cambiar la ruta actual del sistema.
     *
     * @param path (String) Nombre de la carpeta o ruta a la que se cambiará.
     */
    public void cd(String path);

    /**
     * Permite agregar un archivo al sistema. Cada archivo es único en su ruta.
     *
     * @param archivo (IFile) Archivo que se agregará al sistema.
     */
    public void addFile(IFile_20832740_TorresUndurraga archivo);

    /**
     * Permite eliminar un archivo o directorio del sistema y enviarlo a la papelera.
     *
     * @param fileName (String) Nombre del archivo o carpeta que se desea eliminar.
     */
    public void del(String fileName);

    /**
     * Permite copiar un archivo o directorio a un directorio objetivo, siempre y
     * cuando no se rompa la unicidad dentro del directorio.
     *
     * @param source (String) Nombre del archivo o directorio que será copiado.
     * @param target (String) Ruta objetivo en la que se copiarán los archivos.
     */
    public void copy(String source, String target);

    /**
     * Permite mover un archivo o directorio a una ruta objetivo. En caso de que
     * ya exista, se sobreescribe.
     *
     * @param source (String) Nombre del archivo o directorio que se moverá.
     * @param target (String) Ruta objetivo en la que se moverán los archivos.
     */
    public void move(String source, String target);

    /**
     * Permite renombrar un archivo o directorio en el sistema.
     *
     * @param currentName (String) Nombre original del archivo o directorio.
     * @param newName (String) Nuevo nombre del archivo o directorio.
     */
    public void ren(String currentName, String newName);

    /**
     * Permite listar el contenido de un directorio específico o de toda una ruta, lo que se
     * determina mediante parámetros.
     *
     * @param params (ArrayList<String>) Lista de parámetros para listar el contenido del directorio.
     */
    public void dir(ArrayList<String> params);

    /**
     * Permite formatear un drive del sistema.
     *
     * @param letter (String) Letra del drive que será formateado.
     * @param name (String) Nuevo nombre del drive que será formateado.
     */
    public void format(String letter, String name);
}
