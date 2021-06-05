package com.upgrade.erp.app.models.entity.erp3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upgrade.erp.app.models.Auditable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mesa_sufragio")
public class MesaSufragio extends Auditable<Integer> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nro_mesa;
	private String cant_electores;
	private String departamento;
	private String provincia;
	private String distrito;
	private String nombre_local;
	private String direccion_local;

	@JsonIgnore
	private Integer usuario_id;

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNro_mesa() {
		return nro_mesa;
	}

	public void setNro_mesa(String nro_mesa) {
		this.nro_mesa = nro_mesa;
	}

	public String getCant_electores() {
		return cant_electores;
	}

	public void setCant_electores(String cant_electores) {
		this.cant_electores = cant_electores;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getNombre_local() {
		return nombre_local;
	}

	public void setNombre_local(String nombre_local) {
		this.nombre_local = nombre_local;
	}

	public String getDireccion_local() {
		return direccion_local;
	}

	public void setDireccion_local(String direccion_local) {
		this.direccion_local = direccion_local;
	}

}
