package com.upgrade.erp.app.models.repository.erp3;

import com.upgrade.erp.app.models.entity.erp3.MesaSufragio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaSufragioRepository extends PagingAndSortingRepository<MesaSufragio, Long> {

    @Query("select p from MesaSufragio p where p.nro_mesa=?1")
    MesaSufragio findByNroMesa(String nro_mesa);

}
