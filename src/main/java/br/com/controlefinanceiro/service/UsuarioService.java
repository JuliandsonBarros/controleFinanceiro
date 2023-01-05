package br.com.controlefinanceiro.service;

import java.util.List;

import br.com.controlefinanceiro.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();

	public Usuario findId(Integer id);

	public Usuario insert(Usuario obj);

	public Usuario update(Usuario usuario);
	
	public void delete(Integer id);

}
