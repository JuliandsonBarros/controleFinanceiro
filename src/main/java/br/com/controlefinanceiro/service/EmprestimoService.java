package br.com.controlefinanceiro.service;

import java.util.List;

import br.com.controlefinanceiro.domain.Emprestimo;

public interface EmprestimoService {

	public List<Emprestimo> findAll();
	
	public Emprestimo buscarPorId(Integer id);
	
	public Emprestimo insert(Emprestimo emprestimo);
	
	public Emprestimo update(Emprestimo emprestimo);
	
	public void delete(Integer id);
}
