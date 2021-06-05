package com.upgrade.erp.app.models.entity.erp3;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upgrade.erp.app.models.Auditable;

@Entity
@Table(schema = "legal", name = "ubigeo")
public class Ubigeo extends Auditable<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;

    private String coddpto;
    private String codprov;
    private String coddist;
    private String nombre;
    private Long id;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCoddpto() {
        return coddpto;
    }

    public void setCoddpto(String coddpto) {
        this.coddpto = coddpto;
    }

    public String getCodprov() {
        return codprov;
    }

    public void setCodprov(String codprov) {
        this.codprov = codprov;
    }

    public String getCoddist() {
        return coddist;
    }

    public void setCoddist(String coddist) {
        this.coddist = coddist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
