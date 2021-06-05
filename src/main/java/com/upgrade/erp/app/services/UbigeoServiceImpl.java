package com.upgrade.erp.app.services;

import java.util.List;
import java.util.Optional;

import com.upgrade.erp.app.models.entity.erp3.Ubigeo;
import com.upgrade.erp.app.models.repository.erp3.UbigeoRepository;
import com.upgrade.erp.app.services.common.CommonServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class UbigeoServiceImpl extends CommonServiceImpl<Ubigeo, UbigeoRepository> implements UbigeoService {

    @Override
    public List<Ubigeo> getDepartamentos() {
        return repository.getAllDepartamento();
    }

    @Override
    public List<Ubigeo> getDistritos() {
        return null;
    }

    @Override
    public List<Ubigeo> getRegionesByDpto(String dpto) {
        return repository.getRegionesByDpto(dpto);
    }

    @Override
    public List<Ubigeo> getDistritosByRegion(String dpto, String prov) {
        return repository.getDistritosByRegion(dpto, prov);
    }

}
