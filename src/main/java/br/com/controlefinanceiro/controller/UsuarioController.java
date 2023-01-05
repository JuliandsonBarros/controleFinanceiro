package br.com.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.dto.UsuarioDTO;
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
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Integer id){
		Usuario usuarioSalvo = service.fromDTO(usuarioDTO);
		usuarioSalvo.setId_usuario(id);
		usuarioSalvo = service.insert(usuarioSalvo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioSalvo.getId_usuario()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Integer id) {
		Usuario usuarioSalvo = service.fromDTO(usuarioDTO);
		usuarioSalvo.setId_usuario(id);
		usuarioSalvo = service.update(usuarioSalvo);
		return ResponseEntity.noContent().build();
	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable  Integer id){
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
