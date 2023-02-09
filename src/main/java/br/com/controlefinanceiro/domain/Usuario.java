package br.com.controlefinanceiro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.controlefinanceiro.domain.enums.Perfis;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@Column(nullable = false, length = 150)
	private String nom_usuario;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	private String cod_telefone;
	private String nom_email;
	
	@JsonIgnore
	private String cod_senha;
	private Integer perfil;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Perfis")
	private Set<Integer> perfis = new HashSet<>();
	
	@OneToMany
	private List<Emprestimo> emprestimo = new ArrayList<>();

	public Usuario() {
	}
	
	public Usuario(Integer id_usuario, String nom_usuario, String cod_cpf, String cod_telefone, String nom_email, String cod_senha) {
		super();
		this.id_usuario = id_usuario;
		this.nom_usuario = nom_usuario;
		this.cpf = cod_cpf;
		this.cod_telefone = cod_telefone;
		this.nom_email = nom_email;
		this.cod_senha = cod_senha;
	}

	public Usuario(Integer id_usuario, String nom_usuario, String cod_cpf, String cod_telefone, 
			String nom_email, Perfis per) {
		super();
		this.id_usuario = id_usuario;
		this.nom_usuario = nom_usuario;
		this.cpf = cod_cpf;
		this.cod_telefone = cod_telefone;
		this.nom_email = nom_email;
		this.perfil = per.getCod();
		addPerfil(per);
	}
	
	public void addPerfil(Perfis perfis) {
		this.perfis.add(perfis.getCod());
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cod_cpf) {
		this.cpf = cod_cpf;
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
	
	
	public Set<Perfis> getPerfil() {
		return perfis.stream().map(x -> Perfis.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfil(Perfis perfil) {
		this.perfil = perfil.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}
	
	public String getCod_senha() {
		return cod_senha;
	}

	public void setCod_senha(String cod_senha) {
		this.cod_senha = cod_senha;
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
