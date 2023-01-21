package br.com.controlefinanceiro.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.controlefinanceiro.domain.enums.Status;

@Entity
public class Emprestimo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_emprestimo;
	private Double cod_valor;
	private Integer cod_numeroParcelas;
	private Integer cod_taxaJuros;
	//private LocalDate dta_emprestimo;
	
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(name = "status")
	private Integer status;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Status")
	private Set<Integer> sta = new HashSet<>();
	
	public Emprestimo() {
	}

	public Emprestimo(Integer id_emprestimo, Double cod_valor, Integer cod_taxaJuros,Usuario usuario){

		this.id_emprestimo = id_emprestimo;
		this.cod_valor = cod_valor;
		this.cod_taxaJuros = cod_taxaJuros;
		this.usuario = usuario;
	}

	public Emprestimo(Integer id_emprestimo, Double cod_valor, Integer cod_numeroParcelas, Integer cod_taxaJuros,
			LocalDate dta_emprestimo,Usuario usuario ,Status status) {
		super();
		this.id_emprestimo = id_emprestimo;
		this.cod_valor = cod_valor;
		this.cod_numeroParcelas = cod_numeroParcelas;
		this.cod_taxaJuros = cod_taxaJuros;
		//this.dta_emprestimo = dta_emprestimo;
		this.usuario = usuario;
		this.status = status.getCod();
		addStatus(status);
	}
	
	public void addStatus(Status status) {
		this.sta.add(status.getCod());
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

	//public LocalDate getDta_emprestimo() {
	//	return dta_emprestimo;
	//}

	//public void setDta_emprestimo(LocalDate dta_emprestimo) {
	//	this.dta_emprestimo = dta_emprestimo;
	//}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Status getSta() {
		return Status.toEnum(status);
	}
	
	public void setSta(Status status) {
		this.status = status.getCod();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_emprestimo);
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
