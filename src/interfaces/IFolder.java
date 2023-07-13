package interfaces;

public interface IFolder {
    // Selectores
    public String getNombre();
    public String getRuta();
    public String getCreador();
    public long getFechaCreacion();
    public long getFechaModificacion();
    public boolean getEliminado();
    
    // Modificadores
    public void setNombre(String nombre);
    public void setRuta(String ruta);
    public void setCreador(String creador);
    public void actualizarFechaCreacion();
    public void actualizarFechaModificacion();
    public void setEliminado(boolean eliminado);
    
    // Otras Operaciones
    public boolean subdirectorio(String ruta);
    public void cambiarNombre(String nombre);
}
