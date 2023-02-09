package br.com.controlefinanceiro.seviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.repository.UsuarioRepository;
import br.com.controlefinanceiro.security.UserSS;

@Service
public class UserDetailsServiveImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Usuario uso = repo.findByCpf(cpf);
		if(uso == null) {
			throw new UsernameNotFoundException(cpf);
		}
		return new UserSS(uso.getId_usuario(),uso.getCod_senha(),uso.getCpf(),uso.getPerfil());
	}

	
}
