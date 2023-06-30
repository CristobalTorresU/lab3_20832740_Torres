package clases;

public class File {
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
    public String getNombre(){
        return nombre;
    }
    
    public String getExtension(){
        return extension;
    }
    
    public String getRuta(){
        return ruta;
    }
    
    public String getContenido(){
        return contenido;
    }
    
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    public boolean getEliminado(){
        return eliminado;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    
    
    // Modificadores
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setExtension(String extension){
        this.extension = extension;
    }
    
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    
    public void setContenido(String contenido){
        this.contenido = contenido;
    }
    
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }
}


