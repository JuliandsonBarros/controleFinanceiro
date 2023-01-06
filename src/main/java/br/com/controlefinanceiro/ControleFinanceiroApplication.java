package br.com.controlefinanceiro;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.controlefinanceiro.domain.Emprestimo;
import br.com.controlefinanceiro.domain.Usuario;
import br.com.controlefinanceiro.domain.enums.Perfis;
import br.com.controlefinanceiro.repository.EmprestimoRepository;
import br.com.controlefinanceiro.repository.UsuarioRepository;

@SpringBootApplication
public class ControleFinanceiroApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmprestimoRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Usuario u1 = new Usuario(null, "Juliandson Barros Soares", "01384935100", "61992850840", "123456",Perfis.RESPONSAVEL);
		Usuario u2 = new Usuario(null, "Felipe Xavier", "01384935100", "61992850840", "123456",Perfis.ADMIN);
		Usuario u3 = new Usuario(null, "Eduarda Leão", "01384935100", "61992850840", "123456", Perfis.ADMIN);
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Emprestimo e1 = new Emprestimo(null, 10.00,1, 15, LocalDate.now());
		Emprestimo e2 = new Emprestimo(null, 15.00,1, 10, LocalDate.now());		
		Emprestimo e3 = new Emprestimo(null, 20.00,1, 12, LocalDate.now());
		
		repo.saveAll(Arrays.asList(e1,e2,e3));
		
	}
}
