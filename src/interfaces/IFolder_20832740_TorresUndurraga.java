package interfaces;

/**
 * Interfaz que tiene los métodos que deben aplicar las carpetas.
 *
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public interface IFolder_20832740_TorresUndurraga {
    // Selectores
    /**
     * Obtiene el nombre de la carpeta.
     *
     * @return String Nombre de la carpeta.
     */
    public String getNombre();

    /**
     * Obtiene la ruta de la carpeta.
     *
     * @return String Ruta de la carpeta
     */
    public String getRuta();

    /**
     * Obtiene el nombre del usuario creador de la carpeta.
     *
     * @return String Nombre del creador de la carpeta.
     */
    public String getCreador();

    /**
     * Obtiene la fecha de creación de la carpeta.
     *
     * @return long Fecha de creación en formato Epoch.
     */
    public long getFechaCreacion();

    /**
     * Obtiene la fecha de modificación de la carpeta.
     *
     * @return Fecha de modificación de la carpeta en formato Epoch.
     */
    public long getFechaModificacion();

    /**
     * Obtiene si una carpeta fue eliminado.
     *
     * @return "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    public boolean getEliminado();
    
    // Modificadores
    /**
     * Modifica el nombre de la carpeta.
     *
     * @param nombre (String) Nombre que se reemplazará en la carpeta.
     */
    public void setNombre(String nombre);

    /**
     * Modifica la ruta de la carpeta.
     *
     * @param ruta (String) Ruta que se reemplazará en la carpeta.
     */
    public void setRuta(String ruta);

    /**
     * Actualiza la fecha de modificación de la carpeta.
     */
    public void actualizarFechaModificacion();

    /**
     * Modifica si una carpeta está eliminada.
     *
     * @param eliminado "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    public void setEliminado(boolean eliminado);


    
    // Otras Operaciones
    /**
     * Determina si una carpeta es un subdirectorio de la ruta ingresada.
     *
     * @param ruta (String) Ruta ingresada.
     * @return boolean "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    public boolean subdirectorio(String ruta);

    /**
     * Cambia el nombre y ruta de una carpeta.
     *
     * @param nombre (String) Nombre que se reemplazará en la carpeta.
     */
    public void cambiarNombre(String nombre);
}
