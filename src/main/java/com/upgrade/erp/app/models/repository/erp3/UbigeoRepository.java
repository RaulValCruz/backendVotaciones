package com.upgrade.erp.app.models.repository.erp3;

import java.util.List;
import com.upgrade.erp.app.models.entity.erp3.Ubigeo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbigeoRepository extends PagingAndSortingRepository<Ubigeo, Long> {

    @Query("select u from Ubigeo u where u.coddpto!='00' and u.codprov='00' and u.coddist='00'")
    List<Ubigeo> getAllDepartamento();

    @Query("select u from Ubigeo u where u.coddpto=?1 and u.codprov!='00' and u.coddist='00'")
    List<Ubigeo> getRegionesByDpto(String dpto);

    @Query("select u from Ubigeo u where u.coddpto=?1 and u.codprov=?2 and u.coddist!='00'")
    List<Ubigeo> getDistritosByRegion(String dpto, String prov);

    /*
     * List<Ubigeo> getAllRegion(); List<Ubigeo> getAllDistrito();
     */

}
