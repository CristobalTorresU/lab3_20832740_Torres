package clases;

import java.time.Instant;

public class Folder {
    // Atributos
    private String nombre;
    private String ruta;
    private String creador;
    private long fechaCreacion;
    private long fechaModificacion;
    private boolean eliminado;
    
    // Métodos
    // Constructor
    public Folder(String nombre, String ruta, String creador){
        this.nombre = nombre;
        this.ruta = ruta;
        this.creador = creador;
        this.fechaCreacion = Instant.now().toEpochMilli();
        this.fechaModificacion = Instant.now().toEpochMilli();
        this.eliminado = false;
    }
    
    // Selectores
    public String getNombre(){
        return nombre;
    }
    
    public String getRuta(){
        return ruta;
    }
    
    public String getCreador(){
        return creador;
    }
    
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    public long getFechaModificacion(){
        return fechaModificacion;
    }
    
    public boolean getEliminado(){
        return eliminado;
    }
    
    
    
    // Modificadores
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    
    public void setCreador(String creador){
        this.creador = creador;
    }
    
    public void actualizarFechaModificacion(){
        this.fechaModificacion = Instant.now().toEpochMilli();
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
