package com.upgrade.erp.app.services;

import java.util.List;

import com.upgrade.erp.app.models.entity.erp3.Ubigeo;
import com.upgrade.erp.app.services.common.CommonService;

public interface UbigeoService extends CommonService<Ubigeo> {

    List<Ubigeo> getDepartamentos();

    List<Ubigeo> getRegionesByDpto(String dpto);

    List<Ubigeo> getDistritosByRegion(String dpto, String prov);

    List<Ubigeo> getDistritos();

}
