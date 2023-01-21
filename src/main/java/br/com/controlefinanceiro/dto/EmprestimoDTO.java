package br.com.controlefinanceiro.dto;

import java.io.Serializable;

import br.com.controlefinanceiro.domain.Emprestimo;
import br.com.controlefinanceiro.domain.Usuario;

public class EmprestimoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_emprestimo;
	private Double cod_valor;
	private Integer cod_taxaJuros;
	//private LocalDate dta_emprestimo;
	
	private Usuario usuario;
	
	public EmprestimoDTO() {
	}

	public EmprestimoDTO(Emprestimo emprestimo) {
		id_emprestimo = emprestimo.getId_emprestimo();
		cod_valor = emprestimo.getCod_valor();
		cod_taxaJuros = emprestimo.getCod_taxaJuros();
		usuario = emprestimo.getUsuario();
	}

	public Integer getId_emprestimo() {
		return id_emprestimo;
	}

	public void setId_emprestimo(Integer id_emprestimo) {
		this.id_emprestimo = id_emprestimo;
	}

	public Double getCod_valor() {
		return cod_valor;
	}

	public void setCod_valor(Double cod_valor) {
		this.cod_valor = cod_valor;
	}

	public Integer getCod_taxaJuros() {
		return cod_taxaJuros;
	}

	public void setCod_taxaJuros(Integer cod_taxaJuros) {
		this.cod_taxaJuros = cod_taxaJuros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
