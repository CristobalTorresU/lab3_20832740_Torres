package menu;

//import control.Control;
import java.util.Scanner;
import java.util.ArrayList;
import interfaces.IFilesystem;
import clases.Filesystem;

public class Menu {
    // Atributos
    private IFilesystem filesystem;


    // Métodos
    // Constructor
    public Menu(){
        this.filesystem = null;
    }
    
    // Selectores
    public IFilesystem getFilesystem(){
        return filesystem;
    }
    
    // Modificadores
    public void system(String name){
        this.filesystem = new Filesystem(name);
    }
    
    //MENUS
    public void menuPreeliminar(){
        Scanner opcion = new Scanner(System.in);
        String alternativa;
        while(true) {
            System.out.println("### Manipulador de Sistema de Archivos ###");
            System.out.println("Escoja su opción");
            System.out.println("1. Crear un Sistema de Archivos");
            System.out.println("2. Salir");
            System.out.println("\nIntroduzca su opción: ");
            alternativa = opcion.nextLine();
            switch (alternativa) {
                case "1":
                    System.out.println("### Crear un Sistema de Archivos ###");
                    System.out.println("Introduzca el nombre del sistema de archivos: ");
                    //opcion.nextLine();
                    String nameSistema = opcion.nextLine();
                    system(nameSistema);
                    System.out.println("El sistema se creó con éxito.");
                    menuPrincipal(opcion);
                    return;
                case "2":
                    System.out.println("Hasta pronto");
                    return;
                default:
                    System.out.println("La opción introducida no existe");
            }
        }
    }
    public void menuPrincipal(Scanner opcion){
        String alternativa;

        while(true){
            // Menu Principal
            System.out.println("### Manipulador de Sistema de Archivos ###");
            System.out.println("Escoja su opción");
            System.out.println("1. Crear un nuevo Sistema de Archivos");
            System.out.println("2. Modificar un Sistema de Archivos");
            System.out.println("3. Visualizar Sistema de Archivos");
            System.out.println("4. Visualizar Directorio");
            System.out.println("5. Salir");
            System.out.println("\nIntroduzca su opción: ");
            
            // Introducir opción
            //opcion.nextLine();
            alternativa = opcion.nextLine();
            switch(alternativa){
                case "1":
                    System.out.println("### Crear un nuevo Sistema de Archivos ###");
                    System.out.println("Introduzca el nombre del sistema de archivos: ");
                    //opcion.nextLine();
                    String nameSistema = opcion.nextLine();
                    system(nameSistema);
                    System.out.println("El sistema se creó con éxito.");
                    break;
                case "2":
                    menuModificarSistema(opcion);
                    break;
                case "3":
                    menuVisualizar(opcion);
                    break;
                case "4":
                    System.out.println("Introduzca los parámetros: ");
                    //opcion.nextLine();
                    String params = opcion.nextLine();
                    String[] paramsArray = params.split(",");
                    int largo = paramsArray.length;
                    ArrayList<String> paramsAL = new ArrayList<>();
                    for(int i = 0 ; i < largo ; ++i){
                        paramsArray[i] = paramsArray[i].split("\\[")[0];
                        paramsArray[i] = paramsArray[i].split("\\]")[0];
                        paramsAL.add(paramsArray[i]);
                    }
                    filesystem.dir(paramsAL);
                    break;
                case "5":
                    System.out.println("Hasta pronto");
                    return;
                default:
                    System.out.println("La opción introducida no existe");
            }
        }
    }
    
    public void menuModificarSistema(Scanner opcion){
        String alternativa;
        System.out.println("### Modificar un Sistema de Archivos ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Unidades");
        System.out.println("2. Usuarios");
        System.out.println("3. Carpetas");
        System.out.println("4. Archivos");
        System.out.println("5. Cambiar Directorio");
        System.out.println("6. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        alternativa = opcion.nextLine();
        
        switch(alternativa){
            case "1":
                menuUnidades(opcion);
                break;
            case "2":
                menuUsuarios(opcion);
                break;
            case "3":
                menuCarpetas(opcion);
                break;
            case "4":
                menuArchivos(opcion);
                break;
            case "5":
                menuCambiarDirectorio(opcion);
                break;
            case "6":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuUnidades(Scanner opcion){
        String alternativa;
        
        System.out.println("### Unidades ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Agregar Unidad");
        System.out.println("2. Cambiar Unidad");
        System.out.println("3. Formatear Unidad");
        System.out.println("4. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        //opcion.nextInt();
        alternativa = opcion.nextLine();
        
        switch(alternativa){
            case "1":
                System.out.println("Ingrese la letra de la unidad: ");
                //opcion.nextLine();
                String letterUnidad = opcion.nextLine();
                System.out.println("Ingrese el nombre de la unidad: ");
                //opcion.nextLine();
                String nameUnidad = opcion.nextLine();
                System.out.println("Ingrese la capacidad de la unidad: ");
                //opcion.nextLine();
                int capacity = opcion.nextInt();
                filesystem.addDrive(letterUnidad.toLowerCase(), nameUnidad, capacity);
                break;
            case "2":
                System.out.println("Ingrese la letra de la unidad a la que desea cambiar: ");
                //opcion.nextLine();
                String letterUnidadCambiar = opcion.nextLine();
                filesystem.switchDrive(letterUnidadCambiar.toLowerCase());
                break;
            case "3":
                System.out.println("Ingrese la letra de la unidad: ");
                //opcion.nextLine();
                String letterUnidadFormatear = opcion.nextLine();
                System.out.println("Ingrese el nombre de la unidad: ");
                String nameUnidadFormatear = opcion.nextLine();
                filesystem.format(letterUnidadFormatear.toLowerCase(), nameUnidadFormatear);
                break;
            case "4":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuUsuarios(Scanner opcion){
        String alternativa;
        System.out.println("### Usuarios ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Cerrar Sesión");
        System.out.println("4. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        alternativa = opcion.nextLine();
        
        switch(alternativa){
            case "1":
                System.out.println("Ingrese el nombre de usuario que desea registrar: ");
                //opcion.nextLine();
                String userRegistrar = opcion.nextLine();
                filesystem.register(userRegistrar.toLowerCase());
                break;
            case "2":
                System.out.println("Ingrese el nombre de usuario con el que desea iniciar sesión: ");
                //opcion.nextLine();
                String userLogin = opcion.nextLine();
                filesystem.login(userLogin.toLowerCase());
                break;
            case "3":
                filesystem.logout();
                break;
            case "4":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuCarpetas(Scanner opcion){
        String alternativa;
        System.out.println("### Carpetas ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Agregar Carpeta");
        System.out.println("2. Eliminar Carpeta");
        System.out.println("3. Renombrar Carpeta");
        System.out.println("4. Copiar Carpeta");
        System.out.println("5. Mover Carpeta");
        System.out.println("6. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        alternativa = opcion.nextLine();
        
        switch(alternativa){
            case "1":
                System.out.println("Ingrese el nombre de la carpeta: ");
                //opcion.nextLine();
                String nombreCarpeta = opcion.nextLine();
                filesystem.mkdir(nombreCarpeta.toLowerCase());
                break;
            case "2":
                System.out.println("Ingrese el nombre de la carpeta: ");
                //opcion.nextLine();
                String nombreCarpetaEliminar = opcion.nextLine();
                filesystem.del(nombreCarpetaEliminar.toLowerCase());
                break;
            case "3":
                System.out.println("Ingrese el nombre de la carpeta que desea renombrar: ");
                //opcion.nextLine();
                String nombreRenombrar = opcion.nextLine();
                System.out.println("Ingrese el nuevo nombre: ");
                String nombreNuevo = opcion.nextLine();
                filesystem.ren(nombreRenombrar.toLowerCase(), nombreNuevo.toLowerCase());
                break;
            case "4":
                System.out.println("Ingrese el nombre de la carpeta: ");
                //opcion.nextLine();
                String nombreCarpetaCopiar = opcion.nextLine();
                System.out.println("Ingrese el nombre del directorio objetivo: ");
                String nombreRutaCarpetaCopiar = opcion.nextLine();
                filesystem.copy(nombreCarpetaCopiar.toLowerCase(), nombreRutaCarpetaCopiar.toLowerCase());
                break;
            case "5":
                System.out.println("\nIngrese el nombre de la carpeta que desea mover: ");
                //opcion.nextLine();
                String nombreMover = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaMover = opcion.nextLine();
                filesystem.move(nombreMover.toLowerCase(), nombreRutaMover.toLowerCase());
                break;
            case "6":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuArchivos(Scanner opcion){
        String alternativa;
        System.out.println("### Archivos ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Agregar Archivo");
        System.out.println("2. Eliminar Archivo");
        System.out.println("3. Renombrar Archivo");
        System.out.println("4. Copiar Archivo");
        System.out.println("5. Mover Archivo");
        System.out.println("6. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        alternativa = opcion.nextLine();
        
        switch(alternativa){
            case "1":
                System.out.println("\nIngrese el nombre del archivo que desea crear: ");
                //opcion.nextLine();
                String nombreCrear = opcion.nextLine();
                System.out.println("Ingrese el contenido del archivo: ");
                String contenido = opcion.nextLine();
                filesystem.addFile(filesystem.generarFile(nombreCrear.toLowerCase(),contenido));
                break;
            case "2":
                System.out.println("\nIngrese el nombre del archivo que desea eliminar: ");
                //opcion.nextLine();
                String nombreEliminar = opcion.nextLine();
                filesystem.del(nombreEliminar.toLowerCase());
                break;
            case "3":
                System.out.println("\nIngrese el nombre del archivo que desea renombrar: ");
                //opcion.nextLine();
                String nombreCambiar = opcion.nextLine();
                System.out.println("\nIngrese el nuevo nombre: ");
                String nuevoNombre = opcion.nextLine();
                filesystem.ren(nombreCambiar.toLowerCase(), nuevoNombre.toLowerCase());
                break;
            case "4":
                System.out.println("\nIngrese el nombre del archivo que desea copiar: ");
                //opcion.nextLine();
                String nombreCopiar = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaCopiar = opcion.nextLine();
                filesystem.copy(nombreCopiar.toLowerCase(), nombreRutaCopiar.toLowerCase());
                break;
            case "5":
                System.out.println("\nIngrese el nombre del archivo que desea mover: ");
                //opcion.nextLine();
                String nombreMover = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaMover = opcion.nextLine();
                filesystem.move(nombreMover.toLowerCase(), nombreRutaMover.toLowerCase());
                break;
            case "6":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuVisualizar(Scanner opcion){
        String nombrecitoNow = filesystem.getName();
        String usuarioNow = filesystem.getLoggedUser();
        String rutaA = filesystem.getRutaActual();
        System.out.println("\n### Sistema ###\n");
        System.out.println("Filesystem: " + nombrecitoNow);
        System.out.println("Usuario actual: " + usuarioNow);
        System.out.println("Ruta Actual: " + rutaA);
        System.out.println("");
        
        System.out.println("## Unidades ##");
        int largoUnidades = filesystem.getDrives().size();
        for(int i = 0 ; i < largoUnidades ; ++i){
            System.out.println("\nUnidad: " + filesystem.getDrives().get(i).getLetra());
            System.out.println("Nombre: " + filesystem.getDrives().get(i).getName());
            System.out.println("Capacidad: " + filesystem.getDrives().get(i).getCapacity());
            
            System.out.println("\nContenidos:");
            System.out.println("Carpetas: ");
            int lCarpetas = filesystem.getFolders().size();
            String nRuta;
            String letraDrive;
            boolean eliminadoCarpeta;
            
            for(int j = 0 ; j < lCarpetas ; ++j){
                letraDrive = "" + filesystem.getFolders().get(j).getRuta().charAt(0);
                eliminadoCarpeta = filesystem.getFolders().get(j).getEliminado();
                if(letraDrive.equals(filesystem.getDrives().get(i).getLetra()) && eliminadoCarpeta == false){
                    nRuta = filesystem.getFolders().get(j).getRuta();
                    System.out.println("    " + nRuta);
                    int lArchivos = filesystem.getFiles().size();
                    String nArchivo;
                    String cArchivo;
                    String rArchivo;
                    String tArchivo;
                    boolean eArchivo;
                    System.out.println("        Archivos:");
                    
                    for(int k = 0 ; k < lArchivos ; ++k){
                        nArchivo = filesystem.getFiles().get(k).getNombre();
                        cArchivo = filesystem.getFiles().get(k).getContenido();
                        rArchivo = filesystem.getFiles().get(k).getRuta();
                        eArchivo = filesystem.getFiles().get(k).getEliminado();
                        tArchivo = filesystem.getFiles().get(k).getTipo();
                        if(nRuta.equals(rArchivo) && eArchivo == false){
                            System.out.println("            " + nArchivo + "    " + tArchivo + "     " + cArchivo);
                        }
                    }
                }
            }
            System.out.println("#################");
        }
        
        
        System.out.println("\n## Usuarios ##");
        int largoUsuarios = filesystem.getUsers().size();
        String nUsuario;
        for(int i = 0 ; i < largoUsuarios ; ++i){
            nUsuario = filesystem.getUsers().get(i).getName();
            System.out.println(nUsuario);
        }
        
        System.out.println("\n### Papelera ###");
       
        System.out.println("Carpetas:");
        int largoPapelera = filesystem.getFolders().size();
        for(int i = 0 ; i < largoPapelera ; ++i){
            if(filesystem.getFolders().get(i).getEliminado() == true){
                System.out.println("    " + filesystem.getFolders().get(i).getRuta());
            }
        }

        System.out.println("Archivos:");
        largoPapelera = filesystem.getFiles().size();
        for(int i = 0 ; i < largoPapelera ; ++i){
            if(filesystem.getFiles().get(i).getEliminado() == true){
                System.out.println("    " + filesystem.getFiles().get(i).getNombre());
            }
        }
    }
    
    public void menuCambiarDirectorio(Scanner opcion){
        System.out.println("### Cambiar Directorio ###");
        System.out.println("\nIntroduzca el directorio al que desea cambiar: ");

        //opcion.nextLine();
        String path = opcion.nextLine();
        filesystem.cd(path);
    }
}
