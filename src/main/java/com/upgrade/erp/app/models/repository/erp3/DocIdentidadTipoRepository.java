package com.upgrade.erp.app.models.repository.erp3;

import com.upgrade.erp.app.models.entity.erp3.DocIdentidadTipo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocIdentidadTipoRepository extends PagingAndSortingRepository<DocIdentidadTipo, Long> {

}
