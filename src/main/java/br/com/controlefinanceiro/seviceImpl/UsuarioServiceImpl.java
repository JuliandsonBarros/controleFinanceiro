package br.com.controlefinanceiro.seviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.repository.UsuarioRepository;

public class UsuarioServiceImpl {
	
    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> findAll(){
        return repo.findAll();
    }

    public Usuario findId(Integer id){
        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElseThrow();
    }
    
    public Usuario insert(Usuario obj) {
    	return repo.save(obj);
    }
    
    public Usuario update(Usuario usuario) {
    	Usuario novoUsuario =  findId(usuario.getId_usuario());
    	AtualizaBanco(novoUsuario,usuario);
    	return repo.save(novoUsuario);
    	
    }

	private void AtualizaBanco(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNom_usuario(usuario.getNom_usuario());
		novoUsuario.setCod_cpf(usuario.getCod_cpf());
		novoUsuario.setCod_telefone(usuario.getCod_telefone());
		novoUsuario.setNom_email(usuario.getNom_email());
		
	}
    

}
