package interfaces;

public interface IFile {
    // Selectores
    public String getNombre();
    public String getNombreSinExtension();
    public String getExtension();
    public String getRuta();
    public String getContenido();
    public long getFechaCreacion();
    public boolean getEliminado();
    public String getTipo();
    
    // Modificadores
    public void setNombre(String nombre);
    public void setTipo(String extension);
    public void setExtension(String extension);
    public void setRuta(String ruta);
    public void setContenido(String contenido);
    public void setEliminado(boolean eliminado);
    public void actualizarFechaCreacion();
    
    // Otras Operaciones
    public boolean subdirectorio(String ruta);
}
