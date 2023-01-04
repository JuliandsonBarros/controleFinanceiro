package br.com.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> listUsuario = service.findAll();
		return ResponseEntity.ok().body(listUsuario);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> busccaId(@PathVariable Integer id){
		Usuario usuario = service.findId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = service.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioSalvo.getId_usuario()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Integer id) {
		usuario.setId_usuario(id);
		service.update(usuario);
		return ResponseEntity.noContent().build();
	}
	
}
