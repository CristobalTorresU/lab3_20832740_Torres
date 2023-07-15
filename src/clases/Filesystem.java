package clases;

import java.time.Instant;
import java.util.ArrayList;
import interfaces.*;
import java.util.Comparator;

/**
 *
 * @author 
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
            if(drive.getLetra().equalsIgnoreCase(letra)){
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
            if(user.getName().equalsIgnoreCase(userName)){
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
            if(folder.getRuta().equalsIgnoreCase(ruta)){
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
            if(file.getNombreSinExtension().equalsIgnoreCase(nombre) && file.getRuta().equalsIgnoreCase(ruta)){
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
            if(file.getNombre().equalsIgnoreCase(nombre) && file.getRuta().equalsIgnoreCase(ruta)){
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void eliminarFile(String nombre, String ruta){
        int largo = this.files.size();
        for(int i = 0 ; i < largo ; ++i){
            if(files.get(i).getNombre().equalsIgnoreCase(nombre) && files.get(i).getRuta().equalsIgnoreCase(ruta)){
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
        IFolder folder;
        for(int i = 0 ; i < largoF ; ++i){
            rutaF = getFolders().get(i).getRuta();
            if(rutaF.equals(ruta) || folders.get(i).subdirectorio(ruta) == false){
                folder = new Folder(folders.get(i).getNombre(), target + source + "/", folders.get(i).getCreador());
                agregarFolder(folder);
            }
        }
        
        int largoFi = getFiles().size();
        String rutaFi;
        IFile file;
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
    
    @Override
    public IFile generarFile(String nombre, String contenido){
        IFile newFile;
        String extension = nombre.split("\\.")[1];
        switch(extension){
        case "txt":
        case "md":
            newFile = new TextoPlano(nombre, extension, contenido, getRutaActual());
            return newFile;
        case "docx":
        case "pdf":
        case "tex":
            newFile = new Documento(nombre, extension, contenido, getRutaActual());
            return newFile;
        case "py":
        case "c":
        case "java":
        case "rkt":
        case "pl":
            newFile = new CodigoFuente(nombre, extension, contenido, getRutaActual());
            return newFile;
        default:
            System.out.println("La extensión ingresada no esá permitida.");
            newFile = new TextoPlano(null, "", null,null);
            return newFile;
        }
    }




    // Requerimientos Funcionales
    @Override
    public void addDrive(String letter, String name, int capacity){
        // Verificar que no exista
        if(letter.length() != 1){
            System.out.println("La letra ingresada solo debe ser 1 caracter.");
            return;
        }
        if(buscarDrive(letter) == false){
            // Agregar a la ArrayList
            IDrive newDrive = new Drive(letter,name,capacity);
            agregarDrive(newDrive);
            IFolder newFolder = new Folder(letter, letter + ":/", getLoggedUser());
            agregarFolder(newFolder);
            System.out.println("La unidad se agregó correctamente.");
            return;
        }

        System.out.println("La unidad ingresada ya existe.");
    }
    
    @Override
    public void register(String userName){
        // Verificar que no exista
        if(buscarUser(userName) == false){
            if(!userName.equals("")){
                // Agregar a la ArrayList
                IUser newUser = new User(userName.toLowerCase());
                agregarUser(newUser);
                System.out.println("El usuario se registró correctamente.");
                return;
            }
            System.out.println("Nombre de usuario inválido.");
        }
        System.out.println("El usuario ya existe.");
    }
    
    @Override
    public void login(String userName){
        // Verificar que exista
        if(!getLoggedUser().equals("")){
            System.out.println("Cierre la sesión actual antes de iniciar otra.");
        } else if(buscarUser(userName) == true){
            // Cambiar el usuario
            setLoggedUser(userName.toLowerCase());
            System.out.println("Se inició sesión correctamente.");
        } else {
            System.out.println("El usuario ingresado no está registrado.");
        }
    }
    
    @Override
    public void logout(){
        // Verficar que exista un usuario loggeado
        if(!getLoggedUser().equals("")){
            // Cerrar sesión
            setLoggedUser("");
            System.out.println("Se cerró la sesión correctamente.");
            return;
        }
        
        System.out.println("No existe una sesión iniciada.");
    }
    
    @Override
    public void switchDrive(String letter){
        // Verificar que exista el drive y un usuario loggeado
        if(buscarDrive(letter) == true){
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
    
    @Override
    public void mkdir(String name){
        String ruta = getRutaActual() + name.toLowerCase() + "/";
        // Verificar que el nombre de la carpeta no exista en la ruta
        if(buscarFolder(ruta) == false){
            String creador = getLoggedUser();
            IFolder newFolder = new Folder(name.toLowerCase(), ruta.toLowerCase(), creador);
            agregarFolder(newFolder);
            System.out.println("La carpeta se creó exitosamente.");
            return;
        }
        
        System.out.println("La carpeta ya existe en el directorio.");
    }
    
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
        
        // AGREGAR EL CASO EN QUE SE USE EL COMODÍN
        // Verificar que la ruta exista
        String ruta = getRutaActual() + path + "/";

        if(buscarFolder(path)){
            setRutaActual(path.toLowerCase());
            setDriveActual(path.toLowerCase().split(":/")[0]);
            System.out.println("Se cambió a la ruta satisfactoriamente.");
        } else if(buscarFolder(ruta)== true){ // Verificar que la carpeta exista
            setRutaActual(ruta.toLowerCase());
            System.out.println("Se cambió al directorio satisfactoriamente.");
        } else {
            System.out.println("El directorio ingresado no existe.");
        }
    }
    
    @Override
    public void addFile(IFile archivo){
        // Verificar si el archivo no existe en el directorio
        if(archivo.getExtension().equals("")){
            return;
        }else if(!buscarFile(archivo.getNombreSinExtension(), archivo.getRuta())){
            agregarFile(archivo);
            System.out.println("El archivo se agregó exitosamente.");
        } else if(buscarFile(archivo.getNombreSinExtension(), archivo.getRuta())){ // Si existe
            String nombre = archivo.getNombre();
            String ruta = archivo.getRuta();
            String contenido = archivo.getContenido();
            String extension = archivo.getExtension();
            sobreescribirFile(nombre, ruta, contenido, extension);
            System.out.println("El archivo se sobreescribió exitosamente.");
        }
    }
    
    @Override
    public void del(String fileName){
        // Es un archivo
        if(buscarFile(fileName, getRutaActual())){
            eliminarFile(fileName, getRutaActual());
            System.out.println("El archivo se eliminó exitosamente.");
        } else if(buscarFolder(getRutaActual() + fileName + "/")){ // Es una carpeta
            System.out.println(getRutaActual() + fileName + "/");
            eliminarFolder(getRutaActual() + fileName + "/");
            System.out.println("La carpeta se eliminó exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    @Override
    public void copy(String source, String target){
        // Archivo
        String rutaA = getRutaActual();
        if(buscarFile(source.split("\\.")[0], rutaA) == true && buscarFolder(target) == true && buscarFile(source.split("\\.")[0], target) == false){
            IFile newFile;
            String nombre = getFile(source.split("\\.")[0], getRutaActual()).getNombre();
            String extension = getFile(source.split("\\.")[0], getRutaActual()).getExtension();
            String contenido = getFile(source.split("\\.")[0], getRutaActual()).getContenido();
            switch(extension){
                case "txt":
                case "md":
                    newFile = new TextoPlano(nombre, extension, contenido, target);
                    agregarFile(newFile);
                    break;
                case "docx":
                case "pdf":
                case "tex":
                    newFile = new Documento(nombre, extension, contenido, target);
                    agregarFile(newFile);
                    break;
                case "py":
                case "c":
                case "java":
                case "rkt":
                case "pl":
                    newFile = new CodigoFuente(nombre, extension, contenido, target);
                    agregarFile(newFile);
                    break;
            }
            System.out.println("El archivo fue copiado exitosamente.");
        } else if(source.split("\\.").length != 2 && buscarFolder(rutaA) && buscarFolder(target) && !buscarFolder(target + source + "/")) {  // Carpeta
            copiarFolder(source, rutaA + source + "/", target);
            System.out.println("La carpeta fue copiada exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    @Override
    public void move(String source, String target){
        // Archivo
        String rutaA = getRutaActual();
        if(buscarFile(source.split("\\.")[0], rutaA) == true && buscarFolder(target) == true){
            if(buscarFile(source.split("\\.")[0], target) == false){
                getFile(source.split("\\.")[0], getRutaActual()).setRuta(target);
                System.out.println("El archivo se movió exitosamente.");
            } else if(buscarFile(source.split("\\.")[0], target) == true){
                String nombre = getFile(source.split("\\.")[0], getRutaActual()).getNombre();
                // String ruta = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getRuta();
                String contenido = getFile(source.split("\\.")[0], getRutaActual()).getContenido();
                String extension = getFile(source.split("\\.")[0], getRutaActual()).getExtension();
                sobreescribirFile(nombre, target, contenido, extension);
                desaparecerFile(source, rutaA);
                System.out.println("El archivo se sobreescribió exitosamente.");
            }
        } else if(source.split("\\.").length != 2 && buscarFolder(rutaA) && buscarFolder(target) && !buscarFolder(target + source + "/")) {  // Carpeta
            moverFolder(source, rutaA + source + "/", target);
            System.out.println("La carpeta se movió exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    @Override
    public void ren(String currentName, String newName){
        String rutaA = getRutaActual();
        // Archivo
        if(buscarFileConExtension(currentName, rutaA) == true){
            getFile(currentName.toLowerCase().split("\\.")[0], rutaA).setRuta(newName.toLowerCase());
            System.out.println("El archivo se renombró exitosamente.");
        } else if(buscarFolder(rutaA+currentName+"/") == true){ // Carpeta
            renombrarCarpetas(currentName.toLowerCase(),newName.toLowerCase());
            System.out.println("La carpeta se renombró exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }

    @Override
    public void dir(ArrayList<String> params){
        String salida = "";
        int largo;
        int n;
        
        if(params.contains("") == true){
            salida += getRutaActual();
            largo = getFolders().size();
            n = getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getEliminado() == false && getFolders().get(i).subdirectorio(getRutaActual()) == false && getFolders().get(i).getRuta().split("/").length == n+1){
                   salida += "\n" + getFolders().get(i).getNombre();
                }
            }
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).getEliminado() == false && getFiles().get(i).getRuta().equals(getRutaActual())){
                    salida += "\n" + getFiles().get(i).getNombre();
                }
            }
            System.out.println(salida);
        } else if(params.contains("/a") == true && params.contains("/s") == true){
            
        } else if(params.contains("/s") == true){
            
        } else if(params.contains("/a") == true){
            
        } else if(params.contains("/o N") == true){
            salida += getRutaActual();
            ArrayList<String> nombres = new ArrayList<>();
            largo = getFolders().size();
            n = getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getEliminado() == false && getFolders().get(i).subdirectorio(getRutaActual()) == false && getFolders().get(i).getRuta().split("/").length == n+1){
                    nombres.add(getFolders().get(i).getNombre());
                }
            }
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).getEliminado() == false && getFiles().get(i).getRuta().equals(getRutaActual())){
                    nombres.add(getFiles().get(i).getNombre());
                }
            }
            nombres.sort(Comparator.naturalOrder());
            largo = nombres.size();
            for(int i = 0 ; i < largo ; ++i){
                salida += "\n" + nombres.get(i);
            }
            System.out.println(salida);
        } else if(params.contains("/o -N") == true){
            salida += getRutaActual();
            ArrayList<String> nombres = new ArrayList<>();
            largo = getFolders().size();
            n = getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getEliminado() == false && getFolders().get(i).subdirectorio(getRutaActual()) == false && getFolders().get(i).getRuta().split("/").length == n+1){
                    nombres.add(getFolders().get(i).getNombre());
                }
            }
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).getEliminado() == false && getFiles().get(i).getRuta().equals(getRutaActual())){
                    nombres.add(getFiles().get(i).getNombre());
                }
            }
            nombres.sort(Comparator.reverseOrder());
            largo = nombres.size();
            for(int i = 0 ; i < largo ; ++i){
                salida += "\n" + nombres.get(i);
            }
            System.out.println(salida);
            /*
        } else if(params.contains("/o D") == true){
            salida += filesystem.getRutaActual();
            ArrayList<String> nombres = new ArrayList<>();
            largo = filesystem.getFolders().size();
            n = filesystem.getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFolders().get(i).getEliminado() == false && filesystem.getFolders().get(i).subdirectorio(filesystem.getRutaActual()) == false && filesystem.getFolders().get(i).getRuta().split("/").length == n+1){
                    nombres.add(filesystem.getFolders().get(i).getNombre());
                }
            }
            largo = filesystem.getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFiles().get(i).getEliminado() == false && filesystem.getFiles().get(i).getRuta().equals(filesystem.getRutaActual())){
                    nombres.add(filesystem.getFiles().get(i).getNombre());
                }
            }
            nombres.sort(Comparator.reverseOrder());
            largo = nombres.size();
            for(int i = 0 ; i < largo ; ++i){
                salida += "\n" + nombres.get(i);
            }
            
            
            
            for(int i = 0 ; i <  ; ++i){
                for(int j = 0 ; j <  ; ++j){
                    
                }
            }
            System.out.println(salida);
        } else if(params.contains("/o -D") == true){*/
            
        } else if(params.contains("/?") == true){
            salida += "\nSe puede utilizar:\n";
            salida += "/s          lista el contenido del directorio actual y todos los subdirectorios\n";
            salida += "/a          lista el contenido del directorio actual incluyendo contenido oculto\n";
            salida += "/o [-]N     lista el contenido del directorio actual en orden alfabético ascendente o descendente '-'\n";
            salida += "/o [-]D     lista el contenido del directorio actual ordenado por la fecha de creación de forma ascendente o descendente '-'\n";
            salida += "/?          muestra este panel\n";
            System.out.println(salida);
        }
            
    }

    @Override
    public void format(String letter, String name){
        int largo;
        // Verificar que el drive exista
        if(buscarDrive(letter) == true && getDriveActual().equals(letter) == false){
            // Eliminar carpetas
            largo = getFolders().size();
            System.out.println(largo);
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getRuta().split(":/")[0].equalsIgnoreCase(letter) && !getFolders().get(i).getRuta().equalsIgnoreCase(letter + ":/")){
                    getFolders().remove(i);
                    largo -= 1;
                    i -= 1;
                    /*System.out.println("\nMod:");
                    for(int j = 0 ; j < largo ; ++j){
                        System.out.println(filesystem.getFolders().get(j).getRuta());
                        System.out.println("");
                    }*/
                }
            }
            
            // Eliminar archivos
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).subdirectorio(letter.toLowerCase() + ":/") == false || getFiles().get(i).getRuta().equalsIgnoreCase(letter.toLowerCase() + ":/")){
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

        } else if(buscarDrive(letter) == true){ // Es el mismo en que uno se encuentra.
            // Eliminar carpetas
            largo = getFolders().size();
            System.out.println(largo);
            for(int i = 0 ; i < largo ; ++i){
                if(getFolders().get(i).getRuta().split(":/")[0].equals(letter.toLowerCase()) && !getFolders().get(i).getRuta().equals(letter.toLowerCase() + ":/")){
                    getFolders().remove(i);
                    largo -= 1;
                    i -= 1;
                    /*System.out.println("\nMod:");
                    for(int j = 0 ; j < largo ; ++j){
                        System.out.println(filesystem.getFolders().get(j).getRuta());
                        System.out.println("");
                    }*/
                }
            }
            
            // Eliminar archivos
            largo = getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(getFiles().get(i).subdirectorio(letter.toLowerCase() + ":/") == false || getFiles().get(i).getRuta().equals(letter.toLowerCase() + ":/")){
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
