package br.com.controlefinanceiro.service;

import java.util.List;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.dto.UsuarioDTO;

public interface UsuarioService {

	public List<Usuario> findAll();

	public Usuario findId(Integer id);

	public Usuario insert(Usuario obj);

	public Usuario update(Usuario usuario);
	
	public void delete(Integer id);
	
	public Usuario fromDTO(UsuarioDTO dto);
}
