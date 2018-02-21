package model.bean;

import javax.ejb.Local;

@Local
public interface SCABeanLocal {
	
	public void criarUsuario(Long id, String nome, String login, String senha);

}
