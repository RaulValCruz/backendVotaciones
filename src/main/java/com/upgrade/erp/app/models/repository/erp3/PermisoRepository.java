package com.upgrade.erp.app.models.repository.erp3;

import java.util.List;

import com.upgrade.erp.app.models.entity.erp3.Permisos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends PagingAndSortingRepository<Permisos, Long> {

    List<Permisos> getAllByActivoIsTrue();

}
