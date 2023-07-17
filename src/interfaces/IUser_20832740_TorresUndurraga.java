package interfaces;

/**
 * Interfaz que tiene los métodos que deben aplicar los usuarios.
 *
 * @version 11
 * @author Cristóbal Torres Undurraga
 */
public interface IUser_20832740_TorresUndurraga {
    // Selectores
    /**
     * Obtiene el nombre de un usuario.
     *
     * @return String Nombre del usuario.
     */
    public String getName();

    /**
     * Obtiene la fecha de creación del usuario.
     *
     * @return long Fecha de creación en formato Epoch.
     */
    public long getFechaCreacion();
}
