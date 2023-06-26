package interfaces;

public interface Drive {
    // Constructor
    public void Drive(char letter, String name, int capacity);
    // Selectores
    public char getLetra();
    public String getName();
    public int getCapacity();
    // Modificadores
    public void setLetra(char letter);
    public void setName(String name);
    public void setCapacity(int capacity);
}
