package br.com.controlefinanceiro.seviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.dto.UsuarioDTO;
import br.com.controlefinanceiro.repository.UsuarioRepository;
import br.com.controlefinanceiro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Usuario findId(Integer id) {
		Optional<Usuario> usuario = repo.findById(id);
		return usuario.orElseThrow();
	}

	public Usuario insert(Usuario obj) {
		return repo.save(obj);
	}

	public Usuario update(Usuario usuario) {
		Usuario novoUsuario = findId(usuario.getId_usuario());
		AtualizaBanco(novoUsuario, usuario);
		return repo.save(novoUsuario);

	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	private void AtualizaBanco(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNom_usuario(usuario.getNom_usuario());
		novoUsuario.setCod_cpf(usuario.getCod_cpf());
		novoUsuario.setCod_telefone(usuario.getCod_telefone());
		novoUsuario.setNom_email(usuario.getNom_email());

	}

	public Usuario fromDTO(UsuarioDTO dto) {
		return new Usuario(dto.getId_usuarioDTO(),dto.getNom_usuario() ,dto.getCod_cpf(), 
				dto.getCod_telefone(),dto.getNom_email());
	}
}
