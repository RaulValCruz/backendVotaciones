package com.upgrade.erp.app.models.entity.erp3;

import com.upgrade.erp.app.models.Auditable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permisos")
public class Permisos extends Auditable<Integer> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 25)
	private String nombre;

	private Boolean activo;

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

}
