package com.upgrade.erp.app.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upgrade.erp.app.models.entity.erp3.Permisos;
import com.upgrade.erp.app.models.entity.erp3.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	private List<Permisos> permisos;

	public UserDetailsImpl(Long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities, List<Permisos> permisos) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.permisos = permisos;
	}

	public static UserDetailsImpl build(Usuario user) {

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());

		List<Permisos> permisos = new ArrayList<Permisos>();

		user.getRoles().forEach(p -> {
			p.getPermisos().forEach(a -> {
				permisos.add(a);
			});
		});

		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), authorities, permisos);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public List<Permisos> getPermisos() {
		return permisos;
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

	@Override
	public String toString() {
		return "UserDetailsImpl{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\''
				+ ", authorities=" + authorities + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
