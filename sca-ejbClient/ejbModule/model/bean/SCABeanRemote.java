package model.bean;

import javax.ejb.Remote;

@Remote
public interface SCABeanRemote {
	
	public void criarUsuario(Long id, String nome, String login, String senha);

}
