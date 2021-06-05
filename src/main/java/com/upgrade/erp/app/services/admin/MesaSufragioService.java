package com.upgrade.erp.app.services.admin;

import com.upgrade.erp.app.models.entity.erp3.MesaSufragio;
import com.upgrade.erp.app.models.entity.erp3.Persona;
import com.upgrade.erp.app.services.common.CommonService;

import java.util.List;

public interface MesaSufragioService extends CommonService<MesaSufragio> {

    MesaSufragio findByNroMesa(String nro_mesa);

}
