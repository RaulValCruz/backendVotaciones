package com.upgrade.erp.app.models.entity.erp3;

import com.upgrade.erp.app.models.Auditable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
@Table(name = "persona")
public class Persona extends Auditable<Integer> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String dni;

	private String password;
	private String nombres;
	private String apellido_materno;
	private String apellido_paterno;
	private String direccion;
	private String telefono;
	private String region;
	private String provincia;
	private String distrito;
	private String centro_votacion;
	private Boolean activo;

	@OneToOne
	private MesaSufragio mesa;

	@OneToOne
	private Rol rol;

	public Rol getRoles() {
		return rol;
	}

	public void setRoles(Rol roles) {
		this.rol = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoMaterno() {
		return apellido_materno;
	}

	public void setApellidoMaterno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getApellidoPaterno() {
		return apellido_materno;
	}

	public void setApellidoPaterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getCentroVotacion() {
		return centro_votacion;
	}

	public void setCentroVotacion(String centro_votacion) {
		this.centro_votacion = centro_votacion;
	}

	public MesaSufragio getMesa() {
		return mesa;
	}

	public void setMesa(MesaSufragio mesa) {
		this.mesa = mesa;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
