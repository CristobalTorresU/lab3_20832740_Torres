package interfaces;

/**
 *
 */
public interface IFile_20832740_TorresUndurraga {
    // Selectores
    /**
     * Obtiene el nombre del archivo.
     *
     * @return String Nombre del archivo.
     */
    public String getNombre();

    /**
     * Obtiene el nombre del archivo sin la extensión.
     *
     * @return String Nombre sin la extensión.
     */
    public String getNombreSinExtension();

    /**
     * Obtiene la extensión del archivo.
     *
     * @return String Extensión del archivo.
     */
    public String getExtension();

    /**
     * Obtiene la ruta en que se encuentra el archivo.
     *
     * @return String Ruta del archivo.
     */
    public String getRuta();

    /**
     * Obtiene el contenido del archivo.
     *
     * @return String Contenido del archivo.
     */
    public String getContenido();

    /**
     * Obtiene la fecha de creación del archivo.
     *
     * @return long Fecha de creación en formato Epoch.
     */
    public long getFechaCreacion();

    /**
     * Obtiene si un archivo fue eliminado.
     *
     * @return boolean "true" si el archivo está eliminado, "false" en caso contrario.
     */
    public boolean getEliminado();

    /**
     * Obtiene el tipo del archivo.
     *
     * @return String Tipo del archivo.
     */
    public String getTipo();
    
    // Modificadores
    /**
     * Modifica el nombre del archivo.
     *
     * @param nombre (String) Nombre que se reemplazará en el archivo.
     */
    public void setNombre(String nombre);

    /**
     * Modifica el tipo del archivo.
     *
     * @param extension (String) Extensión que determina el tipo del archivo.
     */
    public void setTipo(String extension);

    /**
     * Modifica la extensión del archivo.
     *
     * @param extension (String) Extensión que se reemplazará en el archivo.
     */
    public void setExtension(String extension);

    /**
     * Modifica la ruta del archivo.
     *
     * @param ruta (String) Ruta que se reemplazará en el archivo.
     */
    public void setRuta(String ruta);

    /**
     * Modifica el contenido del archivo.
     *
     * @param contenido (String) Contenido que se reemplazará en el archivo.
     */
    public void setContenido(String contenido);

    /**
     * Modifica si un archivo está eliminado.
     *
     * @param eliminado (boolean) "true" si es que está eliminado, "false" en caso contrario.
     */
    public void setEliminado(boolean eliminado);


    
    // Otras Operaciones
    /**
     * Determina si el archivo es el subdirectorio de la ruta ingresada.
     *
     * @param ruta (String) Ruta ingresada.
     * @return boolean "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    public boolean subdirectorio(String ruta);

    /**
     * Modifica la ruta del archivo con un nombre ingresado.
     *
     * @param nombre (String) Nombre que se utilizará en la ruta.
     */
    public void modificarRuta(String nombre);
}
