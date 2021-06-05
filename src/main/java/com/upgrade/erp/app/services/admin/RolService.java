package com.upgrade.erp.app.services.admin;

import com.upgrade.erp.app.models.entity.erp3.Rol;
import com.upgrade.erp.app.services.common.CommonService;
import java.util.List;

public interface RolService extends CommonService<Rol> {

  List<Rol> getAll();

  Rol update(Rol rol);

  Rol delete(Rol rol);

}
