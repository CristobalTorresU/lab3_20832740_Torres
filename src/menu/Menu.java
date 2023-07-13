package menu;

import control.Control;
import java.util.Scanner;
import java.util.ArrayList;
import clases.*;

public class Menu {
    // Atributos
    private Control controlSistema;
    
    
    // Métodos
    // Constructor
    public Menu(Control controlSistema){
        this.controlSistema = controlSistema;
    }
    
    // Selectores
    public Control getControl(){
        return controlSistema;
    }
    
    //MENUS
    public void menuPrincipal(){
        Scanner opcion = new Scanner(System.in);
        int alternativa;
        Control controlSistema = getControl();

        while(true){
            // Menu Principal
            System.out.println("### Manipulador de Sistema de Archivos ###");
            System.out.println("Escoja su opción");
            System.out.println("1. Crear un Sistema de Archivos");
            System.out.println("2. Modificar un Sistema de Archivos");
            System.out.println("3. Visualizar Sistema de Archivos");
            System.out.println("4. Visualizar Directorio");
            System.out.println("5. Salir");
            System.out.println("\nIntroduzca su opción: ");
            
            // Introducir opción
            alternativa = opcion.nextInt();
            switch(alternativa){
                case 1:
                    System.out.println("### Crear un Sistema de Archivos ###");
                    System.out.println("Introduzca el nombre del sistema de archivos: ");
                    opcion.nextLine();
                    String nameSistema = opcion.nextLine();
                    controlSistema.system(nameSistema);
                    System.out.println("El sistema se creó con éxito.");
                    break;
                case 2:
                    menuModificarSistema(opcion);
                    break;
                case 3:
                    menuVisualizar(opcion);
                    break;
                case 4:
                    System.out.println("Introduzca los parámetros: ");
                    opcion.nextLine();
                    String params = opcion.nextLine();
                    String[] paramsArray = params.split(",");
                    int largo = paramsArray.length;
                    ArrayList<String> paramsAL = new ArrayList<>();
                    for(int i = 0 ; i < largo ; ++i){
                        paramsArray[i] = paramsArray[i].split("\\[")[0];
                        paramsArray[i] = paramsArray[i].split("\\]")[0];
                        paramsAL.add(paramsArray[i]);
                    }
                    controlSistema.dir(paramsAL);
                    // System.out.println(paramsAL);
                    /*
                    for(int i = 0 ; i < paramsAL.size() ; ++i){
                        System.out.println(paramsAL.get(i));
                    }*/
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    return;
                default:
                    System.out.println("La opción introducida no existe");
            }
        }
    }
    
    public void menuModificarSistema(Scanner opcion){
        int alternativa;
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
        //opcion.nextInt();
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                menuUnidades(opcion);
                break;
            case 2:
                menuUsuarios(opcion);
                break;
            case 3:
                menuCarpetas(opcion);
                break;
            case 4:
                menuArchivos(opcion);
                break;
            case 5:
                menuCambiarDirectorio(opcion);
                break;
            case 6:
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuUnidades(Scanner opcion){
        int alternativa;
        
        System.out.println("### Unidades ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Agregar Unidad");
        System.out.println("2. Cambiar Unidad");
        System.out.println("3. Formatear Unidad");
        System.out.println("4. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        //opcion.nextInt();
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                System.out.println("Ingrese la letra de la unidad: ");
                opcion.nextLine();
                String letterUnidad = opcion.nextLine();
                System.out.println("Ingrese el nombre de la unidad: ");
                //opcion.nextLine();
                String nameUnidad = opcion.nextLine();
                System.out.println("Ingrese la capacidad de la unidad: ");
                //opcion.nextLine();
                int capacity = opcion.nextInt();
                controlSistema.addDrive(letterUnidad, nameUnidad, capacity);
                break;
            case 2:
                System.out.println("Ingrese la letra de la unidad a la que desea cambiar: ");
                opcion.nextLine();
                String letterUnidadCambiar = opcion.nextLine();
                controlSistema.switchDrive(letterUnidadCambiar);
                break;
            case 3:
                System.out.println("Ingrese la letra de la unidad: ");
                opcion.nextLine();
                String letterUnidadFormatear = opcion.nextLine();
                System.out.println("Ingrese el nombre de la unidad: ");
                String nameUnidadFormatear = opcion.nextLine();
                controlSistema.format(letterUnidadFormatear, nameUnidadFormatear);
                break;
            case 4:
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuUsuarios(Scanner opcion){
        int alternativa;
        System.out.println("### Usuarios ###");
        System.out.println("Escoja su opción");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Cerrar Sesión");
        System.out.println("4. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                System.out.println("Ingrese el nombre de usuario que desea registrar: ");
                opcion.nextLine();
                String userRegistrar = opcion.nextLine();
                controlSistema.register(userRegistrar);
                break;
            case 2:
                System.out.println("Ingrese el nombre de usuario con el que desea iniciar sesión: ");
                opcion.nextLine();
                String userLogin = opcion.nextLine();
                controlSistema.login(userLogin);
                break;
            case 3:
                controlSistema.logout();
                break;
            case 4:
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuCarpetas(Scanner opcion){
        int alternativa;
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
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                System.out.println("Ingrese el nombre de la carpeta: ");
                opcion.nextLine();
                String nombreCarpeta = opcion.nextLine();
                controlSistema.mdkir(nombreCarpeta);
                break;
            case 2:
                System.out.println("Ingrese el nombre de la carpeta: ");
                opcion.nextLine();
                String nombreCarpetaEliminar = opcion.nextLine();
                controlSistema.del(nombreCarpetaEliminar);
                break;
            case 3:
                System.out.println("Ingrese el nombre de la carpeta que desea renombrar: ");
                opcion.nextLine();
                String nombreRenombrar = opcion.nextLine();
                System.out.println("Ingrese el nuevo nombre: ");
                String nombreNuevo = opcion.nextLine();
                controlSistema.ren(nombreRenombrar, nombreNuevo);
                break;
            case 4:
                System.out.println("Ingrese el nombre de la carpeta: ");
                opcion.nextLine();
                String nombreCarpetaCopiar = opcion.nextLine();
                System.out.println("Ingrese el nombre del directorio objetivo: ");
                String nombreRutaCarpetaCopiar = opcion.nextLine();
                controlSistema.copy(nombreCarpetaCopiar, nombreRutaCarpetaCopiar);
                break;
            case 5:
                System.out.println("\nIngrese el nombre de la carpeta que desea mover: ");
                opcion.nextLine();
                String nombreMover = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaMover = opcion.nextLine();
                controlSistema.move(nombreMover, nombreRutaMover);
                break;
            case 6:
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuArchivos(Scanner opcion){
        int alternativa;
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
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                System.out.println("\nIngrese el nombre del archivo que desea crear: ");
                opcion.nextLine();
                String nombreCrear = opcion.nextLine();
                System.out.println("Ingrese el contenido del archivo: ");
                String contenido = opcion.nextLine();
                String extension = nombreCrear.split("\\.")[1];
                File newFile;
                switch(extension){
                    case "txt":
                    case "md":
                        newFile = new TextoPlano(nombreCrear, extension, contenido, controlSistema.filesystem.getRutaActual());
                        controlSistema.addFile(newFile);
                        break;
                    case "docx":
                    case "pdf":
                    case "tex":
                        newFile = new Documento(nombreCrear, extension, contenido, controlSistema.filesystem.getRutaActual());
                        controlSistema.addFile(newFile);
                        break;
                    case "py":
                    case "c":
                    case "java":
                    case "rkt":
                    case "pl":
                        newFile = new CodigoFuente(nombreCrear, extension, contenido, controlSistema.filesystem.getRutaActual());
                        controlSistema.addFile(newFile);
                        break;
                }
                break;
            case 2:
                System.out.println("\nIngrese el nombre del archivo que desea eliminar: ");
                opcion.nextLine();
                String nombreEliminar = opcion.nextLine();
                controlSistema.del(nombreEliminar);
                break;
            case 3:
                System.out.println("\nIngrese el nombre del archivo que desea renombrar: ");
                opcion.nextLine();
                String nombreCambiar = opcion.nextLine();
                System.out.println("\nIngrese el nuevo nombre: ");
                String nuevoNombre = opcion.nextLine();
                controlSistema.ren(nombreCambiar, nuevoNombre);
                break;
            case 4:
                System.out.println("\nIngrese el nombre del archivo que desea copiar: ");
                opcion.nextLine();
                String nombreCopiar = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaCopiar = opcion.nextLine();
                controlSistema.copy(nombreCopiar, nombreRutaCopiar);
                break;
            case 5:
                System.out.println("\nIngrese el nombre del archivo que desea mover: ");
                opcion.nextLine();
                String nombreMover = opcion.nextLine();
                System.out.println("\nIngrese el nombre de la ruta objetivo: ");
                String nombreRutaMover = opcion.nextLine();
                controlSistema.move(nombreMover, nombreRutaMover);
                break;
            case 6:
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuVisualizar(Scanner opcion){
        String nombrecitoNow = controlSistema.filesystem.getName();
        String usuarioNow = controlSistema.filesystem.getLoggedUser();
        String rutaA = controlSistema.filesystem.getRutaActual();
        System.out.println("\n### Sistema ###\n");
        System.out.println("Filesystem: " + nombrecitoNow);
        System.out.println("Usuario actual: " + usuarioNow);
        System.out.println("Ruta Actual: " + rutaA);
        System.out.println("");
        
        System.out.println("## Unidades ##");
        int largoUnidades = controlSistema.filesystem.getDrives().size();
        for(int i = 0 ; i < largoUnidades ; ++i){
            System.out.println("\nUnidad: " + controlSistema.filesystem.getDrives().get(i).getLetra());
            System.out.println("Nombre: " + controlSistema.filesystem.getDrives().get(i).getName());
            System.out.println("Capacidad: " + controlSistema.filesystem.getDrives().get(i).getCapacity());
            
            System.out.println("\nContenidos:");
            System.out.println("Carpetas: ");
            int lCarpetas = controlSistema.filesystem.getFolders().size();
            String nRuta;
            String letraDrive;
            boolean eliminadoCarpeta;
            
            for(int j = 0 ; j < lCarpetas ; ++j){
                letraDrive = "" + controlSistema.filesystem.getFolders().get(j).getRuta().charAt(0);
                eliminadoCarpeta = controlSistema.filesystem.getFolders().get(j).getEliminado();
                if(letraDrive.equals(controlSistema.filesystem.getDrives().get(i).getLetra()) && eliminadoCarpeta == false){
                    nRuta = controlSistema.filesystem.getFolders().get(j).getRuta();
                    System.out.println("    " + nRuta);
                    int lArchivos = controlSistema.filesystem.getFiles().size();
                    String nArchivo;
                    String cArchivo;
                    String rArchivo;
                    String tArchivo;
                    boolean eArchivo;
                    System.out.println("        Archivos:");
                    
                    for(int k = 0 ; k < lArchivos ; ++k){
                        nArchivo = controlSistema.filesystem.getFiles().get(k).getNombre();
                        cArchivo = controlSistema.filesystem.getFiles().get(k).getContenido();
                        rArchivo = controlSistema.filesystem.getFiles().get(k).getRuta();
                        eArchivo = controlSistema.filesystem.getFiles().get(k).getEliminado();
                        tArchivo = controlSistema.filesystem.getFiles().get(k).getTipo();
                        if(nRuta.equals(rArchivo) && eArchivo == false){
                            System.out.println("            " + nArchivo + "    " + tArchivo + "     " + cArchivo);
                        }
                    }
                }
            }
            System.out.println("#################");
        }
        
        
        System.out.println("\n## Usuarios ##");
        int largoUsuarios = controlSistema.filesystem.getUsers().size();
        String nUsuario;
        for(int i = 0 ; i < largoUsuarios ; ++i){
            nUsuario = controlSistema.filesystem.getUsers().get(i).getName();
            System.out.println(nUsuario);
        }
        
        System.out.println("\n### Papelera ###");
       
        System.out.println("Carpetas:");
        int largoPapelera = controlSistema.filesystem.getFolders().size();
        for(int i = 0 ; i < largoPapelera ; ++i){
            if(controlSistema.filesystem.getFolders().get(i).getEliminado() == true){
                System.out.println("    " + controlSistema.filesystem.getFolders().get(i).getRuta());
            }
        }

        System.out.println("Archivos:");
        largoPapelera = controlSistema.filesystem.getFiles().size();
        for(int i = 0 ; i < largoPapelera ; ++i){
            if(controlSistema.filesystem.getFiles().get(i).getEliminado() == true){
                System.out.println("    " + controlSistema.filesystem.getFiles().get(i).getNombre());
            }
        }
    }
    
    public void menuEspecial(Scanner opcion){
        String nombrecito = controlSistema.filesystem.getRutaActual();
        System.out.println(nombrecito);
    }
    
    public void menuCambiarDirectorio(Scanner opcion){
        System.out.println("### Cambiar Directorio ###");
        System.out.println("\nIntroduzca el directorio al que desea cambiar: ");

        opcion.nextLine();
        String path = opcion.nextLine();
        controlSistema.cd(path);
    }
}
