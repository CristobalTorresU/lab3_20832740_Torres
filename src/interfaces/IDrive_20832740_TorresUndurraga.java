package interfaces;

/**
 * Interfaz que tiene los métodos que deben aplicar las unidades.
 *
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public interface IDrive_20832740_TorresUndurraga {
    // Selectores
    /**
     * Obtiene la letra de la unidad.
     *
     * @return String Letra de la unidad.
     */
    public String getLetra();

    /**
     * Obtiene en el nombre de la unidad.
     *
     * @return String Nombre de la unidad.
     */
    public String getName();

    /**
     * Obtiene la capacidad de la unidad.
     *
     * @return int Capacidad de la unidad
     */
    public int getCapacity();


    // Modificadores
    /**
     * Modifica el nombre de la unidad.
     *
     * @param name (String) Nombre que se reemplazará en la unidad.
     */
    public void setName(String name);
}
