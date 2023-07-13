package interfaces;

public interface IDrive {
    // Selectores
    public String getLetra();
    public String getName();
    public int getCapacity();
    // Modificadores
    public void setLetra(String letter);
    public void setName(String name);
    public void setCapacity(int capacity);
}
