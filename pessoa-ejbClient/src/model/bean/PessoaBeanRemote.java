package model.bean;

import java.util.List;
import javax.ejb.Remote;
import model.Pessoa;


/**
 * @generated DT_ID=none
 */
@Remote
public interface PessoaBeanRemote
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
