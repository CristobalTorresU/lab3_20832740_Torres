package clases;

import java.time.Instant;
import interfaces.IFile;

public class File implements IFile{
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
    @Override
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String getNombreSinExtension(){
        return nombre.split("\\.")[0];
    }
    
    @Override
    public String getExtension(){
        return extension;
    }
    
    @Override
    public String getRuta(){
        return ruta;
    }
    
    @Override
    public String getContenido(){
        return contenido;
    }
    
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    @Override
    public boolean getEliminado(){
        return eliminado;
    }
    
    @Override
    public String getTipo(){
        return tipo;
    }
    
    
    
    // Modificadores
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
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
    
    @Override
    public void setExtension(String extension){
        this.extension = extension;
    }
    
    @Override
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    
    @Override
    public void setContenido(String contenido){
        this.contenido = contenido;
    }
    
    @Override
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }
    
    @Override
    public void actualizarFechaCreacion(){
        this.fechaCreacion = Instant.now().toEpochMilli();
    }
    
    
    
    // Otras Operaciones
    @Override
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


