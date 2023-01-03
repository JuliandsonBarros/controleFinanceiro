package br.com.controlefinanceiro.seviceImpl;

import java.util.List;
import java.util.Optional;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.repository.UsuarioRepository;

public class UsuarioServiceImpl {
	
	private UsuarioRepository repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

	public Usuario findId(Integer id) {
		Optional<Usuario> usuario = repo.findById(id);
		return usuario.orElse(null);
	}
}
