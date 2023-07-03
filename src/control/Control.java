package control;

import java.util.ArrayList;
import clases.*;

public class Control {
    public Filesystem filesystem;
    
    // Constructor
    public Control(Filesystem filesystem){
        this.filesystem = filesystem;
    }
    
    // Métodos
    public void system(String name){
        Filesystem system = new Filesystem(name);
    }
    
    public void addDrive(String letter, String name, int capacity){
        // Verificar que no exista
        if(filesystem.buscarDrive(letter) == false){
            // Agregar a la ArrayList
            Drive newDrive = new Drive(letter,name,capacity);
            filesystem.agregarDrive(newDrive);
            Folder newFolder = new Folder(letter, letter + ":/", filesystem.getLoggedUser());
            filesystem.agregarFolder(newFolder);
            System.out.println("La unidad se agregó correctamente.");
            return;
        }
        
        System.out.println("La unidad ingresada ya existe.");
    }
    
    public void register(String userName){
        // Verificar que no exista
        if(filesystem.buscarUser(userName) == false){
            if(!userName.equals("")){
                // Agregar a la ArrayList
                User newUser = new User(userName);
                filesystem.agregarUser(newUser);
                System.out.println("El usuario se registró correctamente.");
                return;
            }
            System.out.println("Nombre de usuario inválido.");
        }
        System.out.println("El usuario ya existe.");
    }
    
    public void login(String userName){
        // Verificar que exista
        if(filesystem.buscarUser(userName) == true){
            // Cambiar el usuario
            filesystem.setLoggedUser(userName);
            System.out.println("Se inició sesión correctamente.");
        }
    }
    
    public void logout(){
        // Verficar que exista un usuario loggeado
        if(!filesystem.getLoggedUser().equals("")){
            // Cerrar sesión
            filesystem.setLoggedUser("");
            System.out.println("Se cerró la sesión correctamente.");
            return;
        }
        
        System.out.println("No existe una sesión iniciada.");
    }
    
    public void switchDrive(String letter){
        // Verificar que exista el drive y un usuario loggeado
        if(filesystem.buscarDrive(letter) == true){
            if(!filesystem.getLoggedUser().equals("")){
                // Cambiar Drive
                filesystem.setDriveActual(letter);
                filesystem.setRutaActual(letter + ":/");
                System.out.println("Se cambió de unidad correctamente.");
                return;
            }
            System.out.println("Debe iniciar sesión para cambiar de unidad.");
        }
        
        System.out.println("La unidad ingresada no existe.");
    }
    
    public void mdkir(String name){
        String ruta = filesystem.getRutaActual() + name + "/";
        // Verificar que el nombre de la carpeta no exista en la ruta
        if(filesystem.buscarFolder(ruta) == false){
            String creador = filesystem.getLoggedUser();
            Folder newFolder = new Folder(name, ruta, creador);
            filesystem.agregarFolder(newFolder);
            System.out.println("La carpeta se creó exitosamente.");
            return;
        }
        
        System.out.println("La carpeta ya existe en el directorio.");
    }
    
    public void cd(String path){
        // Comandos predeterminados
        switch(path){
            case "..":
                if(filesystem.getRutaActual().split("/").length > 1){
                   String[] ruta = filesystem.getRutaActual().split("/");
                   int largo = ruta.length;
                   String newRuta = "";
                   for(int i = 0 ; i < largo - 1 ; ++i){
                       newRuta = newRuta + ruta[i] + "/";
                   }
                   
                   filesystem.setRutaActual(newRuta);
                   System.out.println("Se cambió al directorio padre.");
                   return;
                }
                System.out.println("Ya se encuentra en la carpeta raíz.");
                return;
            case "/":
                filesystem.setRutaActual(filesystem.getDriveActual() + ":/");
                System.out.println("Se cambió al directorio raíz.");
                return;
            case ".":
                System.out.println("Se cambió al mismo directorio.");
                return;
        }
        
        // AGREGAR EL CASO EN QUE SE USE EL COMODÍN
        // Verificar que la ruta exista
        String ruta = filesystem.getRutaActual() + path + "/";

        if(filesystem.buscarFolder(path)){
            filesystem.setRutaActual(path);
            System.out.println("Se cambió a la ruta satisfactoriamente.");
        } else if(filesystem.buscarFolder(ruta)== true){ // Verificar que la carpeta exista
            filesystem.setRutaActual(ruta);
            System.out.println("Se cambió al directorio satisfactoriamente.");
        } else {
            System.out.println("El directorio ingresado no existe.");
        }
    }
    
    public void addFile(File archivo){
        // Verificar si el archivo no existe en el directorio
        
        if(!filesystem.buscarFile(archivo.getNombreSinExtension(), archivo.getRuta())){
            filesystem.agregarFile(archivo);
            System.out.println("El archivo se agregó exitosamente.");
        } else if(filesystem.buscarFile(archivo.getNombreSinExtension(), archivo.getRuta())){ // Si existe
            String nombre = archivo.getNombre();
            String ruta = archivo.getRuta();
            String contenido = archivo.getContenido();
            String extension = archivo.getExtension();
            filesystem.sobreescribirFile(nombre, ruta, contenido, extension);
            System.out.println("El archivo se sobreescribió exitosamente.");
        }
    }
    
    public void del(String fileName){
        // Es un archivo
        if(filesystem.buscarFile(fileName, filesystem.getRutaActual())){
            filesystem.eliminarFile(fileName, filesystem.getRutaActual());
            System.out.println("El archivo se eliminó exitosamente.");
        } else if(filesystem.buscarFolder(filesystem.getRutaActual() + fileName + "/")){ // Es una carpeta
            System.out.println(filesystem.getRutaActual() + fileName + "/");
            filesystem.eliminarFolder(filesystem.getRutaActual() + fileName + "/");
            System.out.println("La carpeta se eliminó exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    
    public void copy(String source, String target){
        // Archivo
        String rutaA = filesystem.getRutaActual();
        if(filesystem.buscarFile(source.split("\\.")[0], rutaA) == true && filesystem.buscarFolder(target) == true && filesystem.buscarFile(source.split("\\.")[0], target) == false){
            File newFile;
            String nombre = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getNombre();
            String extension = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getExtension();
            String contenido = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getContenido();
            switch(extension){
                case "txt":
                case "md":
                    newFile = new TextoPlano(nombre, extension, contenido, target);
                    filesystem.agregarFile(newFile);
                    break;
                case "docx":
                case "pdf":
                case "tex":
                    newFile = new Documento(nombre, extension, contenido, target);
                    filesystem.agregarFile(newFile);
                    break;
                case "py":
                case "c":
                case "java":
                case "rkt":
                case "pl":
                    newFile = new CodigoFuente(nombre, extension, contenido, target);
                    filesystem.agregarFile(newFile);
                    break;
            }
            System.out.println("El archivo fue copiado exitosamente.");
        } else if(source.split("\\.").length != 2 && filesystem.buscarFolder(rutaA) && filesystem.buscarFolder(target) && !filesystem.buscarFolder(target + source + "/")) {  // Carpeta
            filesystem.copiarFolder(source, rutaA + source + "/", target);
            System.out.println("La carpeta fue copiada exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    public void move(String source, String target){
        // Archivo
        String rutaA = filesystem.getRutaActual();
        if(filesystem.buscarFile(source.split("\\.")[0], rutaA) == true && filesystem.buscarFolder(target) == true){
            if(filesystem.buscarFile(source.split("\\.")[0], target) == false){
                filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).setRuta(target);
                System.out.println("El archivo se movió exitosamente.");
            } else if(filesystem.buscarFile(source.split("\\.")[0], target) == true){
                String nombre = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getNombre();
                // String ruta = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getRuta();
                String contenido = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getContenido();
                String extension = filesystem.getFile(source.split("\\.")[0], filesystem.getRutaActual()).getExtension();
                filesystem.sobreescribirFile(nombre, target, contenido, extension);
                filesystem.desaparecerFile(source, rutaA);
                System.out.println("El archivo se sobreescribió exitosamente.");
            }
        } else if(source.split("\\.").length != 2 && filesystem.buscarFolder(rutaA) && filesystem.buscarFolder(target) && !filesystem.buscarFolder(target + source + "/")) {  // Carpeta
            filesystem.copiarFolder(source, rutaA + source + "/", target);
            System.out.println("La carpeta se movió exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    /*
    public void ren(){
    
    }
    */
    
    /*
    public void dir(){
    
    }
    */
    
    /*
    public void format(){
    
    }
    */
}
