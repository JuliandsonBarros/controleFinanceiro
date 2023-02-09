package br.com.controlefinanceiro.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.controlefinanceiro.domain.enums.Perfis;


public class UserSS implements UserDetails{
	private static final long serialVersionUID = 1L;

	private Integer id_usuario;
	private String cod_senha;
	private String cod_cpf;
	public  Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
	}
	
	public UserSS(Integer id_usuario, String cod_senha, String cod_cpf, Set<Perfis> perfis) {
		super();
		this.id_usuario = id_usuario;
		this.cod_senha = cod_senha;
		this.cod_cpf = cod_cpf;
		this.authorities = perfis.stream().map(x ->
				new SimpleGrantedAuthority(x.getDescriao())).collect(Collectors.toList());
	}

	public Integer getId_usuario() {
		return id_usuario;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return  authorities;
	}

	@Override
	public String getPassword() {
		return cod_senha;
	}

	@Override
	public String getUsername() {
		return cod_cpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
