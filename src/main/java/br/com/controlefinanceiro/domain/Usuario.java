package br.com.controlefinanceiro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.controlefinanceiro.domain.enums.Perfis;

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
	private Integer perfil;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Perfis")
	private Set<Integer> perfis = new HashSet<>();

	public Usuario() {
		addPerfil(Perfis.RESPONSAVEL);
	}

	public Usuario(Integer id_usuario, String nom_usuario, String cod_cpf, String cod_telefone, String nom_email, Perfis perfil) {
		super();
		this.id_usuario = id_usuario;
		this.nom_usuario = nom_usuario;
		this.cod_cpf = cod_cpf;
		this.cod_telefone = cod_telefone;
		this.nom_email = nom_email;
		this.perfil = perfil.getCod();
		addPerfil(Perfis.RESPONSAVEL);
	}

	public void addPerfil(Perfis perfis) {
		this.perfis.add(perfis.getCod());
	}
	
	public Set<Perfis> getPerfis(){
		return perfis.stream().map(x -> Perfis.ADMIN).collect(Collectors.toSet());
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getCod_cpf() {
		return cod_cpf;
	}

	public void setCod_cpf(String cod_cpf) {
		this.cod_cpf = cod_cpf;
	}

	public String getCod_telefone() {
		return cod_telefone;
	}

	public void setCod_telefone(String cod_telefone) {
		this.cod_telefone = cod_telefone;
	}

	public String getNom_email() {
		return nom_email;
	}

	public void setNom_email(String nom_email) {
		this.nom_email = nom_email;
	}
	
	
	public Perfis getPerfil() {
		return Perfis.toEnum(perfil);
	}

	public void setPerfil(Perfis perfil) {
		this.perfil = perfil.getCod();
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
