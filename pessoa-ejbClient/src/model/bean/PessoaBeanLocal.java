package model.bean;

import java.util.List;
import javax.ejb.Local;
import model.Pessoa;


/**
 * @generated DT_ID=none
 */
@Local
public interface PessoaBeanLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Pessoa persistPessoa(Pessoa pessoa);

    /**
     * @generated DT_ID=none
     */
    public Pessoa mergePessoa(Pessoa pessoa);

    /**
     * @generated DT_ID=none
     */
    public void removePessoa(Pessoa pessoa);

    /**
     * @generated DT_ID=none
     */
    public List<Pessoa> getPessoaFindAll();
    
    
    public Pessoa getPessoaFindByPrimaryKey(Long id);

}
