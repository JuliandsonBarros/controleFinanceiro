package br.com.controlefinanceiro.seviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefinanceiro.domain.Emprestimo;
import br.com.controlefinanceiro.dto.EmprestimoDTO;
import br.com.controlefinanceiro.dto.EmprestimoNewDTO;
import br.com.controlefinanceiro.repository.EmprestimoRepository;
import br.com.controlefinanceiro.service.EmprestimoService;
import br.com.controlefinanceiro.service.UsuarioService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

	@Autowired
	private EmprestimoRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Emprestimo> findAll() {
		return repo.findAll();
	}

	public Emprestimo buscarPorId(Integer id) {
		Optional<Emprestimo> emprestimo = repo.findById(id);

		if (emprestimo == null) {

		}
		return emprestimo.orElseThrow();
	}

	@Transactional
	public Emprestimo insert(Emprestimo emprestimo) {
		return repo.save(emprestimo);
	}

	public Emprestimo update(Emprestimo emprestimo) {
		Emprestimo emprestimoSalvo = buscarPorId(emprestimo.getId_emprestimo());
		atualizaBanco(emprestimoSalvo, emprestimo);
		return repo.save(emprestimoSalvo);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Emprestimo fromDto(EmprestimoDTO dto) {
		return new Emprestimo(dto.getId_emprestimo(),dto.getCod_valor(),dto.getCod_taxaJuros(),dto.getUsuario());
	}
	
	public Emprestimo fromNewDTO(EmprestimoNewDTO dto) {
		return new Emprestimo(null,dto.getCod_valor(),dto.getCod_taxaJuros(),usuarioService.fromDTO(dto.getUsuario()));
	}

	private void atualizaBanco(Emprestimo emprestimoSalvo, Emprestimo emprestimo) {
		emprestimoSalvo.setCod_numeroParcelas(emprestimo.getCod_numeroParcelas());
		emprestimoSalvo.setCod_taxaJuros(emprestimo.getCod_taxaJuros());
		emprestimoSalvo.setCod_valor(emprestimo.getCod_valor());
		//emprestimoSalvo.setDta_emprestimo(emprestimo.getDta_emprestimo());
		emprestimoSalvo.setUsuario(emprestimo.getUsuario());
	}
}