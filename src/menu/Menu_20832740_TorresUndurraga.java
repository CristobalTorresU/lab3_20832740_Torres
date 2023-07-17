package menu;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import interfaces.IFilesystem_20832740_TorresUndurraga;
import clases.Filesystem_20832740_TorresUndurraga;

/**
 * Clase que representa el Menú con el cual se interactúa para realizar
 * cambios en el sistema de archivos.
 * El menú posee un filesystem.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public class Menu_20832740_TorresUndurraga {
    // Atributos
    private IFilesystem_20832740_TorresUndurraga filesystem;


    // Métodos
    // Constructor
    public Menu_20832740_TorresUndurraga(){
        this.filesystem = null;
    }
    
    // Selectores
    public IFilesystem_20832740_TorresUndurraga getFilesystem(){
        return filesystem;
    }
    
    // Modificadores
    /**
     * Construye el sistema de archivos dentro del menú, siguiendo los métodos que posee
     * la interfaz IFilesystem_20832740_TorresUndurraga.
     *
     * @param name (String) Nombre que tendrá el sistema de archivos.
     */
    public void system(String name){
        this.filesystem = new Filesystem_20832740_TorresUndurraga(name);
    }


    //MENÚS
    /**
     * Muestra el menú Preeliminar para crear un sistema.
     */
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

    /**
     * Muestra el menú principal para interactuar con el sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuPrincipal(Scanner opcion){
        String alternativa;

        while(true){
            // Menu Principal
            System.out.println("\n### Manipulador de Sistema de Archivos ###");
            System.out.println("Escoja su opción");
            System.out.println("1. Crear un nuevo Sistema de Archivos");
            System.out.println("2. Modificar un Sistema de Archivos");
            System.out.println("3. Visualizar Sistema de Archivos");
            System.out.println("4. Visualizar Directorio");
            System.out.println("5. Salir");
            System.out.println("\nIntroduzca su opción: ");
            
            // Introducir opción
            alternativa = opcion.nextLine();
            switch(alternativa){
                case "1":
                    System.out.println("### Crear un nuevo Sistema de Archivos ###");
                    System.out.println("Introduzca el nombre del sistema de archivos: ");
                    String nameSistema = opcion.nextLine();
                    system(nameSistema);
                    System.out.println("El sistema se creó con éxito.");
                    break;
                case "2":
                    menuModificarSistema(opcion);
                    break;
                case "3":
                    menuVisualizar();
                    break;
                case "4":
                    System.out.println("Introduzca los parámetros: ");
                    String params = opcion.nextLine();
                    String[] paramsArray = params.split(",");
                    int largo = paramsArray.length;
                    ArrayList<String> paramsAL = new ArrayList<>();
                    for(int i = 0 ; i < largo ; ++i){
                        paramsArray[i] = paramsArray[i].split("\\[")[0];
                        paramsArray[i] = paramsArray[i].split("]")[0];
                        paramsAL.add(paramsArray[i]);
                    }
                    getFilesystem().dir(paramsAL);
                    break;
                case "5":
                    System.out.println("Hasta pronto");
                    return;
                default:
                    System.out.println("La opción introducida no existe");
            }
        }
    }

    /**
     * Muestra el menú para modificar el sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuModificarSistema(Scanner opcion){
        String alternativa;
        System.out.println("\n### Modificar un Sistema de Archivos ###");
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

    /**
     * Muestra el menú para modificar las unidades del sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuUnidades(Scanner opcion){
        String alternativa;
        
        System.out.println("\n### Unidades ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Agregar Unidad");
        System.out.println("2. Fijar/Cambiar Unidad");
        System.out.println("3. Formatear Unidad");
        System.out.println("4. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        alternativa = opcion.nextLine();
        
        switch(alternativa){
            case "1":
                System.out.println("Ingrese la letra de la unidad: ");
                String letterUnidad = opcion.nextLine();
                System.out.println("Ingrese el nombre de la unidad: ");
                String nameUnidad = opcion.nextLine();
                System.out.println("Ingrese la capacidad de la unidad: ");
                String capacity = opcion.nextLine();
                try {
                    getFilesystem().addDrive(letterUnidad.toLowerCase(), nameUnidad, Integer.parseInt(capacity));
                    break;
                } catch(NumberFormatException e) {
                    System.out.println("La capacidad ingresada debe ser un número entero.");
                    break;
                }
            case "2":
                System.out.println("Ingrese la letra de la unidad a la que desea cambiar: ");
                String letterUnidadCambiar = opcion.nextLine();
                getFilesystem().switchDrive(letterUnidadCambiar.toLowerCase());
                break;
            case "3":
                System.out.println("Ingrese la letra de la unidad: ");
                String letterUnidadFormatear = opcion.nextLine();
                System.out.println("Ingrese el nombre de la unidad: ");
                String nameUnidadFormatear = opcion.nextLine();
                getFilesystem().format(letterUnidadFormatear.toLowerCase(), nameUnidadFormatear);
                break;
            case "4":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }

    /**
     * Muestra el menú para modificar a los usuarios del sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuUsuarios(Scanner opcion){
        String alternativa;
        System.out.println("\n### Usuarios ###");
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
                String userRegistrar = opcion.nextLine();
                getFilesystem().register(userRegistrar.toLowerCase());
                break;
            case "2":
                System.out.println("Ingrese el nombre de usuario con el que desea iniciar sesión: ");
                String userLogin = opcion.nextLine();
                getFilesystem().login(userLogin.toLowerCase());
                break;
            case "3":
                getFilesystem().logout();
                break;
            case "4":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }

    /**
     * Muestra el menú para modificar las carpetas del sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuCarpetas(Scanner opcion){
        String alternativa;
        System.out.println("\n### Carpetas ###");
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
                if(getFilesystem().getDriveActual().equals("")){
                    System.out.println("Debe fijar una unidad para crear un directorio.");
                    return;
                }
                System.out.println("Ingrese el nombre de la carpeta: ");
                String nombreCarpeta = opcion.nextLine();
                getFilesystem().mkdir(nombreCarpeta.toLowerCase());
                break;
            case "2":
                System.out.println("Ingrese el nombre de la carpeta: ");
                String nombreCarpetaEliminar = opcion.nextLine();
                getFilesystem().del(nombreCarpetaEliminar.toLowerCase());
                break;
            case "3":
                System.out.println("Ingrese el nombre de la carpeta que desea renombrar: ");
                String nombreRenombrar = opcion.nextLine();
                System.out.println("Ingrese el nuevo nombre: ");
                String nombreNuevo = opcion.nextLine();
                getFilesystem().ren(nombreRenombrar.toLowerCase(), nombreNuevo.toLowerCase());
                break;
            case "4":
                System.out.println("Ingrese el nombre de la carpeta: ");
                String nombreCarpetaCopiar = opcion.nextLine();
                System.out.println("Ingrese el nombre del directorio objetivo: ");
                String nombreRutaCarpetaCopiar = opcion.nextLine();
                getFilesystem().copy(nombreCarpetaCopiar.toLowerCase(), nombreRutaCarpetaCopiar.toLowerCase());
                break;
            case "5":
                System.out.println("\nIngrese el nombre de la carpeta que desea mover: ");
                String nombreMover = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaMover = opcion.nextLine();
                getFilesystem().move(nombreMover.toLowerCase(), nombreRutaMover.toLowerCase());
                break;
            case "6":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }

    /**
     * Muestra el menú para modificar a los archivos del sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuArchivos(Scanner opcion){
        String alternativa;
        System.out.println("\n### Archivos ###");
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
                if(getFilesystem().getDriveActual().equals("")){
                    System.out.println("Debe fijar una unidad para crear un archivo.");
                    return;
                }
                System.out.println("\nIngrese el nombre del archivo que desea crear: ");
                String nombreCrear = opcion.nextLine();
                System.out.println("Ingrese el contenido del archivo: ");
                String contenido = opcion.nextLine();
                getFilesystem().addFile(getFilesystem().generarFile(nombreCrear.toLowerCase(),contenido));
                break;
            case "2":
                System.out.println("\nIngrese el nombre del archivo que desea eliminar: ");
                String nombreEliminar = opcion.nextLine();
                getFilesystem().del(nombreEliminar.toLowerCase());
                break;
            case "3":
                System.out.println("\nIngrese el nombre del archivo que desea renombrar: ");
                String nombreCambiar = opcion.nextLine();
                System.out.println("\nIngrese el nuevo nombre: ");
                String nuevoNombre = opcion.nextLine();
                getFilesystem().ren(nombreCambiar.toLowerCase(), nuevoNombre.toLowerCase());
                break;
            case "4":
                System.out.println("\nIngrese el nombre del archivo que desea copiar: ");
                String nombreCopiar = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaCopiar = opcion.nextLine();
                getFilesystem().copy(nombreCopiar.toLowerCase(), nombreRutaCopiar.toLowerCase());
                break;
            case "5":
                System.out.println("\nIngrese el nombre del archivo que desea mover: ");
                String nombreMover = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaMover = opcion.nextLine();
                getFilesystem().move(nombreMover.toLowerCase(), nombreRutaMover.toLowerCase());
                break;
            case "6":
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }

    /**
     * Muestra el menú que visualiza el sistema.
     */
    public void menuVisualizar(){
        String nombreNow = getFilesystem().getName();
        String usuarioNow = getFilesystem().getLoggedUser();
        String rutaA = getFilesystem().getRutaActual();
        Date fecha = new Date(getFilesystem().getFechaCreacion());
        System.out.println("\n### Sistema ###\n");
        System.out.println("Filesystem: " + nombreNow);
        System.out.println("Fecha de creación: " + fecha);
        System.out.println("Usuario actual: " + usuarioNow);
        System.out.println("Ruta Actual: " + rutaA);
        System.out.println();
        
        System.out.println("## Unidades ##");
        int largoUnidades = getFilesystem().getDrives().size();
        for(int i = 0 ; i < largoUnidades ; ++i){
            System.out.println("\nUnidad: " + getFilesystem().getDrives().get(i).getLetra());
            System.out.println("Nombre: " + getFilesystem().getDrives().get(i).getName());
            System.out.println("Capacidad: " + getFilesystem().getDrives().get(i).getCapacity());
            
            System.out.println("\nContenidos:");
            System.out.println("Carpetas: ");
            int lCarpetas = getFilesystem().getFolders().size();
            String nRuta;
            String letraDrive;
            boolean eliminadoCarpeta;
            String creador;
            
            for(int j = 0 ; j < lCarpetas ; ++j){
                letraDrive = "" + getFilesystem().getFolders().get(j).getRuta().charAt(0);
                eliminadoCarpeta = getFilesystem().getFolders().get(j).getEliminado();
                if(letraDrive.equals(getFilesystem().getDrives().get(i).getLetra()) && !eliminadoCarpeta){
                    nRuta = getFilesystem().getFolders().get(j).getRuta();
                    Date fechaC = new Date(getFilesystem().getFolders().get(j).getFechaCreacion());
                    Date fechaM = new Date(getFilesystem().getFolders().get(j).getFechaModificacion());
                    creador = getFilesystem().getFolders().get(i).getCreador();
                    System.out.println("    " + nRuta + "       " + creador + "       " + fechaC + "       " + fechaM);
                    int lArchivos = getFilesystem().getFiles().size();
                    String nArchivo;
                    String cArchivo;
                    String rArchivo;
                    String tArchivo;
                    boolean eArchivo;
                    Date fechaArchivo;
                    System.out.println("        Archivos:");
                    
                    for(int k = 0 ; k < lArchivos ; ++k){
                        nArchivo = getFilesystem().getFiles().get(k).getNombre();
                        cArchivo = getFilesystem().getFiles().get(k).getContenido();
                        rArchivo = getFilesystem().getFiles().get(k).getRuta();
                        eArchivo = getFilesystem().getFiles().get(k).getEliminado();
                        tArchivo = getFilesystem().getFiles().get(k).getTipo();
                        fechaArchivo = new Date(getFilesystem().getFiles().get(k).getFechaCreacion());
                        if(nRuta.equals(rArchivo) && !eArchivo){
                            System.out.println("            " + nArchivo + "    " + tArchivo + "     " + cArchivo + "      " + fechaArchivo);
                        }
                    }
                }
            }
            System.out.println("#################");
        }
        
        
        System.out.println("\n## Usuarios ##");
        int largoUsuarios = getFilesystem().getUsers().size();
        String nUsuario;
        Date fechaU;
        for(int i = 0 ; i < largoUsuarios ; ++i){
            nUsuario = getFilesystem().getUsers().get(i).getName();
            fechaU = new Date(getFilesystem().getUsers().get(i).getFechaCreacion());
            System.out.println(nUsuario + "     " + fechaU);
        }
        
        System.out.println("\n### Papelera ###");
       
        System.out.println("Carpetas:");
        int largoPapelera = getFilesystem().getFolders().size();
        for(int i = 0 ; i < largoPapelera ; ++i){
            if(getFilesystem().getFolders().get(i).getEliminado()){
                System.out.println("    " + getFilesystem().getFolders().get(i).getRuta());
            }
        }

        System.out.println("Archivos:");
        largoPapelera = getFilesystem().getFiles().size();
        for(int i = 0 ; i < largoPapelera ; ++i){
            if(getFilesystem().getFiles().get(i).getEliminado()){
                System.out.println("    " + getFilesystem().getFiles().get(i).getNombre());
            }
        }
    }

    /**
     * Muestra el menú para visualizar el directorio actual en el sistema.
     *
     * @param opcion (Scanner) Input que se ingresa por consola.
     */
    public void menuCambiarDirectorio(Scanner opcion){
        if(getFilesystem().getDriveActual().equals("")){
            System.out.println("Debe fijar una unidad para cambiar de directorio.");
            return;
        }
        System.out.println("### Cambiar Directorio ###");
        System.out.println("\nIntroduzca el directorio al que desea cambiar: ");

        String path = opcion.nextLine();
        getFilesystem().cd(path);
    }
}
