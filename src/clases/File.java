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
    
    public String getNombreSinExtension(){
        return nombre.split("\\.")[0];
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
    
    
    
    // Otras Operaciones
    public boolean subdirectorio(String ruta){
        String[] rutaOriginal = ruta.split("/");
        String[] rutaSub = getRuta().split("/");
        int largo = rutaOriginal.length;

        for(int i = 0 ; i < largo ; ++i){
            if(rutaOriginal.length < rutaSub.length){
                if(!rutaOriginal[i].equals(rutaSub[i])){
                    return false;
                }
                
                return false;
            }
        }

        return true;
    }
}


