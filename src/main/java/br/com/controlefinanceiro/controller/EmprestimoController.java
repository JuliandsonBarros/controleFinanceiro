package br.com.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.controlefinanceiro.domain.Emprestimo;
import br.com.controlefinanceiro.dto.EmprestimoDTO;
import br.com.controlefinanceiro.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
@CrossOrigin("http://localhost:4200")
public class EmprestimoController {

	@Autowired
	private EmprestimoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Emprestimo>> findAll() {
		List<Emprestimo> emprestimos = service.findAll();
		return ResponseEntity.ok().body(emprestimos);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarEmprestimoPorId(@PathVariable Integer id) {
		Emprestimo emprestimo = service.buscarPorId(id);
		return ResponseEntity.ok().body(emprestimo);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimoSalvo = service.fromDto(emprestimoDTO);
		emprestimoSalvo = service.insert(emprestimoSalvo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(emprestimoSalvo.getId_emprestimo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Emprestimo emprestimo, @PathVariable Integer id){	
		emprestimo.setId_emprestimo(id);
		service.update(emprestimo);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
