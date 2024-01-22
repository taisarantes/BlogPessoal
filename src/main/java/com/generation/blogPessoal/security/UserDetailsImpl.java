package com.generation.blogPessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogPessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	// falar para a segurança quais são as informações que vamos usar para login

	private static final long serialVersionUID = 1L;
	// atributo que vai ser utilizado apenas nessa classe,
	// por isso ele está como static e possui o 1 Long
	// que siginifica a versão da classe
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	// com a spring security é possível definir níveis de acesso
	// essa classe GrantedAuthority consegue passar os níveis de acesso de um usuário
	
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl() {
		// construtor vazio para que a aplicação continue funcionando
		// mesmo que usuario e senha não sejam informados
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
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
