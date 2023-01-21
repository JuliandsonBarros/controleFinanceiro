package br.com.controlefinanceiro.dto;

import java.io.Serializable;

public class EmprestimoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_emprestimo;
	private Double cod_valor;
	private Integer cod_taxaJuros;
	//private LocalDate dta_emprestimo;
	
	private UsuarioDTO usuario;
	
	public EmprestimoNewDTO(Integer id_emprestimo, Double cod_valor, Integer cod_taxaJuros,UsuarioDTO usuario) {
		super();
		this.id_emprestimo = id_emprestimo;
		this.cod_valor = cod_valor;
		this.cod_taxaJuros = cod_taxaJuros;
		this.usuario = usuario;
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

	//public LocalDate getDta_emprestimo() {
	//	return dta_emprestimo;
	//}

	//public void setDta_emprestimo(LocalDate dta_emprestimo) {
	//	this.dta_emprestimo = dta_emprestimo;
	//}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
