package com.upgrade.erp.app.services.admin;

import com.upgrade.erp.app.models.entity.erp3.DocIdentidadTipo;
import com.upgrade.erp.app.models.entity.erp3.MesaSufragio;
import com.upgrade.erp.app.models.repository.erp3.DocIdentidadTipoRepository;
import com.upgrade.erp.app.models.repository.erp3.MesaSufragioRepository;
import com.upgrade.erp.app.services.common.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MesaSufragioServiceImpl extends CommonServiceImpl<MesaSufragio, MesaSufragioRepository>
        implements MesaSufragioService {

    @Override
    public MesaSufragio findByNroMesa(String nro_mesa) {
        return repository.findByNroMesa(nro_mesa);
    }

}
