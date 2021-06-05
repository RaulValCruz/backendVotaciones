package com.upgrade.erp.app.models.entity.erp3;

import com.upgrade.erp.app.models.Auditable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doc_identidad_tipo")
public class DocIdentidadTipo  extends Auditable<Long> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 30)
	private String nombre;

	private String abreviatura;

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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	private static final long serialVersionUID = 4467531611801172710L;

}
