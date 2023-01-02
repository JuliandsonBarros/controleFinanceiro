package br.com.controlefinanceiro.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	private String nom_usuario;
	private String cod_cpf;
	private String cod_telefone;
	private String nom_email;
	
	public Usuario(Integer id_usuario, String nom_usuario, String cod_cpf, String cod_telefone, String nom_email) {
		super();
		this.id_usuario = id_usuario;
		this.nom_usuario = nom_usuario;
		this.cod_cpf = cod_cpf;
		this.cod_telefone = cod_telefone;
		this.nom_email = nom_email;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public String getCod_cpf() {
		return cod_cpf;
	}

	public String getCod_telefone() {
		return cod_telefone;
	}

	public String getNom_email() {
		return nom_email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id_usuario, other.id_usuario);
	}
}
