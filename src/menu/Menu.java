package menu;

import control.Control;
import java.util.Scanner;

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
            System.out.println("4. Salir");
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
        System.out.println("5. Cambiar Ruta");
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
                // Cambiar Ruta
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
        //opcion.nextInt();
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
        opcion.nextInt();
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
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
        System.out.println("3. Borrar Archivo");
        System.out.println("4. Renombrar Archivo");
        System.out.println("5. Salir");
        System.out.println("\nIntroduzca su opción: ");
        
        // Introducir opción
        opcion.nextInt();
        alternativa = opcion.nextInt();
        
        switch(alternativa){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                return;
            default:
                System.out.println("La opción introducida no existe");
        }
    }
    
    public void menuVisualizar(Scanner opcion){
        String nombrecito = controlSistema.filesystem.getRutaActual();
        System.out.println(nombrecito);
    }
}
