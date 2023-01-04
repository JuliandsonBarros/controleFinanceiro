package br.com.controlefinanceiro.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emprestimo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_emprestimo;
	private Double cod_valor;
	private Integer cod_numeroParcelas;
	private Integer cod_taxaJuros;
	private LocalDate dta_emprestimo;
	private Usuario usuario;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(Integer id_emprestimo, Double cod_valor, Integer cod_numeroParcelas, Integer cod_taxaJuros,
			LocalDate dta_emprestimo) {
		super();
		this.id_emprestimo = id_emprestimo;
		this.cod_valor = cod_valor;
		this.cod_numeroParcelas = cod_numeroParcelas;
		this.cod_taxaJuros = cod_taxaJuros;
		this.dta_emprestimo = dta_emprestimo;
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

	public Integer getCod_numeroParcelas() {
		return cod_numeroParcelas;
	}

	public void setCod_numeroParcelas(Integer cod_numeroParcelas) {
		this.cod_numeroParcelas = cod_numeroParcelas;
	}

	public Integer getCod_taxaJuros() {
		return cod_taxaJuros;
	}

	public void setCod_taxaJuros(Integer cod_taxaJuros) {
		this.cod_taxaJuros = cod_taxaJuros;
	}

	public LocalDate getDta_emprestimo() {
		return dta_emprestimo;
	}

	public void setDta_emprestimo(LocalDate dta_emprestimo) {
		this.dta_emprestimo = dta_emprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(id_emprestimo, other.id_emprestimo);
	}

}
