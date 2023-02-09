package br.com.controlefinanceiro.dto;

public class CredenciaisDTO {
	
	private String cod_cpf;
	private String cod_senha;
	
	public CredenciaisDTO() {
	}

	public String getCod_cpf() {
		return cod_cpf;
	}

	public void setCod_cpf(String cod_cpf) {
		this.cod_cpf = cod_cpf;
	}
	public String getCod_senha() {
		return cod_senha;
	}

	public void setCod_senha(String cod_senha) {
		this.cod_senha = cod_senha;
	}
}
