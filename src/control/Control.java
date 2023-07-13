package control;

import java.util.ArrayList;
import java.util.Comparator;
//import interfaces.IFilesystem;
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
            filesystem.setDriveActual(path.split("/")[0]);
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
            filesystem.moverFolder(source, rutaA + source + "/", target);
            System.out.println("La carpeta se movió exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }
    
    public void ren(String currentName, String newName){
        String rutaA = filesystem.getRutaActual();
        // Archivo
        if(filesystem.buscarFileConExtension(currentName, rutaA) == true){
            filesystem.getFile(currentName.split("\\.")[0], rutaA).setRuta(newName);
            System.out.println("El archivo se renombró exitosamente.");
        } else if(filesystem.buscarFolder(rutaA+currentName+"/") == true){ // Carpeta
            filesystem.renombrarCarpetas(currentName,newName);
            System.out.println("La carpeta se renombró exitosamente.");
        } else {
            System.out.println("El nombre ingresado no existe.");
        }
    }

    public void dir(ArrayList<String> params){
        String salida = "";
        int largo;
        int n;
        
        if(params.contains("") == true){
            salida += filesystem.getRutaActual();
            largo = filesystem.getFolders().size();
            n = filesystem.getRutaActual().split("/").length;
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFolders().get(i).getEliminado() == false && filesystem.getFolders().get(i).subdirectorio(filesystem.getRutaActual()) == false && filesystem.getFolders().get(i).getRuta().split("/").length == n+1){
                   salida += "\n" + filesystem.getFolders().get(i).getNombre();
                }
            }
            largo = filesystem.getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFiles().get(i).getEliminado() == false && filesystem.getFiles().get(i).getRuta().equals(filesystem.getRutaActual())){
                    salida += "\n" + filesystem.getFiles().get(i).getNombre();
                }
            }
            System.out.println(salida);
        } else if(params.contains("/a") == true && params.contains("/s") == true){
            
        } else if(params.contains("/s") == true){
            
        } else if(params.contains("/a") == true){
            
        } else if(params.contains("/o N") == true){
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
            nombres.sort(Comparator.naturalOrder());
            largo = nombres.size();
            for(int i = 0 ; i < largo ; ++i){
                salida += "\n" + nombres.get(i);
            }
            System.out.println(salida);
        } else if(params.contains("/o -N") == true){
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

    public void format(String letter, String name){
        int largo;
        // Verificar que el drive exista
        if(filesystem.buscarDrive(letter) == true && filesystem.getDriveActual().equals(letter) == false){
            // Eliminar carpetas
            largo = filesystem.getFolders().size();
            System.out.println(largo);
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFolders().get(i).getRuta().split(":/")[0].equals(letter) && !filesystem.getFolders().get(i).getRuta().equals(letter + ":/")){
                    filesystem.getFolders().remove(i);
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
            largo = filesystem.getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFiles().get(i).subdirectorio(letter + ":/") == false || filesystem.getFiles().get(i).getRuta().equals(letter + ":/")){
                    filesystem.getFiles().remove(i);
                    largo -= 1;
                    i -= 1;
                }
            }
            
            // Buscar Drive
            largo = filesystem.getDrives().size();
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getDrives().get(i).getLetra().equals(letter)){
                    filesystem.getDrives().get(i).setName(name);
                    break;
                }
            }
            System.out.println("La unidad fue formateada exitosamente.");

        } else if(filesystem.buscarDrive(letter) == true){ // Es el mismo en que uno se encuentra.
            // Eliminar carpetas
            largo = filesystem.getFolders().size();
            System.out.println(largo);
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFolders().get(i).getRuta().split(":/")[0].equals(letter) && !filesystem.getFolders().get(i).getRuta().equals(letter + ":/")){
                    filesystem.getFolders().remove(i);
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
            largo = filesystem.getFiles().size();
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getFiles().get(i).subdirectorio(letter + ":/") == false || filesystem.getFiles().get(i).getRuta().equals(letter + ":/")){
                    filesystem.getFiles().remove(i);
                    largo -= 1;
                    i -= 1;
                }
            }
            
            // Buscar Drive
            largo = filesystem.getDrives().size();
            for(int i = 0 ; i < largo ; ++i){
                if(filesystem.getDrives().get(i).getLetra().equals(letter)){
                    filesystem.getDrives().get(i).setName(name);
                    break;
                }
            }
            // Cambiar Ruta Actual
            filesystem.setRutaActual(letter + ":/");
            System.out.println("La unidad fue formateada exitosamente.");
        } else {
            System.out.println("La unidad ingresada no existe.");
        }
    }
}
