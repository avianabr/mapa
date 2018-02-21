package model.bean;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Pessoa;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "PessoaBean", mappedName = "pessoa-ear-pessoa-ejb-PessoaBean")
public class PessoaBean
        implements PessoaBeanLocal, PessoaBeanRemote
{

    /**
     * @generated DT_ID=none
     */
	@Resource
	SessionContext sessionContext;

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="pessoa-ejb")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public PessoaBean() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pessoa persistPessoa(Pessoa pessoa) {
        em.persist(pessoa);
        return pessoa;
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pessoa mergePessoa(Pessoa pessoa) {
        return em.merge(pessoa);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void removePessoa(Pessoa pessoa) {
        pessoa = em.find(Pessoa.class, pessoa.getId());
        em.remove(pessoa);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Pessoa> getPessoaFindAll() {
        return em.createNamedQuery("Pessoa.findAll").getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Pessoa getPessoaFindByPrimaryKey(Long id) {
        return em.find(Pessoa.class, id);
    }

}
