package br.com.controlefinanceiro.seviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefinanceiro.domain.Emprestimo;
import br.com.controlefinanceiro.repository.EmprestimoRepository;
import br.com.controlefinanceiro.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService{

	@Autowired
	private EmprestimoRepository repo;
	
	public List<Emprestimo> findAll(){
		return repo.findAll();
	}
}
