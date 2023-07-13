package clases;

import java.time.Instant;
import interfaces.IFolder;

public class Folder implements IFolder{
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
    @Override
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String getRuta(){
        return ruta;
    }
    
    @Override
    public String getCreador(){
        return creador;
    }
    
    @Override
    public long getFechaCreacion(){
        return fechaCreacion;
    }
    
    @Override
    public long getFechaModificacion(){
        return fechaModificacion;
    }
    
    @Override
    public boolean getEliminado(){
        return eliminado;
    }
    
    
    
    // Modificadores
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    
    @Override
    public void setCreador(String creador){
        this.creador = creador;
    }
    
    @Override
    public void actualizarFechaCreacion(){
        this.fechaCreacion = Instant.now().toEpochMilli();
    }
    
    @Override
    public void actualizarFechaModificacion(){
        this.fechaModificacion = Instant.now().toEpochMilli();
    }
    
    @Override
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
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
