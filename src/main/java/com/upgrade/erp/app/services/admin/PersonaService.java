package com.upgrade.erp.app.services.admin;

import com.upgrade.erp.app.models.entity.erp3.Persona;
import com.upgrade.erp.app.services.common.CommonService;

import java.util.List;

/**
 * Created by Alxndr on 19/10/18.
 */
// @Repository
public interface PersonaService extends CommonService<Persona> {

    List<Persona> getAll();

    Persona login(String user, String password);

    Persona update(Persona persona);

    Persona delete(Persona persona);

    // Persona findByDNI(String dni);

}
