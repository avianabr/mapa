package model.bean;

import java.util.Hashtable;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;

import model.Pessoa;
import model.Usuario;

/**
 * Session Bean implementation class SCABean
 */
@Stateless(name = "SCABean", mappedName = "sca-ear-sca-ejb-SCABean")
public class SCABean implements SCABeanRemote, SCABeanLocal {

    /**
     * Default constructor. 
     */
    public SCABean() {
        // TODO Auto-generated constructor stub
    }
    
    public void criarUsuario(Long id, String nome, String login, String senha) {
    		Context ctxPessoaBean = null;
    		Context ctxUsuarioBean = null;
    		PessoaBeanRemote pessoaBean = null;
    		UsuarioBeanRemote usuarioBean = null;
    		Pessoa p = null;
    		Usuario u = null;

    		try {
    			Hashtable htPessoaBean = new Hashtable();
    			htPessoaBean.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    			htPessoaBean.put(Context.PROVIDER_URL, "t3://localhost:7003");
    			ctxPessoaBean = new InitialContext(htPessoaBean);
    			// Use the context in your program
    		
    		
    			pessoaBean = (PessoaBeanRemote) ctxPessoaBean.lookup("pessoa-ear-pessoa-ejb-PessoaBean#model.bean.PessoaBeanRemote");
    			
    			p = pessoaBean.getPessoaFindByPrimaryKey(id);
    			if (p != null) {
    				throw new RuntimeException("Pessoa Already Exists");
    			}
    			else {
    			p = new Pessoa();
    			p.setId(id);
    			p.setNome(nome);
    			pessoaBean.persistPessoa(p);
    			
    			Hashtable htUsuarioBean = new Hashtable();
    			htUsuarioBean.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    			htUsuarioBean.put(Context.PROVIDER_URL, "t3://localhost:7004");
    			ctxUsuarioBean = new InitialContext(htUsuarioBean);
    			
    			usuarioBean = (UsuarioBeanRemote) ctxUsuarioBean.lookup("usuario-ear-usuario-ejb-UsuarioBean#model.bean.UsuarioBeanRemote");
    			u = new Usuario();
    			u.setId(id);
    			u.setLogin(login);
    			u.setSenha(senha);
    			usuarioBean.persistUsuario(u);
    			}
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				ctxPessoaBean.close();
    				ctxUsuarioBean.close();
    			} catch (Exception e) {
    				// a failure occurred
    				e.printStackTrace();
    			}
    		}

    	}
    

}
