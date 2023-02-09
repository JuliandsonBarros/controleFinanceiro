package br.com.controlefinanceiro.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.controlefinanceiro.domain.Usuario;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id_usuario;
    
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nom_usuario;
    
    
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	private String cod_telefone;
	private String nom_email;
	private String cod_senha;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		id_usuario = usuario.getId_usuario();
		nom_usuario = usuario.getNom_usuario();
		cpf = usuario.getCpf();
		cod_telefone = usuario.getCod_telefone();
		nom_email = usuario.getNom_email();
		cod_senha = usuario.getCod_senha();
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuarioDTO(Integer id_usuario) {
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

	public String getCod_senha() {
		return cod_senha;
	}

	public void setCod_senha(String cod_senha) {
		this.cod_senha = cod_senha;
	}
}
