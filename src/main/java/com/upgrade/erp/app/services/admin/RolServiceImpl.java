package com.upgrade.erp.app.services.admin;

import java.util.List;
import java.util.Optional;

import com.upgrade.erp.app.models.entity.erp3.Rol;
import com.upgrade.erp.app.models.repository.erp3.RolRepository;
import com.upgrade.erp.app.services.common.CommonServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends CommonServiceImpl<Rol, RolRepository> implements RolService {

    @Override
    public List<Rol> getAll() {
        return repository.getAllByActivoIsTrue();
    }

    @Override
    public Rol update(Rol rol) {

        Optional<Rol> o = this.repository.findById(rol.getId());
        if (o.orElse(null) == null)
            return rol;
        Rol upd = o.get();
        upd.setNombre(rol.getNombre());
        upd.setActivo(rol.getActivo());
        upd.setPermisos(rol.getPermisos());

        return this.repository.save(upd);
    }

    @Override
    public Rol delete(Rol rol) {
        Optional<Rol> o = this.repository.findById(rol.getId());
        if (o.orElse(null) == null)
            return rol;
        Rol upd = o.get();
        upd.setActivo(false);
        return this.repository.save(upd);
    }

}
