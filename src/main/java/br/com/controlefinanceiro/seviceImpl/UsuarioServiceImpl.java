package br.com.controlefinanceiro.seviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.dto.UsuarioDTO;
import br.com.controlefinanceiro.repository.UsuarioRepository;
import br.com.controlefinanceiro.security.UserSS;
import br.com.controlefinanceiro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;

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
		repo.findById(id)
		.map(usuario -> {
			repo.delete(usuario);
			return Void.TYPE;
		})
		.orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

	private void AtualizaBanco(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNom_usuario(usuario.getNom_usuario());
		novoUsuario.setCpf(usuario.getCpf());
		novoUsuario.setCod_telefone(usuario.getCod_telefone());
		novoUsuario.setNom_email(usuario.getNom_email());

	}
	

	public Usuario fromDTO(UsuarioDTO dto) {
		return new Usuario(dto.getId_usuario(),dto.getNom_usuario() ,dto.getCpf(), 
				dto.getCod_telefone(),dto.getNom_email(),pe.encode(dto.getCod_senha()));
	}
}
