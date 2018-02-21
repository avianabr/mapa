package model.bean;

import java.util.List;
import javax.ejb.Local;
import model.Usuario;


/**
 * @generated DT_ID=none
 */
@Local
public interface UsuarioBeanLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Usuario persistUsuario(Usuario usuario);

    /**
     * @generated DT_ID=none
     */
    public Usuario mergeUsuario(Usuario usuario);

    /**
     * @generated DT_ID=none
     */
    public void removeUsuario(Usuario usuario);

    /**
     * @generated DT_ID=none
     */
    public List<Usuario> getUsuarioFindAll();

}
