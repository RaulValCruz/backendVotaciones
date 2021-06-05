package com.upgrade.erp.app.models.entity.erp3;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 30)
	private String nombre;

	private Boolean activo;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rol_permiso", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "permiso_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "rol_id", "permiso_id" }) })
	private List<Permisos> permisos;

	public List<Permisos> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permisos> permisos) {
		this.permisos = permisos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	private static final long serialVersionUID = 4467531611801172710L;

}
