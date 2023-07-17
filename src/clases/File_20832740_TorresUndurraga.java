package clases;

import interfaces.IFile_20832740_TorresUndurraga;

/**
 * Clase abstracta que representa un archivo en el sistema.
 * Cada archivo tiene un nombre, tipo, extensión, ruta en
 * que se encuentra, contenido del archivo, fecha de
 * creación y atributo que indica si está eliminado.
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public abstract class File_20832740_TorresUndurraga implements IFile_20832740_TorresUndurraga {
    // Atributos
    protected String nombre;
    protected String tipo;
    protected String extension;
    protected String ruta;
    protected String contenido;
    protected long fechaCreacion;
    protected boolean eliminado;

    // Métodos
    // Selectores
    /**
     * Obtiene el nombre del archivo.
     *
     * @return String Nombre del archivo.
     */
    @Override
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el nombre del archivo sin la extensión.
     *
     * @return String Nombre sin la extensión.
     */
    @Override
    public String getNombreSinExtension(){
        return nombre.split("\\.")[0];
    }

    /**
     * Obtiene la extensión del archivo.
     *
     * @return String Extensión del archivo.
     */
    @Override
    public String getExtension(){
        return extension;
    }

    /**
     * Obtiene la ruta en que se encuentra el archivo.
     *
     * @return String Ruta del archivo.
     */
    @Override
    public String getRuta(){
        return ruta;
    }

    /**
     * Obtiene el contenido del archivo.
     *
     * @return String Contenido del archivo.
     */
    @Override
    public String getContenido(){
        return contenido;
    }

    /**
     * Obtiene la fecha de creación del archivo.
     *
     * @return long Fecha de creación en formato Epoch.
     */
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }

    /**
     * Obtiene si un archivo fue eliminado.
     *
     * @return boolean "true" si el archivo está eliminado, "false" en caso contrario.
     */
    @Override
    public boolean getEliminado(){
        return eliminado;
    }

    /**
     * Obtiene el tipo del archivo.
     *
     * @return String Tipo del archivo.
     */
    @Override
    public String getTipo(){
        return tipo;
    }
    
    
    
    // Modificadores
    /**
     * Modifica el nombre del archivo.
     *
     * @param nombre (String) Nombre que se reemplazará en el archivo.
     */
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Modifica el tipo del archivo.
     *
     * @param extension (String) Extensión que determina el tipo del archivo.
     */
    @Override
    public void setTipo(String extension){
        switch(extension){
            case "txt":
            case "md":
                this.tipo = "Texto Plano";
                break;
            case "docx":
            case "pdf":
            case "tex":
                this.tipo = "Documento";
                break;
            case "py":
            case "c":
            case "java":
            case "rkt":
            case "pl":
                this.tipo = "Código Fuente";
                break;
        }
    }

    /**
     * Modifica la extensión del archivo.
     *
     * @param extension (String) Extensión que se reemplazará en el archivo.
     */
    @Override
    public void setExtension(String extension){
        this.extension = extension;
    }

    /**
     * Modifica la ruta del archivo.
     *
     * @param ruta (String) Ruta que se reemplazará en el archivo.
     */
    @Override
    public void setRuta(String ruta){
        this.ruta = ruta;
    }

    /**
     * Modifica el contenido del archivo.
     *
     * @param contenido (String) Contenido que se reemplazará en el archivo.
     */
    @Override
    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    /**
     * Modifica si un archivo está eliminado.
     *
     * @param eliminado (boolean) "true" si es que está eliminado, "false" en caso contrario.
     */
    @Override
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }
    
    
    // Otras Operaciones
    /**
     * Determina si el archivo es el subdirectorio de la ruta ingresada.
     *
     * @param ruta (String) Ruta ingresada.
     * @return boolean "true" en caso de que el archivo se encuentre en el subdirectorio, "false" en el caso contrario.
     */
    @Override
    public boolean subdirectorio(String ruta){
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
     * Modifica la ruta del archivo con un nombre ingresado.
     *
     * @param nombre (String) Nombre que se utilizará en la ruta.
     */
    @Override
    public void modificarRuta(String nombre){
        String[] rutaOriginal = getRuta().split("/");
        int n = rutaOriginal.length;
        String resultado = "";
        for(int i = 0 ; i < n - 1 ; ++i){
            resultado += rutaOriginal[i] + "/";
        }
        resultado += nombre + "/";
        setRuta(resultado);
    }
}


