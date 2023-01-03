package br.com.controlefinanceiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefinanceiro.domain.Emprestimo;
import br.com.controlefinanceiro.seviceImpl.EmprestimoServiceImpl;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoServiceImpl service;

	
	public ResponseEntity<List<Emprestimo>> findAll(){
		List<Emprestimo> emprestimos = service.findAll();
		return ResponseEntity.ok().body(emprestimos);
	}
}
