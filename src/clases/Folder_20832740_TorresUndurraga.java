package clases;

import java.time.Instant;
import interfaces.IFolder_20832740_TorresUndurraga;

/**
 * Clase que representa una carpeta en el sistema.
 * Cada carpeta tiene un nombre, ruta, nombre del creador,
 * fecha de creación, fecha de modificación y atributo que
 * representa si está eliminado.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public class Folder_20832740_TorresUndurraga implements IFolder_20832740_TorresUndurraga {
    // Atributos
    private String nombre;
    private String ruta;
    private String creador;
    private long fechaCreacion;
    private long fechaModificacion;
    private boolean eliminado;
    
    // Métodos
    // Constructor
    public Folder_20832740_TorresUndurraga(String nombre, String ruta, String creador){
        this.nombre = nombre;
        this.ruta = ruta;
        this.creador = creador;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.fechaModificacion = Instant.now().toEpochMilli();
        this.eliminado = false;
    }

    /**
     * Obtiene el nombre de la carpeta.
     *
     * @return String Nombre de la carpeta.
     */
    // Selectores
    @Override
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene la ruta de la carpeta.
     *
     * @return String Ruta de la carpeta
     */
    @Override
    public String getRuta(){
        return ruta;
    }

    /**
     * Obtiene el nombre del usuario creador de la carpeta.
     *
     * @return String Nombre del creador de la carpeta.
     */
    @Override
    public String getCreador(){
        return creador;
    }

    /**
     * Obtiene la fecha de creación de la carpeta.
     *
     * @return long Fecha de creación en formato Epoch.
     */
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }

    /**
     * Obtiene la fecha de modificación de la carpeta.
     *
     * @return Fecha de modificación de la carpeta en formato Epoch.
     */
    @Override
    public long getFechaModificacion(){
        return fechaModificacion;
    }

    /**
     * Obtiene si una carpeta fue eliminado.
     *
     * @return "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    @Override
    public boolean getEliminado(){
        return eliminado;
    }


    // Modificadores
    /**
     * Modifica el nombre de la carpeta.
     *
     * @param nombre (String) Nombre que se reemplazará en la carpeta.
     */
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Modifica la ruta de la carpeta.
     *
     * @param ruta (String) Ruta que se reemplazará en la carpeta.
     */
    @Override
    public void setRuta(String ruta){
        this.ruta = ruta;
    }

    /**
     * Actualiza la fecha de modificación de la carpeta.
     */
    @Override
    public void actualizarFechaModificacion(){
        this.fechaModificacion = Instant.now().toEpochMilli();
    }

    /**
     * Modifica si una carpeta está eliminada.
     *
     * @param eliminado "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    @Override
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }


    /**
     * Determina si una carpeta es un subdirectorio de la ruta ingresada.
     *
     * @param ruta (String) Ruta ingresada.
     * @return boolean "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    // Otras Operaciones
    @Override
    public boolean subdirectorio(String ruta) {
        String[] rutaOriginal = ruta.split("/");
        String[] rutaSub = getRuta().split("/");
        int largo = rutaOriginal.length;

        if(rutaSub.length < rutaOriginal.length){
            return false;
        } else {
            for (int i = 0; i < largo; ++i) {
                if (!rutaOriginal[i].equals(rutaSub[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Cambia el nombre y ruta de una carpeta.
     *
     * @param nombre (String) Nombre que se reemplazará en la carpeta.
     */
    @Override
    public void cambiarNombre(String nombre){
        String[] rutaOriginal = getRuta().split("/");
        int n = rutaOriginal.length;
        String resultado = "";
        for(int i = 0 ; i < n - 1 ; ++i){
            resultado += rutaOriginal[i] + "/";
        }
        resultado += nombre + "/";
        setRuta(resultado);
        setNombre(nombre);
    }
}
