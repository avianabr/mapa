package model.bean;

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
    		Context ctx = null;
    		PessoaBeanRemote pessoaBean = null;
    		UsuarioBeanRemote usuarioBean = null;
    		Pessoa p = null;
    		Usuario u = null;

    		try {
    			ctx = new InitialContext();
    			// Use the context in your program
    		
    		
    			pessoaBean = (PessoaBeanRemote) ctx.lookup("pessoa-ear-pessoa-ejb-PessoaBean#model.bean.PessoaBeanRemote");
    			
    			p = pessoaBean.getPessoaFindByPrimaryKey(id);
    			if (p != null) {
    				throw new RuntimeException("Pessoa Already Exists");
    			}
    			else {
    			p = new Pessoa();
    			p.setId(id);
    			p.setNome(nome);
    			pessoaBean.persistPessoa(p);
    			
    			usuarioBean = (UsuarioBeanRemote) ctx.lookup("usuario-ear-usuario-ejb-UsuarioBean#model.bean.UsuarioBeanRemote");
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
    				ctx.close();
    			} catch (Exception e) {
    				// a failure occurred
    				e.printStackTrace();
    			}
    		}

    	}
    

}
