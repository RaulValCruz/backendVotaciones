package com.upgrade.erp.app.models.entity.erp3;

import com.upgrade.erp.app.models.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario extends Auditable<Integer> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 25)
	private String username;

	@Column(length = 100)
	private String password;

	private Long persona_id;

	private Boolean activo;

	// private Long rol_id;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario_id", "rol_id" }) })
	private List<Rol> roles;

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Long persona_id) {
		this.persona_id = persona_id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/*
	 * public Long getrol_id() { return rol_id; }
	 * 
	 * public void setrol_id(Long rol_id) { this.rol_id = rol_id; }
	 * 
	 */

	private static final long serialVersionUID = 4002221912401133094L;

}
