package interfaces;

public interface Drive {
    // Selectores
    public char getLetra();
    public String getName();
    public int getCapacity();
    // Modificadores
    public void setLetra(char letter);
    public void setName(String name);
    public void setCapacity(int capacity);
}
