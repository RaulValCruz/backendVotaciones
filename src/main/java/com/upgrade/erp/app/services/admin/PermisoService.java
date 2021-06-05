package com.upgrade.erp.app.services.admin;

import java.util.List;

import com.upgrade.erp.app.models.entity.erp3.Permisos;
import com.upgrade.erp.app.services.common.CommonService;

public interface PermisoService extends CommonService<Permisos> {

    List<Permisos> getAll();

    Permisos update(Permisos Permisos);

    Permisos delete(Permisos Permisos);

}
