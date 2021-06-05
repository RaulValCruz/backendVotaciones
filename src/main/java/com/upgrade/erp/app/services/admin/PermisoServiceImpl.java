package com.upgrade.erp.app.services.admin;

import java.util.List;
import java.util.Optional;

import com.upgrade.erp.app.models.entity.erp3.Permisos;
import com.upgrade.erp.app.models.repository.erp3.PermisoRepository;
import com.upgrade.erp.app.services.common.CommonServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class PermisoServiceImpl extends CommonServiceImpl<Permisos, PermisoRepository> implements PermisoService {

    @Override
    public List<Permisos> getAll() {
        return repository.getAllByActivoIsTrue();
    }

    @Override
    public Permisos update(Permisos permiso) {

        Optional<Permisos> o = this.repository.findById(permiso.getId());
        if (o.orElse(null) == null)
            return permiso;
        Permisos upd = o.get();

        upd.setNombre(permiso.getNombre());
        upd.setActivo(permiso.getActivo());

        return this.repository.save(upd);
    }

    @Override
    public Permisos delete(Permisos permiso) {
        Optional<Permisos> o = this.repository.findById(permiso.getId());
        if (o.orElse(null) == null)
            return permiso;
        Permisos upd = o.get();
        upd.setActivo(false);
        return this.repository.save(upd);
    }

}
