package interfaces;

public interface User {
    // Constructor
    public void User(String name);
    // Selectores
    public String getName();
    public long getFechaCreacion();
    // Modificadores
    public void setName(String name);
}
