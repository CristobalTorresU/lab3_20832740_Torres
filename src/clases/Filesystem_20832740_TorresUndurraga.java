package clases;

import java.time.Instant;
import java.util.ArrayList;
import interfaces.*;
import java.util.Comparator;

/**
 * Clase que representa el sistema de archivos.
 * El sistema de archivos tiene un nombre, fecha de creación,
 * usuario que tiene la sesión iniciada, letra de la unidad
 * fijada, lista de unidades del sistema, lista de usuarios
 * registrados en el sistema, lista de carpetas creadas y
 * una lista de archivos creados.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public class Filesystem_20832740_TorresUndurraga implements IFilesystem_20832740_TorresUndurraga {
    // Atributos
    private String name;
    private long fechaCreacion;
    private String loggedUser;
    private String driveActual;
    private String rutaActual;
    private ArrayList<IDrive_20832740_TorresUndurraga> drives;
    private ArrayList<IUser_20832740_TorresUndurraga> users;
    private ArrayList<IFolder_20832740_TorresUndurraga> folders;
    private ArrayList<IFile_20832740_TorresUndurraga> files;
    
    // Métodos
    
    // Constructor
    public Filesystem_20832740_TorresUndurraga(String name){
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
    /**
     * Obtiene el nombre del sistema.
     *
     * @return String nombre del sistema.
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * Obtiene la fecha de creación del sistema.
     *
     * @return long fecha de creación en formato Epoch.
     */
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }

    /**
     * Obtiene las unidades del sistema.
     *
     * @return ArrayList<IDrive> Lista con las unidades del sistema.
     */
    @Override
    public ArrayList<IDrive_20832740_TorresUndurraga> getDrives(){
        return drives;
    }

    /**
     * Obtiene el nombre de usuario que ha iniciado sesión.
     *
     * @return String nombre del usuario con una sesión iniciada.
     */
    @Override
    public String getLoggedUser(){
        return loggedUser;
    }

    /**
     * Obtiene los usuarios registrados en el sistema.
     *
     * @return ArrayList<IUser> Lista de usuarios registrados en el sistema.
     */
    @Override
    public ArrayList<IUser_20832740_TorresUndurraga> getUsers(){
        return users;
    }

    /**
     * Obtiene la unidad con la que se está trabajando.
     *
     * @return String Letra de la unidad en la que se realizan las operaciones.
     */
    @Override
    public String getDriveActual(){
        return driveActual;
    }

    /**
     * Obtiene la ruta actual del sistema.
     *
     * @return String La ruta en que se realizan las operaciones en el sistema.
     */
    @Override
    public String getRutaActual(){
        return rutaActual;
    }

    /**
     * Obtiene las carpetas que existen en el sistema.
     *
     * @return ArrayList<IFolder> Lista de carpetas creadas en el sistema.
     */
    @Override
    public ArrayList<IFolder_20832740_TorresUndurraga> getFolders(){
        return folders;
    }

    /**
     * Obtiene los archivos que existen en el sistema.
     *
     * @return ArrayList<IFile> Lista de archivos creados en el sistema.
     */
    @Override
    public ArrayList<IFile_20832740_TorresUndurraga> getFiles(){
        return files;
    }

    // Modificadores
    /**
     * Modifica las unidades existentes en el sistema.
     *
     * @param drives (ArrayList<IDrive>) Lista de unidades que se reemplazará en el sistema.
     */
    @Override
    public void setDrives(ArrayList<IDrive_20832740_TorresUndurraga> drives){
        this.drives = drives;
    }

    /**
     * Modifica el usuario que ha iniciado sesión en el sistema.
     *
     * @param userName (String) Nombre del usuario que iniciará sesión.
     */
    @Override
    public void setLoggedUser(String userName){
        this.loggedUser = userName;
    }

    /**
     * Modifica la unidad fijada en el sistema.
     *
     * @param letter (String) Letra del sistema que será fijado.
     */
    @Override
    public void setDriveActual(String letter){
        this.driveActual = letter;
    }

    /**
     * Modifica la lista de usuarios que existe en el sistema.
     *
     * @param users (ArrayList<IUser>) Lista de usuarios que se reemplazará en el sistema.
     */
    @Override
    public void setUsers(ArrayList<IUser_20832740_TorresUndurraga> users){
        this.users = users;
    }

    /**
     * Modifica la ruta en que se realizan las operaciones en el sistema.
     *
     * @param rutaActual (String) Ruta actual que será fijada.
     */
    @Override
    public void setRutaActual(String rutaActual){
        this.rutaActual = rutaActual;
    }

    /**
     * Modifica la lista de carpetas que existe en el sistema.
     *
     * @param folders (ArrayList<IFolder>) Lista de carpetas que se reemplazará en el sistema.
     */
    @Override
    public void setFolders(ArrayList<IFolder_20832740_TorresUndurraga> folders){
        this.folders = folders;
    }

    /**
     * Modifica la lista de archivos que existe en el sistema.
     *
     * @param files (ArrayList<IFile>) Lista de archivos que se reemplazará en el sistema.
     */
    @Override
    public void setFiles(ArrayList<IFile_20832740_TorresUndurraga> files){
        this.files = files;
    }


    // Otras Operaciones
    /**
     * Añade una unidad a la lista de unidades del sistema.
     *
     * @param newDrive (IDrive) Unidad que se agregará al sistema.
     */
    @Override
    public void agregarDrive(IDrive_20832740_TorresUndurraga newDrive){
        ArrayList<IDrive_20832740_TorresUndurraga> listaDrives = getDrives();
        listaDrives.add(newDrive);
        setDrives(listaDrives);
    }

    /**
     * Añade un usuario a la lista de usuarios del sistema.
     *
     * @param newUser (IUser) Usuario que se agregará al sistema.
     */
    @Override
    public void agregarUser(IUser_20832740_TorresUndurraga newUser){
        ArrayList<IUser_20832740_TorresUndurraga> listaUsers = getUsers();
        listaUsers.add(newUser);
        setUsers(listaUsers);
    }

    /**
     * Añade una carpeta a la lista de carpetas del sistema.
     *
     * @param newFolder (IFolder) Carpeta que se agregará al sistema.
     */
    @Override
    public void agregarFolder(IFolder_20832740_TorresUndurraga newFolder){
        ArrayList<IFolder_20832740_TorresUndurraga> listaFolders = getFolders();
        listaFolders.add(newFolder);
        setFolders(listaFolders);
    }

    /**
     * Añade un archivo a la lista de archivos del sistema.
     *
     * @param newFile (IFile) Archivo que se agregará al sistema.
     */
    @Override
    public void agregarFile(IFile_20832740_TorresUndurraga newFile){
        ArrayList<IFile_20832740_TorresUndurraga> listaFiles = getFiles();
        listaFiles.add(newFile);
        setFiles(listaFiles);
    }

    /**
     * Comprueba si existe una unidad en el sistema.
     *
     * @param letra (String) Letra de la unidad que se está buscando.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    @Override
    public boolean buscarDrive(String letra){
        int largo = this.getDrives().size();
        for(int i = 0 ; i < largo ; ++i){
            IDrive_20832740_TorresUndurraga drive = getDrives().get(i);
            if(drive.getLetra().equalsIgnoreCase(letra)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Comprueba si existe un usuario en el sistema.
     *
     * @param userName (String) Nombre del usuario que se está buscando.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    @Override
    public boolean buscarUser(String userName){
        int largo = this.getUsers().size();
        for(int i = 0 ; i < largo ; ++i){
            IUser_20832740_TorresUndurraga user = getUsers().get(i);
            if(user.getName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Comprueba si existe una carpeta en el sistema.
     *
     * @param ruta (String) Ruta de la carpeta que se está buscando.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    @Override
    public boolean buscarFolder(String ruta){
        int largo = this.getFolders().size();
        for(int i = 0 ; i < largo ; ++i){
            IFolder_20832740_TorresUndurraga folder = getFolders().get(i);
            if(folder.getRuta().equalsIgnoreCase(ruta)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Comprueba si existe un archivo en el sistema.
     *
     * @param nombre (String) Nombre del archivo que se está buscando.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    @Override
    public boolean buscarFile(String nombre, String ruta){
        int largo = this.getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            IFile_20832740_TorresUndurraga file = getFiles().get(i);
            if(file.getNombreSinExtension().equalsIgnoreCase(nombre) && file.getRuta().equalsIgnoreCase(ruta)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Comprueba si existe un archivo en el sistema, sin utilizar la extensión del archivo.
     *
     * @param nombre (String) Nombre sin extensión del archivo que se está buscando.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     * @return boolean "true" si es que existe, "false" en el caso contrario.
     */
    @Override
    public boolean buscarFileConExtension(String nombre, String ruta){
        int largo = this.getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            IFile_20832740_TorresUndurraga file = getFiles().get(i);
            if(file.getNombre().equalsIgnoreCase(nombre) && file.getRuta().equalsIgnoreCase(ruta)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Elimina un archivo del sistema, modificando el atributo "eliminado".
     *
     * @param nombre (String) Nombre del archivo que se quire eliminar.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     */
    @Override
    public void eliminarFile(String nombre, String ruta){
        int largo = this.getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            if(getFiles().get(i).getNombre().equalsIgnoreCase(nombre) && getFiles().get(i).getRuta().equalsIgnoreCase(ruta)){
                getFiles().get(i).setEliminado(true);
            }
        }
    }

    /**
     * Elimina una carpeta del sistema, modificando el atributo "eliminado".
     *
     * @param ruta (String) Ruta correspondiente a la carpeta que se quiere eliminar.
     */
    @Override
    public void eliminarFolder(String ruta){
        int largoF = getFolders().size();
        String rutaF;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta) || getFolders().get(i).subdirectorio(ruta)){
                getFolders().get(i).setEliminado(true);
            }
        }
        
        int largoFi = getFiles().size();
        String rutaFi;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta) || getFiles().get(i).subdirectorio(ruta)){
                getFiles().get(i).setEliminado(true);
            }
        }
    }

    /**
     * Copia una carpeta y sus contenidos a una ruta objetivo.
     *
     * @param source (String) Nombre del directorio que se copiará.
     * @param ruta (String) Ruta de la carpeta que se copiará.
     * @param target (String) Ruta objetivo a la que se copiarán los elementos.
     */
    @Override
    public void copiarFolder(String source, String ruta, String target){
        int largoF = getFolders().size();
        String rutaF;
        IFolder_20832740_TorresUndurraga folder;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta)){
                folder = new Folder_20832740_TorresUndurraga(getFolders().get(i).getNombre(), target + source + "/", getFolders().get(i).getCreador());
                agregarFolder(folder);
            } else if(getFolders().get(i).subdirectorio(ruta)){
                folder = new Folder_20832740_TorresUndurraga(getFolders().get(i).getNombre(), cambiarRuta(ruta.split("/").length, getFolders().get(i).getRuta(), target + source + "/"), getFolders().get(i).getCreador());
                agregarFolder(folder);
            }
        }

        int largoFi = getFiles().size();
        String rutaFi;
        IFile_20832740_TorresUndurraga file;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta) || getFiles().get(i).subdirectorio(ruta)){
                String extension = getFiles().get(i).getExtension();
                switch(extension){
                    case "txt":
                    case "md":
                        file = new TextoPlano_20832740_TorresUndurraga(getFiles().get(i).getNombre(), extension, getFiles().get(i).getContenido(), cambiarRuta(ruta.split("/").length, getFolders().get(i).getRuta(), target + source + "/"));
                        agregarFile(file);
                        break;
                    case "docx":
                    case "pdf":
                    case "tex":
                        file = new Documento_20832740_TorresUndurraga(getFiles().get(i).getNombre(), extension, getFiles().get(i).getContenido(), cambiarRuta(ruta.split("/").length, getFolders().get(i).getRuta(), target + source + "/"));
                        agregarFile(file);
                        break;
                    case "py":
                    case "c":
                    case "java":
                    case "rkt":
                    case "pl":
                        file = new CodigoFuente_20832740_TorresUndurraga(getFiles().get(i).getNombre(), extension, getFiles().get(i).getContenido(), cambiarRuta(ruta.split("/").length, getFolders().get(i).getRuta(), target + source + "/"));
                        agregarFile(file);
                        break;
                }
            }
        }
    }

    /**
     * Mueve una carpeta y sus contenidos a una ruta objetivo.
     *
     * @param source (String) Nombre de la carpeta que se moverá.
     * @param ruta (String) Ruta de la carpeta que se moverá.
     * @param target (String) Ruta objetivo en la que se moverá la carpeta.
     */
    @Override
    public void moverFolder(String source, String ruta, String target){
        int largoF = getFolders().size();
        String rutaF;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta)){
                getFolders().get(i).setRuta(target + source + "/");
            } else if(folders.get(i).subdirectorio(ruta)){
                getFolders().get(i).setRuta(cambiarRuta(ruta.split("/").length, getFolders().get(i).getRuta(), target + source + "/"));
            }
        }
        
        int largoFi = getFiles().size();
        String rutaFi;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta)){
                getFiles().get(i).setRuta(target + source + "/");
            } else if(getFiles().get(i).subdirectorio(ruta)){
                getFiles().get(i).setRuta(cambiarRuta(ruta.split("/").length, getFiles().get(i).getRuta() , target + source + "/"));
            }
        }
    }

    /**
     * Obtiene un archivo en específico.
     *
     * @param nombre (String) Nombre del archivo que se busca.
     * @param ruta (String) Ruta en que se encuentra el archivo que se busca.
     * @return IFile Archivo buscado.
     */
    @Override
    public IFile_20832740_TorresUndurraga getFile(String nombre, String ruta){
        int largo = getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            IFile_20832740_TorresUndurraga file = getFiles().get(i);
            if(file.getNombreSinExtension().equals(nombre) && file.getRuta().equals(ruta)){
                return file;
            }
        }
        return null;
    }

    /**
     * Obtiene una carpeta en específico.
     *
     * @param ruta (String) Ruta de la carpeta que se busca.
     * @return IFolder Carpeta buscada.
     */
    @Override
    public IFolder_20832740_TorresUndurraga getFolder(String ruta){
        int largo = getFolders().size();
        for(int i = 0 ; i < largo ; ++i){
            IFolder_20832740_TorresUndurraga folder = getFolders().get(i);
            if(folder.getRuta().equals(ruta)){
                return folder;
            }
        }
        return null;
    }

    /**
     * Sobreescribe la extensión y el contenido de un archivo.
     *
     * @param nombre (String) Nombre sin extensión del archivo.
     * @param ruta (String) Ruta en que se encuentra el archivo.
     * @param contenido (String) Contenido que se reemplazará en el archivo.
     * @param extension (String) Nombre la extensión que se sobreescribirá en el archivo.
     */
    @Override
    public void sobreescribirFile(String nombre, String ruta, String contenido, String extension){
        int largo = this.getFiles().size();
        String nombreSinExtension = nombre.split("\\.")[0];
        for(int i = 0 ; i < largo ; ++i){
            if(getFiles().get(i).getNombreSinExtension().equals(nombreSinExtension) && getFiles().get(i).getRuta().equals(ruta)){
                getFiles().get(i).setNombre(nombre);
                getFiles().get(i).setExtension(extension);
                getFiles().get(i).setContenido(contenido);
                getFiles().get(i).setTipo(extension);
                return;
            }
        }
    }

    /**
     * Quita un archivo de la lista de archivos.
     *
     * @param nombre (String) Nombre del archivo que se removerá.
     * @param ruta (String) Ruta en que se encuentra el archivo que se removerá.
     */
    @Override
    public void desaparecerFile(String nombre, String ruta){
        int largo = getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            if(getFiles().get(i).getNombre().equals(nombre) && getFiles().get(i).getRuta().equals(ruta)){
                getFiles().remove(i);
                return;
            }
        }
    }

    /**
     * Quita una carpeta de la lista de carpetas.
     *
     * @param ruta (String) Ruta en que se encuentra la carpeta que se removerá.
     */
    @Override
    public void desaparecerFolder(String ruta){
        int largoF = getFolders().size();
        String rutaF;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta) || getFolders().get(i).subdirectorio(ruta)){
                getFolders().remove(i);
                i -= 1;
                largoF -= 1;
            }
        }

        int largoFi = getFiles().size();
        String rutaFi;
        for(int i = 0 ; i < largoFi ; ++i){
            rutaFi = getFiles().get(i).getRuta();
            if(rutaFi.equals(ruta) || getFiles().get(i).subdirectorio(ruta)){
                getFiles().remove(i);
                i -= 1;
                largoFi -= 1;
            }
        }
    }

    /**
     * Cambia una ruta ingresada por una nueva fuente.
     *
     * @param n (int) Largo de la fuente nueva.
     * @param rutaOriginal (String) Ruta que será modificada.
     * @param fuenteNueva (String) Fuente que será reemplazada en la ruta.
     * @return String Ruta renovada.
     */
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

    /**
     * Modifica el nombre de una carpeta y todas las rutas de sus subdirectorios.
     *
     * @param currentName (String) Nombre actual de la carpeta que será modificada.
     * @param newName (String) Nuevo nombre que se usará en la carpeta.
     */
    @Override
    public void renombrarCarpetas(String currentName, String newName){
        int largo = getFolders().size();
        int n = (getRutaActual()+newName+"/").split("/").length;
        for(int i = 0 ; i < largo ; ++i){
            if(getFolders().get(i).getRuta().equals(getRutaActual()+currentName+"/")){
                getFolders().get(i).cambiarNombre(newName);
                getFolders().get(i).actualizarFechaModificacion();
            } else if(getFolders().get(i).subdirectorio(getRutaActual()+currentName+"/")){
                getFolders().get(i).setRuta(cambiarRuta(n, getFolders().get(i).getRuta(), getRutaActual()+newName+"/"));
            }
        }

        largo = getFiles().size();
        for(int i = 0 ; i < largo ; ++i){
            if(getFiles().get(i).getRuta().equals(getRutaActual()+currentName+"/")){
                getFiles().get(i).modificarRuta(newName);
            } else if(getFiles().get(i).subdirectorio(getRutaActual()+currentName+"/")){
                getFiles().get(i).setRuta(cambiarRuta(n, getFiles().get(i).getRuta(), getRutaActual()+newName+"/"));
            }
        }
    }

    /**
     * Genera un archivo del tipo correspondiente a la extensión ingresada.
     *
     * @param nombre (String)
     * @param contenido (String)
     * @return IFile el archivo generado.
     */
    @Override
    public IFile_20832740_TorresUndurraga generarFile(String nombre, String contenido){
        IFile_20832740_TorresUndurraga newFile;
        String extension = nombre.split("\\.")[1];
        switch(extension){
        case "txt":
        case "md":
            newFile = new TextoPlano_20832740_TorresUndurraga(nombre, extension, contenido, getRutaActual());
            return newFile;
        case "docx":
        case "pdf":
        case "tex":
            newFile = new Documento_20832740_TorresUndurraga(nombre, extension, contenido, getRutaActual());
            return newFile;
        case "py":
        case "c":
        case "java":
        case "rkt":
        case "pl":
            newFile = new CodigoFuente_20832740_TorresUndurraga(nombre, extension, contenido, getRutaActual());
            return newFile;
        default:
            System.out.println("La extensión ingresada no esá permitida.");
            newFile = new TextoPlano_20832740_TorresUndurraga(null, "", null,null);
            return newFile;
        }
    }



    // Requerimientos Funcionales
    /**
     * Permite agregar unidades al sistema. Cada unidad es única.
     *
     * @param letter (String) Letra de la unidad que se agregará.
     * @param name (String) Nombre de la unidad que se agregará.
     * @param capacity (int) Capacidad de la unidad que se agregará.
     */
    @Override
    public void addDrive(String letter, String name, int capacity){
        // Verificar que no exista
        if(letter.length() != 1){
            System.out.println("La letra ingresada solo debe ser 1 caracter.");
            return;
        }
        if(!buscarDrive(letter)){
            // Agregar a la ArrayList
            IDrive_20832740_TorresUndurraga newDrive = new Drive_20832740_TorresUndurraga(letter,name,capacity);
            agregarDrive(newDrive);
            IFolder_20832740_TorresUndurraga newFolder = new Folder_20832740_TorresUndurraga(letter, letter + ":/", getLoggedUser());
            agregarFolder(newFolder);
            System.out.println("La unidad se agregó correctamente.");
            return;
        }

        System.out.println("La unidad ingresada ya existe.");
    }

    /**
     * Permite registrar usuarios en el sistema. Cada usuario es único.
     *
     * @param userName (String) Nombre del usuario que será registrado.
     */
    @Override
    public void register(String userName){
        // Verificar que no exista
        if(!buscarUser(userName)){
            if(!userName.equals("")){
                // Agregar a la ArrayList
                IUser_20832740_TorresUndurraga newUser = new User_20832740_TorresUndurraga(userName.toLowerCase());
                agregarUser(newUser);
                System.out.println("El usuario se registró correctamente.");
                return;
            }
            System.out.println("Nombre de usuario inválido.");
        }
        System.out.println("El usuario ya existe.");
    }

    /**
     * Permite iniciar sesión con uno de los usuarios ya registrados en el sistema.
     *
     * @param userName (String) Nombre del usuario con el que se iniciará sesión.
     */
    @Override
    public void login(String userName){
        // Verificar que exista
        if(!getLoggedUser().equals("")){
            System.out.println("Cierre la sesión actual antes de iniciar otra.");
        } else if(buscarUser(userName)){
            // Cambiar el usuario
            setLoggedUser(userName.toLowerCase());
            System.out.println("Se inició sesión correctamente.");
        } else {
            System.out.println("El usuario ingresado no está registrado.");
        }
    }

    /**
     * Permite cerrar sesión en el sistema.
     */
    @Override
    public void logout(){
        // Verificar que exista un usuario con la sesión iniciada
        if(!getLoggedUser().equals("")){
            // Cerrar sesión
            setLoggedUser("");
            System.out.println("Se cerró la sesión correctamente.");
            return;
        }
        
        System.out.println("No existe una sesión iniciada.");
    }

    /**
     * Permite fijar una unidad en el sistema para realizar las operaciones en el sistema.
     * Debe existir una sesión iniciada para ejecutarse.
     *
     * @param letter (String) Letra de la unidad que se fijará.
     */
    @Override
    public void switchDrive(String letter){
        // Verificar que exista el drive y un usuario con la sesión iniciada
        if(buscarDrive(letter)){
            if(!getLoggedUser().equals("")){
                // Cambiar Drive
                setDriveActual(letter.toLowerCase());
                setRutaActual(letter.toLowerCase() + ":/");
                System.out.println("Se cambió de unidad correctamente.");
                return;
            }
            System.out.println("Debe iniciar sesión para cambiar de unidad.");
        }
        
        System.out.println("La unidad ingresada no existe.");
    }

    /**
     * Permite crear y agregar un directorio en el sistema. Cada directorio es único en su ruta.
     *
     * @param name (String) Nombre del directorio que se creará.
     */
    @Override
    public void mkdir(String name) {
        String ruta = getRutaActual() + name.toLowerCase() + "/";
        // Verificar que el nombre de la carpeta no exista en la ruta
        if(name.equals("")) {
            System.out.println("Nombre inválido.");
            return;
        } else if(!buscarFolder(ruta)){
            String creador = getLoggedUser();
            IFolder_20832740_TorresUndurraga newFolder = new Folder_20832740_TorresUndurraga(name.toLowerCase(), ruta.toLowerCase(), creador);
            agregarFolder(newFolder);
            getFolder(getRutaActual()).actualizarFechaModificacion();
            System.out.println("La carpeta se creó exitosamente.");
            return;
        }
        
        System.out.println("La carpeta ya existe en el directorio.");
    }

    /**
     * Permite cambiar la ruta actual del sistema.
     *
     * @param path (String) Nombre de la carpeta o ruta a la que se cambiará.
     */
    @Override
    public void cd(String path){
        // Comandos predeterminados
        switch(path){
            case "..":
                if(getRutaActual().split("/").length > 1){
                   String[] ruta = getRutaActual().split("/");
                   int largo = ruta.length;
                   String newRuta = "";
                   for(int i = 0 ; i < largo - 1 ; ++i){
                       newRuta = newRuta + ruta[i] + "/";
                   }
                   
                   setRutaActual(newRuta);
                   System.out.println("Se cambió al directorio padre.");
                   return;
                }
                System.out.println("Ya se encuentra en la carpeta raíz.");
                return;
            case "/":
                setRutaActual(getDriveActual() + ":/");
                System.out.println("Se cambió al directorio raíz.");
                return;
            case ".":
                System.out.println("Se cambió al mismo directorio.");
                return;
        }

        // Verificar que la ruta exista
        String ruta = getRutaActual() + path + "/";

        if(buscarFolder(path)){
            setRutaActual(path.toLowerCase());
            setDriveActual(path.toLowerCase().split(":/")[0]);
            System.out.println("Se cambió a la ruta satisfactoriamente.");
        } else if(buscarFolder(ruta)){ // Verificar que la carpeta exista
            setRutaActual(ruta.toLowerCase());
            System.out.println("Se cambió al directorio satisfactoriamente.");
        } else {
            System.out.println("El directorio ingresado no existe.");
        }
    }

    /**
     * Permite agregar un archivo al sistema. Cada archivo es único en su ruta.
     *
     * @param archivo (IFile) Archivo que se agregará al sistema.
     */
    @Override
    public void addFile(IFile_20832740_TorresUndurraga archivo){
        // Verificar si el archivo no existe en el directorio
        if(archivo.getExtension().equals("")){
            return;
        }else if(!buscarFile(archivo.getNombreSinExtension(), archivo.getRuta())){
            agregarFile(archivo);
            getFolder(getRutaActual()).actualizarFechaModificacion();
            System.out.println("El archivo se agregó exitosamente.");
        } else if(buscarFile(archivo.getNombreSinExtension(), archivo.getRuta())){ // Si existe
            String nombre = archivo.getNombre();
            String ruta = archivo.getRuta();
            String contenido = archivo.getContenido();
            String extension = archivo.getExtension();
            sobreescribirFile(nombre, ruta, contenido, extension);
            getFolder(getRutaActual()).actualizarFechaModificacion();
            System.out.println("El archivo se sobreescribió exitosamente.");
        }
    }

    /**
     * Permite eliminar un archivo o directorio del sistema y enviarlo a la papelera.
     *
     * @param fileName (String) Nombre del archivo o carpeta que se desea eliminar.
     */
    @Override
    public void del(String fileName){
        // Es un archivo
        if(buscarFileConExtension(fileName, getRutaActual())){
            eliminarFile(fileName, getRutaActual());
            getFolder(getRutaActual()).actualizarFechaModificacion();
            System.out.println("El archivo se eliminó exitosamente.");
        } else if(buscarFolder(getRutaActual() + fileName + "/")){ // Es una carpeta
            eliminarFolder(getRutaActual() + fileName + "/");
            getFolder(getRutaActual()).actualizarFechaModificacion();
            System.out.println("La carpeta se eliminó exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }

    /**
     * Permite copiar un archivo o directorio a un directorio objetivo, siempre y
     * cuando no se rompa la unicidad dentro del directorio.
     *
     * @param source (String) Nombre del archivo o directorio que será copiado.
     * @param target (String) Ruta objetivo en la que se copiarán los archivos.
     */
    @Override
    public void copy(String source, String target){
        String rutaA = getRutaActual();
        // Archivo
        if(source.contains("*")){
            int largo = getFiles().size();
            if(source.startsWith("*")){ // "*" al comienzo
                for(int i = 0 ; i < largo ; ++i){
                    if(getFiles().get(i).getExtension().equals(source.split("\\.")[1]) && getFiles().get(i).getRuta().equals(getRutaActual()) && !buscarFile(getFiles().get(i).getNombreSinExtension(), target)){
                        IFile_20832740_TorresUndurraga newFile;
                        String nombre = getFiles().get(i).getNombre();
                        String extension = getFiles().get(i).getExtension();
                        String contenido = getFiles().get(i).getContenido();
                        switch (extension) {
                            case "txt":
                            case "md":
                                newFile = new TextoPlano_20832740_TorresUndurraga(nombre, extension, contenido, target);
                                agregarFile(newFile);
                                getFolder(target).actualizarFechaModificacion();
                                break;
                            case "docx":
                            case "pdf":
                            case "tex":
                                newFile = new Documento_20832740_TorresUndurraga(nombre, extension, contenido, target);
                                agregarFile(newFile);
                                getFolder(target).actualizarFechaModificacion();
                                break;
                            case "py":
                            case "c":
                            case "java":
                            case "rkt":
                            case "pl":
                                newFile = new CodigoFuente_20832740_TorresUndurraga(nombre, extension, contenido, target);
                                agregarFile(newFile);
                                getFolder(target).actualizarFechaModificacion();
                                break;
                        }
                    }
                }
                System.out.println("Los archivos se copiaron exitosamente.");
            } else if(source.endsWith("*")){ // "*" al final
                for(int i = 0 ; i < largo ; ++i){
                    if(getFiles().get(i).getNombre().startsWith(source.split("\\*")[0]) && getFiles().get(i).getRuta().equals(getRutaActual()) && !buscarFile(getFiles().get(i).getNombreSinExtension(), target)){
                        IFile_20832740_TorresUndurraga newFile;
                        String nombre = getFiles().get(i).getNombre();
                        String extension = getFiles().get(i).getExtension();
                        String contenido = getFiles().get(i).getContenido();
                        switch (extension) {
                            case "txt":
                            case "md":
                                newFile = new TextoPlano_20832740_TorresUndurraga(nombre, extension, contenido, target);
                                getFolder(target).actualizarFechaModificacion();
                                agregarFile(newFile);
                                break;
                            case "docx":
                            case "pdf":
                            case "tex":
                                newFile = new Documento_20832740_TorresUndurraga(nombre, extension, contenido, target);
                                getFolder(target).actualizarFechaModificacion();
                                agregarFile(newFile);
                                break;
                            case "py":
                            case "c":
                            case "java":
                            case "rkt":
                            case "pl":
                                newFile = new CodigoFuente_20832740_TorresUndurraga(nombre, extension, contenido, target);
                                getFolder(target).actualizarFechaModificacion();
                                agregarFile(newFile);
                                break;
                        }
                    }
                }
                System.out.println("Los archivos se copiaron exitosamente.");
            }
        } else if(buscarFile(source.split("\\.")[0], rutaA) && buscarFolder(target)){
            if(!buscarFile(source.split("\\.")[0], target)) {
                IFile_20832740_TorresUndurraga newFile;
                String nombre = getFile(source.split("\\.")[0], getRutaActual()).getNombre();
                String extension = getFile(source.split("\\.")[0], getRutaActual()).getExtension();
                String contenido = getFile(source.split("\\.")[0], getRutaActual()).getContenido();
                switch (extension) {
                    case "txt":
                    case "md":
                        newFile = new TextoPlano_20832740_TorresUndurraga(nombre, extension, contenido, target);
                        getFolder(target).actualizarFechaModificacion();
                        agregarFile(newFile);
                        break;
                    case "docx":
                    case "pdf":
                    case "tex":
                        newFile = new Documento_20832740_TorresUndurraga(nombre, extension, contenido, target);
                        getFolder(target).actualizarFechaModificacion();
                        agregarFile(newFile);
                        break;
                    case "py":
                    case "c":
                    case "java":
                    case "rkt":
                    case "pl":
                        newFile = new CodigoFuente_20832740_TorresUndurraga(nombre, extension, contenido, target);
                        getFolder(target).actualizarFechaModificacion();
                        agregarFile(newFile);
                        break;
                }
                System.out.println("El archivo fue copiado exitosamente.");
            } else {
                System.out.println("El archivo ya existe en el directorio objetivo.");
            }
        } else if(source.split("\\.").length != 2 && buscarFolder(rutaA) && buscarFolder(target)) {  // Carpeta
            if(!buscarFolder(target + source + "/")) {
                copiarFolder(source, rutaA + source + "/", target);
                getFolder(target).actualizarFechaModificacion();
                System.out.println("La carpeta fue copiada exitosamente.");
            } else {
                System.out.println("La carpeta ya existe en el directorio objetivo.");
            }
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }

    /**
     * Permite mover un archivo o directorio a una ruta objetivo. En caso de que
     * ya exista, se sobreescribe.
     *
     * @param source (String) Nombre del archivo o directorio que se moverá.
     * @param target (String) Ruta objetivo en la que se moverán los archivos.
     */
    @Override
    public void move(String source, String target){
        // Archivo
        String rutaA = getRutaActual();
        if(buscarFile(source.split("\\.")[0], rutaA) && buscarFolder(target)){
            if(!buscarFile(source.split("\\.")[0], target)){
                getFile(source.split("\\.")[0], getRutaActual()).setRuta(target);
                getFolder(getRutaActual()).actualizarFechaModificacion();
                getFolder(target).actualizarFechaModificacion();
                System.out.println("El archivo se movió exitosamente.");
            } else if(buscarFile(source.split("\\.")[0], target)){
                String nombre = getFile(source.split("\\.")[0], getRutaActual()).getNombre();
                String contenido = getFile(source.split("\\.")[0], getRutaActual()).getContenido();
                String extension = getFile(source.split("\\.")[0], getRutaActual()).getExtension();
                sobreescribirFile(nombre, target, contenido, extension);
                desaparecerFile(source, rutaA);
                System.out.println("El archivo se sobreescribió exitosamente.");
            }
        } else if(source.split("\\.").length != 2 && buscarFolder(rutaA) && buscarFolder(target)) {  // Carpeta
            if(!buscarFolder(target + source + "/")) { // Solo mueve carpeta
                moverFolder(source, rutaA + source + "/", target);
                getFolder(getRutaActual()).actualizarFechaModificacion();
                getFolder(target).actualizarFechaModificacion();
                System.out.println("La carpeta se movió exitosamente.");
            } else if(buscarFolder(target + source + "/")) { // Mueve y sobreescribe carpeta
                desaparecerFolder(target + source + "/");
                moverFolder(source, rutaA + source + "/", target);
                getFolder(getRutaActual()).actualizarFechaModificacion();
                getFolder(target).actualizarFechaModificacion();
                System.out.println("La carpeta se sobreescribió exitosamente.");
            }
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }

    /**
     * Permite renombrar un archivo o directorio en el sistema.
     *
     * @param currentName (String) Nombre original del archivo o directorio.
     * @param newName (String) Nuevo nombre del archivo o directorio.
     */
    @Override
    public void ren(String currentName, String newName){
        String rutaA = getRutaActual();
        // Archivo
        if(buscarFileConExtension(currentName, rutaA)){
            getFile(currentName.toLowerCase().split("\\.")[0], rutaA).setRuta(newName.toLowerCase());
            getFolder(getRutaActual()).actualizarFechaModificacion();
            System.out.println("El archivo se renombró exitosamente.");
        } else if(buscarFolder(rutaA+currentName+"/")){ // Carpeta
            if(!buscarFolder(rutaA + newName + "/")) {
                renombrarCarpetas(currentName.toLowerCase(), newName.toLowerCase());
                getFolder(getRutaActual()).actualizarFechaModificacion();
                System.out.println("La carpeta se renombró exitosamente.");
            } else {
                System.out.println("El nuevo nombre ingresado ya existe en el directorio.");
            }
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }

    /**
     * Permite listar el contenido de un directorio específico o de toda una ruta, lo que se
     * determina mediante parámetros.
     *
     * @param params (ArrayList<String>) Lista de parámetros para listar el contenido del directorio.
     */
    @Override
    public void dir(ArrayList<String> params){
        String salida = "";
        int largo;
        int n;
        
        if(params.contains("")){
            salida += getRutaActual();
            largo = getFolders().size();
            n = getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(!getFolders().get(i).getEliminado() && getFolders().get(i).subdirectorio(getRutaActual()) && getFolders().get(i).getRuta().split("/").length == n+1){
                   salida += "\n" + getFolders().get(i).getNombre();
                }
            }
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(!getFiles().get(i).getEliminado() && getFiles().get(i).getRuta().equals(getRutaActual())){
                    salida += "\n" + getFiles().get(i).getNombre();
                }
            }
            System.out.println(salida+"\n");
        } else if(params.contains("/a") && params.contains("/s")){
            
        } else if(params.contains("/s")){
            largo = getFolders().size();
            for(int i = 0 ; i < largo ; ++i){
                if(!getFolders().get(i).getEliminado() && (getFolders().get(i).getRuta().equals(getRutaActual()) || getFolders().get(i).subdirectorio(getRutaActual()))){
                    salida += getFolders().get(i).getRuta();
                    n = getFolders().get(i).getRuta().split("/").length;
                    for(int j = 0 ; j < largo ; ++j){
                        if(!getFolders().get(i).getEliminado() && getFolders().get(i).subdirectorio(getFolders().get(i).getRuta()) && getFolders().get(i).getRuta().split("/").length == n+1){
                            salida += "\n" + getFolders().get(i).getNombre();
                        }
                    }
                    largo = getFiles().size();
                    for(int j = 0 ; j < getFiles().size() ; ++j){
                        if(!getFiles().get(i).getEliminado() && getFiles().get(i).getRuta().equals(getFolders().get(i).getRuta())){
                            salida += "\n" + getFiles().get(i).getNombre();
                        }
                    }
                    salida += "\n\n";
                }
            }
            System.out.println(salida+"\n");
        } else if(params.contains("/a")){
            
        } else if(params.contains("/o N")){
            salida += getRutaActual();
            ArrayList<String> nombres = new ArrayList<>();
            largo = getFolders().size();
            n = getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(!getFolders().get(i).getEliminado() && getFolders().get(i).subdirectorio(getRutaActual()) && getFolders().get(i).getRuta().split("/").length == n+1){
                    nombres.add(getFolders().get(i).getNombre());
                }
            }
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(!getFiles().get(i).getEliminado() && getFiles().get(i).getRuta().equals(getRutaActual())){
                    nombres.add(getFiles().get(i).getNombre());
                }
            }
            nombres.sort(Comparator.naturalOrder());
            largo = nombres.size();
            for(int i = 0 ; i < largo ; ++i){
                salida += "\n" + nombres.get(i);
            }
            System.out.println(salida+"\n");
        } else if(params.contains("/o -N")){
            salida += getRutaActual();
            ArrayList<String> nombres = new ArrayList<>();
            largo = getFolders().size();
            n = getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(!getFolders().get(i).getEliminado() && getFolders().get(i).subdirectorio(getRutaActual()) && getFolders().get(i).getRuta().split("/").length == n+1){
                    nombres.add(getFolders().get(i).getNombre());
                }
            }
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(!getFiles().get(i).getEliminado() && getFiles().get(i).getRuta().equals(getRutaActual())){
                    nombres.add(getFiles().get(i).getNombre());
                }
            }
            nombres.sort(Comparator.reverseOrder());
            largo = nombres.size();
            for(int i = 0 ; i < largo ; ++i){
                salida += "\n" + nombres.get(i);
            }
            System.out.println(salida+"\n");
        } else if(params.contains("/o D")){

        } else if(params.contains("/o -D")){
            
        } else if(params.contains("/?")){
            salida += "\nSe puede utilizar:\n";
            salida += "/s          lista el contenido del directorio actual y todos los subdirectorios\n";
            salida += "/a          lista el contenido del directorio actual incluyendo contenido oculto\n";
            salida += "/o [-]N     lista el contenido del directorio actual en orden alfabético ascendente o descendente '-'\n";
            salida += "/o [-]D     lista el contenido del directorio actual ordenado por la fecha de creación de forma ascendente o descendente '-'\n";
            salida += "/?          muestra este panel\n";
            System.out.println(salida+"\n");
        }
            
    }

    /**
     * Permite formatear un drive del sistema.
     *
     * @param letter (String) Letra del drive que será formateado.
     * @param name (String) Nuevo nombre del drive que será formateado.
     */
    @Override
    public void format(String letter, String name){
        int largo;
        // Verificar que el drive exista
        if(buscarDrive(letter) && !getDriveActual().equals(letter)){
            // Eliminar carpetas
            largo = getFolders().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getRuta().split(":/")[0].equalsIgnoreCase(letter) && !getFolders().get(i).getRuta().equalsIgnoreCase(letter + ":/")){
                    getFolders().remove(i);
                    largo -= 1;
                    i -= 1;
                }
            }
            
            // Eliminar archivos
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).subdirectorio(letter.toLowerCase() + ":/") || getFiles().get(i).getRuta().equalsIgnoreCase(letter.toLowerCase() + ":/")){
                    getFiles().remove(i);
                    largo -= 1;
                    i -= 1;
                }
            }
            
            // Buscar Drive
            largo = getDrives().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getDrives().get(i).getLetra().equals(letter.toLowerCase())){
                    getDrives().get(i).setName(name);
                    break;
                }
            }
            System.out.println("La unidad fue formateada exitosamente.");

        } else if(buscarDrive(letter)){ // Es el mismo en que uno se encuentra.
            // Eliminar carpetas
            largo = getFolders().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getRuta().split(":/")[0].equals(letter.toLowerCase()) && !getFolders().get(i).getRuta().equals(letter.toLowerCase() + ":/")){
                    getFolders().remove(i);
                    largo -= 1;
                    i -= 1;
                }
            }
            
            // Eliminar archivos
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).subdirectorio(letter.toLowerCase() + ":/") || getFiles().get(i).getRuta().equals(letter.toLowerCase() + ":/")){
                    getFiles().remove(i);
                    largo -= 1;
                    i -= 1;
                }
            }
            
            // Buscar Drive
            largo = getDrives().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getDrives().get(i).getLetra().equalsIgnoreCase(letter.toLowerCase())){
                    getDrives().get(i).setName(name);
                    break;
                }
            }
            // Cambiar Ruta Actual
            setRutaActual(letter.toLowerCase() + ":/");
            System.out.println("La unidad fue formateada exitosamente.");
        } else {
            System.out.println("La unidad ingresada no existe.");
        }
    }
}
