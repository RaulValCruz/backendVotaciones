package com.upgrade.erp.app.models.repository.erp3;

import java.util.List;
import com.upgrade.erp.app.models.entity.erp3.Rol;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {

  List<Rol> getAllByActivoIsTrue();

}
